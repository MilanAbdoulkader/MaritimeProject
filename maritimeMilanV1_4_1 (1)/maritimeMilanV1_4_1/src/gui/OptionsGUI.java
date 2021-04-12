package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import engine.process.ElementManager;
import engine.process.TransportManager;

public class OptionsGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ElementManager manager;
	
	JButton buttonStart = new JButton("Nouveau jeu");
    JButton buttonDisplaySettings  = new JButton("Réglages de l'affichage");
    JButton buttonSettings = new JButton("Paramètres");
    JButton buttonHelp = new JButton("Aide");
    JButton buttonCredits = new JButton("Les crédits");

    public OptionsGUI(String title) {
		super(title);
		PropertiesOptionsGUI();
	}

    private void PropertiesOptionsGUI() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(5,1));
        
        buttonStart.addActionListener(this);
        buttonDisplaySettings.addActionListener(this);
        buttonSettings.addActionListener(this);
        buttonHelp.addActionListener(this);
        buttonCredits.addActionListener(this);
        
        contentPane.add(buttonStart);
        contentPane.add(buttonDisplaySettings);
        contentPane.add(buttonSettings);
        contentPane.add(buttonHelp);
        contentPane.add(buttonCredits);
        
       
        setSize(250,250);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
		
	}

    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonStart){
			MainGUI gameMainGUI = new MainGUI("MARITIME");
	        Thread gameThread = new Thread(gameMainGUI);
	        gameThread.start();
		}

		if(e.getSource()==buttonDisplaySettings){

		}

		if(e.getSource()==buttonCredits){

		}
		
		if(e.getSource()==buttonHelp){

		}
		
		if(e.getSource()==buttonSettings){

		}
	}

}


