import graphicalInterface.Login_Window;
import logic.Controller;

public class Start {

	public static void main(String[] args) {
		Controller controller = new Controller();
		Login_Window window = new Login_Window(controller);
		window.frmLoginPage.setVisible(true);
	}

}
