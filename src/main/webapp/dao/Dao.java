package main.webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    public static Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/baza?autoReconnect=true&useSSL=false", "root", "123456");
         return connection;
        }
    }
