import java.io.IOException;

public class H {
	private static String input;

	private static UI ui;

	public H() {
		ui = new UI();
	}
	
	public void setCharName(String charName) throws NumberFormatException, IOException {
		ui.setCharName(charName);
	}

	//This is just so we can take shortcuts :P
	public static void pln(String x) {
		System.out.println(x);
		ui.pln(x);

	}

	public static void pr(String x) {
		System.out.print(x);
		ui.pr(x);
	}

	public static void pln(int x) {
		System.out.println(x);
		ui.pln(Integer.toString(x));
	}

	public static void pr(int x) {
		System.out.print(x);
		ui.pr(Integer.toString(x));
	}

	public static int inputInt() {
		int num = 0;
		String str = "";
		while(!str.matches("-?\\d+")) {
			ui.update();
			while(!ui.asked) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			str = ui.getString();
			if(!str.matches("-?\\d+")) {
				pln("Improper input. Number Expected.");
			} else {
				num = Integer.parseInt(str);
			}

		}
		return num;
	}

	public static String inputString() {

		ui.update();
		while(!ui.asked) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		input = ui.getString();
		ui.pln(input);
		return ui.getString();
	}


	public static void showPic(int type) {



	}


}

