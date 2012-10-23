import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Login{
	private String pName; //The players name
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
		pName = charName;
		if (Exists(charName) == true){
			System.out.println("File Found");
			System.out.println("Loading form File");
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
			input.close();
		}
		else{
			System.out.println("No File Found");
			System.out.println("Creating File");
			File newChar = new File(charName+".txt");
			newChar.createNewFile();
			
			BufferedWriter news = new BufferedWriter(new FileWriter(newChar));
			
			//Initializing the Stats variables
			health = 100;
			chealth = 100;
			mana = 100;
			cmana = 100;
			level = 1;
			xp = 0;
			str = 5;
			dex = 5;
			intel = 5;
			clv = 0;
			turns = 0;
			
			//Printing Stats to Text File
			news.write(Integer.toString(health));
			news.newLine();
			news.write(Integer.toString(chealth));
			news.newLine();
			news.write(Integer.toString(mana));
			news.newLine();
			news.write(Integer.toString(cmana));
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
			news.close();
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

	/**
	 * Saves the current stats
	 * @throws IOException 
	 */
	public void saveStats() throws IOException{
		File oldSave = new File(pName+".txt");
		oldSave.delete();
		File newSave = new File(pName+".txt");
		newSave.createNewFile();
		
		BufferedWriter save = new BufferedWriter(new FileWriter(newSave));
		
		save.write(health);
		save.write(chealth);
		save.write(mana);
		save.write(cmana);
		save.write(level);
		save.write(xp);
		save.write(str);
		save.write(dex);
		save.write(intel);
		save.write(clv);
		save.write(turns);
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
		return chealth;
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
		return cmana;
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
	 * Retirieves the last time the player visited the castle
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
}

