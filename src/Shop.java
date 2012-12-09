import java.io.IOException;

public class Shop {
	private boolean leave;
	private int response;
	private Character player;

	public Shop(String charName) throws NumberFormatException, IOException{
		player = new Character(charName);
		leave = false;
	}

	public void shop() throws IOException{
		H.pln("Welcome to the Shop!");
		leave = false;
		while(!leave){
			H.pln("Type the number next to the item to buy it.");
			H.pln("1- Wood(4).....50");
			H.pln("2- Iron........50");
			H.pln("3- Pickaxe.....100");
			H.pln("4- Axe.........100");
			H.pln("5- Health P....150");
			H.pln("6- Wood Sword..150");
			H.pln("7- Iron Sword..200");
			H.pln("8- Gold Sword..300");
			H.pln("9- Map.........300");
			H.pln("10- Upgrade Map.300");
			H.pln("Press 11 if you would like to learn more about an object");
			H.pln("Press any other number to leave");
			response = H.inputInt();
			switch(response){
			case 1:
				if(player.getGold()>=50){
					H.pln("You have bought 4 Wood");
					player.setGold(-50);
					player.setWood(4);
				}
				else{
					H.pln("Not enought gold.");
				}
				break;

			case 2:
				if(player.getGold()>=50){
					H.pln("You have bought 1 Iron");
					player.setGold(-50);
					player.setIron(1);
				}
				else{
					H.pln("Not enought gold.");
				}
				break;

			case 3:
				if(player.getGold()>=100){
					H.pln("You have bought a Pickaxe!");
					player.setGold(-100);
					player.findPick();
				}
				else{
					H.pln("Not enought gold.");
				}
				break;

			case 4:
				if(player.getGold()>=100){
					H.pln("You have bought an Axe!");
					player.setGold(-100);
					player.findAxe();
				}
				else{
					H.pln("Not enought gold.");
				}
				break;

			case 5:
				if(player.getGold()>=150){
					H.pln("You have bought Health Potion!");
					player.setGold(-150);
					player.setHpot(1);
				}
				else{
					H.pln("Not enought gold.");
				}
				break;

			case 6:
				if(player.getGold()>=150){
					H.pln("You have bought a Wooden Sword!");
					player.setGold(-150);
					player.setWeapon(1);
				}
				else{
					H.pln("Not enought gold.");
				}

				break;


			case 7:
				if(player.getGold()>=150){
					H.pln("You have bought an Iron Sword!");
					player.setGold(-200);
					player.setWeapon(2);
				}
				else{
					H.pln("Not enought gold.");
				}

				break;

			case 8:
				if(player.getGold()>=150){
					H.pln("You have bought a Gold Sword!");
					player.setGold(-300);
					player.setWeapon(3);
				}
				else{
					H.pln("Not enought gold.");
				}

			case 9:
				if(player.getGold() >= 300 && player.getMap() == 0) {
					H.pln("You have bought a map");
				} else if(player.getMap() > 0) {
					H.pln("You already have a map.");
				} else {
					H.pln("Not enought gold.");
				}

				break;

			case 10:
				if(player.getGold() >= 300 && player.getMap() == 1) {
					H.pln("Your map has been upgraded");
				} else if(player.getMap() == 0) {
					H.pln("You do not have a map to upgrade.");
				} else if(player.getMap() == 3) {
					H.pln("You already have an upgraded map.");
				} else {
					H.pln("You do not have enough gold");
				}
				break;
				
			case 11:
				H.pln("Sorry this is not a fully developed feature yet");

				break;

			default:
				H.pln("Goodbye");
				leave = true;
				player.saveAll();
				break;
			}
		}
	}
}
