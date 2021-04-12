package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import engine.process.ElementManager;

public class PauseGUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private ElementManager manager;
	
	JButton buttonContinue = new JButton("Continuer");
    JButton buttonSave  = new JButton("Sauvegarder");
    JButton buttonQuit = new JButton("Quitter");
    JButton buttonVolume = new JButton("Volume");

    
    public PauseGUI(String title) {
		super(title);
		PropertiesPauseGUI();
	}

    private void PropertiesPauseGUI() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4,1));
        
        buttonContinue.addActionListener(this);
        buttonSave.addActionListener(this);
        buttonQuit.addActionListener(this);
        buttonVolume.addActionListener(this);


        
        contentPane.add(buttonContinue);
        contentPane.add(buttonSave);
        contentPane.add(buttonQuit);
        contentPane.add(buttonVolume);

        
       
        setSize(250,250);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
		
	}

    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonContinue){
			
		}

		if(e.getSource()==buttonSave){

		}

		if(e.getSource()==buttonQuit){

		}
		
		if(e.getSource()==buttonVolume){

		}
		
	}
}
