		ContainerFrame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 101, 538, 300);
		ContainerFrame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		PositionPanel = new JPanel();
		PositionPanel.setBackground(new Color(95, 158, 160));
		PositionPanel.setBounds(6, -16, 526, 310);
		layeredPane.add(PositionPanel);
		PositionPanel.setLayout(null);
		
		JTextArea txtrPosition = new JTextArea();
		txtrPosition.setText("position");
		txtrPosition.setBounds(253, 140, 66, 16);
		PositionPanel.add(txtrPosition);
		
		StatusPanel = new JPanel();
		StatusPanel.setBackground(new Color(95, 158, 160));
		layeredPane.setLayer(StatusPanel, 1);
		StatusPanel.setBounds(6, 0, 526, 294);
		layeredPane.add(StatusPanel);
		StatusPanel.setLayout(null);
		
		JTextArea txtrStatus = new JTextArea();
		txtrStatus.setText("status");
		txtrStatus.setBounds(150, 120, 136, 16);
		StatusPanel.add(txtrStatus);
		
		PositionRdb = new JRadioButton("Position");
		PositionRdb.setSelected(true);
		PositionRdb.setBounds(6, 43, 141, 23);
		ContainerFrame.getContentPane().add(PositionRdb);
		
		StatusRdb = new JRadioButton("Status");
		StatusRdb.setBounds(403, 43, 141, 23);
		ContainerFrame.getContentPane().add(StatusRdb);
		ContainerFrame.setBounds(100, 100, 550, 429);
		ContainerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(PositionPanel);
		
		
	}
}
