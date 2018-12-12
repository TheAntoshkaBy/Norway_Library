package sample.workedClasses.interfaces.relize;

import sample.dataBaseWorkClasses.DbHandler;
import sample.workedClasses.User;
import sample.workedClasses.interfaces.ReadersList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBReadersList implements ReadersList{

    private ArrayList<User> readersList = new ArrayList<User>();

    @Override
    public void add(User user) {

        readersList.add(user);

    }


    @Override
    public void update(User user) {
        // реализовать обновление объекта с последующим добавлением его в базу данных
    }

    @Override
    public void delete(User user) {
        //реализовать удаление объекта из базы данных
    }

    public void addAll() throws SQLException {
        DbHandler dbHandler = new DbHandler();

        ResultSet resultSet = dbHandler.getAll();

        while (resultSet.next()){
            User user = new User();
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setLogin(resultSet.getString(4));
            user.setNowBook(resultSet.getString(5));
            user.setBookForClub(resultSet.getString(6));
            user.setData(null);
            user.setMale(resultSet.getString(8));
            user.setPassword(resultSet.getString(9));
            readersList.add(user);
        }
    }
}
