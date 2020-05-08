package graphicalInterface;
import controllers.LoginController;

public class Start {
	private static boolean simulationOn = false;
	private static double simulationHoursPerSecond = 1.;
	
	public static void main(String[] args) {
		LoginController controller = new LoginController();
		controller.setSimulation(simulationOn, simulationHoursPerSecond);
	}

}
