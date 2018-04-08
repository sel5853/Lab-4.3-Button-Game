/*
 * Stanley Liang and Evan Wu
 * AP CSA Period 2
 * Lab 4.3
 */


// import BackEnd.HighScore;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GameCode extends Application
{

	private int score = 0;
	private boolean scoring = false;
	private int newHighScore = 0;
	
	
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Click me!");
        Button btn = new Button();
        btn.setText("Click me");
        Text txt = new Text(10,0, "Click Score");
        Label highScore = new Label();
        btn.setStyle("-fx-font: normal 12px 'monospace' ");
        txt.setStyle("-fx-font: normal bold 15px 'monospace' "); 
        highScore.setStyle("-fx-font: normal bold 15px 'monospace' "); 
        Image image = new Image(getClass().getResourceAsStream("mole.jpg"));
        btn.setOnAction(new EventHandler<ActionEvent>() 
        
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            	btn.setText("");
                Button button = (Button) event.getSource();
                ImageView imageview = new ImageView(image);
                imageview.setFitHeight(40);
                imageview.setFitWidth(40);
                button.setGraphic(imageview);
            	scoring = true;
            	   score++;  
            	   if(score> newHighScore) 
            	   {
            		   newHighScore = score;
            		   BackEnd.WritetoFile(newHighScore);
                   }
            }
            
        });
       
        new AnimationTimer()
        {
        	
        	public void handle(long now)
        	{
        		if(score!=0 && scoring)
        		{
        			 btn.setTranslateX((Math.random()*200)-100);
        			 btn.setTranslateY((Math.random()*200)-100);
        			 scoring = false;
   
        		}
        	
        		txt.setText("Score: " + Integer.toString(score));
        		highScore.setText("High Score: " + Integer.toString(newHighScore));
             }
        }.start();
    
        
   
        
       
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(txt);
        root.setAlignment(txt, Pos.TOP_LEFT);
        root.setAlignment(highScore, Pos.TOP_RIGHT);
        root.getChildren().add(highScore);
        root.setStyle("-fx-background-color: green");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}
