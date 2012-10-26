import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Login{
	private String pName; //The players name
	private int health; //The players health
	private int cHealth; //The players current health
	private int mana; // The players mana
	private int cMana; //The players current mana
	private int level; // The players level
	private int xp; // The players expierience
	private int str; //The players Strength rating
	private int dex; //The players Dexterity rating
	private int intel; //The players intelligence rating
	private int clv; //The last time they visited the castle
	private int turns; //The amount of turns the player has had.
	private int mapSize; //The size of the map.
	private int locationX; //The x location of the player
	private int locationY; //The y location of the player
	private int weapon; //The weapon the player has
	/**
	 * Logins in a character
	 * @param charName The character name
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public Login(String charName) throws NumberFormatException, IOException{
		pName = charName;
		if (Exists(charName) == true){
			System.out.println("File Found");
			System.out.println("Loading form File");
			BufferedReader input = new BufferedReader(new FileReader(charName+".txt"));
			health = Integer.parseInt(input.readLine());
			cHealth = Integer.parseInt(input.readLine());
			mana = Integer.parseInt(input.readLine());
			cMana = Integer.parseInt(input.readLine());
			level = Integer.parseInt(input.readLine());
			xp = Integer.parseInt(input.readLine());
			str = Integer.parseInt(input.readLine());
			dex = Integer.parseInt(input.readLine());
			intel = Integer.parseInt(input.readLine());
			clv = Integer.parseInt(input.readLine());
			turns = Integer.parseInt(input.readLine());
			mapSize = Integer.parseInt(input.readLine());
			locationX = Integer.parseInt(input.readLine());
			locationY = Integer.parseInt(input.readLine());
			weapon = Integer.parseInt(input.readLine());
			input.close();
		}
		else {
			System.out.println("How Large would you like the map?");
			System.out.println("The input, x, will create a map with the size (x,x).");
			Scanner scanner = new Scanner(System.in);
			mapSize = scanner.nextInt();
			System.out.println("No File Found");
			System.out.println("Creating File");
			File newChar = new File(charName+".txt");
			newChar.createNewFile();
			
			BufferedWriter news = new BufferedWriter(new FileWriter(newChar));
			
			//Initializing the Stats variables
			health = 100;
			cHealth = 100;
			mana = 100;
			cMana = 100;
			level = 1;
			xp = 0;
			str = 5;
			dex = 5;
			intel = 5;
			clv = 0;
			turns = 0;
			locationX = mapSize/2;
			locationY = 0;
			weapon = 0;
			
			//Printing Stats to Text File
			news.write(Integer.toString(health));
			news.newLine();
			news.write(Integer.toString(cHealth));
			news.newLine();
			news.write(Integer.toString(mana));
			news.newLine();
			news.write(Integer.toString(cMana));
			news.newLine();
			news.write(Integer.toString(level));
			news.newLine();
			news.write(Integer.toString(xp));
			news.newLine();
			news.write(Integer.toString(str));
			news.newLine();
			news.write(Integer.toString(dex));
			news.newLine();
			news.write(Integer.toString(intel));
			news.newLine();
			news.write(Integer.toString(clv));
			news.newLine();
			news.write(Integer.toString(turns));
			news.newLine();
			news.write(Integer.toString(mapSize));
			news.newLine();
			news.write(Integer.toString(locationX));
			news.newLine();
			news.write(Integer.toString(locationY));
			news.newLine();
			news.write(Integer.toString(weapon));
			news.close();
		}
	}
	/**
	 * Checks if the textfile exists so I can throw the io exception
	 * @param charName the name of the character to figure out if the file exists
	 * @return
	 */
	public boolean Exists(String charName){
		File f = new File(charName+".txt");
		return f.exists()==true ? true : false; 

	}

	/**
	 * Saves the current stats
	 * @throws IOException 
	 */
	public void saveStats(int health1, int cHealth1, int mana1, int cMana1, int level1, int xp1, int str1, int dex1, int intel1, int clv1, int turns1, int x, int y, int weapon1) throws IOException{
		health = health1;
		cHealth = cHealth1;
		mana = mana1;
		cMana = cMana1;
		level = level1;
		xp = xp1;
		str = str1;
		dex = dex1;
		intel = intel1;
		clv = clv1;
		turns = turns1;
		locationX = x;
		locationY = y;
		weapon = weapon1;
		
		File oldSave = new File(pName+".txt");
		oldSave.delete();
		File newSave = new File(pName+".txt");
		newSave.createNewFile();
		
		BufferedWriter save = new BufferedWriter(new FileWriter(newSave));
		
		save.write(Integer.toString(health));
		save.newLine();
		save.write(Integer.toString(cHealth));
		save.newLine();
		save.write(Integer.toString(mana));
		save.newLine();
		save.write(Integer.toString(cMana));
		save.newLine();
		save.write(Integer.toString(level));
		save.newLine();
		save.write(Integer.toString(xp));
		save.newLine();
		save.write(Integer.toString(str));
		save.newLine();
		save.write(Integer.toString(dex));
		save.newLine();
		save.write(Integer.toString(intel));
		save.newLine();
		save.write(Integer.toString(clv));
		save.newLine();
		save.write(Integer.toString(turns));
		save.newLine();
		save.write(Integer.toString(mapSize));
		save.newLine();
		save.write(Integer.toString(locationX));
		save.newLine();
		save.write(Integer.toString(locationY));
		save.newLine();
		save.write(Integer.toString(weapon));
		save.close();
	}
	/**
	 * Returns Health
	 * @return Health - Maximum Health
	 */
	public int getHealth(){
		return health;
	}
	
	/**
	 * Returns Current Health
	 * @return Current Health - Current Health of Player
	 */
	public int getCHealth(){
		return cHealth;
	}
	
	/**
	 * Retrieves Mana Value
	 * @return Mana- The Maximum amount of mana
	 */
	public int getMana(){
		return mana;
	}
	
	/**
	 * Retrieves Current Mana Value
	 * @return Current Mana - The Players Current Amount Of Mana
	 */
	public int getCMana(){
		return cMana;
	}
	
	/**
	 * Retrieves the Players Level
	 * @return Level- The Current Players Level
	 */
	public int getLevel(){
		return level;
	}
	
	/**
	 * Retrieves Experience Points
	 * @return Experience - How close you are to the next level
	 */
	public int getXp(){
		return xp;
	}
	
	/**
	 * Retrieves Strength Rating
	 * @return Strength - The Strength Level
	 */
	public int getStr(){
		return str;
	}
	
	/**
	 * Retrieves Dexterity Rating
	 * @return Dexterity - Retrieves Dexterity Rating
	 */
	public int getDex(){
		return dex;
	}
	
	/**
	 * Retrieves Intelligence
	 * @return Intel - The Intelligence rating
	 */
	public int getIntel(){
		return intel;
	}
	
	/**
	 * Retrieves the last time the player visited the castle
	 * @return Castle Last Visited- The last turn a player was at the castle
	 */
	public int getCLV(){
		return clv;
	}
	
	/**
	 * Retrieves the amount of turns a player has went through
	 * @return Turns - The amount of turns
	 */
	public int getTurns(){
		return turns;
	}
	
	/**
	 * Retrieves the size of the map
	 * @return mapSize - the size of the map
	 */
	public int getMapSize(){
		return mapSize;
	}
	
	/**
	 * Retrieves the X start location
	 * @return locationX - the X location
	 */
	public int getLocationX() {
		return locationX;
	}
	
	/**
	 * Retrieves the Y start location
	 * @return locationY - the Y location
	 */
	public int getLocationY() {
		return locationY;
	}
	
	/**
	 * Retrieves the weapon the player has
	 * @return weapon - the weapon the player has
	 */
	public int getWeapon() {
		return weapon;
	}
}

