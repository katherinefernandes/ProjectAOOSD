package graphicalInterface;
import controllers.LoginController;

public class Start {
	private static boolean simulationOn = true;
	private static double simulationHoursPerSecond = 6.;
	
	public static void main(String[] args) {
		LoginController controller = new LoginController();
		controller.setSimulation(simulationOn, simulationHoursPerSecond);
	}

}
