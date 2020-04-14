package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;

public class DisplayContainerData {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayContainerData window = new DisplayContainerData();
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
	public DisplayContainerData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBounds(100, 100, 542, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(34, 46, 476, 370);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea txtrThisIsThe = new JTextArea();
		txtrThisIsThe.setBackground(new Color(95, 158, 160));
		txtrThisIsThe.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrThisIsThe.setEditable(false);
		txtrThisIsThe.setText("This is the container ID:");
		txtrThisIsThe.setBounds(21, 39, 189, 16);
		panel.add(txtrThisIsThe);
		
		JTextArea txtrCargo = new JTextArea();
		txtrCargo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrCargo.setBackground(new Color(95, 158, 160));
		txtrCargo.setEditable(false);
		txtrCargo.setText("Cargo:");
		txtrCargo.setBounds(141, 83, 48, 30);
		panel.add(txtrCargo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(34, 6, 476, 28);
		frame.getContentPane().add(panel_1);
		
		JTextArea txtrHereIsAll = new JTextArea();
		txtrHereIsAll.setBackground(new Color(95, 158, 160));
		txtrHereIsAll.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrHereIsAll.setEditable(false);
		txtrHereIsAll.setText("Here is all the data available about the container ");
		panel_1.add(txtrHereIsAll);
	}
}
