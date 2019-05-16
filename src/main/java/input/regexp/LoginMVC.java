package input.regexp;

import input.regexp.controller.JDBC;
import input.regexp.model.Dao;
import input.regexp.model.UserDao;
import input.regexp.view.View;
import input.regexp.controller.Controller;
import input.regexp.model.Model;

/**
 * This is starting point of the program.
 * @author Andrii Kolomiiets
 *  * Created on 07.04.2019
 */
public class LoginMVC {
    public static void main(String[] args) {
        JDBC jdbc = JDBC.getInstance();
        Model model = new Model();
        View view = new View();
        Dao dao = new UserDao(jdbc);
        Controller inputController = new Controller(model,view, dao);
        inputController.processUser();
    }
}
