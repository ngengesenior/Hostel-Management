package com.gluonapplication.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection connnect() {
        String url = "";
        String user = "";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
