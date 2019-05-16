package input.regexp.model;

/**
 * User class store user information.
 * @author Andrii Kolomiiets
 * Created on 07.04.2019
 */
public class User {
    private String firstName;
    private String lastName;
    private String initials;
    private String nickName;
    private String email;
    private String homePhoneNumber;
    private String modifyTime;
    private String mobilePhoneNumber;
    private String createTime;

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitials() {
        return initials;
    }

    public String getLogin() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public void setCreateTime(String time) {
        this.createTime = time;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "\nNew note was created in User\nUser: " + getFirstName() + " " + getLastName()
                + "\nLogin: " + getLogin()
                + "\nEmail: " + getEmail()
                + "\nHome phone number: " + getHomePhoneNumber()
                + "\nMobile phone number: " + getMobilePhoneNumber()
                + "\nProfile created: " + getCreateTime();
    }
}
