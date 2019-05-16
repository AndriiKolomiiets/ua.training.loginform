package input.regexp.model;

import input.regexp.controller.JDBC;

public interface Dao {
    boolean isLoginInDb(String login);
    void buildUserInfoIntoDB(User user);
}
