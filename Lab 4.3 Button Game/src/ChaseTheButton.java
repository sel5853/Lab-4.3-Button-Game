
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChaseTheButton extends Application 
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
       
        btn.setOnAction(new EventHandler<ActionEvent>() 
        
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            
            	scoring = true;
            	   score++;  
            	   if(score> newHighScore) 
            	   {
                  	   newHighScore++;
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
        			 btn.setTranslateY((Math.random()*175)-75);
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
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}