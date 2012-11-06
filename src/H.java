import java.util.InputMismatchException;
import java.util.Scanner;
public class H {
	//This is just so we can take shortcuts :P
	public static void pln(String x){
		System.out.println(x);
	}

	public static void pr(String x){
		System.out.print(x);
	}

	public static void pln(int x){
		System.out.println(x);
	}

	public static void pr(int x){
		System.out.print(x);
	}

	public static int inputInt() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = 1;
		try {
			num = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Improper input number expected");
			System.out.println("Option 1 automatically chosen.");
		}
		return num;
	}

	public static String inputString() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		return input.next();
	}


}
