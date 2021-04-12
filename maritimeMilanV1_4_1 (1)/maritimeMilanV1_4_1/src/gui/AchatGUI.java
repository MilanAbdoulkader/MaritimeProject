package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import config.GameConfiguration;
import engine.mobileElement.CombatShip;
import engine.process.ElementManager;
import engine.process.Player;

public class AchatGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private ElementManager manager;
	private Player player;
	
	JTextField boatName = new JTextField("");
	JButton acheter = new JButton("Acheter");

	
	public AchatGUI(String title, ElementManager manager, Player player) {
		super(title);
		this.manager = manager;
		this.player = player;
		PropertiesAchatGUI();
	}
	
	private void PropertiesAchatGUI() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2,1));

        acheter.addActionListener(this);


        contentPane.add(boatName);
        contentPane.add(acheter);
       
        setSize(150,150);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==acheter) {
			CombatShip testShip = new CombatShip(boatName.getText(), 200, 200, 200);
			manager.getFleets().get(GameConfiguration.FLEET_ONE).getCombatShips().put(testShip.getName(),testShip);
		}
	}
}
