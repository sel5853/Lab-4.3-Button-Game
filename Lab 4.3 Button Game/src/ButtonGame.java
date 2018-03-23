
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

public class ButtonGame extends Application 
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
        Label label = new Label("Score: 0");
        btn.setOnAction(new EventHandler<ActionEvent>() 
        
        {
            @Override
            public void handle(ActionEvent event) 
            {
            	
                System.out.println("Click me!");
                score ++;
                label.setText("Score: "+ score);
                System.out.println(score);
            }
        });
        
        timeStep = System.nanoTime() + 1000000000L;
        new AnimationTimer()
        {
        	public void handle(long now)
        	{
        		if(now > timeStep)
        		{
        			timeStep = now + 1000000000L;
        			scoring = !scoring;
        		}
        		if(!scoring)
        		{
        			btn.setText("Don't click!");
        			
        		}
        		else
        		{
        			btn.setText("Click me");
        		}
        		txt.setText("Score: " + Integer.toString(score));
        	}
        	}.start();
        
        label.setTranslateX(-30);
        label.setTranslateY(-50);
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(label);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}