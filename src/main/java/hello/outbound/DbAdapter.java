/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello.outbound;

import hello.entities.User;

import java.sql.*;

public class DbAdapter {
//    private String dbUsername = "sa";
//    private String dbPassword = "sa";
    private String dbUsername = "root";
    private String dbPassword = "letmeinnow";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

//    public void saveUser(User user) {
    public void saveUser(User user) throws Exception {
        // Setup the connection with the DB
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost/checklists"
//                    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/checklists"
                    + "?autoReconnect=true&useSSL=false&"
                    + "user=" + dbUsername + "&password=" + dbPassword);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            throw ex;
        } catch (Exception ex) {
            throw ex;
//        } finally {
//             connect.close();
        }
        connect.close();

//        // Statements allow to issue SQL queries to the database
//        statement = connect.createStatement();
//        // Result set get the result of the SQL query
//        resultSet = statement
//                .executeQuery("select * from feedback.comments");
//        writeResultSet(resultSet);
//
//        // PreparedStatements can use variables and are more efficient
//        preparedStatement = connect
//                .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
    }
}
