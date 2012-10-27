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
    private int P_MAX_DAM; //Maximum Damage a player can do
    private int P_MIN_DAM; //Minimum Damage a player can do
    private int E_MAX_DAM; //Maximum Damage an enemy can do
    private int E_MIN_DAM; //Minumum Damage an enemy can do
    private boolean E_ALIVE; //Enemy is alive
    private boolean P_ALIVE; //Player is alive
    private int E_HEALTH; //Enemy's Max Health
    private int EC_HEALTH; //Enemy's Current Health
    private Character player;
    private Random elgen;


    public AttackEngine(String charName){
        Character player = new Character(charName);
        Random elgen = new Random();
    }
    public void Battle(){
        elevel = elgen.nextInt(2)+(plevel-1);
            switch(elevel){
                case -1:
                     E_HEALTH = 70;
                     EC_HEALTH = 70;
                case 0 :
                     E_HEALTH = 100;
                     EC_HEALTH = 100;
                case 1:
                     E_HEALTH = 130;
                     EC_HEALTH = 130;
                case 2:
                     E_HEALTH = 160;
                     EC_HEALTH = 160;
                case 3:
                     E_HEALTH = 190;
                     EC_HEALTH = 190;
                case 4 :
                     E_HEALTH = 220;
                     EC_HEALTH = 220;
                case 5:
                     E_HEALTH = 250;
                     EC_HEALTH = 250;
                case 6:
                     E_HEALTH = 280;
                     EC_HEALTH = 280;
                case 7:
                     E_HEALTH = 310;
                     EC_HEALTH = 310;
                case 8:
                     E_HEALTH = 340;
                     EC_HEALTH = 340;
                case 9:
                     E_HEALTH = 370;
                     EC_HEALTH = 370;
                case 10:
                     E_HEALTH = 400;
                     EC_HEALTH = 400;
                case 11:
                     E_HEALTH = 430;
                     EC_HEALTH = 430;
              }
        }
    }
}

