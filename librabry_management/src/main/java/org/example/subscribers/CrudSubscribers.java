package org.example.subscribers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudSubscribers implements OperationsSubscribers{

    Connection connection;

    public CrudSubscribers(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAllSubscribers() {
        List<User> users = new ArrayList<>();
        String sql = "select * from \"user\"";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                users.add(new User(resultSet.getInt("userId"),
                        resultSet.getNString("userName"),
                        resultSet.getString("gender"),
                        resultSet.getString("role")));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> saveAllSubscribers(List<User> users) {
        for (User user : users) {

            String sql = "insert into \"user\" (userName , gender ,role) values (?,?,?);";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());
                statement.setString(2,user.getGender);
                statement.setString(3,user.getRole());

                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return users;
    }

    @Override
    public User saveSubscribers(User toSave) {

        String sql = "insert into \"user\" (userName , gender ) values (?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toSave.getUserName());
            statement.setString(2,toSave.getGender);
            statement.setString(3,toSave.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User deleteSubscribers(User toDelete) {

        String sql = "delete from \"user\" where userid = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, toDelete.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return toDelete;
    }
}
