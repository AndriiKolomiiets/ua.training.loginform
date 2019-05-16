package input.regexp.model;

import input.regexp.controller.JDBC;

public class UserDao implements Dao {
    private JDBC jdbc;

    public UserDao(JDBC jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public boolean isLoginInDb(String login) {
        return jdbc.getFieldByCondition("login", login) != null;
    }

    @Override
    public void buildUserInfoIntoDB(User user) {
        jdbc.buildUserInfoIntoDB(user);
    }
}
