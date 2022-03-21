import java.io.*;
import java.util.*;

public class ChemistryQuizDemo {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to the Chemistry Quiz. There will be 10 random questions!");
		
	    MapInterface<String, String> periodicMap = new ArrayListMap<String, String>();

	    String fname = args[0]; // input file of text
	    FileReader fin = new FileReader(fname);
	    Scanner info = new Scanner(fin);
	    info.useDelimiter("[#\\n\\r]");  // delimiters are # signs, line feeds,
	                                     // carriage returns

	    // get information about the key and value
	    String keyInfo = info.next();
	    String valueInfo = info.next();
	    info.nextLine();
	    
	    // Reads the key/value pairs from the file and puts them into the map
	    String key, value;
	    while (info.hasNext()) {
	      key = info.next();
	      value = info.next().substring(1);
	      info.nextLine();
	      periodicMap.put(key, value);
	    }
	    
	    Scanner scan = new Scanner(System.in);    
	    key = null;
	    double score = 0;
	    
	    for(int i = 0; i < 10; i++) {
	    	Random random = new Random();
	    	int randEl = random.nextInt(118)+1;
	    	System.out.println("What is the corresponding element of periodic number " + randEl + "?");
	    	
	    	String convertedEl = String.valueOf(randEl);
		    key = scan.next().toLowerCase();
		    key = key.substring(0,1).toUpperCase() + key.substring(1);
		    
		    if (periodicMap.get(convertedEl).equals(key)) {
		    	System.out.println("Correct! "+ periodicMap.get(convertedEl) + " corresponds to " + randEl);
		    	score++;
		    }
		    else
		    	System.out.println("Incorrect! The correct answer is " + periodicMap.get(convertedEl));
	    }
	    
	    score = score / 10 * 100;
	    System.out.println("Score: " + score + "%");
	    System.out.println();
	    
	}

}
