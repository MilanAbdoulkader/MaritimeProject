package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.ElementManager;
import engine.process.Gamebuilder;
import engine.process.Player;


public class MainGUI extends JFrame implements Runnable {
    /**
     * This class is the main frame in which the game and player statistics are displayed.
     *
     */

    private static final long serialVersionUID = 1L;

    private Map map = Gamebuilder.buildMap();

    private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

    private ElementManager manager = Gamebuilder.buildElements(map);
    private Player player = Gamebuilder.buildResources();
    private GameDisplay dashboard = new GameDisplay(map, manager);

    
    JTextField nbShip = new JTextField ("");
    JTextField coins = new JTextField ("");
    JTextField bnHar = new JTextField ("");
    


    public MainGUI(String title){
        super(title);
        PropertiesGUI();
    }

    public void PropertiesGUI() {
    	updateValues();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        pack();
        setResizable(true);
        setLocationRelativeTo(null);
        //setPreferredSize(preferredSize);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        setVisible(true);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setLayout(new BorderLayout());

        //FENETRE INTERNE StatsGUI
        JInternalFrame internalFrame = new JInternalFrame("Stats");

        internalFrame.setSize(170,200);
        internalFrame.setVisible(true);
        internalFrame.setClosable(false);
        internalFrame.setLayout(new GridLayout(12, 1));

        desktopPane.add(internalFrame, BorderLayout.LINE_END);
        contentPane.add(desktopPane);


        //StatsGUI frame components
        JLabel label1 = new JLabel("Contenant:");
        JLabel label2 = new JLabel("Valeur :");
        JLabel label3 = new JLabel("Santé :");
        JLabel label4 = new JLabel("Bateaux de combat :");
        JLabel label5 = new JLabel("Bateaux marchands :");
        JLabel label6 = new JLabel("Temps de trajet restant:");
        JTextField content = new JTextField ();
        JTextField value = new JTextField ();
        JTextField life = new JTextField ();
        JTextField cships = new JTextField ();
        JTextField mships = new JTextField ();
        JTextField time = new JTextField ();

        content.setEditable(false);
        value.setEditable(false);
        life.setEditable(false);
        cships.setEditable(false);
        mships.setEditable(false);
        time.setEditable(false);

        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.CENTER);

        internalFrame.add(label1);
        internalFrame.add(content);
        internalFrame.add(label2);
        internalFrame.add(value);
        internalFrame.add(label3);
        internalFrame.add(life);
        internalFrame.add(label4);
        internalFrame.add(cships);
        internalFrame.add(label5);
        internalFrame.add(mships);
        internalFrame.add(label6);
        internalFrame.add(time);



        //FENETRE INTERNE Flotte or Ports
        JInternalFrame internalFrame2 = new JInternalFrame("");

        //internalFrame2.setSize(800,70);
        internalFrame2.setVisible(true);
        internalFrame2.setClosable(false);
        internalFrame2.setLayout(new GridLayout(1,6));

        internalFrame2.setPreferredSize(new Dimension(800, 70));
        desktopPane.add(internalFrame2, BorderLayout.PAGE_START);


        //Composant de la fenetre interne flotte or ports
        JLabel flotte = new JLabel("Flotte :");
        JLabel or = new JLabel("Or :");
        JLabel ports = new JLabel("Ports:");


        nbShip.setEditable(false);
        coins.setEditable(false);
        bnHar.setEditable(false);

        
        flotte.setHorizontalAlignment(JLabel.CENTER);
        or.setHorizontalAlignment(JLabel.CENTER);
        ports.setHorizontalAlignment(JLabel.CENTER);

        internalFrame2.add(flotte);
        internalFrame2.add(nbShip);
        internalFrame2.add(or);
        internalFrame2.add(coins);
        internalFrame2.add(ports);
        internalFrame2.add(bnHar);
        
        repaint();


        //FENETRE INTERNE JEU
        JInternalFrame main = new JInternalFrame();

        main.setVisible(true);
        main.add(dashboard, BorderLayout.CENTER);

        desktopPane.add(main, BorderLayout.CENTER);

        MouseControls mouseControls = new MouseControls();
        dashboard.addMouseListener(mouseControls);

        //Composant Text
        JInternalFrame text = new JInternalFrame ();
        text.setVisible(true);

        KeyControls keyControls = new KeyControls();
        JTextField textfield = new JTextField();
        textfield.setFocusTraversalKeysEnabled(false);
        textfield.addKeyListener(keyControls);


        text.add(textfield);
        desktopPane.add(text, BorderLayout.SOUTH);
        dashboard.setPreferredSize(preferredSize);

    }
    
    public void updateValues() {
    	int valNbFlotte = manager.getFleets().size();
    	nbShip.setText(Integer.toString(valNbFlotte));
        
    	int valNbPorts = manager.getHarbors().get(1).size();
    	bnHar.setText(Integer.toString(valNbPorts));
    	   	 
        int valNbOr = player.getGoldCounter();
        coins.setText(Integer.toString(valNbOr));
        
    }
    
    public void run(){
        while (true) {
            try {
                Thread.sleep(GameConfiguration.GAME_SPEED);                
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            dashboard.repaint();
            updateValues();

        }
    }


    private class KeyControls implements KeyListener {

        public void keyPressed(KeyEvent event) {
            char keyChar = event.getKeyChar();
            switch (keyChar) {

                case 'z':
                    manager.moveUpShip();

                    break;
                case 'q':
                    manager.moveLeftShip();
                    break;
                case 's':
                    manager.moveDownShip();

                    break;
                case 'd' :
                    manager.moveRightShip();

                    break;

                case '	':
                    GameConfiguration.STATE = !GameConfiguration.STATE;
                    System.out.println(GameConfiguration.STATE);
                    break;

                default:
                    break;
            }

        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

    }

    private class MouseControls implements MouseListener {
    	
    public void mouseClicked(MouseEvent e) {
   	 int x = e.getX();
   	 int y = e.getY();

   	 Block position = dashboard.getPosition(x,y);

   	 if(manager.isHarbor(position.getColumn(), position.getRow())) {
   	     System.out.println(manager.harborId(position.getRow(),position.getColumn()));

         if (!manager.isHarborAlly(position.getColumn(), position.getRow())) {
             PortGUI port = new PortGUI(manager.harborName(position.getColumn(), position.getRow()), manager , player, manager.harborId(position.getColumn(), position.getRow()));
             port.setVisible(true);
         }
         else {
             PortAllieGUI allyHarbor = new PortAllieGUI(manager.harborName(position.getColumn(), position.getRow()), manager, player);
         }
     }

   	 if(manager.isFleet(position.getColumn(), position.getRow())){
                FlotteGUI flotte = new FlotteGUI("Fleet", manager, player);
                flotte.setVisible(true);
            }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }


    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

   }


}