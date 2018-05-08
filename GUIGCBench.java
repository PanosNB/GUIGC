import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Map;

public class GUIGCBench extends Application {
	
	private GUIGCSettingsPane settingsPane = new GUIGCSettingsPane();
	private Button startButton;
	private boolean runAsyncGCOnSleep;

	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		Map<String, String> params = super.getParameters().getNamed();
		
		String autoRun = params.get("autoRun");
		if(autoRun==null || !autoRun.equals("true")){
			autoRun = "false";
		}
		
		String asyncGCOnSleep = params.get("asyncGCOnSleep");
		if(asyncGCOnSleep==null || !asyncGCOnSleep.equals("true")){
			asyncGCOnSleep = "false";
		}
		runAsyncGCOnSleep = asyncGCOnSleep.equals("true");

		String preset = params.get("preset");
		
		String gcNames="";
		for(GarbageCollectorMXBean gc: ManagementFactory.getGarbageCollectorMXBeans()){
			gcNames+="\t#"+gc.getName();
			gcNames+="\t"+gc.getName()+"(ms)";
		}
		
		System.out.println("Create\tShow\tFiring\tClose\tSleep\tTotal"+gcNames);

		
		primaryStage.setTitle ("GUI GC Bench");
		
		startButton = new Button("Start!");
		startButton.setOnAction(this::startTest);
		startButton.setPrefWidth(300);
	
		VBox vbox = new VBox(settingsPane, startButton);	
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-font-size:30px");

		Scene scene = new Scene (vbox, 650, 500);

		primaryStage.setScene (scene);
		primaryStage.show ();
		
		if(autoRun.equals("true")){
			switch(preset){
			case "A":
				settingsPane.buttonA.fire(); break;
			case "B":
				settingsPane.buttonB.fire(); break;
			case "C":
				settingsPane.buttonC.fire(); break;
			case "D":
				settingsPane.buttonD.fire(); break;
			}
			startButton.fire();
			System.exit(0);
		}
	}
	
	public void startTest(ActionEvent event){
		int reps = settingsPane.getReps();
		int seed = settingsPane.getSeed();
		int depth = settingsPane.getDepth();
		int breadth = settingsPane.getBreadth();
		int nButtons = settingsPane.getNButtons();
		int sleepTime = settingsPane.getSleepTime();

		for(int i=0; i<reps; i++){
			GUIGCStage.runTest(seed, depth, breadth, nButtons, sleepTime, runAsyncGCOnSleep);
		}
	}
} 
