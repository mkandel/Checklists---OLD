/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.outbound;

import mkandel.entities.*;
import mkandel.utils.*;
import org.springframework.stereotype.*;

import java.sql.*;
import java.util.*;

import static mkandel.utils.UserType.*;

@Component
public class DbAdapter {
    private String dbUsername = "sa";
    private String dbPassword = "sa";

    private Connection connection;
    private Statement statement = null;
    //private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DbAdapter() throws Exception {
        // Setup the connection with the DB
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/checklists"
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
        } catch (InvalidEmailException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        return returnVal;
    }

    public User getUser(String username) throws Exception {

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
                //Retrieve by column name
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
        user.setfName(rs.getString("FName"));
        user.setlName(rs.getString("lName"));
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
        user.setId(java.util.UUID.fromString(uuidString));
    }
}
