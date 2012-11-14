//Java_RPG
//Alpha 1.3.0
//Released 11/14/2012
//©2012 Ryan Cicchiello & Jason Holman
//See LICENCE for details


import java.io.IOException;
import java.util.Random;

public class Event {

	private Random e_calc;
	private int choice;
	private AttackEngine encounter;
	private int event; // Type of event
	private Character player;
	private Crafting craft;
	private Shop plrs;
	private String playerName;
	private Location location;
	private int x;
	private int y;
	private int item;
	private boolean leave;
	private boolean alive;

	public Event(String charName) throws NumberFormatException, IOException {
		item = 0;
		encounter = new AttackEngine(charName);
		player = new Character(charName);
		craft = new Crafting(charName);
		leave = false;
		alive = true;
		plrs = new Shop(charName);
		playerName = charName;
		x = player.getLocationX();
		y = player.getLocationY();
		location = new Location(player.getMapSize(), charName, x, y);
	}

	public void eventCalc() throws IOException {
		item = 0;
		player.update();
		e_calc = new Random();
		switch(location.getCell()){

		case 1:
			H.pln("You are stuck in quicksand!");
			H.pln("You lost 30 health!");
			player.setCHealth(player.getCHealth() - 30);
			player.saveAll();
			if(player.getCHealth() <= 0) 
				died();
			break;
		case 2:
			H.pln("You are in a Forest!");
			event = e_calc.nextInt(99)+1;
			if(event>0 && event<60){ //Finding an enemy (60% chance)
				if(!encounter.Battle()) 
					died();
				player.update();
			}
			if(event>=61 && event<=80) { //20% chance of nothing
				H.pln("Nothing here seems out of the ordinary.");
			}
			if(event >= 81 && event <= 90) { //10% chance of finding fallen tree
				H.pln("You see a fallen tree on the ground.");
				item = 1;
			}
			if(event>=91 && event<=95){ //5% chance of finding extra XP
				H.pln("You found a book");
				H.pln("It looks old and is hard to read.");
				H.pln("However after figuring out the symbols");
				H.pln("You have learned valuable skills");
				H.pln("You gained 500 XP!");
				player.addXP(500);
			}
			if(event>=96 && event<=100){
				H.pln("You found a map!");
				player.findMap();
				player.saveAll();
			}
			break;
		case 3:
			H.pln("You have found a pond.");
			H.pln("All seems quiet and peaceful.");
			H.pln("You have regained 30 Health!");
			player.setCHealth((player.getCHealth())+30);
			player.saveAll();
			break;
		case 4:
			H.pln("You are on a field");
			H.pln("There is a person on the Horizon.");
			H.pln("Would you like to : (1)Attack or (2)Ignore and Keep Moving?");
			choice =  H.inputInt();
			if(choice<= 1 || choice >2){
				if(!encounter.Battle()) 
					died();
				player.update();
			}
			else{
				H.pln("You and the person pass by without");
				H.pln("either of you intending to attack");
			}
			break;
		case 5:
			H.pln("You are on a beach.");
			H.pln("This is only found");
			H.pln("on the edges of the island.");
			break;

		case 6:
			H.pln("You are in a castle.");
			while(leave = false){
				H.pln("You can:");
				H.pln("(1) Fight Enemies, (2) Leave");
				if(H.inputInt()==1){
					if(!encounter.Battle())
						died();
					player.update();
				}
				else{
					H.pln("You have left the castle!");
					leave = true;
				}

			}
			leave = false;
			break;

		case 7:
			H.pln("You have entered a town");
			plrs.shop();
			break;
		case 8:
			H.pln("YOU HACKER!");
			H.pln("This type of land is not available yet!!!!");
			break;

		case 9:
			H.pln("You have found a mine!");
			event = e_calc.nextInt(99) + 1;
			if(event > 0 && event <= 15) {
				H.pln("You found gold!");
				item = 2;
			} else if(event > 15 && event <= 50) {
				H.pln("You found iron");
				item = 3;
			} else {
				H.pln("All you find is stone.");
				item = 4;
			}
			break;
			
		default:
			H.pln("Cell read error - Event.java eventCalc()");
			break;
		}

	}

	public void move(int direction) throws IOException {
		location.move(direction);
		x = location.getX();
		y = location.getY();
		player.setLocation(x, y);
	}

	public void showMap() {
		if(player.hasMap()) {
			location.showMap();
		} else {
			H.pln("You do not have a map");
		}
	}

	public void save() throws IOException {
		player.setLocation(x, y);
		player.saveAll();
	}
	public void died() throws IOException {
		H.pln("You Died! :(");
		location.died();
		x = location.getX();
		y = location.getY();
		player.setLocation(x, y);
		player.saveAll();
		player.setCHealth(player.getHealth());
		player.resetXP();
		player.resetInv();
		alive = false;
	}
	public boolean isAlive() {
		return alive;
	}
	public void revive() {
		alive = true;
	}
	public void showStats() throws NumberFormatException, IOException {
		H.pln("Current Health - "+player.getCHealth()+"/"+player.getHealth());
		H.pln("Current XP - "+player.getXp());
		H.pln("Current Level - "+player.getLevel());
	}
	public void take() throws IOException {
		switch(item) {
		case 0:
			H.pln("There is nothing for you to take");
			break;
		case 1:
			int woodAmount = e_calc.nextInt(9) + 1;
			if(player.getAxe()) {
			H.pln("You took "+woodAmount+" wood.");
			player.setWood(woodAmount);
			} else {
				H.pln("You only could take 1 wood because");
				H.pln("you don't have an axe");
				player.setWood(1);
			}
			break;
		case 2:
			int goldAmount = e_calc.nextInt(4) + 1;
			if(player.getPick()) {
				H.pln("You took "+goldAmount+" gold.");
				player.setGold(goldAmount);
			} else {
				H.pln("You do not have a pick axe");
			}
			break;
		case 3:
			int ironAmount = e_calc.nextInt(6) + 1;
			if(player.getPick()) {
				H.pln("You took "+ironAmount+" iron.");
				player.setIron(ironAmount);
			} else {
				H.pln("You do not have a pick axe");
			}
			break;
		case 4:
			int stoneAmount = e_calc.nextInt(6) + 1;
			if(player.getPick()) {
				H.pln("You took "+stoneAmount+" stone");
				player.setStone(stoneAmount);
			} else {
				H.pln("You only could take 1 stone because");
				H.pln("you don't have a pick axe");
				player.setStone(1);
			}
			break;
		default:
			H.pln("Error - Event.java take() method");
			H.pln("There is nothing for you to take");
			break;

		}
	}
	public void craft() throws NumberFormatException, IOException {
		craft.craft();
		player.update();
	}
	
	public void drink() throws IOException{
		if(player.getHPot()>=1){
			H.pln("Your heath has been restored");
			player.setHpot(-1);
			player.setCHealth(5000000);
		}
		else{
			H.pln("You have no Health Potions to Drink");
		}
	}
	public void showInv() {
		if(player.getWood() > 0)
			H.pln("wood - "+player.getWood());
		if(player.getStone() > 0)
			H.pln("stone - "+player.getStone());
		if(player.getIron() > 0)
			H.pln("iron - "+player.getIron());
		if(player.getGold() > 0)
			H.pln("gold - "+player.getGold());
		if(player.getAxe())
			H.pln("axe");
		if(player.getPick())
			H.pln("pickaxe");
		if(player.hasMap())
			H.pln("map");
		if(player.getWood() < 1 && player.getIron() < 1 && player.getGold() < 1 && player.getStone() < 1 && !player.getAxe() && !player.getPick() && !player.hasMap())
			H.pln("You do not have anything in your inventory");
	}
}

