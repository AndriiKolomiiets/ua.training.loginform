package input.regexp.controller;

import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class JDBC {
    private static Connection connection;
    private static volatile JDBC jdbc = null;
    private static PreparedStatement preparedStatement;
    public static final String PROPERTIES_EN = "message_and_regexp_en_GB";
    private ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_EN,
            new Locale("en", "GB"));

    private JDBC() {}

    public static JDBC getInstance() {
        if (jdbc == null) {
            synchronized (JDBC.class) {
                if (jdbc == null) {
                    jdbc = new JDBC();
                }
            }
        }
        return new JDBC();
    }

    private Connection connectToDb() {
        connection = null;
        try {
            Driver driver = new com.mysql.jdbc.Driver();
//            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(
                    resourceBundle.getString("jdbc.db.connection"),
                    resourceBundle.getString("jdbc.db.user"),
                    resourceBundle.getString("jdbc.db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
//todo:check doesn't work
    public boolean isLoginInDB(String userLogin){
        Statement statement;
        ResultSet rs;
        String loginFromDB=null;
        connection = connectToDb();
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT login FROM user_login WHERE login='"+userLogin+"'");
            while (rs.next()){
                loginFromDB = rs.getString("login");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
          return loginFromDB != null;
    }

    public void buildUserInfoIntoDB(String login, String firstName, String lastName, String email,
                                    String homePhone, String mobilePhone) {
        connection = connectToDb();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement = connection.prepareStatement(
                    resourceBundle.getString("jdbc.db.insertUserIntoDB"));
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, homePhone);
            preparedStatement.setString(6, mobilePhone);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ignored) {
                }
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }}




