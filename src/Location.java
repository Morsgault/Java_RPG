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

	public Location(int worldSize) {
		x = 3;
		y = 0;
		alive = true;
		maxX = 6;
		maxY = 6;
		mapSize = worldSize;
		world = new int[mapSize][mapSize];
		hasMap = true;
		genWorld();
		showMap();
	}
	public void move(int direction) {
		switch (direction) {

		case 1:
			y++;
			if(y > maxY) {
				alive = false;
			}
			break;
		case 2:
			x++;
			if(x > maxX) {
				alive = false;
			}
			break;
		case 3:
			y--;
			if(y < 0) {
				alive = false;
			}
			break;
		case 4:
			x--;
			if(x < 0) {
				alive = false;
			}
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
	public void findMap() {
		hasMap = true;
	}
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
	//This method generates the world
	private void genWorld() {
		Random rand = new Random();
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				if(j > 0 && j < mapSize && i > 0 && i < mapSize) {
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
		}
		for(int k = 0; k < mapSize; k++) {
			world[k][0] = 5;
			world[k][mapSize - 1] = 5;
			world[0][k] = 5;
			world[mapSize - 1][k] = 5;
		}
	}
}
