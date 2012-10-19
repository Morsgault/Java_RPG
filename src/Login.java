import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login{
	private int health; //The players health
	private int chealth; //The players current health
	private int mana; // The players mana
	private int cmana; //The players current mana
	private int level; // The players level
	private int xp; // The players expierience
	private int str; //The players Strength rating
	private int dex; //The players Dexterity rating
	private int intel; //The players intelligence rating
	private int clv; //The last time they visited the castle
	private int turns; //The amount of turns the player has had.
	/**
	 * Logins in a character
	 * @param charName The character name
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public Login(String charName) throws NumberFormatException, IOException{
		if (Exists(charName) == true){
			BufferedReader input = new BufferedReader(new FileReader(charName+".txt"));
			health = Integer.parseInt(input.readLine());
			chealth = Integer.parseInt(input.readLine());
			mana = Integer.parseInt(input.readLine());
			cmana = Integer.parseInt(input.readLine());
			level = Integer.parseInt(input.readLine());
			xp = Integer.parseInt(input.readLine());
			str = Integer.parseInt(input.readLine());
			dex = Integer.parseInt(input.readLine());
			intel = Integer.parseInt(input.readLine());
			clv = Integer.parseInt(input.readLine());
			turns = Integer.parseInt(input.readLine());
			
		}
	}
	/**
	 * Checks if the textfile exists so I can throw the io exception
	 * @param charName the name of the character to figure out if the file exists
	 * @return
	 */
	private boolean Exists(String charName){
		File f = new File(charName+".txt");
		return f.exists()==true ? true : false; 

	}

}

