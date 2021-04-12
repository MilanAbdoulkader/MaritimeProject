package gui;

import engine.process.ElementManager;
import engine.process.Player;
import engine.process.TransportManager;
import engine.staticElement.Seaway;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PortGUI extends JFrame implements ActionListener {
	
	HashMap<Integer,ArrayList<Seaway>> seaways;
	private ElementManager manager;
	private Player player;
	private int id;
	
	JButton buttonAttack = new JButton("Attaquer");
    JButton buttonCommerce = new JButton("Commercer");
    JButton buttonInfo = new JButton("Informations");
	
	
	public PortGUI(String title, ElementManager manager, int id) {
		super(title);
		this.manager = manager;
		this.id = id;
		PropertiesPortGUI();
	}
	
	public PortGUI(String title, ElementManager manager, Player player, int id) {
		super(title);
		this.manager = manager;
		this.player = player;
		this.id = id;
		PropertiesPortGUI();
	}
	
	private void PropertiesPortGUI() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3,1));
        
        buttonAttack.addActionListener(this);
        buttonCommerce.addActionListener(this);
        buttonInfo.addActionListener(this);
        
        contentPane.add(buttonAttack);
        contentPane.add(buttonCommerce);
        contentPane.add(buttonInfo);
        
       
        setSize(250,250);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonAttack){
			TransportManager transportmanager = new TransportManager("TRANSPORTATION",manager,id);
			Thread transportThread = new Thread(transportmanager);
			transportThread.start();
		}

		if(e.getSource()==buttonCommerce){
			CommerceGUI commerceGUI = new CommerceGUI("Commerce", manager, player, id);
		}

		if(e.getSource()==buttonInfo){

		}
	}
	
}
