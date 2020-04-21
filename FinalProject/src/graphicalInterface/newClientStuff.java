package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

import logic.ClientController;
import logic.LoginController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;



public class newClientStuff {

	//private long clientID;
	
	public JFrame frame;
	JButton emailButton,AddJourneyButton,ReferencepersonButton,ContainerButton;
	JPanel ButtonPanel,panel_1,referencePanel,emailPanel,JourneyPanel,DataPanel;
	JLayeredPane layeredPane;
	private JTextArea txtrName;
	private JTextArea txtrLastName;
	private JTextField firstnametext;
	private JTextField middlenametext;
	private JTextField lastnametext;
	private JTextField EmailTextField;
	private JPanel PhonePanel;
	private JTextField newPhoneNumberText;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField containterIDsearch;
	private ClientController controller;
	private JButton LogOutButton;
	private JTextArea txtrCountryCode;
	private JTextField countryCodeTextField;
	private JTextField JourneyIDsearch;
	private JTextField CargoIDsearch;
	private JTextField PortNamesearch;
	private JTextArea CurrentEmailTextField;
	private JTextArea CurrentPhoneNumberTextArea;
	private JTextArea InvalidNameError,validTextField;
	private JTextArea InvalidEmailError, PhoneError;
	private JTextArea emailError;
	private JTextArea emailSuccess;
	private JTextArea phoneSuccess;
	private JTextArea txtrCurrentPhoneNumber_1;
	private JPanel ViewInfoPanel;
	private JTextArea txtrComapnyName;
	private JTextArea txtrCountry;
	private JTextArea txtrEmail_1;
	private JTextArea txtrReferencePerson;
	private JTextArea txtrAddress;
	private JTextArea txtrActiveShipmnts;
	private JTextArea viewCompanyNameTextField;
	private JTextArea viewPhoneTextField;
	private JTextArea viewEmailTextField;
	private JTextArea viewReferencePersonTextField;
	private JTextArea viewAddressTextField;
	private JTextArea viewActiveShipmentsTextField;
	private JTextArea txtrCurrentLocation;
	private JTextArea currentLocationTextField;
	private JTextArea noContainerError;
	private JTextArea txtrSearchByOne; 
	
	public newClientStuff(ClientController controller) {
		this.controller = controller;
		initialize();
	}
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 874, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBackground(new Color(128, 128, 128));
		ButtonPanel.setBounds(0, 0, 291, 478);
		frame.getContentPane().add(ButtonPanel);
		ButtonPanel.setLayout(null);
		
		emailButton = new JButton("E-mail");
		emailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(emailPanel);
			}
		});
		emailButton.setBounds(55, 111, 196, 29);
		ButtonPanel.add(emailButton);
		
		AddJourneyButton = new JButton("Add Journey");
		AddJourneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(JourneyPanel);
			}
		});
		AddJourneyButton.setBounds(55, 195, 196, 29);
		ButtonPanel.add(AddJourneyButton);
		
		ReferencepersonButton = new JButton("Reference Person");
		ReferencepersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(referencePanel);
			}
		});
		ReferencepersonButton.setBounds(55, 68, 196, 29);
		ButtonPanel.add(ReferencepersonButton);
		
		ContainerButton = new JButton("Container Data");
		ContainerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(DataPanel);
			}
		});
		ContainerButton.setBounds(55, 236, 196, 29);
		ButtonPanel.add(ContainerButton);
		
		JButton btnNewButton_1 = new JButton("Phone Number");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(PhonePanel);
			}
		});
		btnNewButton_1.setBounds(55, 154, 196, 29);
		ButtonPanel.add(btnNewButton_1);
		
		LogOutButton = new JButton("Log Out");
		LogOutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("The logout button has been pressed, now need to swtich windows");
				LoginController login = new LoginController();
				frame.setVisible(false);
			}
			
		});
		LogOutButton.setBounds(55, 318, 196, 29);
		ButtonPanel.add(LogOutButton);
		
		JButton viewOwnInfoButton = new JButton("View Personal Info");
		viewOwnInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(ViewInfoPanel);
			}
		});
		viewOwnInfoButton.setBounds(55, 277, 196, 29);
		ButtonPanel.add(viewOwnInfoButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(291, 0, 583, 478);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		layeredPane = new JLayeredPane();
		panel_1.add(layeredPane, "name_7520928918667");
		layeredPane.setLayout(new CardLayout(0, 0));
		
		referencePanel = new JPanel();
		referencePanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(referencePanel, "name_7537419347914");
		referencePanel.setLayout(null);
		
		JTextArea txtrPanel = new JTextArea();
		txtrPanel.setBackground(new Color(95, 158, 160));
		txtrPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrPanel.setEditable(false);
		txtrPanel.setBounds(76, 89, 127, 16);
		txtrPanel.setText("First Name:");
		referencePanel.add(txtrPanel);
		
		txtrName = new JTextArea();
		txtrName.setBackground(new Color(95, 158, 160));
		txtrName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrName.setEditable(false);
		txtrName.setText("Middle Name:");
		txtrName.setBounds(76, 137, 99, 16);
		referencePanel.add(txtrName);
		
		txtrLastName = new JTextArea();
		txtrLastName.setBackground(new Color(95, 158, 160));
		txtrLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrLastName.setEditable(false);
		txtrLastName.setText("Last Name:");
		txtrLastName.setBounds(76, 182, 99, 16);
		referencePanel.add(txtrLastName);
		
		firstnametext = new JTextField();
		firstnametext.setBounds(245, 86, 180, 26);
		referencePanel.add(firstnametext);
		firstnametext.setColumns(10);
		
		middlenametext = new JTextField();
		middlenametext.setBounds(245, 134, 180, 26);
		referencePanel.add(middlenametext);
		middlenametext.setColumns(10);
		
		lastnametext = new JTextField();
		lastnametext.setBounds(245, 179, 180, 26);
		referencePanel.add(lastnametext);
		lastnametext.setColumns(10);
		
		JButton Save1 = new JButton("Save");
		Save1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkMessage;
				validTextField.setVisible(false);
				InvalidNameError.setVisible(false);
				System.out.println("Inside the save button");
				if (middlenametext.getText().isEmpty()) {
					checkMessage=controller.saveReferencePerson(firstnametext.getText()," ",lastnametext.getText());
				}else {
					checkMessage=controller.saveReferencePerson(firstnametext.getText(),middlenametext.getText(),lastnametext.getText());
				}
				if (checkMessage) {
					validTextField.setVisible(true);
					
				}else {
					InvalidNameError.setVisible(true);
				}
				clearNameFields(firstnametext,middlenametext,lastnametext);
				viewReferencePersonTextField.setText(controller.getReferencePerson());
			}
		});
		Save1.setBounds(308, 244, 117, 29);
		referencePanel.add(Save1);
		
		InvalidNameError = new JTextArea();
		InvalidNameError.setForeground(new Color(220, 20, 60));
		InvalidNameError.setText("Invalid Input. Please enter valid information");
		InvalidNameError.setEditable(false);
		InvalidNameError.setBackground(new Color(95, 158, 160));
		InvalidNameError.setBounds(199, 30, 313, 16);
		referencePanel.add(InvalidNameError);
		InvalidNameError.setVisible(false);
		
		validTextField = new JTextArea();
		validTextField.setForeground(new Color(50, 205, 50));
		validTextField.setText("Success");
		validTextField.setEditable(false);
		validTextField.setBackground(new Color(95, 158, 160));
		validTextField.setBounds(308, 58, 59, 16);
		referencePanel.add(validTextField);
		validTextField.setVisible(false);
		
		
		
		emailPanel = new JPanel();
		emailPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(emailPanel, "name_7578041274086");
		emailPanel.setLayout(null);
		
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrEmail.setEditable(false);
		txtrEmail.setBackground(new Color(95, 158, 160));
		txtrEmail.setBounds(82, 97, 118, 16);
		txtrEmail.setText("Current e-mail:");
		emailPanel.add(txtrEmail);
		
		JTextArea txtrNewEmail = new JTextArea();
		txtrNewEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrNewEmail.setBackground(new Color(95, 158, 160));
		txtrNewEmail.setEditable(false);
		txtrNewEmail.setText("New e-mail:");
		txtrNewEmail.setBounds(82, 145, 118, 16);
		emailPanel.add(txtrNewEmail);
		
		EmailTextField = new JTextField();
		EmailTextField.setBounds(267, 140, 210, 26);
		emailPanel.add(EmailTextField);
		EmailTextField.setColumns(10);
		
		JButton saveEmailButton = new JButton("Save");
		saveEmailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailSuccess.setVisible(false);
				emailError.setVisible(false);
				boolean CheckMessage;
				if (EmailTextField.getText().isEmpty()) {
					CheckMessage=false;
				}else {
					CheckMessage = controller.saveEmail(EmailTextField.getText());
				}
				if (CheckMessage) {
					emailSuccess.setVisible(true);
				}else {
					emailError.setVisible(true);
				}
				clearEmailFields(EmailTextField);
				CurrentEmailTextField.setText(controller.getCurrentEmail());
				viewEmailTextField.setText(controller.getCurrentEmail());
			}
		});
		saveEmailButton.setBounds(357, 223, 117, 29);
		emailPanel.add(saveEmailButton);
		
		CurrentEmailTextField = new JTextArea();
		CurrentEmailTextField.setBackground(new Color(95, 158, 160));
		CurrentEmailTextField.setEditable(false);
		CurrentEmailTextField.setBounds(267, 99, 295, 16);
		CurrentEmailTextField.setText(controller.getCurrentEmail());
		emailPanel.add(CurrentEmailTextField);
		
		emailError = new JTextArea();
		emailError.setForeground(new Color(255, 0, 0));
		emailError.setText("Invalid Input. Try again");
		emailError.setEditable(false);
		emailError.setBackground(new Color(95, 158, 160));
		emailError.setBounds(267, 264, 238, 16);
		emailPanel.add(emailError);
		emailError.setVisible(false);
		
		emailSuccess = new JTextArea();
		emailSuccess.setForeground(new Color(127, 255, 0));
		emailSuccess.setText("Success");
		emailSuccess.setBackground(new Color(95, 158, 160));
		emailSuccess.setEditable(false);
		emailSuccess.setBounds(320, 285, 154, 16);
		emailPanel.add(emailSuccess);
		emailSuccess.setVisible(false);
		
		
		PhonePanel = new JPanel();
		PhonePanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(PhonePanel, "name_11046810171646");
		PhonePanel.setLayout(null);
		
		JTextArea txtrCurrentPhoneNumber = new JTextArea();
		txtrCurrentPhoneNumber.setBackground(new Color(95, 158, 160));
		txtrCurrentPhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCurrentPhoneNumber.setEditable(false);
		txtrCurrentPhoneNumber.setText("Current Phone number:");
		txtrCurrentPhoneNumber.setBounds(94, 88, 168, 16);
		JTextArea txtrNewPhoneNumber = new JTextArea();
		txtrNewPhoneNumber.setBackground(new Color(95, 158, 160));
		txtrNewPhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrNewPhoneNumber.setEditable(false);
		txtrNewPhoneNumber.setText("New Phone Number:");
		txtrNewPhoneNumber.setBounds(94, 139, 168, 16);
		PhonePanel.add(txtrNewPhoneNumber);
		
		JButton savePhoneButton = new JButton("Save");
		savePhoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phoneSuccess.setVisible(false);
				PhoneError.setVisible(false);
				boolean checkMessage;
				if (countryCodeTextField.getText().isEmpty()||newPhoneNumberText.getText().isEmpty()) {
					checkMessage=false;
				}else {
					checkMessage = controller.savePhoneNumber(countryCodeTextField.getText(),newPhoneNumberText.getText());
				}
				if (checkMessage) {
					phoneSuccess.setVisible(true);
				}else {
					PhoneError.setVisible(true);
				}
				clearPhoneFields(countryCodeTextField,newPhoneNumberText);
				viewPhoneTextField.setText(controller.getCurrentPhoneNumber());
				CurrentPhoneNumberTextArea.setText(controller.getCurrentPhoneNumber());
			}
		});
		savePhoneButton.setBounds(372, 222, 117, 29);
		PhonePanel.add(savePhoneButton);
		
		newPhoneNumberText = new JTextField();
		newPhoneNumberText.setBounds(291, 136, 198, 26);
		PhonePanel.add(newPhoneNumberText);
		newPhoneNumberText.setColumns(10);
		
		txtrCountryCode = new JTextArea();
		txtrCountryCode.setText("Country Code:");
		txtrCountryCode.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCountryCode.setEditable(false);
		txtrCountryCode.setBackground(new Color(95, 158, 160));
		txtrCountryCode.setBounds(94, 188, 168, 23);
		PhonePanel.add(txtrCountryCode);
		
		countryCodeTextField = new JTextField();
		countryCodeTextField.setBounds(291, 185, 198, 26);
		PhonePanel.add(countryCodeTextField);
		countryCodeTextField.setColumns(10);
		
		CurrentPhoneNumberTextArea = new JTextArea();
		CurrentPhoneNumberTextArea.setEditable(false);
		CurrentPhoneNumberTextArea.setBackground(new Color(95, 158, 160));
		CurrentPhoneNumberTextArea.setBounds(292, 90, 197, 16);
		CurrentPhoneNumberTextArea.setText(controller.getCurrentPhoneNumber());
		PhonePanel.add(CurrentPhoneNumberTextArea);
		
		
		PhoneError = new JTextArea();
		PhoneError.setForeground(new Color(220, 20, 60));
		PhoneError.setText("Invalid Phone Number");
		PhoneError.setBackground(new Color(95, 158, 160));
		PhoneError.setEditable(false);
		PhoneError.setBounds(291, 263, 239, 16);
		PhonePanel.add(PhoneError);
		PhoneError.setVisible(false);
		phoneSuccess = new JTextArea();
		phoneSuccess.setForeground(new Color(173, 255, 47));
		phoneSuccess.setText("Success");
		phoneSuccess.setBackground(new Color(95, 158, 160));
		phoneSuccess.setEditable(false);
		phoneSuccess.setBounds(286, 286, 176, 16);
		PhonePanel.add(phoneSuccess);
		phoneSuccess.setVisible(false);
		txtrCurrentPhoneNumber_1 = new JTextArea();
		txtrCurrentPhoneNumber_1.setText("Current Phone Number");
		txtrCurrentPhoneNumber_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCurrentPhoneNumber_1.setEditable(false);
		txtrCurrentPhoneNumber_1.setBackground(new Color(95, 158, 160));
		txtrCurrentPhoneNumber_1.setBounds(94, 90, 168, 16);
		PhonePanel.add(txtrCurrentPhoneNumber_1);
		PhoneError.setVisible(false);
		
		JourneyPanel = new JPanel();
		JourneyPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(JourneyPanel, "name_7881573753337");
		JourneyPanel.setLayout(null);
		
		JTextArea txtrStartPort = new JTextArea();
		txtrStartPort.setText("Destination Port:");
		txtrStartPort.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrStartPort.setBackground(new Color(95, 158, 160));
		txtrStartPort.setEditable(false);
		txtrStartPort.setBounds(84, 186, 122, 16);
		JourneyPanel.add(txtrStartPort);
		
		JTextArea txtrStartPort_1 = new JTextArea();
		txtrStartPort_1.setText("Start Port:");
		txtrStartPort_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrStartPort_1.setEditable(false);
		txtrStartPort_1.setBackground(new Color(95, 158, 160));
		txtrStartPort_1.setBounds(84, 150, 83, 16);
		JourneyPanel.add(txtrStartPort_1);
		
		JTextArea txtrCargo = new JTextArea();
		txtrCargo.setText("Cargo:");
		txtrCargo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCargo.setEditable(false);
		txtrCargo.setBackground(new Color(95, 158, 160));
		txtrCargo.setBounds(84, 224, 122, 25);
		JourneyPanel.add(txtrCargo);
		
		JTextArea txtrOptimalAtmosphere = new JTextArea();
		txtrOptimalAtmosphere.setText("Optimal Atmosphere:");
		txtrOptimalAtmosphere.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrOptimalAtmosphere.setEditable(false);
		txtrOptimalAtmosphere.setBackground(new Color(95, 158, 160));
		txtrOptimalAtmosphere.setBounds(84, 260, 174, 25);
		JourneyPanel.add(txtrOptimalAtmosphere);
		
		JTextArea txtrOptimalAtmPressure = new JTextArea();
		txtrOptimalAtmPressure.setText("Optimal Temperature:");
		txtrOptimalAtmPressure.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrOptimalAtmPressure.setEditable(false);
		txtrOptimalAtmPressure.setBackground(new Color(95, 158, 160));
		txtrOptimalAtmPressure.setBounds(84, 297, 165, 25);
		JourneyPanel.add(txtrOptimalAtmPressure);
		
		JTextArea txtrOptimalHumidity = new JTextArea();
		txtrOptimalHumidity.setText("Optimal Humidity:");
		txtrOptimalHumidity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrOptimalHumidity.setEditable(false);
		txtrOptimalHumidity.setBackground(new Color(95, 158, 160));
		txtrOptimalHumidity.setBounds(84, 327, 152, 30);
		JourneyPanel.add(txtrOptimalHumidity);
		
		JTextArea txtrArriveBy = new JTextArea();
		txtrArriveBy.setText("Arrive by:");
		txtrArriveBy.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrArriveBy.setEditable(false);
		txtrArriveBy.setBackground(new Color(95, 158, 160));
		txtrArriveBy.setBounds(84, 367, 128, 30);
		JourneyPanel.add(txtrArriveBy);
		
		textField_8 = new JTextField();
		textField_8.setBounds(295, 147, 179, 26);
		JourneyPanel.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(295, 183, 179, 26);
		JourneyPanel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(295, 221, 179, 26);
		JourneyPanel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(295, 257, 179, 26);
		JourneyPanel.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(295, 294, 179, 26);
		JourneyPanel.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(295, 331, 179, 26);
		JourneyPanel.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(295, 364, 179, 26);
		JourneyPanel.add(textField_14);
		textField_14.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.setBounds(358, 408, 117, 29);
		JourneyPanel.add(btnNewButton_3);
		
		JPanel viewContainerPanel = new JPanel();
		viewContainerPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(viewContainerPanel, "name_39906191038179");
		viewContainerPanel.setLayout(null);
		
		JTextArea txtrStartPortName = new JTextArea();
		txtrStartPortName.setText("Start port name:");
		txtrStartPortName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrStartPortName.setEditable(false);
		txtrStartPortName.setBackground(new Color(95, 158, 160));
		txtrStartPortName.setBounds(17, 33, 133, 19);
		viewContainerPanel.add(txtrStartPortName);
		
		JTextArea txtrDestinationPortName = new JTextArea();
		txtrDestinationPortName.setText("Destination port name:");
		txtrDestinationPortName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrDestinationPortName.setEditable(false);
		txtrDestinationPortName.setBackground(new Color(95, 158, 160));
		txtrDestinationPortName.setBounds(17, 78, 167, 19);
		viewContainerPanel.add(txtrDestinationPortName);
		
		JTextArea txtrCargo_2 = new JTextArea();
		txtrCargo_2.setText("Cargo:");
		txtrCargo_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCargo_2.setEditable(false);
		txtrCargo_2.setBackground(new Color(95, 158, 160));
		txtrCargo_2.setBounds(17, 130, 95, 19);
		viewContainerPanel.add(txtrCargo_2);
		
		JTextArea txtrArrivalDate = new JTextArea();
		txtrArrivalDate.setText("Arrival Date:");
		txtrArrivalDate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrArrivalDate.setEditable(false);
		txtrArrivalDate.setBackground(new Color(95, 158, 160));
		txtrArrivalDate.setBounds(17, 350, 95, 19);
		viewContainerPanel.add(txtrArrivalDate);
		
		JTextArea txtrCurrentInternalStatus = new JTextArea();
		txtrCurrentInternalStatus.setText("Current internal status:");
		txtrCurrentInternalStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCurrentInternalStatus.setEditable(false);
		txtrCurrentInternalStatus.setBackground(new Color(95, 158, 160));
		txtrCurrentInternalStatus.setBounds(17, 174, 186, 19);
		viewContainerPanel.add(txtrCurrentInternalStatus);
		
		JTextArea txtrLastUpdated = new JTextArea();
		txtrLastUpdated.setText("Last updated:");
		txtrLastUpdated.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrLastUpdated.setEditable(false);
		txtrLastUpdated.setBackground(new Color(95, 158, 160));
		txtrLastUpdated.setBounds(17, 416, 114, 19);
		viewContainerPanel.add(txtrLastUpdated);
		
		JTextArea startPortTextField = new JTextArea();
		startPortTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		startPortTextField.setEditable(false);
		startPortTextField.setBackground(new Color(95, 158, 160));
		startPortTextField.setBounds(206, 35, 371, 19);
		viewContainerPanel.add(startPortTextField);
		
		JTextArea destinationPortTextField = new JTextArea();
		destinationPortTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		destinationPortTextField.setEditable(false);
		destinationPortTextField.setBackground(new Color(95, 158, 160));
		destinationPortTextField.setBounds(206, 80, 371, 19);
		viewContainerPanel.add(destinationPortTextField);
		
		JTextArea cargoTextField = new JTextArea();
		cargoTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cargoTextField.setEditable(false);
		cargoTextField.setBackground(new Color(95, 158, 160));
		cargoTextField.setBounds(206, 132, 371, 19);
		viewContainerPanel.add(cargoTextField);
		
		JTextArea internalStatusTextField = new JTextArea();
		internalStatusTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		internalStatusTextField.setEditable(false);
		internalStatusTextField.setBackground(new Color(95, 158, 160));
		internalStatusTextField.setBounds(206, 176, 371, 120);
		viewContainerPanel.add(internalStatusTextField);
		
		JTextArea arrivalDateTextField = new JTextArea();
		arrivalDateTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		arrivalDateTextField.setEditable(false);
		arrivalDateTextField.setBackground(new Color(95, 158, 160));
		arrivalDateTextField.setBounds(206, 350, 371, 19);
		viewContainerPanel.add(arrivalDateTextField);
		
		JTextArea lastUpdatedTextField = new JTextArea();
		lastUpdatedTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lastUpdatedTextField.setEditable(false);
		lastUpdatedTextField.setBackground(new Color(95, 158, 160));
		lastUpdatedTextField.setBounds(206, 418, 354, 19);
		viewContainerPanel.add(lastUpdatedTextField);
		
		txtrCurrentLocation = new JTextArea();
		txtrCurrentLocation.setText("Current location:");
		txtrCurrentLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCurrentLocation.setEditable(false);
		txtrCurrentLocation.setBackground(new Color(95, 158, 160));
		txtrCurrentLocation.setBounds(17, 319, 152, 19);
		viewContainerPanel.add(txtrCurrentLocation);
		
		currentLocationTextField = new JTextArea();
		currentLocationTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		currentLocationTextField.setEditable(false);
		currentLocationTextField.setBackground(new Color(95, 158, 160));
		currentLocationTextField.setBounds(206, 319, 262, 19);
		viewContainerPanel.add(currentLocationTextField);
		
		DataPanel = new JPanel();
		DataPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(DataPanel, "name_7969757405032");
		DataPanel.setLayout(null);
		
		JTextArea txtrContainerId = new JTextArea();
		txtrContainerId.setBounds(66, 85, 95, 19);
		txtrContainerId.setText("Container ID:");
		txtrContainerId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrContainerId.setEditable(false);
		txtrContainerId.setBackground(new Color(95, 158, 160));
		DataPanel.add(txtrContainerId);
		
		containterIDsearch = new JTextField();
		containterIDsearch.setBounds(206, 82, 199, 26);
		DataPanel.add(containterIDsearch);
		containterIDsearch.setColumns(10);
		
		JButton Enterbutton = new JButton("Enter");
		Enterbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noContainerError.setVisible(false);
				boolean checkMessage=false;
				if (!containterIDsearch.getText().isEmpty()) {
					checkMessage = controller.getContainerByContainerID(containterIDsearch.getText());
				} 
				if(!checkMessage&&!JourneyIDsearch.getText().isEmpty()) {
					checkMessage = controller.getContainerByJourneyID(JourneyIDsearch.getText());
				}
				if(!checkMessage&&!CargoIDsearch.getText().isEmpty()) {
					checkMessage = controller.getContainerByCargo(CargoIDsearch.getText());
				}
				if(!checkMessage&&!PortNamesearch.getText().isEmpty()) {
					checkMessage = controller.getContainerByPortName(PortNamesearch.getText());
				}
				if(checkMessage) {
					noContainerError.setVisible(false);
					switchPanels(viewContainerPanel);
				}else {
					noContainerError.setVisible(true);
				}
				clearContainerDataFields(containterIDsearch,JourneyIDsearch,CargoIDsearch,PortNamesearch);
				viewActiveShipmentsTextField.setText(controller.getActiveShipments());
			}
		});
		Enterbutton.setBounds(289, 279, 117, 29);
		DataPanel.add(Enterbutton);
		
		JTextArea txtrJourneyId = new JTextArea();
		txtrJourneyId.setText("Journey ID");
		txtrJourneyId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrJourneyId.setEditable(false);
		txtrJourneyId.setBackground(new Color(95, 158, 160));
		txtrJourneyId.setBounds(66, 130, 95, 19);
		DataPanel.add(txtrJourneyId);
		
		JTextArea txtrCargo_1 = new JTextArea();
		txtrCargo_1.setText("Cargo :");
		txtrCargo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCargo_1.setEditable(false);
		txtrCargo_1.setBackground(new Color(95, 158, 160));
		txtrCargo_1.setBounds(66, 177, 95, 19);
		DataPanel.add(txtrCargo_1);
		
		JTextArea txtrPortName = new JTextArea();
		txtrPortName.setText("Port Name:");
		txtrPortName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrPortName.setEditable(false);
		txtrPortName.setBackground(new Color(95, 158, 160));
		txtrPortName.setBounds(66, 220, 95, 19);
		DataPanel.add(txtrPortName);
		
		JourneyIDsearch = new JTextField();
		JourneyIDsearch.setColumns(10);
		JourneyIDsearch.setBounds(206, 127, 199, 26);
		DataPanel.add(JourneyIDsearch);
		
		CargoIDsearch = new JTextField();
		CargoIDsearch.setColumns(10);
		CargoIDsearch.setBounds(206, 174, 199, 26);
		DataPanel.add(CargoIDsearch);
		
		PortNamesearch = new JTextField();
		PortNamesearch.setColumns(10);
		PortNamesearch.setBounds(206, 217, 199, 26);
		DataPanel.add(PortNamesearch);
		
		txtrSearchByOne = new JTextArea();
		txtrSearchByOne.setText("Search by one of the following criteria. Remember that priority will be given to the topmost field correctly entered.");
		txtrSearchByOne.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrSearchByOne.setEditable(false);
		txtrSearchByOne.setBackground(new Color(95, 158, 160));
		txtrSearchByOne.setBounds(151, 30, 320, 19);
		DataPanel.add(txtrSearchByOne);
		
		noContainerError = new JTextArea();
		noContainerError.setForeground(new Color(255, 0, 0));
		noContainerError.setText("Container not found.");
		noContainerError.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		noContainerError.setEditable(false);
		noContainerError.setBackground(new Color(95, 158, 160));
		noContainerError.setBounds(221, 321, 156, 19);
		DataPanel.add(noContainerError);
		noContainerError.setVisible(false);
		
		ViewInfoPanel = new JPanel();
		ViewInfoPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(ViewInfoPanel, "name_37514469502135");
		ViewInfoPanel.setLayout(null);
		
		txtrComapnyName = new JTextArea();
		txtrComapnyName.setText("Comapny Name:");
		txtrComapnyName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrComapnyName.setEditable(false);
		txtrComapnyName.setBackground(new Color(95, 158, 160));
		txtrComapnyName.setBounds(44, 84, 127, 26);
		ViewInfoPanel.add(txtrComapnyName);
		
		txtrCountry = new JTextArea();
		txtrCountry.setText("Phone Number:");
		txtrCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCountry.setEditable(false);
		txtrCountry.setBackground(new Color(95, 158, 160));
		txtrCountry.setBounds(44, 122, 127, 16);
		ViewInfoPanel.add(txtrCountry);
		
		txtrEmail_1 = new JTextArea();
		txtrEmail_1.setText("Email:");
		txtrEmail_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrEmail_1.setEditable(false);
		txtrEmail_1.setBackground(new Color(95, 158, 160));
		txtrEmail_1.setBounds(44, 161, 127, 16);
		ViewInfoPanel.add(txtrEmail_1);
		
		txtrReferencePerson = new JTextArea();
		txtrReferencePerson.setText("Reference Person:");
		txtrReferencePerson.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrReferencePerson.setEditable(false);
		txtrReferencePerson.setBackground(new Color(95, 158, 160));
		txtrReferencePerson.setBounds(44, 207, 127, 16);
		ViewInfoPanel.add(txtrReferencePerson);
		
		txtrAddress = new JTextArea();
		txtrAddress.setText("Address:");
		txtrAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrAddress.setEditable(false);
		txtrAddress.setBackground(new Color(95, 158, 160));
		txtrAddress.setBounds(44, 274, 127, 16);
		ViewInfoPanel.add(txtrAddress);
		
		txtrActiveShipmnts = new JTextArea();
		txtrActiveShipmnts.setText("Active shipments:");
		txtrActiveShipmnts.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrActiveShipmnts.setEditable(false);
		txtrActiveShipmnts.setBackground(new Color(95, 158, 160));
		txtrActiveShipmnts.setBounds(44, 370, 127, 26);
		ViewInfoPanel.add(txtrActiveShipmnts);
		
		viewCompanyNameTextField = new JTextArea();
		viewCompanyNameTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewCompanyNameTextField.setEditable(false);
		viewCompanyNameTextField.setBackground(new Color(95, 158, 160));
		viewCompanyNameTextField.setBounds(206, 86, 356, 16);
		viewCompanyNameTextField.setText(controller.getCompanyName());
		ViewInfoPanel.add(viewCompanyNameTextField);
		
		viewPhoneTextField = new JTextArea();
		viewPhoneTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewPhoneTextField.setEditable(false);
		viewPhoneTextField.setBackground(new Color(95, 158, 160));
		viewPhoneTextField.setBounds(206, 124, 356, 16);
		viewPhoneTextField.setText(controller.getCurrentPhoneNumber());
		ViewInfoPanel.add(viewPhoneTextField);
		
		viewEmailTextField = new JTextArea();
		viewEmailTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewEmailTextField.setEditable(false);
		viewEmailTextField.setBackground(new Color(95, 158, 160));
		viewEmailTextField.setBounds(206, 163, 356, 45);
		viewEmailTextField.setText(controller.getCurrentEmail());
		ViewInfoPanel.add(viewEmailTextField);
		
		viewReferencePersonTextField = new JTextArea();
		viewReferencePersonTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewReferencePersonTextField.setEditable(false);
		viewReferencePersonTextField.setBackground(new Color(95, 158, 160));
		viewReferencePersonTextField.setBounds(206, 207, 356, 37);
		viewReferencePersonTextField.setText(controller.getReferencePerson());
		ViewInfoPanel.add(viewReferencePersonTextField);
		
		viewAddressTextField = new JTextArea();
		viewAddressTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewAddressTextField.setEditable(false);
		viewAddressTextField.setBackground(new Color(95, 158, 160));
		viewAddressTextField.setBounds(206, 256, 356, 109);
		viewAddressTextField.setText(controller.getAddress());
		ViewInfoPanel.add(viewAddressTextField);
		
		viewActiveShipmentsTextField = new JTextArea();
		viewActiveShipmentsTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		viewActiveShipmentsTextField.setEditable(false);
		viewActiveShipmentsTextField.setBackground(new Color(95, 158, 160));
		viewActiveShipmentsTextField.setBounds(206, 370, 371, 102);
		viewActiveShipmentsTextField.setText(controller.getActiveShipments());
		ViewInfoPanel.add(viewActiveShipmentsTextField);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public void clearNameFields(JTextField...fields) {
		for(JTextField field : fields) {
			field.setText("");
		}
	
}
	public void clearPhoneFields(JTextField...fields) {
		for(JTextField field : fields) {
			field.setText("");
		}
	}
	
	public void clearEmailFields(JTextField...fields) {
		for(JTextField field : fields) {
			field.setText("");
		}
	}
	public void clearContainerDataFields(JTextField...fields) {
		for(JTextField field : fields) {
			field.setText("");
		}
	}
}
