

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//define class name

public class CountWords {
	
	//this method is used to read input file and count number repeated word occurrences

    public static void readFileAndPrintCounts(String InputFile) throws FileNotFoundException {

	 // Step 1: Initialize variablesso that memory is allocated to the variables
	    
        int TotalWords = 0;
        int TotalLines = 0;

        String Line;
	
        // Step 2: create a object of Buffered reader it is one way of reading the file
	    
 try( BufferedReader ReadFile = new BufferedReader(new FileReader(InputFile)))

      {
        // Step 3: Create one HashMap object called mapOfRepeatedWord  which will hold words of the input file as keys and their occurrences as values

            Map<String, Integer> mapOfRepeatedWord = new HashMap<String, Integer>();
	 

      // Step 4: Read all the lines of input text file one by one into currentLine using readLine() method.

while (( Line = ReadFile.readLine()) != null) 

            {
		
               
                TotalLines++;

	// Step 5: Split the currentLine into words by using space as delimiter and replaces all  extra whitespaces from String

                String[] myWords = Line.replaceAll("\\s+", " ").split(" ");

	// Step 6: Iterating each word
	
                for (String word : myWords) 
    {
                    
         //Step 7: toLowerCase() is used to covert the words to lowercase  
			
                    String tempUCword = word.toLowerCase();

        
          //Step 8: Iterate through each word of words array and check whether the word is present in mapOfRepeatedWord.
         //If word is already present in mapOfRepeatedWord ,update its count. Otherwise insert the word as a key and 1 as its value.
			  
                    if (mapOfRepeatedWord.containsKey(tempUCword))
                 {

                      
                        mapOfRepeatedWord.put(tempUCword, mapOfRepeatedWord.get(tempUCword) + 1);

                    } 
                   else 
                         {
                             mapOfRepeatedWord.put(tempUCword, 1);
                         }
      }
}


               
                System.out.println("Count of the words : \n");
                System.out.println("Words" + "\t\t\t" + "Count");
                System.out.println("======" + "\t\t\t" + "=====");
	 
	 
	 

        //Step 9: print key and value with the help of entry.getKey() and entry.getValue()


                for (Map.Entry<String, Integer> entry : mapOfRepeatedWord.entrySet())
    
      {
                    System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
      }

}

         // Log exception
	    
        catch(IOException e)
                {
                    e.printStackTrace();
                }

      }
  
//main class we call our function over hear
    public static void main(String[] args) {
        try {
            String InputFile = "/C:/Users/609753284/test.txt";
            readFileAndPrintCounts(InputFile);
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }//main
}//class
