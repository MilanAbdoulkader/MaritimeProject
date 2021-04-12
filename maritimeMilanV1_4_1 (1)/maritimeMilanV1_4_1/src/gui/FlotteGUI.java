package gui;

import engine.process.ElementManager;
import engine.process.Player;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FlotteGUI extends JFrame {

	private ElementManager manager ;
	private Player player;
	private static final long serialVersionUID = 1L;
	
	
	public FlotteGUI(String title, ElementManager manager) {
		super(title);
		this.manager = manager;
		PropertiesPortGUI();
	}

    public FlotteGUI(String title, ElementManager manager, Player player) {
        super(title);
        this.manager = manager;
        this.player = player;
        PropertiesPortGUI();
    }
    public ElementManager getManager() {
        return manager;
    }

    public void setManager(ElementManager manager) {
        this.manager = manager;
    }

    private void PropertiesPortGUI() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4,2));
        
        JLabel nombreBateauxMarchant = new JLabel("Nombre de bateaux Marchands :");
        JLabel nombreBateauxCombat = new JLabel("Nombre de bateaux Combat :");
        JLabel pointsVie = new JLabel("Points de vie :");
        JLabel tempsTrajet = new JLabel("Temps de trajet :");

        JTextField nbBateauxMarchand= new JTextField();
        JTextField nbBateauxCombat = new JTextField();
        JTextField ptsVie= new JTextField();
        JTextField tpsTrajet= new JTextField();

        int valNbBateauxMarchand = manager.getFleets().get(1).getMerchantShips().size();
        int valNbBateauxCombat = manager.getFleets().get(1).getCombatShips().size();
        int valPtsVie ;
        int valtpsTrajet ;

        contentPane.add(nombreBateauxMarchant);
        contentPane.add(nbBateauxMarchand);
        contentPane.add(nombreBateauxCombat);
        contentPane.add(nbBateauxCombat);
        contentPane.add(pointsVie);
        contentPane.add(ptsVie);
        contentPane.add(tempsTrajet);
        contentPane.add(tpsTrajet);


        nbBateauxMarchand.setText(Integer.toString(valNbBateauxMarchand));
        nbBateauxCombat.setText(Integer.toString(valNbBateauxCombat));
        nbBateauxMarchand.setEditable(false);
        nbBateauxCombat.setEditable(false);
        ptsVie.setEditable(false);
        tpsTrajet.setEditable(false);
        
        setSize(400,130);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
		
	}
		
}
