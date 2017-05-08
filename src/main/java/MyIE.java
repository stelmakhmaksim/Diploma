/**
 * Created by Maks on 4/16/2017.
 */

import edu.stanford.nlp.ie.machinereading.structure.ExtractionObject;
import edu.stanford.nlp.ie.machinereading.structure.MachineReadingAnnotations;
import edu.stanford.nlp.ie.machinereading.structure.RelationMention;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;

import java.io.FileNotFoundException;
import java.util.*;

public class MyIE {
    int a =0;


    public static void main(String[] args) throws FileNotFoundException {
        FileApp file = new FileApp();
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,relation");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // read some text in the text variable
        String text = "Putin met with Obama on conference in Paris,France,Europe on November 15. Trump blames Democrats for GOP health care bill failure, says ObamaCare is 'imploding'.";
        //String text = "Obama and Merkel will meet with the Russian president at the Climate Conference in Paris on November 15, 2017. Vladimir Putin was born in St. Petersburg in 1952 .";
        //String text ="2.Tesla Inc. is ready to start taking deposits for its stunning solar roof tiles. The company will begin taking orders next month, Chief Executive Officer Elon Musk said via Twitter on Friday. Installations will begin in mid 2017, according to the company’s website.";
        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        // these are all the sentences in this document
        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            /*for(RelationMention rel: sentence.get(MachineReadingAnnotations.RelationMentionsAnnotation.class)){
                System.out.println(rel);
            }*/
            System.out.println(sentence);
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // System.out.println(word);
                //String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                // this is the POS tag of the token
                //String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // this is the NER label of the token
               // String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                //System.out.println(ne);
                //String ner = token.get(CoreAnnotations.NormalizedNamedEntityTagAnnotation.class);
               // System.out.println(ner);
            }
        }
    }
}
