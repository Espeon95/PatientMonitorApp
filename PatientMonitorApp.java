/**
 * @author Lacy Tesdall
 * Date Written: January 3, 2019
 * Purpose: This program demonstrates modularity. It provides a common interface 
 *          for sensors, and a base class for displaying monitors. 
 *          This setup allows for ease of adding new sensors and being able to read 
 *          and write to them. 
 * Program Documentation:
 *    This program has the following sensors:
 *    - Heart rate 
 *    - Systolic and diastolic blood pressure
 *   Each sensor has its own monitor and display, and is updated every second.
 */
 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Timer;
import java.util.TimerTask;

public class PatientMonitorApp extends Application
{
	PatientMonitor monitor = new PatientMonitor();
	
	public void start(Stage primarystage)
	{
		primarystage.setTitle( "Patient Monitor App" );
		
		BorderPane root = new BorderPane();
		
		Button btnStartStop = new Button( "Start/Stop" );
		btnStartStop.setStyle( (monitor.getHeartRate()==0) ? "-fx-background-color:red" : "-fx-background-color:green" );

		btnStartStop.setOnAction( e -> {
			try {
				int toggle = monitor.toggleStartStop();
				btnStartStop.setStyle( 
				   (monitor.getHeartRate()==0) ? "-fx-background-color:red" : "-fx-background-color:green" 
				   );
			}
			catch(Exception ex) {
				System.out.println( ex );
			}
		});

		Group group = new Group();
		
		Rectangle mainbackground = new Rectangle(0,0,200,200);
		mainbackground.setFill( Color.WHITE );
		
		BPMonitorDisplay        bp        = new BPMonitorDisplay       ( monitor, 0, 190);
		HeartRateMonitorDisplay heartRate = new HeartRateMonitorDisplay( monitor, 0, 0);
		
		group.getChildren().addAll( mainbackground, bp, heartRate );
			
		Timer timer = new Timer();
		primarystage.setOnCloseRequest(event -> {
			timer.cancel();
		});
		
		FlowPane buttons = new FlowPane();
		buttons.getChildren().addAll( btnStartStop );
		
		root.setTop( buttons );
		root.setCenter( group );
		
		Scene scene = new Scene(root);
		
		primarystage.setScene( scene );
		primarystage.show();
		
		timer.schedule( new TimerTask() {
			public void run()
			{
				bp.update();
				heartRate.update();
			}
		}, 0, 1000);
	}
	
	public static void main(String[] args)
	{
		launch( args );
	}
}