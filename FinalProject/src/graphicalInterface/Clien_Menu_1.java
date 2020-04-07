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
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JTextArea txtrWelcomeToThe = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, txtrWelcomeToThe, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtrWelcomeToThe, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtrWelcomeToThe, 450, SpringLayout.WEST, frame.getContentPane());
		txtrWelcomeToThe.setBackground(new Color(102, 205, 170));
		txtrWelcomeToThe.setText("    Welcome to the client menu ---  Velkommen til klientmenuen\n");
		frame.getContentPane().add(txtrWelcomeToThe);
		
		JButton btnNewButton = new JButton("Get the client Information");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, txtrWelcomeToThe);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -96, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update the current client Information");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -96, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_1);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add a new journey");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 102, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 76, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -96, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton_2);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Internal Status of a Journey");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 4, SpringLayout.SOUTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 76, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -96, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_3);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		springLayout.putConstraint(SpringLayout.WEST, slider, 116, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, slider, -29, SpringLayout.SOUTH, frame.getContentPane());
		slider.setToolTipText("");
		frame.getContentPane().add(slider);
		
		JTextPane txtpnYourOpinionMatters = new JTextPane();
		txtpnYourOpinionMatters.setBackground(new Color(102, 205, 170));
		springLayout.putConstraint(SpringLayout.WEST, txtpnYourOpinionMatters, 0, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnYourOpinionMatters, -6, SpringLayout.NORTH, slider);
		txtpnYourOpinionMatters.setText("Your opinion matters. Rate your experience");
		frame.getContentPane().add(txtpnYourOpinionMatters);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
