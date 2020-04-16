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

import logic.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;



public class newClientStuff {

	private long clientID;
	
	public JFrame frame;
	JButton emailButton,AddJourneyButton,ArrivalButton,ReferencepersonButton,ContainerButton;
	JPanel ButtonPanel,panel_1,referencePanel,emailPanel,JourneyPanel,ArrivalPanel,DataPanel;
	JLayeredPane layeredPane;
	private JTextArea txtrName;
	private JTextArea txtrLastName;
	private JTextField firstnametext;
	private JTextField middlenametext;
	private JTextField lastnametext;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel PhonePanel;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private Controller controller;
	private JButton LogOutButton;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					newClientStuff window = new newClientStuff();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public newClientStuff() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
	
	public newClientStuff(Controller controller, String clientID) {
		this.controller = controller;
		this.clientID = Long.valueOf(clientID);
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
		
		ArrivalButton = new JButton("Arrival Date");
		ArrivalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(ArrivalPanel);
			}
		});
		ArrivalButton.setBounds(55, 236, 196, 29);
		ButtonPanel.add(ArrivalButton);
		
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
		ContainerButton.setBounds(55, 270, 196, 29);
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
		LogOutButton.setBounds(55, 311, 196, 29);
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
				controller.saveReferencePerson(firstnametext.getText(),middlenametext.getText(),lastnametext.getText(),clientID);
				firstnametext.setText("");
				middlenametext.setText("");
				lastnametext.setText("");
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(267, 94, 210, 26);
		emailPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(267, 140, 210, 26);
		emailPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(357, 223, 117, 29);
		emailPanel.add(btnNewButton);
		
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
		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBounds(372, 199, 117, 29);
		PhonePanel.add(btnNewButton_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(291, 85, 198, 26);
		PhonePanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(291, 136, 198, 26);
		PhonePanel.add(textField_6);
		textField_6.setColumns(10);
		
		JourneyPanel = new JPanel();
		JourneyPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(JourneyPanel, "name_7881573753337");
		JourneyPanel.setLayout(null);
		
		JTextArea txtrJourney = new JTextArea();
		txtrJourney.setBackground(new Color(95, 158, 160));
		txtrJourney.setEditable(false);
		txtrJourney.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrJourney.setBounds(84, 108, 83, 16);
		txtrJourney.setText("Enter ID:");
		JourneyPanel.add(txtrJourney);
		
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
		
		textField_7 = new JTextField();
		textField_7.setBounds(295, 105, 179, 26);
		JourneyPanel.add(textField_7);
		textField_7.setColumns(10);
		
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
		
		ArrivalPanel = new JPanel();
		ArrivalPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(ArrivalPanel, "name_7922511904851");
		ArrivalPanel.setLayout(null);
		
		JTextArea txtrArrivalDate = new JTextArea();
		txtrArrivalDate.setBounds(69, 121, 124, 19);
		txtrArrivalDate.setText("Arrival date:");
		txtrArrivalDate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrArrivalDate.setEditable(false);
		txtrArrivalDate.setBackground(new Color(95, 158, 160));
		ArrivalPanel.add(txtrArrivalDate);
		
		JTextArea ArrivalDateTextUpdate = new JTextArea();
		ArrivalDateTextUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		ArrivalDateTextUpdate.setEditable(false);
		ArrivalDateTextUpdate.setBackground(new Color(95, 158, 160));
		ArrivalDateTextUpdate.setBounds(239, 123, 162, 16);
		ArrivalPanel.add(ArrivalDateTextUpdate);
		
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
		
		textField_15 = new JTextField();
		textField_15.setBounds(206, 82, 199, 26);
		DataPanel.add(textField_15);
		textField_15.setColumns(10);
		
		JButton Enterbutton = new JButton("Enter");
		Enterbutton.setBounds(288, 120, 117, 29);
		DataPanel.add(Enterbutton);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
}
