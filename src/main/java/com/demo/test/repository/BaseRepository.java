package com.demo.test.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/tanashop?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "000000";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
