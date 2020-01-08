/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.outbound;

import com.mkandel.checklists.entities.User;
import com.mkandel.checklists.utils.InvalidEmailException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mkandel.checklists.utils.UserType.*;

//@Component
public class DbAdapter {
    private String dbUsername = "sa";
    private String dbPassword = "sa";

    private Connection connection;
    private Statement statement = null;
    //private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;

    public DbAdapter() throws Exception {
        // Setup the connection with the DB
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/checklists"
                    + "?userByUsername=" + dbUsername + "&password=" + dbPassword
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
        }
    }

    public void destroy() throws Exception {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            connection = null;
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public Map<String, String> saveUser(User user) throws Exception {
        Map<String, String> returnVal = new HashMap<>();
        try {
            statement = connection.createStatement();
            user.save();
        } catch (SQLException ex){
            throw ex;
//        } catch (InvalidEmailException ex) {
//            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return returnVal;
    }

    public User getUserByUsername(String username) throws Exception {

        User user = new User();

        try {
            // Why doesn't this work??
            //
            //String sql = "SELECT * FROM Users WHERE username LIKE ?";
            //PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setString(1, username);
            statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE username LIKE '" + username + "'";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                processReadUser(user, rs);
            }
            rs.close();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }

        return user;
    }

    public User getUser(String id) throws Exception {

        User user = new User();

        try {
            // Why doesn't this work??
            //
            //String sql = "SELECT * FROM Users WHERE username LIKE ?";
            //PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setString(1, username);
            statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE id = " + id + ";";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                processReadUser(user, rs);
            }
            rs.close();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }

        return user;
    }

    public List<User> getUsers() throws Exception {
        List<User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM Users";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                User user = new User();
                //Retrieve by column name
                processReadUser(user, rs);
                users.add(user);
            }
            rs.close();
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return users;
    }

    private void processReadUser(User user, ResultSet rs) throws SQLException, InvalidEmailException {
        //Retrieve by column name
        user.setFname(rs.getString("FName"));
        user.setLname(rs.getString("Lname"));
        user.setUsername(rs.getString("username"));
        user.setActive(rs.getBoolean("active"));
        user.setEmail(rs.getString("email"));

        int type = rs.getInt("type");
        if (type == 0) {
            user.setType(ADMIN);
        } else if (type == 1) {
            user.setType(CREATOR);
        } else {
            user.setType(USER);
        }

        String uuidString = rs.getString("id");
        user.setId(uuidString);
    }
}
