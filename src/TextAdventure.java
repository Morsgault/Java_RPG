import java.util.Scanner;

public class TextAdventure {
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("How Large would you like the map?");
		System.out.println("The input, x, will create a map with the size (x,x).");
		int mapSize = input.nextInt();
		Location location = new Location(mapSize);
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
		if(location.isAlive() == false) {
			System.out.println(description.getDescription(location.getX(), location.getY()));
			System.out.println("You died");
		}
	}
}
