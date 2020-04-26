package graphicalInterface;
 

import javax.swing.JFrame;
import javax.swing.JPanel; 
import java.awt.Font;
import java.awt.Color;

import javax.swing.SpringLayout;

import logic.LoginController;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class LoginWindow {

	private JFrame frmLoginPage;
	public JRadioButton clientMenuRdb, companyMenuRdb;
	public JTextField IDtextField;
	public JTextField usernameTextField;
	public JPasswordField passwordField;
	public JTextPane errorMessage;
	
	private JButton EnterButton;
	private JPanel clientPanel, companyPanel;
    private LoginController controller;

	/**
	 * Create the application.
	 */
	public LoginWindow(LoginController controller) {
		this.controller = controller;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setResizable(false);
		frmLoginPage.getContentPane().setBackground(new Color(95, 158, 160));
		frmLoginPage.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 35);
		panel.setBackground(new Color(95, 158, 160));
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);

		clientMenuRdb = new JRadioButton("Client Menu");
		
		clientMenuRdb.setBackground(new Color(95, 158, 160));
		clientMenuRdb.setBounds(0, 0, 219, 35);
		clientMenuRdb.setSelected(true);
		panel.add(clientMenuRdb);

		companyMenuRdb = new JRadioButton("Company Menu");
		companyMenuRdb.setBackground(new Color(95, 158, 160));
		companyMenuRdb.setBounds(219, 0, 219, 35);
		panel.add(companyMenuRdb);

	    companyPanel = new JPanel();
		companyPanel.setBounds(6, 53, 438, 102);
		companyPanel.setBackground(new Color(95, 158, 160));
		frmLoginPage.getContentPane().add(companyPanel);
		companyPanel.setLayout(null);

		JTextArea txtrEnterCompanyUsername = new JTextArea();
		txtrEnterCompanyUsername.setBounds(30, 29, 40, 16);
		txtrEnterCompanyUsername.setBackground(new Color(95, 158, 160));
		txtrEnterCompanyUsername.setText("LogIn:");
		companyPanel.add(txtrEnterCompanyUsername);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(128, 24, 211, 26);
		companyPanel.add(usernameTextField);
		usernameTextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(128, 66, 211, 26);
		companyPanel.add(passwordField);

		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setBounds(10, 71, 60, 16);
		txtrPassword.setBackground(new Color(95, 158, 160));
		txtrPassword.setText("Password");
		companyPanel.add(txtrPassword);
		companyPanel.setVisible(false);

		clientPanel = new JPanel();
		clientPanel.setBounds(6, 53, 438, 91);

		
		
		clientPanel.setBackground(new Color(95, 158, 160));
		frmLoginPage.getContentPane().add(clientPanel);
		SpringLayout sl_clientPanel = new SpringLayout();
		clientPanel.setLayout(sl_clientPanel);

		JTextPane txtpnEnterValidClient = new JTextPane();
		sl_clientPanel.putConstraint(SpringLayout.WEST, txtpnEnterValidClient, 148, SpringLayout.WEST, clientPanel);
		sl_clientPanel.putConstraint(SpringLayout.SOUTH, txtpnEnterValidClient, -42, SpringLayout.SOUTH, clientPanel);
		txtpnEnterValidClient.setBackground(new Color(95, 158, 160));
		clientPanel.add(txtpnEnterValidClient);
		txtpnEnterValidClient.setText("Enter Valid Client ID");

		IDtextField = new JTextField();
		sl_clientPanel.putConstraint(SpringLayout.NORTH, IDtextField, 6, SpringLayout.SOUTH, txtpnEnterValidClient);
		sl_clientPanel.putConstraint(SpringLayout.WEST, IDtextField, 70, SpringLayout.WEST, clientPanel);
		sl_clientPanel.putConstraint(SpringLayout.SOUTH, IDtextField, -10, SpringLayout.SOUTH, clientPanel);
		sl_clientPanel.putConstraint(SpringLayout.EAST, IDtextField, -72, SpringLayout.EAST, clientPanel);
		clientPanel.add(IDtextField);
		IDtextField.setColumns(10);

		EnterButton = new JButton("Enter");
		EnterButton.setBounds(167, 227, 117, 29);
		frmLoginPage.getContentPane().add(EnterButton);
		
		errorMessage = new JTextPane();
		errorMessage.setEnabled(false);
		errorMessage.setEditable(false);
		errorMessage.setBounds(99, 40, 272, 16);
		frmLoginPage.getContentPane().add(errorMessage);
		errorMessage.setBackground(new Color(95, 158, 160));
		errorMessage.setForeground(Color.RED);
		errorMessage.setText("Something went wrong. Please try again"); 
		errorMessage.hide();
		
		setEventListeners();
		
		frmLoginPage.setBackground(new Color(95, 158, 160));
		frmLoginPage.setFont(new Font("Dialog", Font.BOLD, 11));
		frmLoginPage.setTitle("Login ");
		frmLoginPage.setBounds(100, 100, 450, 300);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setEventListeners() {
		
		
		clientMenuRdb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				errorMessage.hide();
				if(clientMenuRdb.isSelected()) {
					companyMenuRdb.setSelected(false);
					companyPanel.setVisible(false);
					clientPanel.setVisible(true);
				} else {
					companyMenuRdb.setSelected(true);
					clientPanel.setVisible(false);
					companyPanel.setVisible(true);
				}
 			}
		}); 

		companyMenuRdb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				errorMessage.hide();
				if(companyMenuRdb.isSelected()) {
					clientMenuRdb.setSelected(false);
					clientPanel.setVisible(false);
					companyPanel.setVisible(true);
				} else {
					clientMenuRdb.setSelected(true);
					companyPanel.setVisible(false);
					clientPanel.setVisible(true);
				}
 			}
		});
		
		EnterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				controller.loginButtonPressed();
			}
		});
	}

	public boolean isClientButtonChecked() {
		return clientMenuRdb.isSelected();
	}

	public String getClientInput() {	
		return IDtextField.getText();
	}
	
	public String getCompanyUsername() {
		return usernameTextField.getText();
	}
	
	public char[] getComapnyPassword() {
		return passwordField.getPassword();
	}
	
	public void invalidInput() {
		errorMessage.show(true);
		errorMessage.setEnabled(true);
		IDtextField.setText("");
		usernameTextField.setText("");
		passwordField.setText("");
		
	}
	public void openFrame() {
		frmLoginPage.setVisible(true);
	}
	
	public void closeFrame() {
		frmLoginPage.setVisible(false);
	}
}