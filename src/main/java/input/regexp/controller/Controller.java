package input.regexp.controller;

import input.regexp.view.View;
import input.regexp.model.Model;
import java.util.*;

/**
 * Controller class is used to input, verify and check data form the console.
 * In case input is OK it can call Model class for writing data into NoteBook class.
 * @see input.regexp.model.Model
 * @see input.regexp.model.NoteBook
 *
 * Controller display all the messages to the console with View class.
 * @see input.regexp.view.View
 *
 * Controller uses regular expressions for checking user input.
 * Regexp and messages located in properties.
 *
 * Created on 07.04.2019
 * @author Andrii Kolomiiets
 */
public class Controller {
    private Model model;
    private View view;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("message_and_regexp_en_GB",
            new Locale("en","GB"));

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * processUser method is used to interact with user through View
     * get and check user input via getAndCheckUserInput method and send data to Model.
     * Method process First Name, Last Name, Nick Name, Email, Home Phone, Mobile Phone and send them to Model.
     * Method call view for displaying saved information.
     * */
    public void processUser() {
        Scanner in = new Scanner(System.in);
        setLocale(in);
        model.setFirstName(getAndCheckUserInput(resourceBundle.getString("first.name.input.message"),
                resourceBundle.getString("first.last.name.regexp"), in));
        model.setLastName(getAndCheckUserInput(resourceBundle.getString("last.name.input.message"),
                resourceBundle.getString("first.last.name.regexp"), in));
        model.setNickName(getAndCheckUserInput(resourceBundle.getString("nick.name.input.message"),
                resourceBundle.getString("nick.name.regexp"), in));
        model.setEmail(getAndCheckUserInput(resourceBundle.getString("email.input.message"),
                resourceBundle.getString("email.regexp"), in));
        model.setHomePhoneNumber(getAndCheckUserInput(resourceBundle.getString("home.phone.input.message"),
                resourceBundle.getString("home.phone.regexp"), in));
        model.setMobilePhoneNumber(getAndCheckUserInput(resourceBundle.getString("mobile.phone.input.message"),
                resourceBundle.getString("mobile.phone.regexp"), in));
        in.close();

        model.setCreateTime();
        view.printNote(model.getNoteBook());
    }

    /**
     * setLocation method changes NoteBook locale.
     */
    private void setLocale(Scanner scanner) {
        view.printMessage(resourceBundle.getString("locale.input.message"));

        String inputLocale = scanner.next();
        if (inputLocale.equalsIgnoreCase("ua")) {
            this.resourceBundle = ResourceBundle.getBundle("message_and_regexp_uk_UA",
                    new Locale("uk", "UA"));
        } else {
            this.resourceBundle = ResourceBundle.getBundle("message_and_regexp_en_GB");
        }
    }

    /**
     * getAndCheckUserInput method get user input with scanner and check input with regular expressions.
     * @param inputMessage - message user sees before the input starts
     * @param regexp - regular expression for checking user input
     * @param scanner - example of class Scanner for getting user input from console
     */
    private String getAndCheckUserInput(String inputMessage, String regexp, Scanner scanner) {
        while (true) {
            view.printMessage(inputMessage);
            String input = scanner.next();
            if (input.matches(regexp)) {
                return input;
            } else {
                view.printMessage(resourceBundle.getString("wrong.input.message"));
            }
        }
    }


}
