package input.regexp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Model process user data and write it into NoteBook.
 * @author Andrii Kolomiiets
 * Created on 07.04.2019
 */

public class Model {

    NoteBook noteBook = new NoteBook();

    public void setFirstName(String firstName) {
        noteBook.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        noteBook.setLastName(lastName);
    }

    public void setNickName(String nickName) {
        noteBook.setNickName(nickName);
    }

    /**
     * setInitials method form user initials.
     */
    public void setInitials(String firstName, String lastName) {
        StringBuffer stringBuffer = new StringBuffer(firstName);
        char nameInitial = stringBuffer.charAt(0);
        StringBuffer strBuf = new StringBuffer(lastName);
        String initials = new String(strBuf.append(" " + nameInitial + "."));
        noteBook.setInitials(initials);
    }

    public void setEmail(String email) {
        noteBook.setEmail(email);
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
       noteBook.setHomePhoneNumber(homePhoneNumber);
    }

    public void setMobilePhoneNumber (String mobilePhoneNumber){
        noteBook.setMobilePhoneNumber(mobilePhoneNumber);
    }

    /**
     * setCreateTime method sets creation time of user note.
     */
    public void setCreateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        noteBook.setCreateTime(dateFormat.format(date));
    }

    public NoteBook getNoteBook(){
        return noteBook;
    }


}
