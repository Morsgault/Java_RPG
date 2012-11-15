//Java_RPG
//Alpha Pre-Release 1.3.5
//Released 11/14/2012
//©2012 Ryan Cicchiello & Jason Holman
//See LICENCE for details


import java.io.IOException;

public class Crafting {

	private String charName;
	private Character player;
	private boolean crafted;

	public Crafting(String pName) throws NumberFormatException, IOException {
		charName = pName;
		player = new Character(charName);
	}

	public void craft() throws NumberFormatException, IOException {
		player.update();
		crafted = false;
		while(!crafted) {
			H.pln("Crafting:");
			H.pln("You can craft the following:");
			H.pln("(1) axe (2 wood & 3 stone)");
			H.pln("(2) pickaxe (2 wood and 4 stone)");
			H.pln("(3) exit");
			int item = H.inputInt();

			switch(item) {

			case 1:
				if(player.getWood() >= 2 && player.getStone() >= 3) {
					player.findAxe();
					player.setWood(-2);
					player.setStone(-3);
					H.pln("You crafted an axe");
					crafted = true;
				} else {
					H.pln("You do not have enough materials to craft an axe.");
				}
				break;
				
			case 2:
				if(player.getWood() >= 2 && player.getStone() >= 4) {
					player.findPick();
					player.setWood(-2);
					player.setStone(-4);
					H.pln("You crafted a pickaxe");
					crafted = true;
				} else {
					H.pln("You do not have enough materials to craft a pickaxe.");
				}
				break;
			case 3:
				crafted = true;
				break;
			default:
				H.pln("Improper Input");
				break;
			}
		}
		player.saveAll();

	}

}
