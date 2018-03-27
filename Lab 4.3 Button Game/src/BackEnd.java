
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BackEnd 
{
	/*
	 public static void main(String... args) {
	        List<Score> books = readBooksFromCSV("books.txt");

	        // let's print all the person read from CSV file
	        for (Score b : books) {
	            System.out.println(b);
	        }
	    }
	    */

	    private static List<String> readHighScore(String fileName) {
	        List<String> scores = new ArrayList<>();
	        Path pathToFile = Paths.get(fileName);

	        
	        try (BufferedReader br = Files.newBufferedReader(pathToFile,
	                StandardCharsets.US_ASCII)) {

	           
	            String line = br.readLine();

	           
	            while (line != null) {

	            
	                String[] attributes = line.split(",");

	               String score = createScore(attributes);
	                scores.add(score);
	                line = br.readLine();
	            }

	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }

	        return scores;
	    }

	   private static String createScore(String[] metadata) {
		   String score = metadata[0];
	        
		return score;
	}

	class Score{
		   
	   }

	}


