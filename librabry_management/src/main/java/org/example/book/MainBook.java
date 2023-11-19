package org.example.book;

import org.example.DBconnection;
import org.example.author.Author;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainBook {
    public static void main(String[] args) throws SQLException {
        Connection connection = DBconnection.getConnection();
        List<String> topic = new ArrayList<>();
        topic.add("romance");
        topic.add("comedy");
        Author author = new Author(2,"rabezavana","M");
        Book book = new Book("l'amour",200,author,topic);

        CrudBook crudBook = new CrudBook(connection);

        crudBook.saveBook(book);




    }
}
