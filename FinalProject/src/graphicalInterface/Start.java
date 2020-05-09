package graphicalInterface;
import controllers.LoginController;

public class Start {
	private static boolean simulationOn = false;
	private static double simulationHoursPerSecond = 2.;
	
	public static void main(String[] args) {
		LoginController controller = new LoginController();
		controller.setSimulation(simulationOn, simulationHoursPerSecond);
	}

}
