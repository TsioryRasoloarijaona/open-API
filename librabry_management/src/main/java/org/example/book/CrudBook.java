package org.example.book;

import org.example.author.AuthorCrud;
import org.example.author.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudBook implements BookOperations {
    Connection connection;
    AuthorCrud author;

    public CrudBook(AuthorCrud author) {
        this.author = author;
    }

    public CrudBook(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> getAllBook() {
            List<Book> books = new ArrayList<>();
            List<Author> author = new ArrayList<>() ;
            List<String> topic = new ArrayList<>();
            String sql = "select bookid,bookname,pagenumber, authorname , sex , topic from book inner join author on book.authorid = author.authorid;";
            ResultSet resultSet;



            try (PreparedStatement statement = connection.prepareStatement(sql)){
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    author.add(new Author(resultSet.getString("authorname"),
                            resultSet.getString("sex")));

                    books.add(new Book(resultSet.getInt("bookid"),
                            resultSet.getString("bookname"),
                            resultSet.getInt("pagenumber")));




                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        return null;
    }

    @Override
    public List<Book> saveAllBook(List<Book> books) {
        for (Book book: books) {
            String sql = "insert into book (bookname , pagenumber , authorid,topic.topic_name  ) values (?,?,?,?);";
            String[] topic = book.getTopics().toArray(new String[0]);
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,book.getBookName());
                statement.setInt(2,book.getPageNumbers());
                statement.setInt(3,book.getAuthor().getIdAuthor());
                statement.setArray(4,connection.createArrayOf("text",topic));

                statement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return books;
    }

    @Override
    public Book saveBook(Book toSave) {
        String sql = "insert into book (bookname , pagenumber , authorid,topic.topic_name  ) values (?,?,?,?);";
        String[] topic = toSave.getTopics().toArray(new String[0]);
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,toSave.getBookName());
            statement.setInt(2,toSave.getPageNumbers());
            statement.setInt(3,toSave.getAuthor().getIdAuthor());
            statement.setArray(4,connection.createArrayOf("text",topic));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Book deleteBook(Book toDelete) {
        String sql = "delete from book where bookid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,toDelete.getBookId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toDelete;
    }
}
