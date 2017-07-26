

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class CountWordsLineCharacters {

    public static void readFileAndPrintCounts(String File) throws FileNotFoundException {

        int TotalWords = 0;
        int TotalLines = 0;

        String Line;
	
	
 try( BufferedReader Buffer = new BufferedReader(new FileReader(File)))

      {
            

            Map<String, Integer> mapOfRepeatedWord = new HashMap<String, Integer>();

 

while (( Line = Buffer.readLine()) != null) 

            {
		
               
                TotalLines++;


                String[] myWords = Line.replaceAll("\\s+", " ").split(" ");

                for (String s : myWords) 
    {
                    

                    String tempUCword = s.toLowerCase();


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


                for (Map.Entry<String, Integer> entry : mapOfRepeatedWord.entrySet())
    
      {
                    System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
      }

}

        

        catch(IOException e)
                {
                    e.printStackTrace();
                }

      }
        private static void Log(String string)
    {
        System.out.println(string);
    }

    public static void main(String[] args) {
        try {
            String File = "/C:/Users/609753284/test.txt";
            readFileAndPrintCounts(File);
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }//main
}//class
