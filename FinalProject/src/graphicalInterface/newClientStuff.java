package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.text.LayeredHighlighter;

import logic.ClientController;
import logic.LoginController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;



public class newClientStuff {

	private long clientID;
	
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
		LogOutButton.setBounds(55, 273, 196, 29);
		ButtonPanel.add(LogOutButton);
		
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
				controller.saveReferencePerson(firstnametext.getText(),middlenametext.getText(),lastnametext.getText());
				clearNameFields(firstnametext,middlenametext,lastnametext);
			}
		});
		Save1.setBounds(308, 244, 117, 29);
		referencePanel.add(Save1);
		
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
				controller.saveEmail(EmailTextField.getText());
				clearEmailFields(EmailTextField);
				
		
			}
		});
		saveEmailButton.setBounds(357, 223, 117, 29);
		emailPanel.add(saveEmailButton);
		
		CurrentEmailTextField = new JTextArea();
		CurrentEmailTextField.setBackground(new Color(95, 158, 160));
		CurrentEmailTextField.setEditable(false);
		CurrentEmailTextField.setBounds(267, 99, 129, 16);
		emailPanel.add(CurrentEmailTextField);
		
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
		PhonePanel.add(txtrCurrentPhoneNumber);
		
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
				controller.savePhoneNumber(countryCodeTextField.getText(),newPhoneNumberText.getText());
				clearPhoneFields(countryCodeTextField,newPhoneNumberText);
				
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
		PhonePanel.add(CurrentPhoneNumberTextArea);
		
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
		
		JTextArea txtrSearchByOne = new JTextArea();
		txtrSearchByOne.setText("Search by one of the following criteria:");
		txtrSearchByOne.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrSearchByOne.setEditable(false);
		txtrSearchByOne.setBackground(new Color(95, 158, 160));
		txtrSearchByOne.setBounds(151, 30, 320, 19);
		DataPanel.add(txtrSearchByOne);
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
}
