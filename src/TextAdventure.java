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
		LocationDescription description = new LocationDescription();
		System.out.println("You find yourself on a deserted island. The last thing you remember is going to bed on in your cabin on your ship on route to Africa.");
		while (location.isAlive()) {
			System.out.println(description.getDescription(location.getX(), location.getY()));
			String input2 = input.next();
			if(input2.equals("North")) {
				location.move(1);

			} else if(input2.equals("South")) {
				location.move(3);

			} else if(input2.equals("East")) {
				location.move(2);

			} else if(input2.equals("West")) {
				location.move(4);

			} else  {
				System.out.println("Impropper Input");
			}
			System.out.println("The Current location is "+location.getX()+", "+location.getY());

		}
		if(!location.isAlive()) {
			System.out.println(description.getDescription(location.getX(), location.getY()));
			System.out.println("You died");
		}
	}
}
