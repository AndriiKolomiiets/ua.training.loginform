package input.regexp.model;

public interface Dao {
    boolean isLoginInDb(String login);
    void buildUserInfoIntoDB(User user);
    String getFieldByCondition(String column, String condition);
}
