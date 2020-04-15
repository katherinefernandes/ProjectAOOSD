package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClientStuff {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton updateReferencePersonButton,updateEmail,updateInfoClientButton;
	JButton addJourneyButton,getArrivalDate,displayContainerDataButton;
	JPanel panel,panel_1,UpdateInfoPanel,emailPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientStuff window = new ClientStuff();
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
	public ClientStuff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(6, 6, 612, 46);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		updateReferencePersonButton = new JButton("Reference Person");
		panel.add(updateReferencePersonButton);
		
		updateEmail = new JButton("Change E-mail");
		panel.add(updateEmail);
		
		updateInfoClientButton = new JButton("Update Client Info");
		panel.add(updateInfoClientButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(6, 110, 612, 361);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		UpdateInfoPanel = new JPanel();
		UpdateInfoPanel.setBackground(new Color(95, 158, 160));
		UpdateInfoPanel.setBounds(6, 6, 600, 348);
		panel_1.add(UpdateInfoPanel);
		
		emailPanel = new JPanel();
		emailPanel.setBackground(new Color(95, 158, 160));
		emailPanel.setBounds(6, 6, 600, 348);
		panel_1.add(emailPanel);
		emailPanel.setLayout(null);
		
		JTextArea txtrCurrentEmail = new JTextArea();
		txtrCurrentEmail.setBackground(new Color(95, 158, 160));
		txtrCurrentEmail.setEditable(false);
		txtrCurrentEmail.setText("Current e-mail:");
		txtrCurrentEmail.setBounds(37, 65, 99, 16);
		emailPanel.add(txtrCurrentEmail);
		
		JTextArea txtrNewEmail = new JTextArea();
		txtrNewEmail.setBackground(new Color(95, 158, 160));
		txtrNewEmail.setText("New e-mail:");
		txtrNewEmail.setBounds(58, 106, 78, 16);
		emailPanel.add(txtrNewEmail);
		
		JTextArea CurrentEmailTextbox = new JTextArea();
		CurrentEmailTextbox.setBackground(new Color(95, 158, 160));
		CurrentEmailTextbox.setEditable(false);
		CurrentEmailTextbox.setBounds(148, 65, 171, 16);
		emailPanel.add(CurrentEmailTextbox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(158, 101, 171, 26);
		emailPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(212, 163, 117, 29);
		emailPanel.add(btnNewButton_1);
		
		JPanel ReferencePersonPanel = new JPanel();
		ReferencePersonPanel.setBounds(6, 5, 600, 349);
		panel_1.add(ReferencePersonPanel);
		ReferencePersonPanel.setBackground(new Color(95, 158, 160));
		ReferencePersonPanel.setLayout(null);
		
		JTextArea txtrUpdateFirstName = new JTextArea();
		txtrUpdateFirstName.setEditable(false);
		txtrUpdateFirstName.setBackground(new Color(95, 158, 160));
		txtrUpdateFirstName.setText("Update First Name:");
		txtrUpdateFirstName.setBounds(44, 35, 165, 16);
		ReferencePersonPanel.add(txtrUpdateFirstName);
		
		JTextArea txtrUpdateMiddleName = new JTextArea();
		txtrUpdateMiddleName.setBackground(new Color(95, 158, 160));
		txtrUpdateMiddleName.setText("Update Middle Name:");
		txtrUpdateMiddleName.setBounds(32, 74, 135, 16);
		ReferencePersonPanel.add(txtrUpdateMiddleName);
		
		JTextArea txtrUdateLastName = new JTextArea();
		txtrUdateLastName.setBackground(new Color(95, 158, 160));
		txtrUdateLastName.setText("Udate Last Name:");
		txtrUdateLastName.setEditable(false);
		txtrUdateLastName.setBounds(56, 113, 116, 16);
		ReferencePersonPanel.add(txtrUdateLastName);
		
		textField = new JTextField();
		textField.setBounds(205, 30, 189, 26);
		ReferencePersonPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 69, 189, 26);
		ReferencePersonPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 108, 189, 26);
		ReferencePersonPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(277, 179, 117, 29);
		ReferencePersonPanel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 205, 170));
		panel_2.setBounds(6, 64, 612, 39);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		addJourneyButton = new JButton("Add Journey");
		panel_2.add(addJourneyButton);
		
		getArrivalDate = new JButton("Arrival Date");
		panel_2.add(getArrivalDate);
		
		displayContainerDataButton = new JButton("Container Data");
		panel_2.add(displayContainerDataButton);
		frame.setBounds(100, 100, 624, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setEventListeners();
	}
	
	
	public void setEventListeners() {

		updateReferencePersonButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(ChangeEvent e) {
				
				
				if(updateReferencePersonButton.isEnabled()) {
					emailPanel.setVisible(false);
					UpdateInfoPanel.setVisible(true);
				}
					
					
				if(updateEmail.isEnabled()) {
					emailPanel.setVisible(true);
					UpdateInfoPanel.setVisible(false);

				
					
				}
				else {
					UpdateInfoPanel.setVisible(false);
					emailPanel.setVisible(false);
	
				}
 			}
		}); 
		
		
//		updateEmail.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(ChangeEvent e) {
//				if(updateEmail.isEnabled()) {
//					UpdateInfoPanel.setVisible(false);
//					emailPanel.setVisible(true);
//					
//				} else {
//					UpdateInfoPanel.setVisible(false);
//					emailPanel.setVisible(false);
//					
//				}
// 			}
//		}); 
		
}
}
