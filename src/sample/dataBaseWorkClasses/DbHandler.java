package sample.dataBaseWorkClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort
                +"/"+dbName+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";

        //Class.forName("com.mysql.jdbc.Driver");
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        if (!dbConnection.isClosed()) {
            System.out.println("Соединение с БД установлено");
        }
    }catch (SQLException e) {
        System.out.println("Не удалось загрузить класс драйвера");
    }
        return dbConnection;
    }

    public void signUpUser(String firstName,String surname,String login, String nowBook, String bookForClub,String male,String password)
    {
        String insert = "INSERT INTO " + Const.USER_TABLE                   +     "(" +
                Const.USER_NAME     +    ","  + Const.USER_SURNAME         +","+
                Const.USER_LOGIN    +    ","  +
                Const.USER_NOW_BOOK +    ","  + Const.USER_BOOK_FOR_CLUB   +","+
                Const.USER_MALE     +    ","  + Const.USER_PASSWORD         +     ")" +
                "VALUES(?,?,?,?,?,?,?)";

        try {
            System.out.println(insert);
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,firstName);
            System.out.println(firstName);
            prSt.setString(2,surname);
            System.out.println(surname);
            prSt.setString(3,login);
            System.out.println(login);
            prSt.setString(4,nowBook);
            System.out.println(nowBook);
            prSt.setString(5,bookForClub);
            System.out.println(bookForClub);
            prSt.setString(6,male);
            System.out.println(male);
            prSt.setString(7,password);
            System.out.println(password);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
