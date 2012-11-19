//Java_RPG
//Alpha Pre-Release 1.3.6
//Released 11/19/2012
//©2012 Ryan Cicchiello & Jason Holman
//See LICENCE for details

import java.io.IOException;

public class Build {

	private Character player;

	public Build(String charName) throws NumberFormatException, IOException {
		player = new Character(charName);
	}

	public Location build(Location location) throws IOException {

		boolean exit = false;
		
		while(!exit) {

			H.pln("Avaliable build options:");
			H.pln("(1) Mine (Requires 5 wood)");
			H.pln("     Can only be built on field");
			H.pln("(2) House (Requires 20 wood, 5 iron, and 3 gold)");
			H.pln("     Can only be built on field and forest");
			H.pln("(3) Exit");
			int input = H.inputInt();
			switch(input) {

			case 1:
				if(player.getWood() >= 5 && location.getCell() == 4) {
					H.pln("You built a mine!");
					player.setWood(-5);
					location.editMap(9);
				} else if(location.getCell() != 4){
					H.pln("You are no on the correct land type.");
				} else {
					H.pln("You do not have enough materials");
				}
				break;
				
			case 2:
				if(player.getWood() >= 20 && player.getIron() >= 5 && player.getGold() >= 3 && (location.getCell() == 4 || location.getCell() == 2)) {
					H.pln("You built a House!");
					player.setWood(-20);
					player.setIron(-5);
					player.setGold(-3);
					location.editMap(8);
				} else if(location.getCell() != 4 || location.getCell() != 2) {
					H.pln("You are no on the correct land type.");
				} else {
					H.pln("You do not have enough materials");
				}
				
				break;
				
			case 3:
				H.pln("Goodbye");
				exit = true;
				break;
				
			}

		}
		player.saveAll();
		return location;

	}

}
