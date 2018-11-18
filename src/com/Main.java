package com;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String userName = "root";
        String password = "sql123";
        String connectionUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       // Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
             Statement stat = conn.createStatement()) {
            conn.setAutoCommit(false);
            conn.setAutoCommit(false);
            stat.addBatch("drop table IF EXISTS Books");
            stat.addBatch("CREATE TABLE Books(id MEDIUMINT NOT NULL AUTO_INCREMENT,name CHAR(30) NOT NULL,dt DATE, PRIMARY KEY(id))");
            stat.addBatch("INSERT INTO Books (name) VALUES ('Inferno')");
            stat.addBatch("INSERT INTO Books (name) VALUES ('Davinci code')");
            stat.addBatch("INSERT INTO Books (name) VALUES ('Solomon keyn')");
            if (stat.executeBatch().length == 5) {
                conn.commit();
            } else {
                conn.rollback();
            }

        }
    }
}























