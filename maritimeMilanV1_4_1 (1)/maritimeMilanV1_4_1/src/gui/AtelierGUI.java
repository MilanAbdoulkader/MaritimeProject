package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import engine.process.ElementManager;
import engine.process.Player;

public class AtelierGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ElementManager manager;
	private Player player;

	JButton amelioration = new JButton("Amelioration");
    JButton achat = new JButton("Achat");
	
	public AtelierGUI(String title, ElementManager manager, Player player) {
		super(title);
		this.manager = manager;
		this.player = player ;
		PropertiesAtelierGUI();
	}
	
	private void PropertiesAtelierGUI() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1,2));

        amelioration.addActionListener(this);
        achat.addActionListener(this);

        contentPane.add(amelioration);
        contentPane.add(achat);
      
        setSize(250,150);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==amelioration){
			
		}		
		if(e.getSource()==achat){
			AchatGUI achatGUI = new AchatGUI("Achat", manager, player);
			achatGUI.setVisible(true);
		}
	}
	
}
