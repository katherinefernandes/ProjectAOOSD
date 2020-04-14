package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextArea;

public class CompanyAddClient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyAddClient window = new CompanyAddClient();
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
	public CompanyAddClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JTextPane txtpnUpdateClientInformation = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnUpdateClientInformation, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnUpdateClientInformation, 30, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnUpdateClientInformation, -34, SpringLayout.EAST, frame.getContentPane());
		txtpnUpdateClientInformation.setEditable(false);
		txtpnUpdateClientInformation.setBackground(new Color(102, 205, 170));
		txtpnUpdateClientInformation.setText("For adding a new client please complete the following fields");
		frame.getContentPane().add(txtpnUpdateClientInformation);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 93, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textField_1);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -6, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -171, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 6, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField_1);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 6, SpringLayout.SOUTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField_1);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_5, 6, SpringLayout.SOUTH, textField_4);
		springLayout.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, textField_1);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_6, 0, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_6, 0, SpringLayout.EAST, txtpnUpdateClientInformation);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_7, 0, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_7, 0, SpringLayout.EAST, txtpnUpdateClientInformation);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_8, 0, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_8, 0, SpringLayout.EAST, txtpnUpdateClientInformation);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_9, 0, SpringLayout.NORTH, textField_4);
		springLayout.putConstraint(SpringLayout.EAST, textField_9, 0, SpringLayout.EAST, txtpnUpdateClientInformation);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_10, 0, SpringLayout.NORTH, textField_5);
		springLayout.putConstraint(SpringLayout.EAST, textField_10, 0, SpringLayout.EAST, txtpnUpdateClientInformation);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 209, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -77, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnCompanyName = new JTextPane();
		txtpnCompanyName.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnCompanyName, 25, SpringLayout.SOUTH, txtpnUpdateClientInformation);
		springLayout.putConstraint(SpringLayout.WEST, txtpnCompanyName, 5, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnCompanyName, 0, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, txtpnCompanyName, -6, SpringLayout.WEST, textField_1);
		txtpnCompanyName.setBackground(new Color(102, 205, 170));
		txtpnCompanyName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtpnCompanyName.setText("Company name");
		frame.getContentPane().add(txtpnCompanyName);
		
		JTextArea txtrEmail = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrEmail, 7, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, txtrEmail, -25, SpringLayout.WEST, textField_2);
		txtrEmail.setBackground(new Color(102, 205, 170));
		txtrEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrEmail.setEditable(false);
		txtrEmail.setText("E-mail");
		frame.getContentPane().add(txtrEmail);
		
		JTextArea txtrCountryCode = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrCountryCode, 7, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, txtrCountryCode, -6, SpringLayout.WEST, textField_3);
		txtrCountryCode.setBackground(new Color(102, 205, 170));
		txtrCountryCode.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrCountryCode.setEditable(false);
		txtrCountryCode.setText("Country code");
		frame.getContentPane().add(txtrCountryCode);
		
		JTextArea txtrPhoneNumber = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrPhoneNumber, 7, SpringLayout.NORTH, textField_4);
		springLayout.putConstraint(SpringLayout.EAST, txtrPhoneNumber, -6, SpringLayout.WEST, textField_4);
		txtrPhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrPhoneNumber.setBackground(new Color(102, 205, 170));
		txtrPhoneNumber.setEditable(false);
		txtrPhoneNumber.setText("Phone number");
		frame.getContentPane().add(txtrPhoneNumber);
		
		JTextArea txtrName = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrName, 7, SpringLayout.NORTH, textField_5);
		springLayout.putConstraint(SpringLayout.EAST, txtrName, -6, SpringLayout.WEST, textField_5);
		txtrName.setBackground(new Color(102, 205, 170));
		txtrName.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrName.setEditable(false);
		txtrName.setText("First Name");
		frame.getContentPane().add(txtrName);
		
		JTextArea txtrMiddleName = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrMiddleName, 7, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, txtrMiddleName, -6, SpringLayout.WEST, textField);
		txtrMiddleName.setBackground(new Color(102, 205, 170));
		txtrMiddleName.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrMiddleName.setEditable(false);
		txtrMiddleName.setText("Middle name");
		frame.getContentPane().add(txtrMiddleName);
		
		JTextArea txtrLastName = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrLastName, 7, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, txtrLastName, 6, SpringLayout.EAST, textField_1);
		txtrLastName.setBackground(new Color(102, 205, 170));
		txtrLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrLastName.setEditable(false);
		txtrLastName.setText("Last Name");
		frame.getContentPane().add(txtrLastName);
		
		JTextArea txtrStreet = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrStreet, 7, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, txtrStreet, -6, SpringLayout.WEST, textField_7);
		txtrStreet.setBackground(new Color(102, 205, 170));
		txtrStreet.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrStreet.setEditable(false);
		txtrStreet.setText("Street");
		frame.getContentPane().add(txtrStreet);
		
		JTextArea txtrCity = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrCity, 7, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, txtrCity, -6, SpringLayout.WEST, textField_8);
		txtrCity.setBackground(new Color(102, 205, 170));
		txtrCity.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrCity.setEditable(false);
		txtrCity.setText("City");
		frame.getContentPane().add(txtrCity);
		
		JTextArea txtrBuilding = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrBuilding, 7, SpringLayout.NORTH, textField_4);
		springLayout.putConstraint(SpringLayout.EAST, txtrBuilding, -6, SpringLayout.WEST, textField_9);
		txtrBuilding.setBackground(new Color(102, 205, 170));
		txtrBuilding.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrBuilding.setEditable(false);
		txtrBuilding.setText("Building");
		frame.getContentPane().add(txtrBuilding);
		
		JTextArea txtrPostalCode = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrPostalCode, 7, SpringLayout.NORTH, textField_5);
		springLayout.putConstraint(SpringLayout.EAST, txtrPostalCode, 0, SpringLayout.EAST, txtrLastName);
		txtrPostalCode.setBackground(new Color(102, 205, 170));
		txtrPostalCode.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrPostalCode.setEditable(false);
		txtrPostalCode.setText("Postal code");
		frame.getContentPane().add(txtrPostalCode);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
