package org.example.author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrud implements authorOperation{
    private Connection connection;

    public AuthorCrud(Connection connection) {
        this.connection = connection;
    }

    public List<Author> getAllAuthors(){
        List<Author> authors =  new ArrayList<>();
        ResultSet resultSet;
        String getAll = "select * from author";
        try (PreparedStatement statement = connection.prepareStatement(getAll)){
            resultSet = statement.executeQuery();

          while (resultSet.next()){
              authors.add(new Author(resultSet.getInt("authorId"),
                                    resultSet.getString("authorName"),
                                     resultSet.getString("sex")));
          }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authors;
    };

    public List<Author> saveAllAuthor(List<Author> authors){
      for (Author author : authors){
          String insert = "insert into author (authorName , sex ) values (?,?)";

          try (PreparedStatement statement = connection.prepareStatement(insert)){
              statement.setString(1,author.getAuthorName());
              statement.setString(2,author.getSex());

              statement.executeUpdate();

          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }

        return authors;
    };
    public Author saveAuthor(Author toSave){
        String insert = "insert into author (authorName , sex ) values (?,?)";

        try (PreparedStatement statement = connection.prepareStatement(insert)){
            statement.setString(1,toSave.getAuthorName());
            statement.setString(2,toSave.getSex());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    };
    public Author deleteAuthor(Author toDelete){
        String delete = "delete from author where authorid= ? and authorName = ?";

        try (PreparedStatement statement = connection.prepareStatement(delete)){
            statement.setInt(1,toDelete.getIdAuthor());
            statement.setString(2,toDelete.getAuthorName());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toDelete;
    };


}
