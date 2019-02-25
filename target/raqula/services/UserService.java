package main.webapp.services;

import main.webapp.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static main.webapp.dao.Dao.connect;


public class UserService {

    public static boolean insertUser(User user) throws Exception{
        Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name,surname) values(?,?)");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getSurname());
        try {
            return preparedStatement.execute();
        } catch (Exception e){
            e.getMessage();
            return false;
        }
    }








    public static void updateUser(int id, User user){

    }

    public static boolean deleteUser(int userId) throws Exception{
        boolean res;
        Statement statement = connect().createStatement();
        res = statement.execute("delete from users where " + userId);
        return res;
    }

    public static List<User> selectAllUsers() throws Exception{
        List<User> userList = new ArrayList<>();
        Statement statement = connect().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()){
           String name = resultSet.getString("name");
           String surname = resultSet.getString("surname");
           int id = resultSet.getInt("id");
            User user = new User(name, surname);
            userList.add(user);
        }
        return userList;
    }

    public static User selectUser(int userId) throws Exception{
        User user = null;
        ResultSet resultSet = null;
        try (Statement statement = connect().createStatement()) {
           resultSet = statement.executeQuery("select * from users where id = " + userId);
        }
        while (resultSet.next()){
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
        }
        return user;
    }

    }

