package graphicalInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.text.LayeredHighlighter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class newClientStuff {

	private JFrame frame;
	JButton emailButton,ClientButton,AddJourneyButton,ArrivalButton,ReferencepersonButton,ContainerButton;
	JPanel ButtonPanel,panel_1,referencePanel,emailPanel,updatePanel,JourneyPanel,ArrivalPanel,DataPanel;
	JLayeredPane layeredPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newClientStuff window = new newClientStuff();
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
	public newClientStuff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 874, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBackground(new Color(128, 128, 128));
		ButtonPanel.setBounds(0, 0, 291, 478);
		frame.getContentPane().add(ButtonPanel);
		ButtonPanel.setLayout(null);
		
		emailButton = new JButton("E-mail");
		emailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(emailPanel);
			}
		});
		emailButton.setBounds(55, 111, 196, 29);
		ButtonPanel.add(emailButton);
		
		ClientButton = new JButton("Update Client Info");
		ClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(updatePanel);
			}
		});
		ClientButton.setBounds(55, 158, 196, 29);
		ButtonPanel.add(ClientButton);
		
		AddJourneyButton = new JButton("Add Journey");
		AddJourneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(JourneyPanel);
			}
		});
		AddJourneyButton.setBounds(55, 209, 196, 29);
		ButtonPanel.add(AddJourneyButton);
		
		ArrivalButton = new JButton("Arrival Date");
		ArrivalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(ArrivalPanel);
			}
		});
		ArrivalButton.setBounds(55, 263, 196, 29);
		ButtonPanel.add(ArrivalButton);
		
		ReferencepersonButton = new JButton("Reference Person");
		ReferencepersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(referencePanel);
			}
		});
		ReferencepersonButton.setBounds(55, 68, 196, 29);
		ButtonPanel.add(ReferencepersonButton);
		
		ContainerButton = new JButton("Container Data");
		ContainerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(DataPanel);
			}
		});
		ContainerButton.setBounds(55, 324, 196, 29);
		ButtonPanel.add(ContainerButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(291, 0, 583, 478);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		layeredPane = new JLayeredPane();
		panel_1.add(layeredPane, "name_7520928918667");
		layeredPane.setLayout(new CardLayout(0, 0));
		
		referencePanel = new JPanel();
		referencePanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(referencePanel, "name_7537419347914");
		
		JTextArea txtrPanel = new JTextArea();
		txtrPanel.setText("panel 1");
		referencePanel.add(txtrPanel);
		
		emailPanel = new JPanel();
		emailPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(emailPanel, "name_7578041274086");
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("email");
		emailPanel.add(txtrEmail);
		
		updatePanel = new JPanel();
		layeredPane.add(updatePanel, "name_7873451118640");
		updatePanel.setBackground(new Color(95, 158, 160));
		
		JTextArea txtrUpdate = new JTextArea();
		txtrUpdate.setText("update");
		updatePanel.add(txtrUpdate);
		
		JourneyPanel = new JPanel();
		JourneyPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(JourneyPanel, "name_7881573753337");
		
		JTextArea txtrJourney = new JTextArea();
		txtrJourney.setText("journey");
		JourneyPanel.add(txtrJourney);
		
		ArrivalPanel = new JPanel();
		ArrivalPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(ArrivalPanel, "name_7922511904851");
		
		JTextArea txtrArrival = new JTextArea();
		txtrArrival.setText("arrival");
		ArrivalPanel.add(txtrArrival);
		
		DataPanel = new JPanel();
		DataPanel.setBackground(new Color(95, 158, 160));
		layeredPane.add(DataPanel, "name_7969757405032");
		
		JTextArea txtrData = new JTextArea();
		txtrData.setText("data");
		DataPanel.add(txtrData);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
}
