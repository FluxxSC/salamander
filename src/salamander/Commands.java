package salamander;

public enum Commands {
	
	
	/*
	Generate network commands on the format
	 	
	 	key|id|argument
	 
	*/
	
	ID(0), 			// used by the server to assign an id to each client
	NAME(1), 		// specify the user's name
	LETTER(2), 		// the letter guessed
	CHAT(3),		// chat line
	
	
	UNKNOWN(-1);	// unknown command	
	
	private int key;
	
	private Commands(int value) {
		this.key = value;
	}
	
	public String make(int id) {
		return key + "|" + id;
	}
	
	public String make(int id, String argument) {
		return key + "|" + id + "|" + argument;
	}
	
	public static Commands is(int key) {
		switch (key) {
		case 0:
			return Commands.ID;
		case 1:
			return Commands.NAME;
		case 2:
			return Commands.LETTER;
		default:
			return Commands.UNKNOWN;
		}
		
	}
}
