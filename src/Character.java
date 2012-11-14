//Java_RPG
//Alpha 1.3.0
//Released 11/14/2012
//©2012 Ryan Cicchiello & Jason Holman
//See LICENCE for details

import java.io.IOException;


public class Character {

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
	private int wood; //The amount of wood the player has
	private int gold; //The amount of gold the player has
	private int hpot; // The amount of helath potions a player has
	private int iron; //The amount of iron the player has
	private int stone; //The amount of stone the player has
	private boolean axe; //if the player has an axe
	private boolean pick; //if the player has a pick axe

	private final int LVL_XP[] = {100,500,1200,2500,5000,9000,15000,20000,25000}; //xp needed to get to the next level
	private String charName;
	private boolean hasMap;
	Login login;

	public Character(String name) throws NumberFormatException, IOException {
		charName = name;
		login = new Login(charName);
		getStats();
	}

	public void findWeapon(int weaponType) {
		weapon = Math.max(weaponType, weapon);
	}

	public void saveAll() throws IOException {
		login.saveStats(health, cHealth, mana, cMana, level, xp, str, dex, intel, clv, turns, locationX, locationY, weapon, hasMap, axe, pick, wood, gold, iron, stone, hpot);
	}
	
	/**
	 * Refreshes the stats from the file
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void getStats() throws NumberFormatException, IOException {
		login.update();
		health = login.getHealth();
		cHealth = login.getCHealth();
		mana = login.getMana();
		cMana = login.getCMana();
		level = login.getLevel();
		xp = login.getXp();
		str = login.getStr();
		dex = login.getDex();
		intel = login.getIntel();
		clv = login.getCLV();
		turns = login.getTurns();
		mapSize = login.getMapSize();
		locationX = login.getLocationX();
		locationY = login.getLocationY();
		weapon = login.getWeapon();
		hasMap = login.getMap();
		axe = login.getAxe();
		pick = login.getPick();
		wood = login.getWood();
		gold = login.getGold();
		iron = login.getIron();
		stone = login.getStone();
		hpot = login.getHpot();
	}
	/**
	 * Sets that the player found a map		
	 */
	public void findMap() {
		hasMap = true;
	}
	
	/**
	 * Sets that the player has an axe
	 */
	public void findAxe() {
		axe = true;
	}
	
	/**
	 * Sets that the player has a pick axe
	 */
	public void findPick() {
		pick = true;
	}

	/**
	 * Returns the max health of the player
	 * @return health - the max health of the player
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getHealth() throws NumberFormatException, IOException{
		
		return health;
	}

	/**
	 * Returns Current Health
	 * @return CHealth - Current Health of Player
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getCHealth() throws NumberFormatException, IOException{
		
		return cHealth;
	}

	/**
	 * Retrieves Mana Value
	 * @return mana- The Maximum amount of mana
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getMana() throws NumberFormatException, IOException{
		
		return mana;
	}

	/**
	 * Retrieves Current Mana Value
	 * @return Current Mana - The Players Current Amount Of Mana
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getCMana() throws NumberFormatException, IOException{
		
		return cMana;
	}

	/**
	 * Retrieves the Players Level
	 * @return Level- The Current Players Level
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getLevel() throws NumberFormatException, IOException{
		
		return level;
	}

	/**
	 * Retrieves Experience Points
	 * @return Experience - How close you are to the next level
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getXp() throws NumberFormatException, IOException{
		
		return xp;
	}

	/**
	 * Retrieves Strength Rating
	 * @return Strength - The Strength Level
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getStr() throws NumberFormatException, IOException{
		
		return str;
	}

	/**
	 * Retrieves Dexterity Rating
	 * @return Dexterity - Retrieves Dexterity Rating
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getDex() throws NumberFormatException, IOException{
		
		return dex;
	}

	/**
	 * Retrieves Intelligence
	 * @return Intel - The Intelligence rating
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getIntel() throws NumberFormatException, IOException{
		
		return intel;
	}

	/**
	 * Retrieves the last time the player visited the castle
	 * @return Castle Last Visited- The last turn a player was at the castle
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getCLV() throws NumberFormatException, IOException{
		
		return clv;
	}
	
	public int getHPot(){
		return hpot;
	}

	/**
	 * Retrieves the amount of turns a player has went through
	 * @return Turns - The amount of turns
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getTurns() throws NumberFormatException, IOException{
		
		return turns;
	}

	/**
	 * Retrieves the size of the map
	 * @return mapSize - the size of the map
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getMapSize() throws NumberFormatException, IOException{
		
		return mapSize;
	}

	/**
	 * Retrieves the X start location
	 * @return locationX - the X location
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getLocationX() throws NumberFormatException, IOException {
		
		return locationX;
	}

	/**
	 * Retrieves the Y start location
	 * @return locationY - the Y location
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getLocationY() throws NumberFormatException, IOException {
		
		return locationY;
	}

	/**
	 * Retrieves the weapon the player has
	 * @return weapon - the weapon the player has
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int getWeapon() throws NumberFormatException, IOException {
		
		return weapon;
	}

	/**
	 * Sets the current health
	 * @param setHealth - the current health
	 * @throws IOException
	 */
	public void setCHealth(int setHealth) throws IOException {
		if(setHealth<=health){
			cHealth = setHealth;
			saveAll();
		}
		else{
			cHealth = health;
		}
	}

	/**
	 * Sets the current mana
	 * @param setMana - the current mana
	 * @throws IOException
	 */
	public void changeMana(int setMana) throws IOException{
		cMana = cMana + setMana;
		saveAll();
	}

	public void setHpot(int hp) throws IOException{
		hpot+=hp;
		saveAll();
	}
	
	
	public void setWeapon(int sweapon) throws IOException{
		weapon=sweapon;
		saveAll();
	}
	/**
	 * Sets the current level
	 * @param setLevel - the current level
	 * @throws IOException
	 */
	private void addLevel() throws IOException {
		if(level<10){
			level++;
			health = getHealth()+30;
			mana = getMana() +30;
			str = getStr() + 3;
			dex  = getDex() + 3;
			intel = getIntel() + 3;
			cHealth = getHealth();
			cMana = getMana();
			H.pln("You are now level "+level+"!");
		}
		else{
			level++;
			health = getHealth()+30;
			mana = getMana() +30;
			str = getStr() + 3;
			dex  = getDex() + 3;
			intel = getIntel() + 3;
			cHealth = getHealth();
			cMana = getMana();
		}
			
		saveAll();
	}

	/**
	 * sets the current xp
	 * @param setXP - the current xp
	 * @throws IOException
	 */
	public void addXP(int addXP) throws IOException {
		xp += addXP;
		if(xp >= LVL_XP[level]){
			xp-=LVL_XP[level];
			addLevel();
		}
		saveAll();
	}

	/**
	 * resets xp upon death
	 */
	public void resetXP() {
		xp = 0;
	}

	/**
	 * sets the current strength
	 * @param setStr - the current strength
	 * @throws IOException
	 */
	public void setStr(int setStr) throws IOException {
		str = setStr;
		saveAll();
	}

	/**
	 * sets the current dexterity
	 * @param setDex - the current dexterity
	 * @throws IOException
	 */
	public void setDex(int setDex) throws IOException {
		dex = setDex;
		saveAll();
	}

	/**
	 * sets the current intel
	 * @param setIntel - the current intel
	 * @throws IOException
	 */
	public void setIntel(int setIntel) throws IOException {
		intel = setIntel;
		saveAll();
	}

	/**
	 * sets the last castle visit
	 * @param cetClv - the last castle visit
	 * @throws IOException
	 */
	public void setClv(int setClv) throws IOException {
		clv = setClv;
		saveAll();
	}

	/**
	 * sets the number of turns
	 * @param setTurn - the number of turns
	 * @throws IOException
	 */
	public void setTurn(int setTurn) throws IOException {
		turns = setTurn;
		saveAll();
	}

	/**
	 * sets the current location
	 * @param x - the x coordinate of the location
	 * @param y - the y coordinate of the location
	 * @throws IOException
	 */
	public void setLocation(int x, int y) throws IOException {
		locationX = x;
		locationY = y;
		saveAll();
	}

	public void update() throws NumberFormatException, IOException{
		login.update();
		getStats();
	}
	
	/**
	 * Tells if the player has the map
	 * @return hasMap - if the player has a map
	 */
	public boolean hasMap() {
		return hasMap;
	}
	
	/**
	 * Retrieves whether or not the player has an axe
	 * @return axe - if the player has an axe
	 */
	public boolean getAxe() {
		return axe;
	}
	
	/**
	 * Retrieves whether or not the player has a pick axe
	 * @return pick - if the player has a pick axe
	 */
	public boolean getPick() {
		return pick;
	}
	
	/**
	 * Retrieves the amount of wood the player has
	 * @return wood - the amount of wood the player has
	 */
	public int getWood() {
		return wood;
	}
	
	/**
	 * Adds the amount of wood to the total amount of
	 * wood the player has
	 * @param aWood - the amount of wood to be added or subtracted
	 * @throws IOException 
	 */
	public void setWood(int aWood) throws IOException {
		wood += aWood;
		saveAll();
	}
	
	/**
	 * Adds the amount of wood to the total amount of
	 * wood the player has
	 * @param aWood - the amount of wood to be added or subtracted
	 * @throws IOException 
	 */
	public void setGold(int aGold) throws IOException {
		gold += aGold;
		saveAll();
	}
	
	/**
	 * Adds the amount of iron to the total amount of
	 * iron the player has
	 * @param aIron - the amount of iron to be added or subtracted
	 * @throws IOException 
	 */
	public void setIron(int aIron) throws IOException {
		iron += aIron;
		saveAll();
	}
	
	/**
	 * Adds the amount of iron to the total amount of
	 * iron the player has
	 * @param aIron - the amount of iron to be added or subtracted
	 * @throws IOException 
	 */
	public void setStone(int aStone) throws IOException {
		stone += aStone;
		saveAll();
	}
	
	/**
	 * Resets the player's inventory
	 * @throws IOException 
	 */
	public void resetInv() throws IOException {
		weapon = 0;
		wood = 0;
		gold = 0;
		iron = 0;
		stone = 0;
		axe = false;
		pick = false;
		hasMap = false;
		saveAll();
	}
	
	/**
	 * Retrieves the amount of gold the player has
	 * @return gold - the amount of gold the player has
	 */
	public int getGold() {
		return gold;
	}
	/**
	 *Retrieves the amount of iron the player has
	 * @return iron - the amount of iron the player has
	 */
	public int getIron() {
		return iron;
	}
	
	/**
	 * Retrieves the amount of stone the player has
	 * @return stone - the amount of stone the player has
	 */
	public int getStone() {
		return stone;
	}
}

