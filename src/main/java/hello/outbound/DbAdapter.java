/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello.outbound;

import hello.entities.User;

import java.sql.*;

//@Bean
public class DbAdapter {
    private String dbUsername = "sa";
    private String dbPassword = "sa";

    private Connection connect = null;
    private Statement statement = null;
//    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DbAdapter() throws Exception {
        // Setup the connection with the DB
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/checklists"
                    + "?user=" + dbUsername + "&password=" + dbPassword
                    + "&autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false"
                    + "&useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&serverTimezone=America/New_York"
            );
        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
            throw ex;
        } catch (Exception ex) {
            throw ex;
//        } finally {
//            connect.close();
        }
    }

    public void destroy() throws Exception {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            connect = null;
        }
    }

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
        try {
            statement = connect.createStatement();
        } catch (SQLException ex){
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }


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

    public User getUser(String username) throws Exception {

        User user = new User();

        try {
//            String sql = "SELECT * FROM Users WHERE username LIKE ?";
//            PreparedStatement statement = connect.prepareStatement(sql);
//            statement.setString(1, username);
            statement = connect.createStatement();
            String sql = "SELECT * FROM Users WHERE username LIKE '" + username + "'";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                user.setfName(rs.getNString("lName"));
                user.setlName(rs.getNString("lName"));
                user.setUsername(rs.getNString("username"));
                user.setActive(rs.getBoolean("active"));
                user.setEmail(rs.getNString("email"));
//                int id  = rs.getInt("id");
//                int age = rs.getInt("age");
//                String first = rs.getString("first");
//                String last = rs.getString("last");
            }
            rs.close();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }

        return user;
    }

    public User[] getUsers() throws Exception {
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return new User[0];
    }
}
