package sample.dataBaseWorkClasses;

import sample.workedClasses.Book;
import sample.workedClasses.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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


    public void signUpUser(User user)
    {
        String insert = "INSERT INTO " + Const.USER_TABLE                   +     "(" +
                Const.USER_NAME     +    ","  + Const.USER_SURNAME         +","+
                Const.USER_LOGIN    +    ","  +
                Const.USER_NOW_BOOK +    ","  + Const.USER_BOOK_FOR_CLUB   +","+
                Const.USER_MALE     +    ","  + Const.USER_PASSWORD         +     ")" +
                "VALUES(?,?,?,?,?,?,?)";
        System.out.println(insert);

        try {
            System.out.println(insert);
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getName());
            System.out.println(user.getName());
            prSt.setString(2,user.getSurname());
            System.out.println(user.getSurname());
            prSt.setString(3,user.getLogin());
            System.out.println(user.getLogin());
            prSt.setString(4,user.getNowBook());
            System.out.println(user.getNowBook());
            prSt.setString(5,user.getBookForClub());
            System.out.println(user.getBookForClub());
            prSt.setString(6,user.getMale());
            System.out.println(user.getMale());
            prSt.setString(7,user.getPassword());
            System.out.println(user.getPassword());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user)
    {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                        Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";

        try{
                PreparedStatement prSt = getDbConnection().prepareStatement(select);

                prSt.setString(1,user.getLogin());
                prSt.setString(2,user.getPassword());

                resultSet = prSt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return resultSet;
    }

    public void newBook(Book book){

        String insert = "INSERT INTO " + Const.BOOKING_TABLE                   +     "(" +
                Const.BOOKING_NAME    +    ","  + Const.BOOKING_AUTHOR_NAME         + ")" +
                "VALUES(?,?)";

        System.out.println(insert);
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1,book.getNameBook());
            System.out.println(book.getNameBook());
            prSt.setString(2,book.getAuthor());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getAll()//всех юзеров
    {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE ;

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet getAllBooks()
    {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.BOOKING_TABLE ;

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resultSet = prSt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return resultSet;
    }

    public void deleteUser(Const tableName, Const param)
    {
        String delete = "DELETE FROM " + tableName + " WHERE " + param + "VALUES(?)";
        System.out.println(delete);

        PreparedStatement prStr = null;

        try {
            prStr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prStr = getDbConnection().prepareStatement(delete);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void ChangeDataAboutUser(User user)
    {
        String update = "UPDATE " + Const.USER_TABLE   +     " SET "           +
                Const.USER_NAME            +    " = "  + user.getName()        +
                Const.USER_SURNAME         +    " = "  + user.getSurname()     +
                Const.USER_LOGIN           +    " = "  + user.getLogin()       +
                Const.USER_NOW_BOOK        +    " = "  + user.getNowBook()     +
                Const.USER_BOOK_FOR_CLUB   +    " = "  + user.getBookForClub() +
                Const.USER_MALE            +    " = "  + user.getMale()        +
                Const.USER_PASSWORD        +    " = "  + user.getPassword()    ;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(update);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
