//Java_RPG
//Alpha PreRelease 1.3.0
//Released 11/14/2012
//©2012 Ryan Cicchiello & Jason Holman
//See LICENCE for details


import java.io.IOException;

public class TextAdventure {

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Please input you character's name.");
		System.out.println("Note all of your data is saved using your character's name.");
		String charName = H.inputString();
		//	Character character = new Character(charName);
		//	int mapSize = character.getMapSize();
		//	Location location = new Location(mapSize, charName, character.getLocationX(), character.getLocationY());
		Event event = new Event(charName); 
		H.pln("You find yourself on a deserted island. The last thing you remember is going to bed on in your cabin on your ship on route to Africa.");
		H.pln("You have a dog named Tido following you for no apparent reason!");
		while (true) {
			while (event.isAlive()) {
				event.eventCalc();
				// System.out.println("The Current location is "+location.getX()+", "+location.getY());
				boolean move = false;
				while(move == false) {
					String input2 = H.inputString();
					input2 = input2.toLowerCase();
					if(input2.equals("north") || input2.equals("n")) {
						if(event.isAlive()) {
							event.move(1);
						} else {
							H.pln("You are dead. Type respawn to revive");
						}
						move = true;
					} else if(input2.equals("south") || input2.equals("s")) {
						if(event.isAlive()) {
							event.move(3);
						} else {
							H.pln("You are dead. Type respawn to revive");
						}
						move = true;
					} else if(input2.equals("east") || input2.equals("e")) {
						if(event.isAlive()) {
							event.move(2);
						} else {
							H.pln("You are dead. Type respawn to revive");
						}
						move = true;
					} else if(input2.equals("west") || input2.equals("w")) {
						if(event.isAlive()) {
							event.move(4);
						} else {
							H.pln("You are dead. Type respawn to revive");
						}
						move = true;
					} else if(input2.equals("map") || input2.equals("m")) {
						if(event.isAlive()) {
							event.showMap();
							
						} else {
							H.pln("You are dead. Type respawn to revive");
							move = true;
						}
					} else if(input2.equals("save")) {
						event.save();
						if(!event.isAlive()) {
							move = true;
							H.pln("You are dead. Type respawn to revive");
						}
					} else if(input2.equals("quit") || input2.equals("q")) {
						event.save();
						H.pln("Goodbye");
						System.exit(0);

					} else if(input2.equals("help") || input2.equals("h")){
						H.pln("Commands:");
						H.pln("help - shows help screen");
						H.pln("north - moves north");
						H.pln("south - moves south");
						H.pln("east - moves east");
						H.pln("west - moves west");
						H.pln("take - take any items that are at your current location");
						H.pln("stats - show your stats");
						H.pln("craft - show crafting menu");
						H.pln("inv - shows inventory");
						H.pln("map - shows the map if the player has found one");
						H.pln("save - saves all player stats");
						H.pln("quit - saves and quits game");
						if(!event.isAlive()) 
							move = true;

					} else if(input2.equals("respawn")) {
						event.revive();
						H.pln("You respawned");
					} else if(input2.equals("stats")) {
						event.showStats();
						if(!event.isAlive()) 
							move = true;
					} else if(input2.equals("take")) {
						if(event.isAlive()) {
							event.take();
						} else {
							H.pln("You are dead. Type respawn to revive");
							move = true;
						}
					} else if(input2.equals("craft") || input2.equals("c")){
						if(event.isAlive()) {
							event.craft();
						} else {
							H.pln("You are dead. Type respawn to revive");
							move = true;
						}
					} else if(input2.equals("inv") || input2.equals("i")) {
						if(event.isAlive()) {
							event.showInv();
						} else {
							H.pln("You are dead. Type respawn to revive");
							move = true;
						}
						
					} else if(input2.equals("drink")) {
						event.drink();
					} else {
						System.out.println("Improper Input");
					}
				}
				//System.out.println("The Current location is "+location.getX()+", "+location.getY());

			}
			while(!event.isAlive()) {
				H.pln("You are dead");
				H.pln("Type \"respawn\" to respawn");
				if(H.inputString().toLowerCase().equals("respawn")) {
					event.revive();
					H.pln("You respawned");
				} else H.pln("Impropper input");
			}
		}
		//		if(location.isAlive() == false) {
		//			System.out.println("You died");
		//		}
	}
}


