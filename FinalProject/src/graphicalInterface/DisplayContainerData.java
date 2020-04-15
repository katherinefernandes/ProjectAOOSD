package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;

public class DisplayContainerData {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayContainerData window = new DisplayContainerData();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayContainerData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBounds(100, 100, 542, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(34, 46, 476, 370);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea txtrThisIsThe = new JTextArea();
		txtrThisIsThe.setBackground(new Color(95, 158, 160));
		txtrThisIsThe.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrThisIsThe.setEditable(false);
		txtrThisIsThe.setText("This is the container ID:");
		txtrThisIsThe.setBounds(41, 42, 173, 16);
		panel.add(txtrThisIsThe);
		
		JTextArea txtrCargo = new JTextArea();
		txtrCargo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCargo.setBackground(new Color(95, 158, 160));
		txtrCargo.setEditable(false);
		txtrCargo.setText("Cargo:");
		txtrCargo.setBounds(166, 70, 48, 30);
		panel.add(txtrCargo);
		
		JTextArea txtrItIsLocated = new JTextArea();
		txtrItIsLocated.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrItIsLocated.setBackground(new Color(95, 158, 160));
		txtrItIsLocated.setEditable(false);
		txtrItIsLocated.setText("It is located at latitude:");
		txtrItIsLocated.setBounds(46, 108, 168, 16);
		panel.add(txtrItIsLocated);
		
		JTextArea txtrItIsLocated_1 = new JTextArea();
		txtrItIsLocated_1.setBackground(new Color(95, 158, 160));
		txtrItIsLocated_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrItIsLocated_1.setEditable(false);
		txtrItIsLocated_1.setText("It is located at longitude:");
		txtrItIsLocated_1.setBounds(33, 136, 181, 30);
		panel.add(txtrItIsLocated_1);
		
		JTextArea txtrTheInternalAtmosphere = new JTextArea();
		txtrTheInternalAtmosphere.setBackground(new Color(95, 158, 160));
		txtrTheInternalAtmosphere.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrTheInternalAtmosphere.setEditable(false);
		txtrTheInternalAtmosphere.setText("The internal atmosphere:");
		txtrTheInternalAtmosphere.setBounds(33, 170, 181, 30);
		panel.add(txtrTheInternalAtmosphere);
		
		JTextArea txtrTheInternalTemperature = new JTextArea();
		txtrTheInternalTemperature.setBackground(new Color(95, 158, 160));
		txtrTheInternalTemperature.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrTheInternalTemperature.setEditable(false);
		txtrTheInternalTemperature.setText("The internal Temperature:");
		txtrTheInternalTemperature.setBounds(24, 199, 192, 30);
		panel.add(txtrTheInternalTemperature);
		
		JTextArea txtrTheInternalHumidity = new JTextArea();
		txtrTheInternalHumidity.setBackground(new Color(95, 158, 160));
		txtrTheInternalHumidity.setEditable(false);
		txtrTheInternalHumidity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrTheInternalHumidity.setText("The internal Humidity:");
		txtrTheInternalHumidity.setBounds(46, 229, 168, 24);
		panel.add(txtrTheInternalHumidity);
		
		JTextArea txtrLastUpdated = new JTextArea();
		txtrLastUpdated.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrLastUpdated.setBackground(new Color(95, 158, 160));
		txtrLastUpdated.setEditable(false);
		txtrLastUpdated.setText("Last updated:");
		txtrLastUpdated.setBounds(113, 259, 115, 24);
		panel.add(txtrLastUpdated);
		
		JTextArea txtrEstimatedDateOf = new JTextArea();
		txtrEstimatedDateOf.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrEstimatedDateOf.setBackground(new Color(95, 158, 160));
		txtrEstimatedDateOf.setEditable(false);
		txtrEstimatedDateOf.setText("Estimated date of arrival:");
		txtrEstimatedDateOf.setBounds(28, 294, 186, 16);
		panel.add(txtrEstimatedDateOf);
		
		JTextArea ContainerIDtextbox = new JTextArea();
		ContainerIDtextbox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		ContainerIDtextbox.setEditable(false);
		ContainerIDtextbox.setBackground(new Color(95, 158, 160));
		ContainerIDtextbox.setBounds(249, 44, 199, 16);
		panel.add(ContainerIDtextbox);
		
		JTextArea Cargotextbox = new JTextArea();
		Cargotextbox.setEditable(false);
		Cargotextbox.setBackground(new Color(95, 158, 160));
		Cargotextbox.setBounds(247, 72, 201, 16);
		panel.add(Cargotextbox);
		
		JTextArea latitudetextboc = new JTextArea();
		latitudetextboc.setEditable(false);
		latitudetextboc.setBackground(new Color(95, 158, 160));
		latitudetextboc.setBounds(247, 110, 192, 16);
		panel.add(latitudetextboc);
		
		JTextArea longitudetextbox = new JTextArea();
		longitudetextbox.setEditable(false);
		longitudetextbox.setBackground(new Color(95, 158, 160));
		longitudetextbox.setBounds(249, 138, 209, 16);
		panel.add(longitudetextbox);
		
		JTextArea atmospheretextbox = new JTextArea();
		atmospheretextbox.setEditable(false);
		atmospheretextbox.setBackground(new Color(95, 158, 160));
		atmospheretextbox.setBounds(249, 172, 168, 16);
		panel.add(atmospheretextbox);
		
		JTextArea temperaturetextbox = new JTextArea();
		temperaturetextbox.setBackground(new Color(95, 158, 160));
		temperaturetextbox.setEditable(false);
		temperaturetextbox.setBounds(249, 201, 168, 16);
		panel.add(temperaturetextbox);
		
		JTextArea humiditytextbox = new JTextArea();
		humiditytextbox.setEditable(false);
		humiditytextbox.setBackground(new Color(95, 158, 160));
		humiditytextbox.setBounds(247, 231, 181, 16);
		panel.add(humiditytextbox);
		
		JTextArea updatedtextbox = new JTextArea();
		updatedtextbox.setEditable(false);
		updatedtextbox.setBackground(new Color(95, 158, 160));
		updatedtextbox.setBounds(246, 261, 192, 16);
		panel.add(updatedtextbox);
		
		JTextArea arrivaldatetextbox = new JTextArea();
		arrivaldatetextbox.setBackground(new Color(95, 158, 160));
		arrivaldatetextbox.setEditable(false);
		arrivaldatetextbox.setBounds(241, 296, 176, 16);
		panel.add(arrivaldatetextbox);
		
		JButton Goback = new JButton("Main Menu");
		Goback.setBounds(331, 335, 117, 29);
		panel.add(Goback);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(34, 6, 476, 28);
		frame.getContentPane().add(panel_1);
		
		JTextArea txtrHereIsAll = new JTextArea();
		txtrHereIsAll.setBackground(new Color(95, 158, 160));
		txtrHereIsAll.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrHereIsAll.setEditable(false);
		txtrHereIsAll.setText("Here is all the data available about the container ");
		panel_1.add(txtrHereIsAll);
	}
}
