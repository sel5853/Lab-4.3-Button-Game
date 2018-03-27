
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChaseTheButton extends Application 
{
	private int score = 0;
	private boolean scoring = false;
	
	
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
       
        btn.setOnAction(new EventHandler<ActionEvent>() 
        
        {
        	
            @Override
            public void handle(ActionEvent event) 
            {
            
            	scoring = true;
            	   score++;  
               
            }
            
        });
       
        new AnimationTimer()
        {
        	
        	public void handle(long now)
        	{
        		if(score!=0 && scoring)
        		{
        			 btn.setTranslateX(Math.random()*200-100);
        			 btn.setTranslateY(Math.random()*200-100);
        			 scoring = false;
   
        		}
        	
        		txt.setText("Score: " + Integer.toString(score));
             }
        }.start();
    
        
   
        txt.setTranslateX(-20);
        txt.setTranslateY(-20);
       
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(txt);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }
}