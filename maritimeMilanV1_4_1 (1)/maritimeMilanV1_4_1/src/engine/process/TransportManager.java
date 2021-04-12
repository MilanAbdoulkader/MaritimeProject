package engine.process;

import config.GameConfiguration;

public class TransportManager extends Thread {

	private ElementManager manager;
	private int id;
	private int index = 0;
	private int cptsize = 0;


	/**
	 *
	 * TransportManager constructor
	 *
	 * @param title A title
	 * @param manager
	 * @param id a unique ID
	 */
	public TransportManager(String title, ElementManager manager, int id){
		super(title);
		this.id = id;
		this.manager = manager;
	}

	/**
	 * Creates a thread while the ship is moving.
	 *
	 * Speed will vary depending on the ship's speed
	 */
	public void run(){
		while (GameConfiguration.wayForward == true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED * 100 );
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				GameConfiguration.wayForward = false;

			}

			manager.followSeaway(id, index);
			index++;

		}

		while (GameConfiguration.wayBack) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED * 100 );
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("hello");
			index--;
			cptsize++;
			manager.followReturnSeaway(id, index,cptsize);
			System.out.println(cptsize);
		}
		GameConfiguration.wayForward = true;
		GameConfiguration.wayBack = true;
	}























}
	

