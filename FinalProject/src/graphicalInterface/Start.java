package graphicalInterface;
import controllers.LoginController;

public class Start {
	private static boolean simulationOn = false;
	private static double simulationHoursPerSecond = 2.;
	
	public static void main(String[] args) {		
		if(args.length > 0) {
			if(args[0].toLowerCase().equals("true")) {
				simulationOn = true;
			}
		}
		if(args.length > 1) {
			simulationHoursPerSecond = Double.parseDouble(args[1]);
		}
		
		LoginController controller = new LoginController();
		controller.setSimulation(simulationOn, simulationHoursPerSecond);
	}

}
