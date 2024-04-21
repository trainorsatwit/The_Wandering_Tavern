

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Controller {

	private Stage stage;
	private Scene scene;
	private Parent root;
	

	public void createCharacter(ActionEvent e) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Create.fxml"));
		root = loader.load();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    stage.setX((screenBounds.getWidth() - 700) / 2); 
	    stage.setY((screenBounds.getHeight() - 800) / 2);
	    
		stage.show();
	}
	
	
	public void loadCharacter(ActionEvent e) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Load.fxml"));
		root = loader.load();
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}

}
