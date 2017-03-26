import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Maks on 3/21/2017.
 */
public class main {
    public static void main(String[] args) throws Exception {
        FileApp file = new FileApp();
        file.write("example.txt", "Vladimir Putin was born in St. Petersburg in 1952 . Obama met with the Russian president at the Climate Conference in Paris on November 15, 2015.");
        //file.read("example.txt");//файл с примером разбора предложения
        //file.read("articles.txt");//файл с текстами
        //file.delete("example.txt");
        OpenIE ie = new OpenIE();
        ie.openIE(file.read("example.txt"));//извлечение фактов из документа

////////////////////////////////////////////////////////////////////////////////////////////////
        //запросы через preparemedStatement, ввод, вывод, удаление
        /*final String INSERT ="INSERT INTO facts VALUES (?,?,?,?,?,?,?)";
        final String SELECT ="SELECT * FROM facts";
        final String DELETE ="DELETE FROM facts WHERE id=?";

        DBWorker worker = new DBWorker();
        PreparedStatement preparedStatement =null;*/

        //добавление данных в запрос
        /*preparedStatement = worker.getConnection().prepareStatement(INSERT);
        preparedStatement.setString(1,"Medvedev");
        preparedStatement.setString(2,"met");
        preparedStatement.setString(3,"Lavrov");
        preparedStatement.setInt(4,6);
        preparedStatement.setString(5,"Kremlin");
        preparedStatement.setString(6,"28 of october");
        preparedStatement.setInt(7,2);

        //preparedStatement.setBlob(8,new FileInputStream("smile.png"));//вставка документа в БД
        preparedStatement.executeUpdate();*/

        //вывод таблиц
        /*preparedStatement = worker.getConnection().prepareStatement(SELECT);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Fact fact = new Fact();
            fact.setId(resultSet.getInt("id"));
            fact.setSubject(resultSet.getString("subject"));
            fact.setRelation(resultSet.getString("relation"));
            fact.setObject(resultSet.getString("object"));
            fact.setLocation(resultSet.getString("location"));
            fact.setDate(resultSet.getString("date"));
            System.out.println(fact);
        }*/

        //удаление данных из запроса
        /*preparedStatement = worker.getConnection().prepareStatement(DELETE);
        preparedStatement.setInt(1,2);
        preparedStatement.executeUpdate();*/
    }
}
