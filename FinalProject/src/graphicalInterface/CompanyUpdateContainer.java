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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CompanyUpdateContainer {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public JRadioButton ContainerStatus, ContainerPosition;
	private JPanel StatusPanel;
	private JPanel PositionPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JTextArea txtrNewLongitude;
	private JTextArea txtrNewLatitude;

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
		
		PositionPanel = new JPanel();
		PositionPanel.setBackground(new Color(95, 158, 160));
		PositionPanel.setBounds(19, 103, 607, 328);
		frame.getContentPane().add(PositionPanel);
		PositionPanel.setLayout(null);
		
		ContainerStatus = new JRadioButton("Update Container Status");
		ContainerStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ContainerStatus.setBounds(19, 34, 202, 23);
		ContainerStatus.setSelected(true);
		frame.getContentPane().add(ContainerStatus);
		
		JRadioButton ContainerPosition = new JRadioButton("Update Container Position");
		ContainerPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ContainerPosition.setBounds(430, 34, 196, 23);
		frame.getContentPane().add(ContainerPosition);
		
		
		textField = new JTextField();
		textField.setBounds(233, 53, 203, 43);
		PositionPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 122, 203, 43);
		PositionPanel.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setBounds(319, 203, 117, 29);
		PositionPanel.add(btnNewButton);
		
		txtrNewLongitude = new JTextArea();
		txtrNewLongitude.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrNewLongitude.setEditable(false);
		txtrNewLongitude.setBackground(new Color(95, 158, 160));
		txtrNewLongitude.setText("New longitude:");
		txtrNewLongitude.setBounds(104, 64, 117, 32);
		PositionPanel.add(txtrNewLongitude);
		
		txtrNewLatitude = new JTextArea();
		txtrNewLatitude.setBackground(new Color(95, 158, 160));
		txtrNewLatitude.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrNewLatitude.setEditable(false);
		txtrNewLatitude.setText("New latitude:");
		txtrNewLatitude.setBounds(116, 133, 105, 16);
		PositionPanel.add(txtrNewLatitude);
		
		StatusPanel = new JPanel();
		StatusPanel.setBounds(0, 0, 607, 328);
		PositionPanel.add(StatusPanel);
		StatusPanel.setBackground(new Color(95, 158, 160));
		StatusPanel.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(199, 111, 212, 40);
		StatusPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(199, 54, 212, 40);
		StatusPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 176, 212, 40);
		StatusPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea txtrAtmosphere = new JTextArea();
		txtrAtmosphere.setBounds(88, 64, 93, 19);
		txtrAtmosphere.setBackground(new Color(95, 158, 160));
		txtrAtmosphere.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrAtmosphere.setEditable(false);
		txtrAtmosphere.setText("Atmosphere:");
		StatusPanel.add(txtrAtmosphere);
		
		JTextArea txtrHumidity = new JTextArea();
		txtrHumidity.setBounds(106, 121, 71, 19);
		txtrHumidity.setBackground(new Color(95, 158, 160));
		txtrHumidity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrHumidity.setEditable(false);
		txtrHumidity.setText("Humidity:");
		StatusPanel.add(txtrHumidity);
		
		
		JTextArea txtrTemperature = new JTextArea();
		txtrTemperature.setBounds(90, 186, 97, 19);
		StatusPanel.add(txtrTemperature);
		txtrTemperature.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrTemperature.setBackground(new Color(95, 158, 160));
		txtrTemperature.setText("Temperature:");
		txtrTemperature.setEditable(false);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(349, 250, 97, 29);
		StatusPanel.add(btnNewButton_1);

	}
	private void setEventListeners() {
		ContainerStatus.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(ContainerStatus.isSelected()) {
					ContainerPosition.setSelected(false);
					PositionPanel.setVisible(true);
					StatusPanel.setVisible(false);
					
				}
				else {
					ContainerPosition.setSelected(true);
					PositionPanel.setVisible(false);
					StatusPanel.setVisible(true);
				}
				
			}
			
		
	});
		ContainerPosition.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(ContainerPosition.isSelected()) {
					ContainerStatus.setSelected(false);
					PositionPanel.setVisible(true);
					StatusPanel.setVisible(false);
				} else {
					ContainerPosition.setSelected(false);
					PositionPanel.setVisible(false);
					StatusPanel.setVisible(true);
				}
 			}
		});


		
}
}
