package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DropMode;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPasswordField;

public class login_window {

	private JFrame frmLoginPage;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_window window = new login_window();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setResizable(false);
		frmLoginPage.getContentPane().setBackground(new Color(102, 205, 170));
		frmLoginPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 35);
		panel.setBackground(new Color(102, 205, 170));
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Client Menu");
		rdbtnNewRadioButton.setBounds(0, 0, 219, 35);
		rdbtnNewRadioButton.setSelected(true);
		panel.add(rdbtnNewRadioButton);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Company Menu");
		rdbtnNewRadioButton_1.setBounds(219, 0, 219, 35);
		panel.add(rdbtnNewRadioButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 53, 438, 102);
		panel_2.setBackground(new Color(102, 205, 170));
		frmLoginPage.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea txtrEnterCompanyUsername = new JTextArea();
		txtrEnterCompanyUsername.setBounds(30, 29, 40, 16);
		txtrEnterCompanyUsername.setBackground(new Color(102, 205, 170));
		txtrEnterCompanyUsername.setText("LogIn:");
		panel_2.add(txtrEnterCompanyUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 24, 211, 26);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 66, 211, 26);
		panel_2.add(passwordField);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setBounds(10, 71, 60, 16);
		txtrPassword.setBackground(new Color(102, 205, 170));
		txtrPassword.setText("Password");
		panel_2.add(txtrPassword);
		panel_2.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 53, 438, 91);
		
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnNewRadioButton_1.setSelected(false);
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		panel_1.setBackground(new Color(102, 205, 170));
		frmLoginPage.getContentPane().add(panel_1);
		SpringLayout Client = new SpringLayout();
		panel_1.setLayout(Client);
		
		JTextPane txtpnEnterValidClient = new JTextPane();
		Client.putConstraint(SpringLayout.WEST, txtpnEnterValidClient, 148, SpringLayout.WEST, panel_1);
		Client.putConstraint(SpringLayout.SOUTH, txtpnEnterValidClient, -42, SpringLayout.SOUTH, panel_1);
		txtpnEnterValidClient.setBackground(new Color(102, 205, 170));
		panel_1.add(txtpnEnterValidClient);
		txtpnEnterValidClient.setText("Enter Valid Client ID");
		
		textField = new JTextField();
		Client.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, txtpnEnterValidClient);
		Client.putConstraint(SpringLayout.WEST, textField, 70, SpringLayout.WEST, panel_1);
		Client.putConstraint(SpringLayout.SOUTH, textField, -10, SpringLayout.SOUTH, panel_1);
		Client.putConstraint(SpringLayout.EAST, textField, -72, SpringLayout.EAST, panel_1);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(73, 168, 28, 51);
		frmLoginPage.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(167, 227, 117, 29);
		frmLoginPage.getContentPane().add(btnNewButton);
		
		JTextPane txtpnIAgreeTo = new JTextPane();
		txtpnIAgreeTo.setBounds(99, 184, 313, 48);
		txtpnIAgreeTo.setBackground(new Color(102, 205, 170));
		txtpnIAgreeTo.setText("i agree to the terms and conditions and the privacy policy read the terms and conditions of use");
		frmLoginPage.getContentPane().add(txtpnIAgreeTo);
		frmLoginPage.setBackground(new Color(32, 178, 170));
		frmLoginPage.setFont(new Font("Dialog", Font.BOLD, 11));
		frmLoginPage.setTitle("Login ");
		frmLoginPage.setBounds(100, 100, 450, 300);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
