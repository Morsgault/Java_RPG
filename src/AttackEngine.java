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
    private boolean E_ALIVE; //Enemy is alive
    private boolean P_ALIVE; //Player is alive
    private int E_HEALTH; //Enemy's Max Health
    private int EC_HEALTH; //Enemy's Current Health
    private int P_HEALTH; //Player's Health
    private int PC_HEALTH; //Player's Current Health
    private int MAX_DAM []; //Array of maximum damages
    private int choice; //Holder variable for player input
    private int damage;//The amount of damage done
    private boolean flee; //Tells if a player flees
    private Character player;
    private Random elgen;
    private Random engine;

    public AttackEngine(String charName){
        Character player = new Character(charName);
        Random elgen = new Random();
    }
    public void Battle(){
        flee = false;
        P_HEALTH = player.getHealth();
        PC_HEALTH = player.getCHealth();
        plevel = player.getLevel();
        MAX_DAMAGE [] = {20,30,40,50,60,70,80,90,100,110,120,130}
        elevel = elgen.nextInt(2)+(plevel-1);
        if(elevel !=-1){
        int health = 70 + (elevel + 1) * 30;
        }
        else{
            int health = 70;
        }

        E_HEALTH = health;
        EC_HEALTH = health;

        P.pln("You have encountered a level "+elevel+" enemy);
        while(!EC_HEALTH <= 0 && !PC_HEALTH <= 0 && !flee){
            engine = new Random();
            P.pln("Your Health: "+PC_HEALTH+"/"+ P_HEALTH);
            P.pln("Enemy's Health : "+EC_HEALTH+"/"+ E_HEALTH);
            P.pln("What do you want to do?");
            P.pln("(1)Attack, (2)Defend, (3)Flee");
            choice = P.input();

            switch(choice){
                case 1:
                    if(engine.nextInt(99)+1 <= 95){
                        damage = engine.nextInt(MAX_DAMAGE[plevel]);
                        P.pln("Enemy lost "+damage+" health!");
                        EC_HEALTH-=damage;
                    }
                    else{
                        if(plevel<=8){
                          damage = engine.nextInt(MAX_DAMAGE[plevel+2]);
                          P.pln("Critical Hit!");
                          P.pln("Enemy lost "+damage+" health!");
                        }
                        else{
                            if(plevel == 9){
                                damage = engine.nextInt(MAX_DAMAGE[plevel+1]);
                                P.pln("Critical Hit!");
                                P.pln("Enemy lost "+damage+" health!");
                            }
                            if(plevel == 10){
                                damage = EC_HEALTH;
                                P.pln("You destroyed the Enemy with one blow!!!");
                            }
                        }
                    }
                    damage = engine.nextInt(MAX_DAMAGE[elevel])+1;
                    P.pln("You lost "+damage+" health");
                    PC_HEALTH-=damage;
                    player.setCHealth(PC_HEALTH);
                    break;
                    case 2:
                    P.pln("You have blocked the enemy attack!");
                    break;
                case 3:
                    P.pln("You have fled");
                    flee = true;
                     break;
        }

    }
    if(EC_HEALTH <=0 && PC_HEALTH > 0){
        player.addXP(((elevel)*100)-EC_HEALTH);
        P.pln("You gained "+String.valueOf((((elevel)*100)-EC_HEALTH))+" XP!");
    }
   if(flee){
        player.addXP((EC_HEALTH)*(-1));
        P.pln("You lost "+EC_HEALTH+" XP!");
   }
}
}
