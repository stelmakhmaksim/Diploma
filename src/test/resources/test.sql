--INSERT INTO facts("Subject", "Relation", "Object") VALUES ('Trump','bear','NYC');
--SELECT * FROM facts;

/*statement.execute("INSERT INTO facts (subject,relation,object) VALUES ('Putin','met','Obama');");//insert,select,delete,update
statement.executeUpdate("DELETE FROM facts where id>5 and id<15");//all without select
statement.executeQuery("select * from facts");//only select
statement.addBatch("UPDATE facts SET id = 5 WHERE id=15");//several query
statement.addBatch("DELETE FROM facts where id=16");
statement.clearBatch();*/

/*запросы через preparemedStatement, ввод, вывод, удаление*/
/*final String INSERT ="INSERT INTO facts VALUES (?,?,?,?,?,?,?)";
final String SELECT ="SELECT * FROM facts";
final String DELETE ="DELETE FROM facts WHERE id=?";

DBWorker worker = new DBWorker();
PreparedStatement preparedStatement =null;*/

/*добавление данных в запрос*/
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

/*вывод таблиц*/
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

/*удаление данных из запроса*/
/*preparedStatement = worker.getConnection().prepareStatement(DELETE);
preparedStatement.setInt(1,2);
preparedStatement.executeUpdate();*/