package input.regexp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Model process user data and write it into User.
 * Created on 07.04.2019
 * @author Andrii Kolomiiets
 */

public class Model {

    private User user = new User();

    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    public void setNickName(String nickName) {
        user.setNickName(nickName);
    }

    /**
     * setInitials method form user initials.
     */
    public void setInitials(String firstName, String lastName) {
        StringBuffer stringBuffer = new StringBuffer(firstName);
        char nameInitial = stringBuffer.charAt(0);
        StringBuffer strBuf = new StringBuffer(lastName);
        String initials = new String(strBuf.append(" " + nameInitial + "."));
        user.setInitials(initials);
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
       user.setHomePhoneNumber(homePhoneNumber);
    }

    public void setMobilePhoneNumber (String mobilePhoneNumber){
        user.setMobilePhoneNumber(mobilePhoneNumber);
    }

    /**
     * setCreateTime method sets creation time of user note.
     */
    public void setCreateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        user.setCreateTime(dateFormat.format(date));
    }

    public User getUser(){
        return user;
    }


}
