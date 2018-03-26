
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
	private boolean scoring;
	private long timeStep;

	
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Click me!");
        Button btn = new Button();
        btn.setText("Say 'Click me!'");
        Text txt = new Text(10,0, "Click Score");
        Label label = new Label(" ");
        Label label1 = new Label(" ");
        Label label2 = new Label(" ");
       
        btn.setOnAction(new EventHandler<ActionEvent>() 
        
        {
            @Override
            public void handle(ActionEvent event) 
            {
            
               if(scoring) {
            	   score++;
            	  
               }else{
            	  score--;
            	}
            }
        });
        
        timeStep = System.nanoTime() + 10000000000L;
        new AnimationTimer()
        {
        	public void handle(long now)
        	{ 
        		if(now > timeStep)
        		{
        			timeStep = now + 10000000000L;
        			scoring = !scoring;
        		}
        		if(!scoring)
        		{
        			btn.setText("Click me!");
        			
        		}

        		else
        		{
        			label.setText("Game running");
        			btn.setText("Click me"); 
        			
        		}
        		txt.setText("Score: " + Integer.toString(score));
        	}
        	
        }.start();
        
        txt.setTranslateX(-20);
        txt.setTranslateY(-20);
        label.setTranslateX(-20);
        label.setTranslateY(-50);
        label1.setTranslateX(-20);
        label1.setTranslateY(-75);
        label2.setTranslateX(-20);
        label2.setTranslateY(-65);
      
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(txt);
        root.getChildren().add(label);
        root.getChildren().add(label1);
        root.getChildren().add(label2);
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }
}