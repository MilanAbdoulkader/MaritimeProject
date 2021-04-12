package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CombatGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(800, 400);
    private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(800, 300);

    private JLabel allyFleetLabel = new JLabel("TEMPORAIRE");
    private JLabel ennemiFleetLabel = new JLabel("TEMPORAIRE");



    private JLabel allyFleetLifeValue = new JLabel("");
    private JLabel ennemiFleetLifeValue = new JLabel("");

    private JPanel control = new JPanel();

    private String name;
    private boolean escaped = false;
    private boolean destroyed = false;


    public CombatGUI(String title){
        super(title);
        initCombatGui();
    }

    private void initCombatGui(){
    	Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		pack();
        setResizable(true);
        setLocationRelativeTo(null);
        setSize(500,500);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible(true);
		
        JDesktopPane desktopPane = new JDesktopPane();
	    desktopPane.setLayout(new BorderLayout());
		
	    JInternalFrame internalFrame2 = new JInternalFrame("");
	    
	    internalFrame2.setVisible(true);
        internalFrame2.setClosable(false);
        internalFrame2.setLayout(new GridLayout(1,2));
	    
        internalFrame2.setPreferredSize(new Dimension(800, 70));
        desktopPane.add(internalFrame2, BorderLayout.PAGE_START);
		
      //Composant de la fenetre interne points de vie
        JLabel allyFleetLifeLabel = new JLabel("HP : ");
        JLabel ennemiFleetLifeLabel = new JLabel("HP : ");
        
	    internalFrame2.add(allyFleetLifeLabel);
        internalFrame2.add(ennemiFleetLifeLabel);
        
		contentPane.add(BorderLayout.NORTH, internalFrame2);
        
	    
	    JInternalFrame internalFrame = new JInternalFrame();
	    
	    
	    internalFrame.setVisible(true);
	    internalFrame.setClosable(false);
        internalFrame.setLayout(new GridLayout(1,3));
        
        internalFrame.setPreferredSize(new Dimension(800, 70));
        desktopPane.add(internalFrame, BorderLayout.SOUTH);
        
        JButton attackButton = new JButton("TIRER");
        JButton specialAttackButton = new JButton("GRAPIN");
        JButton escapeButton = new JButton("FUITE");
        
        attackButton.addActionListener(this);
        specialAttackButton.addActionListener(this);
        escapeButton.addActionListener(this);
        
        internalFrame.add(attackButton);
        internalFrame.add(specialAttackButton);
        internalFrame.add(escapeButton);
		contentPane.add(BorderLayout.SOUTH, internalFrame);
        
		 JInternalFrame main = new JInternalFrame();
		 main.setVisible(true);
		 desktopPane.add(main, BorderLayout.CENTER);
			
		contentPane.add(BorderLayout.CENTER, main);
	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public static void main(String[] args) {
		new CombatGUI("Chronometer");
	}
}
