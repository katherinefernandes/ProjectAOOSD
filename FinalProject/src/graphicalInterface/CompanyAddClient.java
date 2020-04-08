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
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, textField_6);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_6, -6, SpringLayout.NORTH, textField_7);
		springLayout.putConstraint(SpringLayout.EAST, textField_6, 0, SpringLayout.EAST, textField_7);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_7, -6, SpringLayout.NORTH, textField_8);
		springLayout.putConstraint(SpringLayout.EAST, textField_7, 0, SpringLayout.EAST, textField_8);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_8, -6, SpringLayout.NORTH, textField_9);
		springLayout.putConstraint(SpringLayout.EAST, textField_8, 0, SpringLayout.EAST, textField_9);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_9, -6, SpringLayout.NORTH, textField_10);
		springLayout.putConstraint(SpringLayout.EAST, textField_10, -52, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_9, 0, SpringLayout.EAST, textField_10);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 209, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_10, -6, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -77, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		JTextPane txtpnCompanyName = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnCompanyName, 25, SpringLayout.SOUTH, txtpnUpdateClientInformation);
		springLayout.putConstraint(SpringLayout.WEST, txtpnCompanyName, 5, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnCompanyName, 0, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, txtpnCompanyName, -6, SpringLayout.WEST, textField_1);
		txtpnCompanyName.setBackground(new Color(102, 205, 170));
		txtpnCompanyName.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtpnCompanyName.setText("Company name");
		frame.getContentPane().add(txtpnCompanyName);
		
		JTextPane txtpnEmail = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnEmail, 6, SpringLayout.SOUTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, txtpnEmail, 203, SpringLayout.WEST, frame.getContentPane());
		txtpnEmail.setEditable(false);
		springLayout.putConstraint(SpringLayout.WEST, txtpnEmail, 37, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnEmail, 12, SpringLayout.SOUTH, txtpnCompanyName);
		txtpnEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtpnEmail.setText("E-mail");
		frame.getContentPane().add(txtpnEmail);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
