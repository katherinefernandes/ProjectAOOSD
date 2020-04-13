package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import java.awt.Canvas;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SpringLayout;

public class CompanyUpdateContainer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyUpdateContainer window = new CompanyUpdateContainer();
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
	public CompanyUpdateContainer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBounds(100, 100, 644, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(19, 102, 607, 334);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setBounds(235, 341, 214, 49);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(235, 421, 214, 46);
		textField_1.setColumns(10);
		
		JTextArea txtrNewLongitude = new JTextArea();
		txtrNewLongitude.setBounds(108, 355, 109, 19);
		txtrNewLongitude.setBackground(new Color(95, 158, 160));
		txtrNewLongitude.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrNewLongitude.setEditable(false);
		txtrNewLongitude.setText("New longitude:");
		
		JTextArea txtrNewLatitude = new JTextArea();
		txtrNewLatitude.setBounds(108, 434, 96, 19);
		txtrNewLatitude.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrNewLatitude.setBackground(new Color(95, 158, 160));
		txtrNewLatitude.setEditable(false);
		txtrNewLatitude.setText("New latitude:");
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(346, 505, 75, 29);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 250, 250));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 607, 335);
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(199, 111, 212, 40);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(199, 54, 212, 40);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 176, 212, 40);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea txtrAtmosphere = new JTextArea();
		txtrAtmosphere.setBounds(88, 64, 93, 19);
		txtrAtmosphere.setBackground(new Color(95, 158, 160));
		txtrAtmosphere.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrAtmosphere.setEditable(false);
		txtrAtmosphere.setText("Atmosphere:");
		panel_1.add(txtrAtmosphere);
		
		JTextArea txtrHumidity = new JTextArea();
		txtrHumidity.setBounds(106, 121, 71, 19);
		txtrHumidity.setBackground(new Color(95, 158, 160));
		txtrHumidity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrHumidity.setEditable(false);
		txtrHumidity.setText("Humidity:");
		panel_1.add(txtrHumidity);
		
		JTextArea txtrTemperature = new JTextArea();
		txtrTemperature.setBounds(84, 186, 97, 19);
		txtrTemperature.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrTemperature.setBackground(new Color(95, 158, 160));
		txtrTemperature.setText("Temperature:");
		txtrTemperature.setEditable(false);
		panel_1.add(txtrTemperature);
		panel.setLayout(null);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(txtrNewLongitude);
		panel.add(txtrNewLatitude);
		panel.add(btnNewButton);
		panel.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(314, 260, 97, 29);
		panel_1.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Update Container Status");
		rdbtnNewRadioButton.setBounds(19, 34, 202, 23);
		rdbtnNewRadioButton.setSelected(true);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Update Container Position");
		rdbtnNewRadioButton_1.setBounds(430, 34, 196, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
	}
}
