//Java_RPG
//Alpha 1.2.0
//Released 11/10/2012
//©2012 Ryan Cicchiello & Jason Holman
//See LICENCE for details

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
		int num = 0;
		String str = "";
		while(!str.matches("-?\\d+")) {
			str = input.next();
			if(!str.matches("-?\\d+")) {
				System.out.println("Improper input. Number Expected.");
			} else {
				num = Integer.parseInt(str);
			}
		}
		return num;
	}

	public static String inputString() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		return input.next();
	}


}

