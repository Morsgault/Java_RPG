import java.io.IOException;
import java.util.Scanner;

public class TextAdventure {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner input = new Scanner(System.in);
		System.out.println("Please input you character's name.");
		System.out.println("Note all of your data is saved using your character's name.");
		String charName = input.next();
		Character character = new Character(charName);
		int mapSize = character.getMapSize();
		Location location = new Location(mapSize, charName, character.getLocationX(), character.getLocationY());
		Event event = new Event(charName); 
		System.out.println("You find yourself on a deserted island. The last thing you remember is going to bed on in your cabin on your ship on route to Africa.");
		while (location.isAlive()) {
			event.eventCalc(location.getWorld());
			// System.out.println("The Current location is "+location.getX()+", "+location.getY());
			boolean move = false;
			while(move == false) {
				String input2 = H.inputString();
				input2 = input2.toLowerCase();
				if(input2.equals("north")) {
					location.move(1);
					move = true;
				} else if(input2.equals("south")) {
					location.move(3);
					move = true;
				} else if(input2.equals("east")) {
					location.move(2);
					move = true;
				} else if(input2.equals("west")) {
					location.move(4);
					move = true;
				} else if(input2.equals("map")) {
					location.showMap();

				} else if(input2.equals("save")) {
					event.save();

				} else {
					System.out.println("Impropper Input");
				}
			}
			//System.out.println("The Current location is "+location.getX()+", "+location.getY());

		}
		if(location.isAlive() == false) {
			System.out.println("You died");
		}
	}
}
