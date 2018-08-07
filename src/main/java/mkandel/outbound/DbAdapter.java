/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.outbound;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Component
@Configuration
@EnableTransactionManagement
@EntityScan
@ComponentScan
public class DbAdapter {
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan(new String[] { "org.baeldung.persistence.model" });
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//
//        return em;
//    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/checklists" +
                "?autoReconnect=true" +
                "&useSSL=false" +
                "&serverTimezone=UTC");
        dataSource.setUsername( "sa" );
        dataSource.setPassword( "sa" );
        return dataSource;
    }

//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

    Properties additionalProperties() {
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        return properties;
    }
//    private String dbUsername = "sa";
//    private String dbPassword = "sa";
//
//    private Connection connection;
//    private Statement statement = null;
//    //private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;
//
//    public DbAdapter() throws Exception {
//        // Setup the connection with the DB
//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/checklists"
//                    + "?user=" + dbUsername + "&password=" + dbPassword
//                    + "&autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false"
//                    + "&useUnicode=true&useJDBCCompliantTimezoneShift=true"
//                    + "&serverTimezone=America/New_York"
//            );
//        } catch (SQLException ex) {
////            System.out.println("SQLException: " + ex.getMessage());
////            System.out.println("SQLState: " + ex.getSQLState());
////            System.out.println("VendorError: " + ex.getErrorCode());
//            throw ex;
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }
//
//    public void destroy() throws Exception {
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw ex;
//        } finally {
//            connection = null;
//        }
//    }
//
//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void setDbPassword(String dbPassword) {
//        this.dbPassword = dbPassword;
//    }
//
//    public void setDbUsername(String dbUsername) {
//        this.dbUsername = dbUsername;
//    }
//
//    public Map<String, String> saveUser(User user) throws Exception {
//        Map<String, String> returnVal = new HashMap<>();
//        try {
//            statement = connection.createStatement();
//            user.save();
//        } catch (SQLException ex){
//            throw ex;
//        } catch (InvalidEmailException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return returnVal;
//    }
//
//    public User getUser(String username) throws Exception {
//
//        User user = new User();
//
//        try {
//            // Why doesn't this work??
//            //
//            //String sql = "SELECT * FROM Users WHERE username LIKE ?";
//            //PreparedStatement statement = connection.prepareStatement(sql);
//            //statement.setString(1, username);
//            statement = connection.createStatement();
//            String sql = "SELECT * FROM Users WHERE username LIKE '" + username + "'";
//
//            ResultSet rs = statement.executeQuery(sql);
//
//            while(rs.next()){
//                processReadUser(user, rs);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw ex;
//        }
//
//        return user;
//    }
//
//    public List<User> getUsers() throws Exception {
//        List<User> users = new ArrayList<>();
//        try {
//            statement = connection.createStatement();
//            String sql = "SELECT * FROM Users";
//
//            ResultSet rs = statement.executeQuery(sql);
//
//            while(rs.next()){
//                User user = new User();
//                //Retrieve by column name
//                processReadUser(user, rs);
//                users.add(user);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return users;
//    }
//
//    private void processReadUser(User user, ResultSet rs) throws SQLException, InvalidEmailException {
//        //Retrieve by column name
//        user.setFname(rs.getString("FName"));
//        user.setLname(rs.getString("Lname"));
//        user.setUsername(rs.getString("username"));
//        user.setActive(rs.getBoolean("active"));
//        user.setEmail(rs.getString("email"));
//
//        int type = rs.getInt("type");
//        if (type == 0) {
//            user.setType(ADMIN);
//        } else if (type == 1) {
//            user.setType(CREATOR);
//        } else {
//            user.setType(USER);
//        }
//
//        String uuidString = rs.getString("id");
//        user.setId(UUID.fromString(uuidString));
//    }
}
