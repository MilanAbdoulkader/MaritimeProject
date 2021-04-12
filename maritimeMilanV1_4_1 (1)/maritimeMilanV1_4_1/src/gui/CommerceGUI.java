package gui;

import engine.process.ElementManager;
import engine.process.Player;
import engine.process.TransportManager;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import config.GameConfiguration;

public class CommerceGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ElementManager manager;
	private Player player;
	
	private int id;
	
	JButton echangerCafe = new JButton("Echanger");
	JButton echangerSucre = new JButton("Echanger");
	JButton echangerSel = new JButton("Echanger");
	JButton echangerEpices = new JButton("Echanger");
	JButton echangerOr = new JButton("Echanger");
	JButton echangerCotton = new JButton("Echanger");
	JButton echangerSoie = new JButton("Echanger");
	JButton echangerPapier = new JButton("Echanger");
	JButton echangerTissu = new JButton("Echanger");
	JButton echangerTabac = new JButton("Echanger");
	JButton envoyer = new JButton("Envoyer");
	
	public CommerceGUI(String title, ElementManager manager, Player player, int id) {
		super(title);
		this.manager = manager;
		this.id = id;
		this.player = player;
		PropertiesCommerceGUI();
	}

	public CommerceGUI(String title) {
		super(title);
		PropertiesCommerceGUI();
	}
	
	public void PropertiesCommerceGUI() {
		Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(13,3));
        
        JLabel produitsAlim= new JLabel("Produits");
        JLabel cafe = new JLabel("Café");
        JLabel sucre = new JLabel("Sucre");
        JLabel sel = new JLabel("Sel");
        JLabel epices = new JLabel("Epices");
        JLabel prix = new JLabel("Prix");
        JLabel prixCafe = new JLabel("60");
        JLabel prixSucre = new JLabel("70");
        JLabel prixSel = new JLabel("50");
        JLabel prixEpices = new JLabel("100");
        JLabel echanges= new JLabel("Echanger");

        echangerCafe.addActionListener(this);
        echangerSucre.addActionListener(this);
        echangerSel.addActionListener(this);
        echangerEpices.addActionListener(this);
        echangerOr.addActionListener(this);
        echangerCotton.addActionListener(this);
        echangerSoie.addActionListener(this);
        echangerPapier.addActionListener(this);
        echangerTissu.addActionListener(this);
        echangerTabac.addActionListener(this);
        envoyer.addActionListener(this);
        
        contentPane.add(produitsAlim);
        contentPane.add(prix);
        contentPane.add(echanges);
        contentPane.add(cafe);
        contentPane.add(prixCafe);
        contentPane.add(echangerCafe);
        contentPane.add(sucre);
        contentPane.add(prixSucre);
        contentPane.add(echangerSucre);
        contentPane.add(sel);
        contentPane.add(prixSel);
        contentPane.add(echangerSel);
        contentPane.add(epices);
        contentPane.add(prixEpices);
        contentPane.add(echangerEpices);
        
		
		 JLabel or = new JLabel("Or");
	     JLabel cotton = new JLabel("Cotton");
	     JLabel soie = new JLabel("Soie");
	     JLabel prixOr = new JLabel("1000");
	     JLabel prixCotton = new JLabel("70");
	     JLabel prixSoie = new JLabel("200");
	     
	     contentPane.add(or);
	     contentPane.add(prixOr);
	     contentPane.add(echangerOr);
	     contentPane.add(cotton);
	     contentPane.add(prixCotton);
	     contentPane.add(echangerCotton);
	     contentPane.add(soie);
	     contentPane.add(prixSoie);
	     contentPane.add(echangerSoie);
		
	     JLabel papier = new JLabel("Papier");
	     JLabel tissu= new JLabel("Tissu");
	     JLabel tabac = new JLabel("Tabac");
	     JLabel prixPapier = new JLabel("10");
	     JLabel prixTissu = new JLabel("70");
	     JLabel prixTabac = new JLabel("200");
        
	     contentPane.add(papier);
	     contentPane.add(prixPapier);
	     contentPane.add(echangerPapier);
	     contentPane.add(tissu);
	     contentPane.add(prixTissu);
	     contentPane.add(echangerTissu);
	     contentPane.add(tabac);
	     contentPane.add(prixTabac);
	     contentPane.add(echangerTabac);
	     contentPane.add(envoyer);

		setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
        toFront();
        setDefaultCloseOperation (DISPOSE_ON_CLOSE);
        setVisible(true);
        
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(player.getResources().get(GameConfiguration.COFFEE));
		if(e.getSource()==echangerCafe){
			if(player.getGoldCounter() >= GameConfiguration.PRICE_COFFEE) {
				player.buy(player.resourcePrice(GameConfiguration.COFFEE)) ;
				System.out.println(player.getGoldCounter());
			}else {
				System.out.println("Déso pas assez d'argent");
			}
			System.out.println(player.getGoldCounter());
		}
		
		if(e.getSource() == echangerSel) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_SALT) {
				player.buy(player.resourcePrice(GameConfiguration.SALT)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		
		if(e.getSource() == echangerSucre) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_SUGAR) {
				player.buy(player.resourcePrice(GameConfiguration.SUGAR)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		
		if(e.getSource() == echangerEpices) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_SPICES) {
				player.buy(player.resourcePrice(GameConfiguration.SPICES)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		
		if(e.getSource() == echangerOr){
			if(player.getGoldCounter() >= GameConfiguration.PRICE_GOLD) {
				player.buy(player.resourcePrice(GameConfiguration.GOLD)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		if(e.getSource() == echangerCotton) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_COTTON) {
				player.buy(player.resourcePrice(GameConfiguration.COTTON)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		if(e.getSource() == echangerSoie) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_SILK) {
				player.buy(player.resourcePrice(GameConfiguration.SILK)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		
		if(e.getSource() == echangerPapier) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_PAPER) {
				player.buy(player.resourcePrice(GameConfiguration.PAPER)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		
		if(e.getSource() == echangerTissu) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_TISSUE) {
				player.buy(player.resourcePrice(GameConfiguration.TISSUE)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		
		if(e.getSource() == echangerTabac) {
			if(player.getGoldCounter() >= GameConfiguration.PRICE_TOBACCO) {
				player.buy(player.resourcePrice(GameConfiguration.TOBACCO)) ;
				System.out.println(player.getGoldCounter());
			}
		}
		
		if(e.getSource() == envoyer) {
			TransportManager transportmanager = new TransportManager("TRANSPORTATION",manager,id);
			Thread transportThread = new Thread(transportmanager);
			transportThread.start();
		}
		
	}

	
	public static void main(String[] args) {
		CommerceGUI fenport = new CommerceGUI("Commerce");
		fenport.setVisible(true);
	}

	
}

