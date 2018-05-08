import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class GUIGCSettingsPane extends HBox{
	
	TextField repsField = new TextField("1000");
	TextField seedField = new TextField("438");
	TextField depthField = new TextField("8");
	TextField breadthField = new TextField("2");
	TextField nButtonsField = new TextField("1");
	TextField sleepTimeField = new TextField("100");
	
	Button buttonA, buttonB, buttonC, buttonD;
	
	public GUIGCSettingsPane(){		
		buttonA = new Button("Preset A");
		buttonA.setOnAction(this::presetA);
	
		buttonB = new Button("Preset B");
		buttonB.setOnAction(this::presetB);
		
		buttonC = new Button("Preset C");
		buttonC.setOnAction(this::presetC);
		
		buttonD = new Button("Preset D");
		buttonD.setOnAction(this::presetD);
		
		VBox presetBox = new VBox(buttonA, buttonB, buttonC, buttonD);
		presetBox.setSpacing(20);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		GridPane.setRowSpan(grid, null);
		GridPane.setColumnSpan(grid, null);
		
		
		Label repsLabel= new Label("Reps: ");
		repsField.setPrefWidth(150);
		grid.add(repsLabel, 0, 0);
		grid.add(repsField, 1, 0);
		
		Label seedLabel= new Label("Seed: ");
		seedField.setPrefWidth(150);
		grid.add(seedLabel, 0, 1);
		grid.add(seedField, 1, 1);
		
		Label depthLabel= new Label("Depth: ");
		depthField.setPrefWidth(150);
		grid.add(depthLabel, 0, 2);
		grid.add(depthField, 1, 2);
		
		Label breadthLabel= new Label("Breadth: ");
		breadthField.setPrefWidth(150);
		grid.add(breadthLabel, 0, 3);
		grid.add(breadthField, 1, 3);
		
		Label nButtonsLabel= new Label("#Buttons: ");
		nButtonsField.setPrefWidth(150);
		grid.add(nButtonsLabel, 0, 4);
		grid.add(nButtonsField, 1, 4);

		Label sleepTimeLabel= new Label("Sleep Time (ms): ");
		sleepTimeField.setPrefWidth(150);
		grid.add(sleepTimeLabel, 0, 5);
		grid.add(sleepTimeField, 1, 5);
		
		super.getChildren().addAll(presetBox, grid);
		super.setSpacing(20);
		super.setAlignment(Pos.CENTER);
		super.setStyle("-fx-font-size:30px");
	}

	public int getReps(){
		return Integer.parseInt(repsField.getText());
	}
	
	public int getSeed(){
		return Integer.parseInt(seedField.getText());
	}

	public int getDepth(){
		return Integer.parseInt(depthField.getText());
	}	
	
	public int getBreadth(){
		return Integer.parseInt(breadthField.getText());
	}
	
	public int getNButtons(){
		return Integer.parseInt(nButtonsField.getText());
	}

	public int getSleepTime(){
		return Integer.parseInt(sleepTimeField.getText());
	}
	
	public void presetA(ActionEvent event){
		repsField.setText("1000");
		seedField.setText("438");
		depthField.setText("8");
		breadthField.setText("2");
		nButtonsField.setText("1");
		sleepTimeField.setText("100");
	}
	
	public void presetB(ActionEvent event){
		repsField.setText("1000");
		seedField.setText("438");
		depthField.setText("8");
		breadthField.setText("1");
		nButtonsField.setText("1");
		sleepTimeField.setText("100");
	}
	
	public void presetC(ActionEvent event){
		repsField.setText("1000");
		seedField.setText("438");
		depthField.setText("8");
		breadthField.setText("2");
		nButtonsField.setText("2");
		sleepTimeField.setText("100");
	}
	
	public void presetD(ActionEvent event){
		repsField.setText("1000");
		seedField.setText("438");
		depthField.setText("8");
		breadthField.setText("2");
		nButtonsField.setText("1");
		sleepTimeField.setText("0");
	}
}
