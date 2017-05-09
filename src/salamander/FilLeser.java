package salamander;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilLeser {
	
	
	File fil = new File("ordliste.txt");
	ArrayList<String> ordliste;
	
	
	public ArrayList<String> getOrdFraFil(){
		ArrayList<String> ord = new ArrayList<String>();
		try{
		BufferedReader reader = new BufferedReader(new FileReader(fil));
		String line;
		while ((line= reader.readLine()) != null){
			ord.add(line);
			
		}reader.close();	
		}
		catch(IOException e){
			e.printStackTrace();
		}
				
		return ord;
	}
	
	public ArrayList<String> getordliste(){
		if(ordliste == null){
			ordliste= getOrdFraFil();
		}
		return ordliste;
	}
	

}
