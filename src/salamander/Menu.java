package salamander;

import java.awt.List;
import java.util.Scanner;

public class Menu {
	
	
	public int run(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Choose Gamemode: ");
		System.out.println("1. Gamemode 1");
		System.out.println("2. Gamemode 2");
		int out = 0;
		String temp = "";
		
		while (true) {
			temp = input.nextLine();
			if(temp.length() == 1){
				out = Integer.parseInt(temp);
				if(out == 2 || out == 1){
					break;
				}
			}
			
		}
		return out;
	}

}
