/**
 * Created by Maks on 3/20/2017.
 */

import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;

import javax.security.auth.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class OpenIE {
    FileApp fil = new FileApp();

    public void openIE(String text) throws Exception {
        // Create the Stanford CoreNLP pipeline
        final String INSERTevent = "INSERT INTO event(location,date) VALUES (?,?)";
        final String INSERTsubevent = "INSERT INTO subevent(subject,relation,object,id_event) VALUES (?,?,?,?)";
        final String SELECT = "SELECT MAX(id_event) FROM event";
        //final String DELETE = "DELETE FROM facts WHERE id=?";

        DBWorker worker = new DBWorker();
        PreparedStatement preparedStatement = null;


        String result, sub, rel, obj;
        String date = "";
        String location = "";
        int countevents = 0;
        int countevents1 = 0;
        int countsubevents = 0;

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,depparse,natlog,openie");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);


        // Annotate an example document.
        Annotation doc = new Annotation(text);
        pipeline.annotate(doc);
        fil.write("example.txt", "Extracted events:");
        // Loop over sentences in the document

        for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
            // Get the OpenIE triples for the sentence
            countevents1+=1;
            fil.write("example.txt", "Event:" + countevents1);
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // this is the NER label of the token
                String ner = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                if (ner.equals("LOCATION")) {
                    if (!location.equals(word))
                        location += " " + word;
                }

                if (ner.equals("DATE")) {
                    if (!date.equals(word))
                        date += " " + word;
                }

            }

            location = location.trim();
            date = date.trim();

            preparedStatement = worker.getConnection().prepareStatement(INSERTevent);
            preparedStatement.setString(1, location);
            preparedStatement.setString(2, date);
            preparedStatement.executeUpdate();

            preparedStatement = worker.getConnection().prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                countevents = resultSet.getInt("max");

            System.out.println(date);
            System.out.println(location);
            location = "";
            date = "";

            Collection<RelationTriple> triples = sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
            // Print the triples

            for (RelationTriple triple : triples) {
                countsubevents += 1;
                System.out.println(triple.subjectGloss() + "\t" +
                        triple.relationGloss() + "\t" +
                        triple.objectGloss() + "\t");

                result = countsubevents + "\t"+ triple.subjectGloss() + "\t" +
                        triple.relationGloss() + "\t" +
                        triple.objectGloss();
                fil.write("example.txt", result);


                sub = triple.subjectGloss();
                rel = triple.relationGloss();
                obj = triple.objectGloss();

                preparedStatement = worker.getConnection().prepareStatement(INSERTsubevent);
                //preparedStatement.setInt(1, countsubevents);
                preparedStatement.setString(1, sub);
                preparedStatement.setString(2, rel);
                preparedStatement.setString(3, obj);
                preparedStatement.setInt(4, countevents);
                preparedStatement.executeUpdate();

            }
            countsubevents = 0;
        }
    }
}