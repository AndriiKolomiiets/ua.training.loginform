package input.regexp;

import input.regexp.controller.JDBC;
import input.regexp.view.View;
import input.regexp.controller.Controller;
import input.regexp.model.Model;

/**
 * This is starting point of the program.
 * @author Andrii Kolomiiets
 *  * Created on 07.04.2019
 */
public class NoteBookMVC {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        JDBC jdbc = JDBC.getInstance();
        Controller inputController = new Controller(model,view, jdbc);
        inputController.processUser();
    }
}
