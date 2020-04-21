package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logic.LoginController;
import logic.LogisticController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogisticsMenu {

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
    
    public LogisticsMenu(LogisticController controller) {
		this.controller = controller;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
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
				switchPanels(newClientPanel);
			}
		});
		newClientButton.setBounds(19, 69, 187, 29);
		panel.add(newClientButton);
		
		getInfoButton = new JButton("Update Container Status");
		getInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(StatusPanel);
			}
		});
		getInfoButton.setBounds(19, 110, 187, 29);
		panel.add(getInfoButton);
		
		UpdateContainerButton = new JButton("Update container Position");
		UpdateContainerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(ContainePositionrPanel);
			}
		});
		UpdateContainerButton.setBounds(19, 145, 187, 29);
		panel.add(UpdateContainerButton);
		
		logoutButton = new JButton("Log Out");
		logoutButton.setBounds(19, 298, 187, 29);
		logoutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("The logout button has been pressed, now need to swtich windows");
				LoginController login = new LoginController();
				frame.setVisible(false);
			}
			
		});
		panel.add(logoutButton);
		
		JButton getClientIfoButton = new JButton("Client Information");
		getClientIfoButton.setBounds(19, 186, 187, 29);
		panel.add(getClientIfoButton);
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(212, 0, 486, 412);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		layeredPane = new JLayeredPane();
		panel_1.add(layeredPane, "name_21719901481320");
		
		newClientPanel = new JPanel();
		layeredPane.setLayer(newClientPanel, 0);
		newClientPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(newClientPanel);
		newClientPanel.setBackground(new Color(95, 158, 160));
		newClientPanel.setLayout(null);
		
		JTextArea txtrCompanyName = new JTextArea();
		txtrCompanyName.setText("Company Name:");
		txtrCompanyName.setEditable(false);
		txtrCompanyName.setBackground(new Color(95, 158, 160));
		txtrCompanyName.setBounds(24, 26, 112, 16);
		newClientPanel.add(txtrCompanyName);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("E-mail:");
		txtrEmail.setEditable(false);
		txtrEmail.setBackground(new Color(95, 158, 160));
		txtrEmail.setBounds(24, 60, 112, 16);
		newClientPanel.add(txtrEmail);
		
		JTextArea txtrCountryCode = new JTextArea();
		txtrCountryCode.setText("Country Code:");
		txtrCountryCode.setEditable(false);
		txtrCountryCode.setBackground(new Color(95, 158, 160));
		txtrCountryCode.setBounds(24, 88, 112, 16);
		newClientPanel.add(txtrCountryCode);
		
		JTextArea txtrPhoneNumber = new JTextArea();
		txtrPhoneNumber.setText("Phone Number:");
		txtrPhoneNumber.setEditable(false);
		txtrPhoneNumber.setBackground(new Color(95, 158, 160));
		txtrPhoneNumber.setBounds(24, 118, 112, 16);
		newClientPanel.add(txtrPhoneNumber);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setText("First Name:");
		txtrFirstName.setEditable(false);
		txtrFirstName.setBackground(new Color(95, 158, 160));
		txtrFirstName.setBounds(24, 146, 112, 16);
		newClientPanel.add(txtrFirstName);
		
		JTextArea txtrMiddleName = new JTextArea();
		txtrMiddleName.setText("Middle Name:");
		txtrMiddleName.setEditable(false);
		txtrMiddleName.setBackground(new Color(95, 158, 160));
		txtrMiddleName.setBounds(24, 174, 112, 16);
		newClientPanel.add(txtrMiddleName);
		
		JTextArea txtrLastName = new JTextArea();
		txtrLastName.setText("Last Name:");
		txtrLastName.setEditable(false);
		txtrLastName.setBackground(new Color(95, 158, 160));
		txtrLastName.setBounds(24, 204, 112, 16);
		newClientPanel.add(txtrLastName);
		
		JTextArea txtrStreet = new JTextArea();
		txtrStreet.setText("Street:");
		txtrStreet.setEditable(false);
		txtrStreet.setBackground(new Color(95, 158, 160));
		txtrStreet.setBounds(24, 232, 112, 16);
		newClientPanel.add(txtrStreet);
		
		JTextArea txtrCity = new JTextArea();
		txtrCity.setText("City:");
		txtrCity.setEditable(false);
		txtrCity.setBackground(new Color(95, 158, 160));
		txtrCity.setBounds(24, 260, 112, 16);
		newClientPanel.add(txtrCity);
		
		JTextArea txtrBuilding = new JTextArea();
		txtrBuilding.setText("Building:");
		txtrBuilding.setEditable(false);
		txtrBuilding.setBackground(new Color(95, 158, 160));
		txtrBuilding.setBounds(24, 291, 112, 16);
		newClientPanel.add(txtrBuilding);
		
		JTextArea txtrPostalCode = new JTextArea();
		txtrPostalCode.setText("Postal Code:");
		txtrPostalCode.setEditable(false);
		txtrPostalCode.setBackground(new Color(95, 158, 160));
		txtrPostalCode.setBounds(24, 319, 112, 16);
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
				boolean checkMessage = false;
				txtrSuccess.setVisible(false);
				txtrSomethingWentWrong.setVisible(false);
				if(!textField.getText().isEmpty()) {
					checkMessage = controller.setCompanyName(textField.getText());
				}
				if(checkMessage&&!textField_1.getText().isEmpty()) {
					checkMessage = controller.setEmail(textField_1.getText());
				}
				if(checkMessage&&!textField_2.getText().isEmpty()) {
					checkMessage = controller.setCountryCode(textField_2.getText());
				}
				if(checkMessage&&!textField_3.getText().isEmpty()) {
					checkMessage = controller.setPhoneNumber(textField_3.getText());
				}
				if (checkMessage&&!textField_4.getText().isEmpty()) {
					checkMessage = controller.setFirstName(textField_4.getText());
				}
				if (checkMessage&&!textField_5.getText().isEmpty()) {
					checkMessage = controller.setMiddleName(textField_5.getText());
				}
				if (checkMessage&&!textField_6.getText().isEmpty()) {
					checkMessage = controller.setLastName(textField_6.getText());
				}
				if(checkMessage&&!textField_7.getText().isEmpty()) {
					checkMessage = controller.setStreetName(textField_7.getText());
				}
				if(checkMessage&&!textField_8.getText().isEmpty()) {
					checkMessage = controller.setCity(textField_8.getText());
				}
				if(checkMessage&&!textField_9.getText().isEmpty()) {
					checkMessage = controller.setBuilding(textField_9.getText());
				}
				if(checkMessage&&!textField_10.getText().isEmpty()) {
					checkMessage = controller.setPostcode(textField_10.getText());
				}
				if(textField_10.getText().isEmpty()||textField_9.getText().isEmpty()||textField_8.getText().isEmpty()||textField_7.getText().isEmpty()||textField_6.getText().isEmpty()||textField_4.getText().isEmpty()||textField_3.getText().isEmpty()||textField_2.getText().isEmpty()||textField_1.getText().isEmpty()) {
					checkMessage = false;
				}
				
				if(checkMessage) {
					checkMessage = controller.addClient();
				}
				if(checkMessage) {
					txtrSuccess.setVisible(true);
				}else {
					txtrSomethingWentWrong.setVisible(true);
				}
				
				clearDataFields(textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8,textField_9,textField_10);
			}
		});
		newClientPanel.add(Save1);
		
		txtrSuccess = new JTextArea();
		txtrSuccess.setBackground(new Color(95, 158, 160));
		txtrSuccess.setForeground(new Color(124, 252, 0));
		txtrSuccess.setText("Success");
		txtrSuccess.setEditable(false);
		txtrSuccess.setBounds(92, 356, 82, 16);
		newClientPanel.add(txtrSuccess);
		txtrSuccess.setVisible(false);
		
		txtrSomethingWentWrong = new JTextArea();
		txtrSomethingWentWrong.setText("Something went wrong. Try again");
		txtrSomethingWentWrong.setBackground(new Color(95, 158, 160));
		txtrSomethingWentWrong.setForeground(new Color(255, 0, 0));
		txtrSomethingWentWrong.setEditable(false);
		txtrSomethingWentWrong.setBounds(93, 375, 236, 16);
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
				boolean checkMessage = false;
				successPosition.setVisible(false);
				positionError.setVisible(false);
				
				if (!textField_16.getText().isEmpty()) {
					checkMessage = controller.setContainerForUpdate(textField_16.getText());
				}
				if (checkMessage&&!(textField_14.getText().isEmpty())&&!(textField_15.getText().isEmpty())){
					checkMessage = controller.updatePosition(textField_14.getText(),textField_15.getText());
				}
				if(checkMessage) {
					successPosition.setVisible(true);
					setViewContainerText();
					switchPanels(viewContainerPanel);
				}else {
					positionError.setVisible(true);
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
				boolean checkMessage = false;
				successStatus.setVisible(false);
				statusError.setVisible(false);
				if (!containerIDtextstatus.getText().isEmpty()) {
					checkMessage = controller.setContainerForUpdate(containerIDtextstatus.getText());
				}
				if (checkMessage&&!(textField_11.getText().isEmpty())&&!(textField_12.getText().isEmpty())&&!(textField_13.getText().isEmpty())){
					checkMessage = controller.updateStatus(textField_11.getText(),textField_12.getText(),textField_13.getText());
				}
				if(checkMessage) {
					successStatus.setVisible(true);
					setViewContainerText();
					switchPanels(viewContainerPanel);
				}else {
					statusError.setVisible(true);
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
		layeredPane.setLayer(viewContainerPanel, 2);
		viewContainerPanel.setBackground(new Color(95, 158, 160));
		viewContainerPanel.setBounds(0, 0, 486, 412);
		layeredPane.add(viewContainerPanel);
		viewContainerPanel.setLayout(null);
		
		 viewContainerText = new JTextArea();
		viewContainerText.setBackground(new Color(95, 158, 160));
		viewContainerText.setEditable(false);
		viewContainerText.setBounds(18, 6, 450, 322);
		viewContainerPanel.add(viewContainerText);
		
		JButton graphsbutton = new JButton("Graphs");
		graphsbutton.setBounds(330, 352, 117, 29);
		viewContainerPanel.add(graphsbutton);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	public void clearDataFields(JTextField...fields) {
		for(JTextField field : fields) {
			field.setText("");
		}
	}
	private void setViewContainerText() {
		viewContainerText.setText(controller.getContainerData());
		successStatus.setVisible(false);
	}
}
