package main.webapp.services;

import main.webapp.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static main.webapp.dao.Dao.connect;


public class UserService {

    public static boolean insertUser(User user) {
        try(Connection connection = connect()) {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name,surname) values(?,?)");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getSurname());
        preparedStatement.execute();
        preparedStatement.close();
        return true;
        }
         catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public static void updateUser(int userId, User user){
        try(Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name,surname,phone,email,nationalityId) values(?,?,?,?,?) where id = " + userId);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getNationalityId());
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteUser(int userId) throws Exception{
        try(Connection connection = connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = " + userId);
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<User> selectAllUsers() throws Exception{
        List<User> listUser = new ArrayList<>();
        try(Connection connection = connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()){
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));
                user.setNationalityId(resultSet.getInt("nationalityId"));
                user.setId(resultSet.getInt("id"));
                listUser.add(user);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return listUser;
    }

    public static User selectUser(int userId) throws Exception{
        try(Connection connection = connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where id = " + userId);
            User user = new User();
            while (resultSet.next()){
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setNationalityId(resultSet.getInt("nationalityId"));
                user.setId(resultSet.getInt("id"));
            }
            statement.close();
            return user;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    }

