import java.util.Random;
public class AttackEngine {
    private int plevel; //Player Level
    private int elevel; //Enemy Level
    private int P_MAX_DAM; //Maximum Damage a player can do
    private int P_MIN_DAM; //Minimum Damage a player can do
    private int E_MAX_DAM; //Maximum Damage an enemy can do
    private int E_MIN_DAM; //Minumum Damage an enemy can do
    private boolean E_ALIVE; //Enemy is alive

    public AttackEngine(String charName){
        Character player = new Character(charName);
        plevel =  player.getLevel();
        Random elgen = new Random();
        elevel = elgen.nextInt(2)+(plevel-1);

    }
}

