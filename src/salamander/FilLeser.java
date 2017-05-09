package salamander;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilLeser {
	
	

	ArrayList<String> ordliste;
	
	
	public ArrayList<String> getOrdFraFil(String navn){
		ArrayList<String> ord = new ArrayList<String>();
		File fil = new File(navn);
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
	
	public ArrayList<String> getordliste(String navn){
		if(ordliste == null){
			ordliste= getOrdFraFil(navn);
		}
		return ordliste;
	}
	

}
