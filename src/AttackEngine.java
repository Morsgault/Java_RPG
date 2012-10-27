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
    private Character player;
    private Random elgen;


    public AttackEngine(String charName){
        Character player = new Character(charName);
        Random elgen = new Random();
    }
    public void Battle(){
        elevel = elgen.nextInt(2)+(plevel-1);
        while(E_ALIVE==true && P_ALIVE==true){
            switch(elevel){
                case -1:
                //To Finish
              }
        }
    }
}

