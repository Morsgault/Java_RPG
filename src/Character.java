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

	private String charName;
	Login login;

	public Character(String name) throws NumberFormatException, IOException {
		charName = name;
		login = new Login(charName);
		getStats();
	}

	public void findWeapon(int weaponType) {
		if (weaponType >= weapon) {
			weapon = weaponType;
		}
	}

	public void saveAll() throws IOException {
		login.saveStats(health, cHealth, mana, cMana, level, xp, str, dex, intel, clv, turns, locationX, locationY, weapon);
	}

	private void getStats() {
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
	}

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

	/**
	 * Sets the current health
	 * @param setHealth - the current health
	 * @throws IOException 
	 */
	public void changeCHealth(int setHealth) throws IOException {
		cHealth = cHealth + setHealth;
		saveAll();
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

	/**
	 * Sets the current level
	 * @param setLevel - the current level
	 * @throws IOException 
	 */
	private void addLevel() throws IOException {
		level++;
		saveAll();
	}

	/**
	 * sets the current xp
	 * @param setXP - the current xp
	 * @throws IOException 
	 */
	public void addXP(int addXP) throws IOException {
		xp = xp + addXP;
		switch(level) {

		case 1:
			if(xp >= 100) {
				addLevel();
				xp = 0;
			}
			break;
		case 2:
			if(xp >= 500) {
				addLevel();
				xp = 0;
			}
			break;
		case 3:
			if(xp >= 1200) {
				addLevel();
				xp = 0;
			}
			break;
		case 4:
			if(xp >= 2500) {
				addLevel();
				xp = 0;
			}
			break;
		case 5:
			if(xp >= 5000) {
				addLevel();
				xp = 0;
			}
			break;
		case 6:
			if(xp >= 9000) {
				addLevel();
				xp = 0;
			}
			break;
		case 7:
			if(xp >= 15000) {
				addLevel();
				xp = 0;
			}
			break;
		case 8:
			if(xp >= 20000) {
				addLevel();
				xp = 0;
			}
			break;
		default:
			if(xp >= 25000 && level > 8) {
				addLevel();
				xp = 0;
			}
			break;
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
}
