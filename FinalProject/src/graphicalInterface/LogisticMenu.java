package graphicalInterface;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import controllers.LoginController;
import controllers.LogisticController;
import graphsForInternalStatus.LineGraphHumidity;
import graphsForInternalStatus.LineGraphPressure;
import graphsForInternalStatus.LineGraphTemperature;
import worldMap.MapPane;

public class LogisticMenu {
	public JFrame frame;
	public JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8,textField_9,textField_10;
	public JTextField textField_11,textField_12,textField_13,textField_14,textField_15;
    public JPanel panel,panel_1,ContainePositionrPanel,newClientPanel,ContainerInfoPanel,StatusPanel;
    public JButton newClientButton,getInfoButton,UpdateContainerButton,logoutButton;
    public JLayeredPane layeredPane;
    private LogisticController controller;
	private JTextArea txtrSomethingWentWrong;
	private JTextArea txtrSuccess;
	private JTextField containerIDtextstatus;
	private JTextField textField_16;
	private JTextArea statusError;
	private JTextArea successStatus;
	private JPanel viewContainerPanel;
	private JTextArea viewContainerText;
	private JTextArea successPosition;
	private JTextArea positionError;
	private JTextField clientemailTextField;
	private JTextField companyNameTextField;
	private JTextField clientPhoneTextField;
	private JTextField firstNameTextField;
	private JTextField middlenameTextField;
	private JTextField lastNameTextField;
	private JTextArea searchError;
	private JTextArea successSearch;
	private JTextArea viewClientTextField;
	private JButton getClientIfoButton;
	private JPanel viewClientPanel;
	private JButton viewJourneysButton;
    private String containerIDForGraphs;
	private JButton temperatureGraphButton;
	private JButton atmosphereGraphButton;
	private JButton humidityGraphButton;
	private JPanel searchClientPanel;
	private JPanel updateContainerPortPanel;
	private JTextField updatePortContainerID;
	private JTextField updatePortName;
	private JTextArea updateCurrentPortError;
	private JButton mapButton;
    
    public LogisticMenu(LogisticController controller) {
		this.controller = controller;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 698, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 212, 412);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		newClientButton = new JButton("Add a new Client");
		newClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrSuccess.setVisible(false);
				txtrSomethingWentWrong.setVisible(false);
				switchPanels(newClientPanel);
			} 
		});
		newClientButton.setBounds(19, 54, 187, 29);
		panel.add(newClientButton);
		
		getInfoButton = new JButton("Update Container Status");
		getInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusError.setVisible(false);
				successStatus.setVisible(false);
				switchPanels(StatusPanel);
			}
		});
		getInfoButton.setBounds(19, 91, 187, 29);
		panel.add(getInfoButton);
		
		UpdateContainerButton = new JButton("Update container Position");
		UpdateContainerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positionError.setVisible(false);
				successPosition.setVisible(false);
				switchPanels(ContainePositionrPanel);
			}
		});
		UpdateContainerButton.setBounds(19, 132, 187, 29);
		panel.add(UpdateContainerButton);
		
		logoutButton = new JButton("Log Out");
		logoutButton.setBounds(19, 332, 187, 29);
		logoutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("The logout button has been pressed, now need to swtich windows");
				LoginController login = new LoginController();
				frame.setVisible(false);
			}
			
		});
		panel.add(logoutButton);
		

		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(212, 0, 486, 412);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		layeredPane = new JLayeredPane();
		panel_1.add(layeredPane, "name_21719901481320");
		
		newClientPanel = new JPanel();
		layeredPane.setLayer(newClientPanel, 1);
		newClientPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(newClientPanel);
		newClientPanel.setBackground(new Color(95, 158, 160));
		newClientPanel.setLayout(null);
		
		JTextArea txtrCompanyName = new JTextArea();
		txtrCompanyName.setBounds(24, 26, 112, 16);
		txtrCompanyName.setText("Company Name:");
		txtrCompanyName.setEditable(false);
		txtrCompanyName.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrCompanyName);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setBounds(24, 60, 112, 16);
		txtrEmail.setText("E-mail:");
		txtrEmail.setEditable(false);
		txtrEmail.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrEmail);
		
		JTextArea txtrCountryCode = new JTextArea();
		txtrCountryCode.setBounds(24, 88, 112, 16);
		txtrCountryCode.setText("Country Code:");
		txtrCountryCode.setEditable(false);
		txtrCountryCode.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrCountryCode);
		
		JTextArea txtrPhoneNumber = new JTextArea();
		txtrPhoneNumber.setBounds(24, 118, 112, 16);
		txtrPhoneNumber.setText("Phone Number:");
		txtrPhoneNumber.setEditable(false);
		txtrPhoneNumber.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrPhoneNumber);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setBounds(24, 146, 112, 16);
		txtrFirstName.setText("First Name:");
		txtrFirstName.setEditable(false);
		txtrFirstName.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrFirstName);
		
		JTextArea txtrMiddleName = new JTextArea();
		txtrMiddleName.setBounds(24, 174, 112, 16);
		txtrMiddleName.setText("Middle Name:");
		txtrMiddleName.setEditable(false);
		txtrMiddleName.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrMiddleName);
		
		JTextArea txtrLastName = new JTextArea();
		txtrLastName.setBounds(24, 204, 112, 16);
		txtrLastName.setText("Last Name:");
		txtrLastName.setEditable(false);
		txtrLastName.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrLastName);
		
		JTextArea txtrStreet = new JTextArea();
		txtrStreet.setBounds(24, 232, 112, 16);
		txtrStreet.setText("Street:");
		txtrStreet.setEditable(false);
		txtrStreet.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrStreet);
		
		JTextArea txtrCity = new JTextArea();
		txtrCity.setBounds(24, 260, 112, 16);
		txtrCity.setText("City:");
		txtrCity.setEditable(false);
		txtrCity.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrCity);
		
		JTextArea txtrBuilding = new JTextArea();
		txtrBuilding.setBounds(24, 291, 112, 16);
		txtrBuilding.setText("Building:");
		txtrBuilding.setEditable(false);
		txtrBuilding.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrBuilding);
		
		JTextArea txtrPostalCode = new JTextArea();
		txtrPostalCode.setBounds(24, 319, 112, 16);
		txtrPostalCode.setText("Postal Code:");
		txtrPostalCode.setEditable(false);
		txtrPostalCode.setBackground(new Color(95, 158, 160));
		newClientPanel.add(txtrPostalCode);
		
		textField = new JTextField();
		textField.setBounds(164, 21, 166, 26);
		newClientPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 55, 166, 26);
		newClientPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 83, 166, 26);
		newClientPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 113, 166, 26);
		newClientPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(164, 141, 166, 26);
		newClientPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(164, 169, 166, 26);
		newClientPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(164, 199, 166, 26);
		newClientPanel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(164, 227, 166, 26);
		newClientPanel.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(164, 255, 166, 26);
		newClientPanel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(164, 286, 166, 26);
		newClientPanel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(164, 314, 166, 26);
		newClientPanel.add(textField_10);
		textField_10.setColumns(10);
		
		JButton Save1 = new JButton("Save");
		Save1.setBounds(213, 351, 117, 29);
		Save1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String middlename;
				if(textField_10.getText().isEmpty()||textField_9.getText().isEmpty()||textField_8.getText().isEmpty()||textField_7.getText().isEmpty()||textField_6.getText().isEmpty()||textField_4.getText().isEmpty()||textField_3.getText().isEmpty()||textField_2.getText().isEmpty()||textField_1.getText().isEmpty()||textField.getText().isEmpty()) {
					System.out.println("One of the fields is empty, please try again");
					txtrSomethingWentWrong.setVisible(true);
					return;
				}else {
					if(textField_5.getText().isEmpty()) {
						 middlename = " ";
						 
					}
					else {
						middlename = textField_5.getText();
					}
					boolean checkMessage = controller.addNewClient(textField_10.getText(),textField_9.getText(),textField_8.getText(),textField_7.getText(),textField_6.getText(),middlename,textField_4.getText(),textField_3.getText(),textField_2.getText(),textField_1.getText(),textField.getText());
				    if(checkMessage) {
				    	txtrSomethingWentWrong.setVisible(false);
				    	txtrSuccess.setVisible(true);
				   
				    
				    }
				    else {
				    	txtrSuccess.setVisible(false);
				    	txtrSomethingWentWrong.setVisible(true);
				    	
				    	
				    }
				}
				
				clearDataFields(textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8,textField_9,textField_10);
			}
		});
		newClientPanel.add(Save1);
		
		txtrSuccess = new JTextArea();
		txtrSuccess.setBounds(92, 356, 82, 16);
		txtrSuccess.setBackground(new Color(95, 158, 160));
		txtrSuccess.setForeground(new Color(124, 252, 0));
		txtrSuccess.setText("Success");
		txtrSuccess.setEditable(false);
		newClientPanel.add(txtrSuccess);
		txtrSuccess.setVisible(false);
		
		txtrSomethingWentWrong = new JTextArea();
		txtrSomethingWentWrong.setBounds(93, 375, 236, 16);
		txtrSomethingWentWrong.setText("Something went wrong. Try again");
		txtrSomethingWentWrong.setBackground(new Color(95, 158, 160));
		txtrSomethingWentWrong.setForeground(new Color(255, 0, 0));
		txtrSomethingWentWrong.setEditable(false);
		newClientPanel.add(txtrSomethingWentWrong);
		txtrSomethingWentWrong.setVisible(false);
		
		ContainePositionrPanel = new JPanel();
		layeredPane.setLayer(ContainePositionrPanel, 0);
		ContainePositionrPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(ContainePositionrPanel);
		ContainePositionrPanel.setBackground(new Color(95, 158, 160));
		ContainePositionrPanel.setLayout(null);
		
		JTextArea txtrNewLongitude = new JTextArea();
		txtrNewLongitude.setToolTipText("");
		txtrNewLongitude.setText("New longitude:");
		txtrNewLongitude.setEditable(false);
		txtrNewLongitude.setBackground(new Color(95, 158, 160));
		txtrNewLongitude.setBounds(32, 106, 101, 16);
		ContainePositionrPanel.add(txtrNewLongitude);
		
		JTextArea txtrNewLatitude = new JTextArea();
		txtrNewLatitude.setToolTipText("");
		txtrNewLatitude.setText("New latitude:");
		txtrNewLatitude.setEditable(false);
		txtrNewLatitude.setBackground(new Color(95, 158, 160));
		txtrNewLatitude.setBounds(32, 147, 101, 16);
		ContainePositionrPanel.add(txtrNewLatitude);
		
		textField_14 = new JTextField();
		textField_14.setBounds(145, 101, 183, 26);
		ContainePositionrPanel.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(145, 142, 183, 26);
		ContainePositionrPanel.add(textField_15);
		textField_15.setColumns(10);
		
		JButton Save2 = new JButton("Save");
		Save2.setBounds(211, 193, 117, 29);
		Save2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				successPosition.setVisible(false);
				positionError.setVisible(false);
				if(textField_16.getText().isEmpty()||textField_14.getText().isEmpty()||textField_15.getText().isEmpty()) {
					System.out.println("One of the text fields is empty, try again");
					positionError.setVisible(true);
					return;
				}else {
					containerIDForGraphs=textField_16.getText();
					controller.updateContainerPosition(textField_16.getText(),textField_14.getText(),textField_15.getText());
				}
				if(controller.checkMessage()) {
					viewContainerText.setText(controller.getContainerData());
					switchPanels(viewContainerPanel);
				}
				clearDataFields(textField_16,textField_14,textField_15);
			
		}}); 
		
		ContainePositionrPanel.add(Save2);
		
		JTextArea txtrContainerId_2 = new JTextArea();
		txtrContainerId_2.setToolTipText("");
		txtrContainerId_2.setText("Container ID:");
		txtrContainerId_2.setEditable(false);
		txtrContainerId_2.setBackground(new Color(95, 158, 160));
		txtrContainerId_2.setBounds(32, 62, 101, 16);
		ContainePositionrPanel.add(txtrContainerId_2);
		
		successPosition = new JTextArea();
		successPosition.setForeground(new Color(50, 205, 50));
		successPosition.setToolTipText("");
		successPosition.setText("Success");
		successPosition.setEditable(false);
		successPosition.setBackground(new Color(95, 158, 160));
		successPosition.setBounds(239, 225, 89, 16);
		ContainePositionrPanel.add(successPosition);
		successPosition.setVisible(false);
		
		
		positionError = new JTextArea();
		positionError.setForeground(new Color(255, 0, 0));
		positionError.setToolTipText("");
		positionError.setText("No container was found.");
		positionError.setEditable(false);
		positionError.setBackground(new Color(95, 158, 160));
		positionError.setBounds(32, 198, 175, 16);
		ContainePositionrPanel.add(positionError);
		positionError.setVisible(false);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(145, 57, 183, 26);
		ContainePositionrPanel.add(textField_16);
		
		StatusPanel = new JPanel();
		layeredPane.setLayer(StatusPanel, 0);
		StatusPanel.setBackground(new Color(95, 158, 160));
		StatusPanel.setBounds(0, 0, 480, 406);
		layeredPane.add(StatusPanel);
		StatusPanel.setLayout(null);
		
		JTextArea txtrConfusedAboutThis = new JTextArea();
		txtrConfusedAboutThis.setToolTipText("");
		txtrConfusedAboutThis.setBackground(new Color(95, 158, 160));
		txtrConfusedAboutThis.setEditable(false);
		txtrConfusedAboutThis.setText("New Atmosphere Pressure:");
		txtrConfusedAboutThis.setBounds(25, 102, 175, 16);
		StatusPanel.add(txtrConfusedAboutThis);
		
		JTextArea txtrNew = new JTextArea();
		txtrNew.setToolTipText("");
		txtrNew.setText("New Humidity Levels :");
		txtrNew.setEditable(false);
		txtrNew.setBackground(new Color(95, 158, 160));
		txtrNew.setBounds(25, 139, 175, 16);
		StatusPanel.add(txtrNew);
		
		JTextArea txtrNewTemperatureLevels = new JTextArea();
		txtrNewTemperatureLevels.setToolTipText("");
		txtrNewTemperatureLevels.setText("New Temperature Levels:");
		txtrNewTemperatureLevels.setEditable(false);
		txtrNewTemperatureLevels.setBackground(new Color(95, 158, 160));
		txtrNewTemperatureLevels.setBounds(25, 182, 175, 16);
		StatusPanel.add(txtrNewTemperatureLevels);
		
		textField_11 = new JTextField();
		textField_11.setBounds(222, 97, 160, 26);
		StatusPanel.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(222, 134, 160, 26);
		StatusPanel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(222, 177, 160, 26);
		StatusPanel.add(textField_13);
		textField_13.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(265, 225, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				successStatus.setVisible(false);
				statusError.setVisible(false);
				if(containerIDtextstatus.getText().isEmpty()||textField_11.getText().isEmpty()||textField_12.getText().isEmpty()||textField_13.getText().isEmpty()) {
					System.out.println("One of the textfields is empty, try again");
					statusError.setVisible(true);
					clearDataFields(containerIDtextstatus,textField_11,textField_12,textField_13);
					return;
				}else {
					containerIDForGraphs=containerIDtextstatus.getText();
					controller.updateContainerStatus(containerIDtextstatus.getText(),textField_11.getText(),textField_12.getText(),textField_13.getText());
					
				}
				if(controller.checkMessage()){
					viewContainerText.setText(controller.getContainerData());
					switchPanels(viewContainerPanel);
					
				}
				
				clearDataFields(containerIDtextstatus,textField_11,textField_12,textField_13);
			
		}});
		StatusPanel.add(btnNewButton);
		
		JTextArea txtrContainerId_1 = new JTextArea();
		txtrContainerId_1.setToolTipText("");
		txtrContainerId_1.setText("Container ID:");
		txtrContainerId_1.setEditable(false);
		txtrContainerId_1.setBackground(new Color(95, 158, 160));
		txtrContainerId_1.setBounds(25, 61, 175, 16);
		StatusPanel.add(txtrContainerId_1);
		
		containerIDtextstatus = new JTextField();
		containerIDtextstatus.setColumns(10);
		containerIDtextstatus.setBounds(222, 56, 160, 26);
		StatusPanel.add(containerIDtextstatus);
		
		statusError = new JTextArea();
		statusError.setForeground(new Color(255, 69, 0));
		statusError.setToolTipText("");
		statusError.setText("Container not found.");
		statusError.setEditable(false);
		statusError.setBackground(new Color(95, 158, 160));
		statusError.setBounds(102, 230, 175, 16);
		StatusPanel.add(statusError);
		statusError.setVisible(false);
		
		successStatus = new JTextArea();
		successStatus.setForeground(new Color(50, 205, 50));
		successStatus.setToolTipText("");
		successStatus.setText("Success");
		successStatus.setEditable(false);
		successStatus.setBackground(new Color(95, 158, 160));
		successStatus.setBounds(245, 251, 175, 16);
		StatusPanel.add(successStatus);
		successStatus.setVisible(false);
		
		updateContainerPortPanel = new JPanel();
		layeredPane.setLayer(updateContainerPortPanel, 0);
		updateContainerPortPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(updateContainerPortPanel);
		updateContainerPortPanel.setBackground(new Color(95, 158, 160));
		updateContainerPortPanel.setLayout(null);
		
		JTextArea txtrContainerId_3 = new JTextArea();
		txtrContainerId_3.setBackground(new Color(95, 158, 160));
		txtrContainerId_3.setText("Container ID:");
		txtrContainerId_3.setEditable(false);
		txtrContainerId_3.setBounds(43, 73, 148, 16);
		updateContainerPortPanel.add(txtrContainerId_3);
		
		JTextArea txtrContainerId_3_1 = new JTextArea();
		txtrContainerId_3_1.setText("Port Name:");
		txtrContainerId_3_1.setEditable(false);
		txtrContainerId_3_1.setBackground(new Color(95, 158, 160));
		txtrContainerId_3_1.setBounds(43, 115, 148, 16);
		updateContainerPortPanel.add(txtrContainerId_3_1);
		
		updatePortContainerID = new JTextField();
		updatePortContainerID.setBounds(242, 68, 217, 26);
		updateContainerPortPanel.add(updatePortContainerID);
		updatePortContainerID.setColumns(10);
		
		updatePortName = new JTextField();
		updatePortName.setColumns(10);
		updatePortName.setBounds(242, 106, 217, 26);
		updateContainerPortPanel.add(updatePortName);
		
		JButton updatePortSaveButton = new JButton("Save");
		updatePortSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCurrentPortError.setVisible(false);
				if(updatePortContainerID.getText().isEmpty()&&updatePortName.getText().isEmpty()) {
					updateCurrentPortError.setVisible(true);
					System.out.println("One of the text fields is empty");
					clearDataFields(updatePortContainerID,updatePortName);
					return;
				}else {
					containerIDForGraphs=updatePortContainerID.getText();
					controller.updateContainerPort(updatePortContainerID.getText(),updatePortName.getText());
					
				}
				if(controller.checkMessage()){
					viewContainerText.setText(controller.getContainerData());
					switchPanels(viewContainerPanel);
					
				}
				else {
					updateCurrentPortError.setVisible(true);
				}
				
				clearDataFields(containerIDtextstatus,textField_11,textField_12,textField_13);
			}
		});
		updatePortSaveButton.setBounds(342, 177, 117, 29);
		updateContainerPortPanel.add(updatePortSaveButton);
		
		updateCurrentPortError = new JTextArea();
		updateCurrentPortError.setForeground(new Color(165, 42, 42));
		updateCurrentPortError.setText("Something went wrong. Try again!");
		updateCurrentPortError.setBackground(new Color(95, 158, 160));
		updateCurrentPortError.setEditable(false);
		updateCurrentPortError.setBounds(56, 182, 274, 16);
		updateContainerPortPanel.add(updateCurrentPortError);
		
		
		ContainerInfoPanel = new JPanel();
		ContainerInfoPanel.setBackground(new Color(95, 158, 160));
		layeredPane.setLayer(ContainerInfoPanel, 0);
		ContainerInfoPanel.setBounds(0, 0, 480, 406);
		layeredPane.add(ContainerInfoPanel);
		ContainerInfoPanel.setLayout(null);
		
		JTextArea txtrContainerId = new JTextArea();
		txtrContainerId.setBackground(new Color(95, 158, 160));
		txtrContainerId.setEditable(false);
		txtrContainerId.setText("Container ID:");
		txtrContainerId.setBounds(31, 51, 89, 16);
		ContainerInfoPanel.add(txtrContainerId);
		
		JTextArea txtrCargo = new JTextArea();
		txtrCargo.setText("Cargo:");
		txtrCargo.setEditable(false);
		txtrCargo.setBackground(new Color(95, 158, 160));
		txtrCargo.setBounds(31, 79, 89, 16);
		ContainerInfoPanel.add(txtrCargo);
		
		JTextArea txtrLatitude = new JTextArea();
		txtrLatitude.setText("Latitude:");
		txtrLatitude.setEditable(false);
		txtrLatitude.setBackground(new Color(95, 158, 160));
		txtrLatitude.setBounds(31, 107, 89, 16);
		ContainerInfoPanel.add(txtrLatitude);
		
		JTextArea txtrLongitude = new JTextArea();
		txtrLongitude.setText("Longitude:");
		txtrLongitude.setEditable(false);
		txtrLongitude.setBackground(new Color(95, 158, 160));
		txtrLongitude.setBounds(31, 132, 89, 16);
		ContainerInfoPanel.add(txtrLongitude);
		
		JTextArea txtrInternalAtmosphere = new JTextArea();
		txtrInternalAtmosphere.setText("Internal Atmosphere:");
		txtrInternalAtmosphere.setEditable(false);
		txtrInternalAtmosphere.setBackground(new Color(95, 158, 160));
		txtrInternalAtmosphere.setBounds(31, 159, 140, 16);
		ContainerInfoPanel.add(txtrInternalAtmosphere);
		
		JTextArea txtrInternalHumidity = new JTextArea();
		txtrInternalHumidity.setText("Internal Humidity:");
		txtrInternalHumidity.setEditable(false);
		txtrInternalHumidity.setBackground(new Color(95, 158, 160));
		txtrInternalHumidity.setBounds(31, 188, 115, 16);
		ContainerInfoPanel.add(txtrInternalHumidity);
		
		JTextArea txtrInternalHumidity_1 = new JTextArea();
		txtrInternalHumidity_1.setText("Internal Temperature:");
		txtrInternalHumidity_1.setEditable(false);
		txtrInternalHumidity_1.setBackground(new Color(95, 158, 160));
		txtrInternalHumidity_1.setBounds(31, 217, 140, 16);
		ContainerInfoPanel.add(txtrInternalHumidity_1);
		
		JTextArea txtrLastUpdated = new JTextArea();
		txtrLastUpdated.setText("Last Updated:");
		txtrLastUpdated.setEditable(false);
		txtrLastUpdated.setBackground(new Color(95, 158, 160));
		txtrLastUpdated.setBounds(31, 246, 115, 16);
		ContainerInfoPanel.add(txtrLastUpdated);
		
		JTextArea txtrEstimatedDateOf = new JTextArea();
		txtrEstimatedDateOf.setText("Estimated date of arrival:");
		txtrEstimatedDateOf.setEditable(false);
		txtrEstimatedDateOf.setBackground(new Color(95, 158, 160));
		txtrEstimatedDateOf.setBounds(31, 274, 166, 16);
		ContainerInfoPanel.add(txtrEstimatedDateOf);
		
		JTextArea ContainerIDtext = new JTextArea();
		ContainerIDtext.setEditable(false);
		ContainerIDtext.setBackground(new Color(95, 158, 160));
		ContainerIDtext.setBounds(218, 51, 128, 16);
		ContainerInfoPanel.add(ContainerIDtext);
		
		JTextArea CargoText = new JTextArea();
		CargoText.setEditable(false);
		CargoText.setBackground(new Color(95, 158, 160));
		CargoText.setBounds(218, 79, 140, 16);
		ContainerInfoPanel.add(CargoText);
		
		JTextArea latitudetext = new JTextArea();
		latitudetext.setEditable(false);
		latitudetext.setBackground(new Color(95, 158, 160));
		latitudetext.setBounds(217, 107, 141, 16);
		ContainerInfoPanel.add(latitudetext);
		
		JTextArea longitudetext = new JTextArea();
		longitudetext.setEditable(false);
		longitudetext.setBackground(new Color(95, 158, 160));
		longitudetext.setBounds(214, 132, 144, 16);
		ContainerInfoPanel.add(longitudetext);
		
		JTextArea atmospheretext = new JTextArea();
		atmospheretext.setEditable(false);
		atmospheretext.setBackground(new Color(95, 158, 160));
		atmospheretext.setBounds(214, 159, 160, 16);
		ContainerInfoPanel.add(atmospheretext);
		
		JTextArea humiditytext = new JTextArea();
		humiditytext.setEditable(false);
		humiditytext.setBackground(new Color(95, 158, 160));
		humiditytext.setBounds(214, 188, 144, 16);
		ContainerInfoPanel.add(humiditytext);
		
		JTextArea temperaturetext = new JTextArea();
		temperaturetext.setEditable(false);
		temperaturetext.setBackground(new Color(95, 158, 160));
		temperaturetext.setBounds(210, 217, 179, 16);
		ContainerInfoPanel.add(temperaturetext);
		
		JTextArea updatedtext = new JTextArea();
		updatedtext.setEditable(false);
		updatedtext.setBackground(new Color(95, 158, 160));
		updatedtext.setBounds(210, 246, 136, 16);
		ContainerInfoPanel.add(updatedtext);
		
		JTextArea arrivaltext = new JTextArea();
		arrivaltext.setEditable(false);
		arrivaltext.setBackground(new Color(95, 158, 160));
		arrivaltext.setBounds(209, 274, 137, 16);
		ContainerInfoPanel.add(arrivaltext);
		
		viewContainerPanel = new JPanel();
		layeredPane.setLayer(viewContainerPanel, 0);
		viewContainerPanel.setBackground(new Color(95, 158, 160));
		viewContainerPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(viewContainerPanel);
		viewContainerPanel.setLayout(null);
		
		viewContainerText = new JTextArea();
		viewContainerText.setBackground(new Color(95, 158, 160));
		viewContainerText.setEditable(false);
		viewContainerText.setBounds(18, 6, 450, 322);
		viewContainerPanel.add(viewContainerText);
		
		temperatureGraphButton = new JButton("Temperature");
		temperatureGraphButton.setBounds(18, 362, 117, 29);
		viewContainerPanel.add(temperatureGraphButton);
		temperatureGraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   SwingUtilities.invokeLater(() -> { 
					      System.out.println(containerIDForGraphs);
					      LineGraphTemperature example = new LineGraphTemperature("Temperature Fluctuations", containerIDForGraphs);  
					      example.setAlwaysOnTop(true);  
					      example.pack();  
					      example.setSize(600, 400);  
					      //example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
					      example.setVisible(true);  
					    }); 
				
			}
		});
		
		
		atmosphereGraphButton = new JButton("Pressure");
		atmosphereGraphButton.setBounds(190, 362, 117, 29);
		viewContainerPanel.add(atmosphereGraphButton);
		atmosphereGraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    SwingUtilities.invokeLater(() -> {  
					System.out.println(containerIDForGraphs);
				      LineGraphPressure example = new LineGraphPressure("Pressure Fluctuations",containerIDForGraphs);  
				      example.setAlwaysOnTop(true);  
				      example.pack();  
				      example.setSize(600, 400);  
				      //example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
				      example.setVisible(true);  
				    });  
			}
		});
		
		humidityGraphButton = new JButton("Humidity");
		humidityGraphButton.setBounds(351, 362, 117, 29);
		viewContainerPanel.add(humidityGraphButton);
		humidityGraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    SwingUtilities.invokeLater(() -> {  
				System.out.println(containerIDForGraphs);
				LineGraphHumidity example = new LineGraphHumidity("Humidity Fluctuations",containerIDForGraphs);  
			      example.setAlwaysOnTop(true);  
			      example.pack();  
			      example.setSize(600, 400);  
			      //example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
			      example.setVisible(true);  
			    });  
		}
	});
		
		
		
		searchClientPanel = new JPanel();
		layeredPane.setLayer(searchClientPanel, 0);
		searchClientPanel.setBackground(new Color(95, 158, 160));
		searchClientPanel.setBounds(0, 0, 486, 406);
		layeredPane.add(searchClientPanel);
		searchClientPanel.setLayout(null);
		
		getClientIfoButton = new JButton("Search Client");
		getClientIfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(searchClientPanel);
				
			}
		});
		getClientIfoButton.setBounds(19, 209, 187, 29);
		panel.add(getClientIfoButton);
		
		
		
		JTextArea txtrSearchByThe = new JTextArea();
		txtrSearchByThe.setBackground(new Color(95, 158, 160));
		txtrSearchByThe.setText("Search by the following criteria. Priority from top to the bottom.");
		txtrSearchByThe.setEditable(false);
		txtrSearchByThe.setBounds(18, 6, 431, 16);
		searchClientPanel.add(txtrSearchByThe);
		
		JTextArea txtrClientEmail = new JTextArea();
		txtrClientEmail.setText("Client email:");
		txtrClientEmail.setEditable(false);
		txtrClientEmail.setBackground(new Color(95, 158, 160));
		txtrClientEmail.setBounds(28, 52, 80, 16);
		searchClientPanel.add(txtrClientEmail);
		
		JTextArea txtrCompanyName_1 = new JTextArea();
		txtrCompanyName_1.setText("Company name:");
		txtrCompanyName_1.setEditable(false);
		txtrCompanyName_1.setBackground(new Color(95, 158, 160));
		txtrCompanyName_1.setBounds(28, 80, 124, 16);
		searchClientPanel.add(txtrCompanyName_1);
		
		JTextArea txtrClientPhoneNumber = new JTextArea();
		txtrClientPhoneNumber.setText("Client phone number:");
		txtrClientPhoneNumber.setEditable(false);
		txtrClientPhoneNumber.setBackground(new Color(95, 158, 160));
		txtrClientPhoneNumber.setBounds(28, 124, 146, 16);
		searchClientPanel.add(txtrClientPhoneNumber);
		
		JTextArea txtrReferencePersonFirst = new JTextArea();
		txtrReferencePersonFirst.setText("Reference person first name:");
		txtrReferencePersonFirst.setEditable(false);
		txtrReferencePersonFirst.setBackground(new Color(95, 158, 160));
		txtrReferencePersonFirst.setBounds(28, 167, 181, 16);
		searchClientPanel.add(txtrReferencePersonFirst);
		
		JTextArea txtrMiddleName_1 = new JTextArea();
		txtrMiddleName_1.setText("middle name:");
		txtrMiddleName_1.setEditable(false);
		txtrMiddleName_1.setBackground(new Color(95, 158, 160));
		txtrMiddleName_1.setBounds(123, 195, 93, 16);
		searchClientPanel.add(txtrMiddleName_1);
		
		JTextArea txtrLastName_1 = new JTextArea();
		txtrLastName_1.setText("last name:");
		txtrLastName_1.setEditable(false);
		txtrLastName_1.setBackground(new Color(95, 158, 160));
		txtrLastName_1.setBounds(144, 223, 80, 16);
		searchClientPanel.add(txtrLastName_1);
		
		clientemailTextField = new JTextField();
		clientemailTextField.setBounds(234, 47, 225, 26);
		searchClientPanel.add(clientemailTextField);
		clientemailTextField.setColumns(10);
		
		companyNameTextField = new JTextField();
		companyNameTextField.setColumns(10);
		companyNameTextField.setBounds(234, 75, 225, 26);
		searchClientPanel.add(companyNameTextField);
		
		clientPhoneTextField = new JTextField();
		clientPhoneTextField.setColumns(10);
		clientPhoneTextField.setBounds(234, 119, 225, 26);
		searchClientPanel.add(clientPhoneTextField);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(234, 162, 225, 26);
		searchClientPanel.add(firstNameTextField);
		
		middlenameTextField = new JTextField();
		middlenameTextField.setColumns(10);
		middlenameTextField.setBounds(234, 190, 225, 26);
		searchClientPanel.add(middlenameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(234, 223, 225, 26);
		searchClientPanel.add(lastNameTextField);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(332, 294, 117, 29);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchError.setVisible(false);
				successSearch.setVisible(false);
				controller.searchClient(clientemailTextField.getText(),companyNameTextField.getText(),clientPhoneTextField.getText(),firstNameTextField.getText(),middlenameTextField.getText(),lastNameTextField.getText());
				if(controller.checkMessage()) {
					viewClientTextField.setText(controller.getclientsview());
					switchPanels(viewClientPanel);
				}
				clearDataFields(clientemailTextField,companyNameTextField,clientPhoneTextField,firstNameTextField,middlenameTextField,lastNameTextField);
				
			}
			
		});
		searchClientPanel.add(searchButton);
		
		searchError = new JTextArea();
		searchError.setForeground(new Color(255, 0, 0));
		searchError.setText("Client not found. Try again");
		searchError.setEditable(false);
		searchError.setBackground(new Color(95, 158, 160));
		searchError.setBounds(124, 299, 181, 16);
		searchClientPanel.add(searchError);
		searchError.setVisible(false);
		
		successSearch = new JTextArea();
		successSearch.setForeground(new Color(124, 252, 0));
		successSearch.setText("Success");
		successSearch.setEditable(false);
		successSearch.setBackground(new Color(95, 158, 160));
		successSearch.setBounds(356, 266, 80, 16);
		searchClientPanel.add(successSearch);
		successSearch.setVisible(false);
		
		viewClientPanel = new JPanel();
		viewClientPanel.setBackground(new Color(95, 158, 160));
		layeredPane.setLayer(viewClientPanel, 0);
		viewClientPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(viewClientPanel);
		viewClientPanel.setLayout(null);
		
		viewClientTextField = new JTextArea();
		viewClientTextField.setEditable(false);
		viewClientTextField.setBackground(new Color(95, 158, 160));
		viewClientTextField.setBounds(17, 16, 452, 375);
		viewClientPanel.add(viewClientTextField);
		
		JScrollPane viewJourneysPanel = new JScrollPane();
		viewJourneysPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		layeredPane.setLayer(viewJourneysPanel, 0);
		viewJourneysPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(viewJourneysPanel);
		
		JTextArea viewJourneysTextArea = new JTextArea();
		viewJourneysTextArea.setLineWrap(true);
		viewJourneysTextArea.setBackground(new Color(95, 158, 160));
		viewJourneysPanel.setViewportView(viewJourneysTextArea);
		
		viewJourneysButton = new JButton("View all Journeys");
		viewJourneysButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewJourneysTextArea.setText(controller.getAllJourneys());
				switchPanels(viewJourneysPanel);
			
			}
		});
		viewJourneysButton.setBounds(19, 250, 187, 29);
		panel.add(viewJourneysButton);
		
		JButton updatePortButton = new JButton("Update Current Port");
		updatePortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCurrentPortError.setVisible(false);
				switchPanels(updateContainerPortPanel);
			}
		});
		updatePortButton.setBounds(19, 168, 187, 29);
		panel.add(updatePortButton);
		
		//World Map stuff logistic
		mapButton = new JButton("World Map");
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Inside the world map");
				controller.startMap();
			}
		});
		mapButton.setBounds(19, 291, 187, 29);
		panel.add(mapButton);
	}
	public void openMap(MapPane m) {
		JFrame f=new JFrame();
		f.add(m);
		f.pack();
		f.setSize(1500,750);  
		f.setVisible(true);
	}
	
	public void setFieldsClientData() {
		
		viewClientTextField.setText(controller.getclientsview());
	}
	public void switchPanels(JPanel panel) {
		System.out.println("in switch panels");
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		System.out.println("in switch pannels");
		
	}
	
	public void switchPanels(JScrollPane pane) {
		System.out.println("in switch panels");
		layeredPane.removeAll();
		layeredPane.add(pane);
		layeredPane.repaint();
		layeredPane.revalidate();
		System.out.println("in switch pannels");
		}
	
	public void clearDataFields(JTextField...fields) {
		for(JTextField field : fields) {
			field.setText("");
		}
	}
	public void setViewContainerText() {
		viewContainerText.setText(controller.getContainerData());
		successPosition.setVisible(false);
		successStatus.setVisible(false);
	}
	private void setTextVisibleTrue(JTextArea field) {
		field.setVisible(true);
	}
	public void errorMessageForAddClient() {
		setTextVisibleTrue(txtrSomethingWentWrong);
	}

	public void successFieldForAddClient() {
		System.out.println("Inside success field for add client");
		setTextVisibleTrue(txtrSuccess);
	}
	public void successPositionUpdate() {
		setTextVisibleTrue(successPosition);
	}
	public void errorPositionUpdate() {
		setTextVisibleTrue(positionError);
	}
	public void viewContainerPanelTrue() {
		System.out.println("trying to swtich pannels now");
		switchPanels(viewContainerPanel);
		
	}
	public void successStatusUpdate() {
		setTextVisibleTrue(successStatus);
	}
	public void errorStatusUpdate() {
		setTextVisibleTrue(statusError);
	}
	public void successSearch() {
		setTextVisibleTrue(successSearch);
	}
	public void errorSearch() {
		setTextVisibleTrue(searchError);
	}
	public void viewClient() {
		System.out.println("Switching panels");
		switchPanels(viewClientPanel);
		successSearch.setVisible(true);// switch it to false once the panel works
	}
	public void displayPortError() {
		updateCurrentPortError.setVisible(true);
		
	}
}
