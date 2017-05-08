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
        //file.write("example.txt","Marine LePen, the French far right’s presidential candidate, and V. Putin on Friday met in the Kremlin on Friday where they discussed issues of concern.");
        OpenIE ie = new OpenIE();
        ie.openIE(file.read("example.txt"));//извлечение фактов из документа
        //file.delete("example.txt");
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
