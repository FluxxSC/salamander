package salamander;

import java.util.ArrayList;

public class HangmanDrawer {
	
	public void drawHangman(int numberWrong){
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("               ,------------------------,");
		lines.add("               | ,------------------|---'");
		if(numberWrong >=6 ){
		lines.add("               | |                  __ ");
		lines.add("               | |                 /xx\\	");	
		lines.add("               | |                 \\__/	");	
			
		}else if(numberWrong >= 1){
		lines.add("               | |                  __ ");
		lines.add("               | |                 /oo\\	");	
		lines.add("               | |                 \\__/	");	
			}
		else{
		lines.add("               | |        	  ");
		lines.add("               | |				");	
		lines.add("               | |		       	");	
		}
		if(numberWrong >= 4){
		lines.add("               | |                 /||\\	");
		lines.add("               | |                //||\\\\");	
		lines.add("               | |               // || \\\\");
		lines.add("               | |                  ||");
		}else if(numberWrong == 3){
		lines.add("               | |                 /||");
		lines.add("               | |                //||");	
		lines.add("               | |               // ||");
		lines.add("               | |                  ||");
		}else if(numberWrong == 2){
		lines.add("               | |                  ||");
		lines.add("               | |                  ||");	
		lines.add("               | |                  ||");
		lines.add("               | |                  ||");
		}else{
		lines.add("               | |                  ");
		lines.add("               | |                  ");	
		lines.add("               | |                  ");
		lines.add("               | |                  ");	
		}
		if(numberWrong >= 6){
		lines.add("               | |                 //\\\\");
		lines.add("               | |                //  \\\\");	
		lines.add("               | |               //    \\\\");	
		}else if(numberWrong == 5){
		lines.add("               | |                 //");
		lines.add("               | |                //");	
		lines.add("               | |               // ");	
		}else{
		lines.add("               | |             ");
		lines.add("               | |              ");	
		lines.add("               | |              ");	
		}
		lines.add("               | |");
		lines.add("               | |                  ");	
		lines.add("               | |                  ");
		lines.add("               | |                  ");
		lines.add("   ------------------------------");
				
	
	for(String line:lines){
		System.out.println(line);
	}
	}

}
