import java.io.IOException;
import java.util.Random;
public class AttackEngine {
	/*
	 *Weapons are not currently going
	 *to have an effect.
	 *Once the the game is running the
	 *First update will include the
	 *implementation of weapons
	 *
	 */
	private int plevel; //Player Level
	private int elevel; //Enemy Level
	private double wD[] = {1,1.1,1.3,1.5,3};
	private boolean E_ALIVE; //Enemy is alive
	private boolean P_ALIVE; //Player is alive
	private int E_HEALTH; //Enemy's Max Health
	private int EC_HEALTH; //Enemy's Current Health
	private int P_HEALTH; //Player's Health
	private int PC_HEALTH; //Player's Current Health
	private final int P_MAX_DAMAGE[] = {40,50,60,70,80,90,100,110,120,130,140,150}; //Array of maximum damages for player
	private final int E_MAX_DAMAGE[] = {5,15,20,30,35,50,55,65,70,75,80,85};
	private int choice; //Holder variable for player input
	private int damage;//The amount of damage done
	private boolean flee; //Tells if a player flees
	private Character player;
	private Random elgen;
	private Random engine;
	private int helper;
	
	public AttackEngine(String charName) throws NumberFormatException, IOException{
		player = new Character(charName);
		elgen = new Random();
	}
	public boolean Battle() throws IOException{
		player.update();
		boolean alive = true;
		int health;
		flee = false;
		P_HEALTH = player.getHealth();
		PC_HEALTH = player.getCHealth();
		plevel = player.getLevel();
		elevel = elgen.nextInt(2)+(plevel-1);
		if(elevel !=-1){
			health = 70 + (elevel) * 30;
		}
		else{
			health = 70;
			elevel = 0;
		}

		E_HEALTH = health;
		EC_HEALTH = health;

		H.pln("You have encountered a level "+elevel+" enemy");
		while(EC_HEALTH > 0 && PC_HEALTH > 0 && !flee){
			engine = new Random();
			H.pln("Your Health: "+PC_HEALTH+"/"+ P_HEALTH);
			H.pln("Enemy's Health : "+EC_HEALTH+"/"+ E_HEALTH);
			H.pln("What do you want to do?");
			H.pln("(1)Attack, (2)Defend, (3)Flee");
			choice = H.inputInt();

			switch(choice){
			case 1:
				if(engine.nextInt(99)+1 <= 95){
					damage = (int) ((engine.nextInt(P_MAX_DAMAGE[plevel]))*wD[player.getWeapon()]);
					if(damage<=EC_HEALTH){
						H.pln("Enemy lost "+damage+" health!");
						EC_HEALTH-=damage;
					}
					else{
						helper = EC_HEALTH;
						H.pln("Enemy lost "+helper+" health!");
						EC_HEALTH -= damage;
					}
				}
				else{
					if(plevel<=8){
						damage = (int) (engine.nextInt(P_MAX_DAMAGE[plevel+2])*wD[player.getWeapon()]);
						H.pln("Critical Hit!");
						if(damage<=EC_HEALTH){
						H.pln("Enemy lost "+damage+" health!");
						EC_HEALTH-=damage;
					}
					else{
						helper = EC_HEALTH;
						H.pln("Enemy lost "+helper+" health!");
						EC_HEALTH = 0;
					}
					}
					else{
						if(plevel == 9){
							damage = (int) (engine.nextInt(P_MAX_DAMAGE[plevel+1])*wD[player.getWeapon()]);
							H.pln("Critical Hit!");
							if(damage<=EC_HEALTH){
								H.pln("Enemy lost "+damage+" health!");
								EC_HEALTH-=damage;
							}	
							else{
								helper = EC_HEALTH;
								H.pln("Enemy lost "+helper+" health!");
								EC_HEALTH -= damage;
							}
						}
						if(plevel == 10){
							damage = EC_HEALTH;
							H.pln("You destroyed the Enemy with one blow!!!");
						}
					}
				}
				damage = engine.nextInt(E_MAX_DAMAGE[elevel])+1;
				H.pln("You lost "+damage+" health");
				PC_HEALTH-=damage;
				player.setCHealth(PC_HEALTH);
				if (player.getCHealth() <= 0) 
					return false;
				break;
			case 2:
				H.pln("You have blocked the enemy attack!");
				break;
			case 3:
				H.pln("You have fled");
				flee = true;
				break;
			}

		}
		if(EC_HEALTH <=0 && PC_HEALTH > 0){
			player.addXP(EC_HEALTH * (-1));
			H.pln("You gained "+String.valueOf(EC_HEALTH * (-1))+" XP!");
		}
		if(flee){
			player.addXP((EC_HEALTH)*(-1));
			H.pln("You lost "+EC_HEALTH+" XP!");
		}
		player.saveAll();
		return true;
	}
}

