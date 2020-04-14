package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateContainer {

	private JFrame ContainerFrame;
	public  JLayeredPane layeredPane;
	public  JPanel PositionPanel;
	public JPanel StatusPanel;
	JRadioButton PositionRdb,StatusRdb;
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
					UpdateContainer window = new UpdateContainer();
					window.ContainerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateContainer() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ContainerFrame = new JFrame();
		ContainerFrame.getContentPane().setBackground(new Color(102, 205, 170));
		ContainerFrame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 101, 538, 300);
		ContainerFrame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		PositionPanel = new JPanel();
		layeredPane.setLayer(PositionPanel, 0);
		PositionPanel.setBackground(new Color(95, 158, 160));
		PositionPanel.setBounds(6, -16, 526, 310);
		layeredPane.add(PositionPanel);
		PositionPanel.setLayout(null);
		
		JTextArea txtrPosition = new JTextArea();
		txtrPosition.setBackground(new Color(95, 158, 160));
		txtrPosition.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrPosition.setEditable(false);
		txtrPosition.setText("New longitude:");
		txtrPosition.setBounds(64, 77, 109, 35);
		PositionPanel.add(txtrPosition);
		
		JTextArea txtrNewLatitude = new JTextArea();
		txtrNewLatitude.setBackground(new Color(95, 158, 160));
		txtrNewLatitude.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrNewLatitude.setEditable(false);
		txtrNewLatitude.setText("New latitude:");
		txtrNewLatitude.setBounds(76, 141, 109, 16);
		PositionPanel.add(txtrNewLatitude);
		
		textField_3 = new JTextField();
		textField_3.setBounds(182, 74, 130, 26);
		PositionPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(182, 141, 130, 26);
		PositionPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(195, 195, 117, 29);
		PositionPanel.add(btnNewButton_1);
		
		StatusPanel = new JPanel();
		StatusPanel.setBackground(new Color(95, 158, 160));
		layeredPane.setLayer(StatusPanel, 1);
		StatusPanel.setBounds(6, 0, 526, 294);
		layeredPane.add(StatusPanel);
		StatusPanel.setLayout(null);
		
		JTextArea txtrStatus = new JTextArea();
		txtrStatus.setBackground(new Color(95, 158, 160));
		txtrStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrStatus.setEditable(false);
		txtrStatus.setText("Atmosphere:");
		txtrStatus.setBounds(38, 73, 136, 16);
		StatusPanel.add(txtrStatus);
		
		JTextArea txtrHumidity = new JTextArea();
		txtrHumidity.setBackground(new Color(95, 158, 160));
		txtrHumidity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrHumidity.setEditable(false);
		txtrHumidity.setText("Humidity:");
		txtrHumidity.setBounds(58, 119, 71, 26);
		StatusPanel.add(txtrHumidity);
		
		JTextArea txtrTemperature = new JTextArea();
		txtrTemperature.setBackground(new Color(95, 158, 160));
		txtrTemperature.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrTemperature.setEditable(false);
		txtrTemperature.setText("Temperature:");
		txtrTemperature.setBounds(38, 168, 104, 26);
		StatusPanel.add(txtrTemperature);
		
		textField = new JTextField();
		textField.setBounds(175, 70, 130, 26);
		StatusPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 116, 130, 26);
		StatusPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 165, 130, 26);
		StatusPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(187, 226, 117, 29);
		StatusPanel.add(btnNewButton);
		
		PositionRdb = new JRadioButton("Position");
		PositionRdb.setBounds(6, 43, 141, 23);
		ContainerFrame.getContentPane().add(PositionRdb);
		
		StatusRdb = new JRadioButton("Status");
		StatusRdb.setSelected(true);
		StatusRdb.setBounds(403, 43, 141, 23);
		ContainerFrame.getContentPane().add(StatusRdb);
		ContainerFrame.setBounds(100, 100, 550, 429);
		ContainerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setEventListeners();
	}
//	public void switchPanels(JPanel panel) {
//		layeredPane.removeAll();
//		layeredPane.add(PositionPanel);
//		layeredPane.repaint();
//		layeredPane.validate();
//		
//		
//	}
	
	public void setEventListeners() {
		PositionRdb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				PositionPanel.setVisible(true);
				if(PositionRdb.isSelected()) {
					StatusRdb.setSelected(false);
					PositionPanel.setVisible(true);
					StatusPanel.setVisible(false);
					
				} else {
					StatusRdb.setSelected(true);
					PositionPanel.setVisible(false);
					StatusPanel.setVisible(true);
					
				}
 			}
		}); 
		
		
		StatusRdb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(StatusRdb.isSelected()) {
					StatusPanel.setVisible(true);
					PositionRdb.setSelected(false);
					
				} else {
					PositionRdb.setSelected(true);
					PositionPanel.setVisible(true);
					StatusPanel.setVisible(false);
					
				}
 			}
		}); 
		
		
		
		

	}
}
