package sample.interfaces.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dataBaseWorkClasses.DbHandler;
import sample.interfaces.BookingList;
import sample.workedClasses.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbBookingList implements BookingList{

    private ObservableList<Book> bookingList = FXCollections.observableArrayList();

    @Override
    public void add(Book book) {
        bookingList.add(book);
    }
    public void addAll() throws SQLException {
        DbHandler dbHandler = new DbHandler();

        ResultSet resultSet = dbHandler.getAllBooks();
        while (resultSet.next()){
            Book book = new Book();
            book.setNameBook(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            bookingList.add(book);
        }
    }
    @Override
    public void update(Book book) {

    }

    public ObservableList<Book> getBookingList() {
        return bookingList;
    }

    @Override
    public void delete(Book book) {

    }
}
