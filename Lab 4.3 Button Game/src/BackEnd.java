
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BackEnd 
{

	/*
	 public static void main(String... args) {
	        List<String> books = readHighScore("scores.txt");

	        for (String b : books) {
	            System.out.println(b);
	        }
	    }
	  */

	    public static List<String> readHighScore(String fileName) {
	        List<String> scores = new ArrayList<>();
	        Path pathToFile = Paths.get(fileName);

	   
	        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

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
	 
	   
	class HighScore {
		
		private int score;
		
		public HighScore(int score) {
			this.score=score;
			
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		
		public String toString() {
	        return "High Score: " + score;
	    }
	}


    public static void WritetoFile(int newHighScore) {

        try {
            FileWriter highScore = new FileWriter("scores.txt");
            BufferedWriter bwr = new BufferedWriter(highScore);
            bwr.write(newHighScore);
            bwr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}


