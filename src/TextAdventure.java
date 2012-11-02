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
		Event event = new Event(); 
		System.out.println("You find yourself on a deserted island. The last thing you remember is going to bed on in your cabin on your ship on route to Africa.");
		while (location.isAlive()) {
			event.getDescription(location.getX(), location.getY());
			System.out.println("The Current location is "+location.getX()+", "+location.getY());
			String input2 = H.inputString();
			H.pln(input2);
			input2 = input2.toLowerCase();
			H.pln(input2);
			if(input2.equals("north")) {
				location.move(1);
				H.pln("1");

			} else if(input2.equals("south")) {
				location.move(3);

			} else if(input2.equals("east")) {
				location.move(2);

			} else if(input2.equals("west")) {
				location.move(4);

			} else  {
				System.out.println("Impropper Input");
			}
			System.out.println("The Current location is "+location.getX()+", "+location.getY());

		}
		if(location.isAlive() == false) {
			event.getDescription(location.getX(), location.getY());
			System.out.println("You died");
		}
	}
}
