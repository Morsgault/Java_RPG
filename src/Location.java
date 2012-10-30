import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Location {

	private int x;
	private int y;
	private int maxX;
	private int maxY;
	private boolean alive;
	private int mapSize;
	private int[][] world;
	private boolean hasMap;
	private String playerName;

	public Location(int worldSize, String charName, int locationX, int locationY) throws IOException {
		x = locationX;
		y = locationY;
		alive = true;
		maxX = mapSize - 1;
		maxY = mapSize - 1;
		mapSize = worldSize;
		world = new int[mapSize][mapSize];
		hasMap = true;
		playerName = charName;
		genWorld();
		showMap();
	}

	public void move(int direction) {
		switch (direction) {

		case 1:
			y++;
			alive = y <= maxY;
			break;
		case 2:
			x++;
			alive = x <= maxX;
			break;
		case 3:
			y--;
			alive = y > 0;
			break;
		case 4:
			x--;
			alive = x > 0;
			break;
		default:
			break;
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isAlive() {
		return alive;
	}
	public void died() {
		alive = false;
	}
	/*
	 * This method gives the player the map is they happen to find it in the world
	 */
	public void findMap() {
		hasMap = true;
	}
	/*
	 * This method prints the map into the system output
	 */
	public void showMap() {
		if(hasMap) {
			for(int r = 0; r < mapSize; r++) {
				String str = "";
				for(int f = 0; f < mapSize; f++) {
					str = str + world[r][f];
				}
				System.out.println(str);
			}
		}
	}
	/*
	 * This method generates the world or if the player has a save file reloads the world.
	 */
	private void genWorld() throws IOException {
		if(Exists(playerName)) {
			BufferedReader load = new BufferedReader(new FileReader(playerName+"Map.txt"));
			String loadMap[] = new String[mapSize];
			for(int p = 0; p < mapSize; p++) {
				loadMap[p] = load.readLine();
			}
			for(int a = 0; a < mapSize; a++) {
				for(int b = 0; b < mapSize; b++) {
					world[a][b] = Integer.parseInt(loadMap[a].substring(b, b+1));
				}
			}

		} else {
			File newMap = new File(playerName+"Map.txt");
			newMap.createNewFile();

			BufferedWriter map = new BufferedWriter(new FileWriter(newMap));
			Random rand = new Random();
			for(int i = 0; i < mapSize; i++) {
				for(int j = 0; j < mapSize; j++) {
					int randNum = rand.nextInt(100)+1;
					int type = 0;
					// Quicksand block
					if(randNum > 0 && randNum < 11) type = 1;
					// forest block
					if(randNum > 10 && randNum <61) type = 2;
					// pond block
					if(randNum > 90 && randNum < 101) type = 3;
					// field block
					if(randNum > 60 && randNum < 91) type = 4;
					if(type == 0) {
						System.out.println("Land Generator Error");
						System.out.println("Program Terminated");
						System.exit(0);
					}
					world[j][i] = type;
				}

			}
			for(int k = 0; k < mapSize; k++) {
				world[k][0] = 5;
				world[k][mapSize - 1] = 5;
				world[0][k] = 5;
				world[mapSize - 1][k] = 5;
			}

			String str = "";
			for(int a = 0; a < mapSize; a++) {
				str = "";
				for(int b = 0; b < mapSize; b++) {
					str = str + Integer.toString(world[a][b]);
				}
				map.write(str);
				map.newLine();
			}
			map.close();

		}
	}
	public boolean Exists(String charName){
		File f = new File(charName+"Map.txt");
		return f.exists();
	}
}
