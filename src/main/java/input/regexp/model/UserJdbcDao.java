package input.regexp.model;

import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class UserJdbcDao implements Dao {
    private static Connection connection;
    private static volatile UserJdbcDao userJdbcDao = null;
    private static PreparedStatement preparedStatement;
    public static final String PROPERTIES_EN = "message_and_regexp_en_GB";
    private ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_EN,
            new Locale("en", "GB"));

    private UserJdbcDao() {}

    public static UserJdbcDao getInstance() {
        if (userJdbcDao == null) {
            synchronized (UserJdbcDao.class) {
                if (userJdbcDao == null) {
                    userJdbcDao = new UserJdbcDao();
                }
            }
        }
        return new UserJdbcDao();
    }

    private Connection connectToDb() {
        connection = null;
        try {
            Driver driver = new com.mysql.jdbc.Driver();
//            Driver driver = new com.mysql.cj.userJdbcDao.Driver();
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

    public boolean isLoginInDb(String userLogin){
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

    public String getFieldByCondition(String column, String condition){
        Statement statement;
        ResultSet rs;
        String field=null;
        connection = connectToDb();
        try {
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT login FROM user_login WHERE "+column+"='"+condition+"'");
            while (rs.next()){
                field = rs.getString(column);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return field;
    }

    public void buildUserInfoIntoDB(User user) {
        connection = connectToDb();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement = connection.prepareStatement(
                    resourceBundle.getString("jdbc.db.insertUserIntoDB"));
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getHomePhoneNumber());
            preparedStatement.setString(6, user.getMobilePhoneNumber());
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




