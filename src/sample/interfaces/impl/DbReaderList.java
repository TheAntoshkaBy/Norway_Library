package sample.interfaces.impl;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dataBaseWorkClasses.DbHandler;
import sample.interfaces.ReadersList;
import sample.workedClasses.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public class DbReaderList implements ReadersList {

    private ObservableList<User> readersList = FXCollections.observableArrayList();

    @Override
    public void add(User user) {

        readersList.add(user);

    }

    public void addAll() throws SQLException {
        DbHandler dbHandler = new DbHandler();

        ResultSet resultSet = dbHandler.getAll();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt(1));
            System.out.println(user.getId());
            user.setName(resultSet.getString(2));
            System.out.println(user.getName());
            user.setSurname(resultSet.getString(3));
            System.out.println(user.getSurname());
            user.setLogin(resultSet.getString(4));
            user.setNowBook(resultSet.getString(5));
            user.setBookForClub(resultSet.getString(6));
            user.setData(null);
            user.setMale(resultSet.getString(8));
            user.setPassword(resultSet.getString(9));
            readersList.add(user);
        }
    }

    public ObservableList<User> getReadersList() {
        return readersList;
    }

    @Override
    public void update(User user) {
        // реализовать обновление объекта с последующим добавлением его в базу данных
    }

    @Override
    public void delete(User user) {
        //реализовать удаление объекта из базы данных
    }
}
