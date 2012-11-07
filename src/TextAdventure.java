package txtrpg;
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
		System.out.println("You find yourself on a deserted island. The last thing you remember is going to bed on in your cabin on your ship on route to Africa.");
		while (true) {
			while (event.isAlive()) {
				event.eventCalc();
				// System.out.println("The Current location is "+location.getX()+", "+location.getY());
				boolean move = false;
				while(move == false) {
					String input2 = H.inputString();
					input2 = input2.toLowerCase();
					if(input2.equals("north")) {
						event.move(1);
						move = true;
					} else if(input2.equals("south")) {
						event.move(3);
						move = true;
					} else if(input2.equals("east")) {
						event.move(2);
						move = true;
					} else if(input2.equals("west")) {
						event.move(4);
						move = true;
					} else if(input2.equals("map")) {
						event.showMap();
						if(!event.isAlive()) move = true;

					} else if(input2.equals("save")) {
						event.save();
						if(!event.isAlive()) move = true;

					} else if(input2.equals("quit")) {
						event.save();
						H.pln("Goodbye");
						System.exit(0);

					} else if(input2.equals("help")){
						H.pln("Commands:");
						H.pln("help - shows help screen");
						H.pln("north - moves north");
						H.pln("south - moves south");
						H.pln("east - moves east");
						H.pln("west - moves west");
						H.pln("map - shows the map if the player has found one");
						H.pln("save - saves all player stats");
						H.pln("quit - saves and quits game");
						if(!event.isAlive()) move = true;

					} else if(input2.equals("revive")){
						event.revive();

					} else {
						System.out.println("Impropper Input");
					}
				}
				//System.out.println("The Current location is "+location.getX()+", "+location.getY());

			}
			while(!event.isAlive()) {
				H.pln("You are dead");
				H.pln("Type \"revive\" to revive");
				if(H.inputString().toLowerCase().equals("revive")) {
					event.revive();
				} else H.pln("Impropper input");
			}
		}
		//		if(location.isAlive() == false) {
		//			System.out.println("You died");
		//		}
	}
}


