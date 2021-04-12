package gui;

import engine.process.ElementManager;
import engine.process.Player;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PortAllieGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton defense = new JButton("Defense");
    JButton atelier = new JButton("Atelier");

    private ElementManager manager;
    private Player player;
	
	public PortAllieGUI(String title, ElementManager manager, Player player) {
		super(title);
		this.manager = manager;
		this.player = player ;
		PropertiesPortAllie();
	}


	private void PropertiesPortAllie() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2,1));

        defense.addActionListener(this);
        atelier.addActionListener(this);

        contentPane.add(defense);
        contentPane.add(atelier);

        
       
        setSize(200,200);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==defense){
			//DEVRA RETIRER DES BATEAUX DE LA LISTE DES BATEAUX POSSEDES POUR LES AJOUTER A LA
			//ET LES AJOUTES A LA FLOTTE DU FORT
		}
		if(e.getSource()==atelier) {
			AtelierGUI atelier = new AtelierGUI("Atelier",manager, player);
			atelier.setVisible(true);
		}
		
	}

	
}
