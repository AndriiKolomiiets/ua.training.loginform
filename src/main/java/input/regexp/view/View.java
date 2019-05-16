package input.regexp.view;

import input.regexp.model.User;

/**
 * View class display messages and Note information on console.
 * @author Andrii Kolomiiets
 * Created on 07.04.2019
 */
public class View {
    public void printMessage(String message){
        System.out.println(message);
    }

    public void printNote(User user){
        System.out.println(user);
    }
}
