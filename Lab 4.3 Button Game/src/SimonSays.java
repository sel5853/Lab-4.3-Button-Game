
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

public class SimonSays extends Application 
{
	private int score = 0;
	private boolean scoring;
	private long timeStep;
	private int highScore=0;

	
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Click me!");
        Button btn = new Button();
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();

       
        btn.setOnAction(new EventHandler<ActionEvent>() 
        
        {
            @Override
            public void handle(ActionEvent event) 
            {
            
               if(scoring) 
               {
            	   score++;
            	   if(score> highScore) 
            	   {
                  	   highScore++;
                   }
               }
               else
               {
            	  score--;
               }
            }
        });
        
        timeStep = System.nanoTime() + 10000000000L;
        new AnimationTimer()
        {
        	
        	public void handle(long now)
        	{
        		
            }
        }.start();
        
        btn.setTranslateX(-50);
        btn.setTranslateY(50);
        btn1.setTranslateX(-50);
        btn1.setTranslateY(-50);
        btn2.setTranslateX(50);
        btn2.setTranslateY(50);
        btn3.setTranslateX(50);
        btn3.setTranslateY(-50);
      
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }
}
