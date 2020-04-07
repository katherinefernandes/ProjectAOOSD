package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import javax.swing.JSlider;

public class Clien_Menu_1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clien_Menu_1 window = new Clien_Menu_1();
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
	public Clien_Menu_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setBounds(0, 0, 450, 32);
		txtrWelcomeToThe.setBackground(new Color(102, 205, 170));
		txtrWelcomeToThe.setText("    Welcome to the client menu ---  Velkommen til klientmenuen\n");
		frame.getContentPane().add(txtrWelcomeToThe);
		
		JButton btnNewButton = new JButton("Get the client Information");
		btnNewButton.setBounds(76, 38, 278, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update the current client Information");
		btnNewButton_1.setBounds(76, 73, 278, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add a new journey");
		btnNewButton_2.setBounds(76, 102, 278, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Internal Status of a Journey");
		btnNewButton_3.setBounds(76, 135, 278, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JSlider slider = new JSlider();
		slider.setBounds(116, 219, 190, 30);
		slider.setPaintLabels(true);
		slider.setToolTipText("");
		frame.getContentPane().add(slider);
		
		JTextPane txtpnYourOpinionMatters = new JTextPane();
		txtpnYourOpinionMatters.setBounds(76, 197, 273, 16);
		txtpnYourOpinionMatters.setBackground(new Color(102, 205, 170));
		txtpnYourOpinionMatters.setText("Your opinion matters. Rate your experience");
		frame.getContentPane().add(txtpnYourOpinionMatters);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
