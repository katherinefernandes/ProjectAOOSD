package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.JSlider;

public class Company_Menu_1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Company_Menu_1 window = new Company_Menu_1();
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
	public Company_Menu_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setEditable(false);
		txtpnWelcomeToThe.setBounds(6, 6, 438, 16);
		txtpnWelcomeToThe.setBackground(new Color(102, 205, 170));
		txtpnWelcomeToThe.setText("Welcome to the Logistic Menu --- Velkommen til Logistikmenuen");
		frame.getContentPane().add(txtpnWelcomeToThe);
		
		JButton btnNewButton = new JButton("Add a new Client");
		btnNewButton.setBounds(105, 34, 213, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Get client Information");
		btnNewButton_1.setBounds(105, 65, 213, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update container Information");
		btnNewButton_2.setBounds(105, 95, 213, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Get Containter Information");
		btnNewButton_3.setBounds(105, 126, 213, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JSlider slider = new JSlider();
		slider.setBounds(115, 205, 190, 29);
		frame.getContentPane().add(slider);
		
		JTextPane txtpnYourOpinionMatters = new JTextPane();
		txtpnYourOpinionMatters.setBackground(new Color(102, 205, 170));
		txtpnYourOpinionMatters.setText("Your opinion matters. Rate your experience");
		txtpnYourOpinionMatters.setEditable(false);
		txtpnYourOpinionMatters.setBounds(79, 184, 291, 16);
		frame.getContentPane().add(txtpnYourOpinionMatters);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
