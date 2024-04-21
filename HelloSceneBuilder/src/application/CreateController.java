package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class CreateController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField nameInput;
	@FXML
	private Label charName;
	@FXML
	private ImageView charImageView;
	
	@FXML
	private ChoiceBox<String> raceChoiceBox = new ChoiceBox<>();
	private String[] tempRaces = {"Elf", "Dwarf", "Half-Orc", "Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf", "Tiefling"};
	
	@FXML
	private ChoiceBox<String> classChoiceBox = new ChoiceBox<>();
	private String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
								"Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
	
	@FXML
	private ChoiceBox<String> backgroundChoiceBox = new ChoiceBox<>();
	private String[] backgrounds = {"Acolyte", "Criminal", "Spy", "Folk Hero", "Haunted One", "Sage", "Noble", "Soldier"};
	
	
	@FXML
	private Label levelLabel;
	@FXML
	private Slider levelSlider;
	@FXML
	private Label strLabel;
	@FXML
	private Slider strSlider;
	@FXML
	private Label dexLabel;
	@FXML
	private Slider dexSlider;
	@FXML
	private Label conLabel;
	@FXML
	private Slider conSlider;
	@FXML
	private Label intLabel;
	@FXML
	private Slider intSlider;
	@FXML
	private Label wisLabel;
	@FXML
	private Slider wisSlider;
	@FXML
	private Label charismaLabel;
	@FXML
	private Slider charismaSlider;
	
	
	String username;
	String myRace;
	String myBackground;
	String myClass;
	int level;
	int strength;
	int dexterity;
	int constitution;
	int intelligence;
	int wisdom;
	int charisma;
	
	
	public void saveName(ActionEvent e) throws IOException {
		
		username = nameInput.getText();
		charName.setText(username);
	
		/**How the program saves the values and puts them into a file
		 * 
		 * All fields must be filled else a NullPointer error will occur
		 * User must click save and have all fields filled
		 * 
		 * Known error(s):
		 * -ints do not print properly
		 * -only saving works, load function does not do anything
		 * 
		 **/
        try {
            FileWriter fw = new FileWriter("dndChar.txt",false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.write(username);
            bw.newLine();
            out.write(myRace);
            bw.newLine();
            out.write(myBackground);
            bw.newLine();
            out.write(myClass);
            bw.newLine();
            out.write(Integer.toString(level));
            bw.newLine();
            out.write(Integer.toString(strength));
            bw.newLine();
            out.write(Integer.toString(dexterity));
            bw.newLine();
            out.write(Integer.toString(constitution));
            bw.newLine();
            out.write(Integer.toString(intelligence));
            bw.newLine();
            out.write(Integer.toString(wisdom));
            bw.newLine();
            out.write(Integer.toString(charisma));
            
            out.close();

        } catch (IOException f) {
            System.err.println("Error reading/writing file: " + f.getMessage());
        }
 
	}
	public void getRace(ActionEvent e) {
	
		myRace = raceChoiceBox.getValue();
		Image raceImage = new Image(myRace + ".png");
		charImageView.setImage(raceImage);
	}
	
	public void getClass(ActionEvent e) {
		
		myClass = classChoiceBox.getValue();
	}
	
	public void getBackground(ActionEvent e) {
		
		myBackground = backgroundChoiceBox.getValue();
	}
	
	public void createSheet(ActionEvent e) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sheet.fxml"));
		root = loader.load();
		
		int[] tempBackOps = {0, 0, 0};
		
		int[] stats = {strength, dexterity, constitution, intelligence, wisdom, charisma};
		CharacterSheet sheet = new CharacterSheet(username, myRace, myBackground, myClass, "Berserker", level, stats, tempBackOps);
		
		SheetController sheetController = loader.getController();
		sheetController.setup(sheet);
		
		
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("sheet.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		
		Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	    stage.setX((screenBounds.getWidth() - 700) / 2); 
	    stage.setY((screenBounds.getHeight() - 800) / 2);
		stage.show();
	}


	//For messing with the controller after root element was already added
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		raceChoiceBox.getItems().addAll(tempRaces);
		raceChoiceBox.setOnAction(this::getRace);
	
		classChoiceBox.getItems().addAll(classes);
		classChoiceBox.setOnAction(this::getClass);
		
		backgroundChoiceBox.getItems().addAll(backgrounds);
		backgroundChoiceBox.setOnAction(this::getBackground);
	
		levelSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				
				level = (int) levelSlider.getValue();
				levelLabel.setText("Level: " + Integer.toString(level));
			}
		
		
		});
		
		strSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			
				strength = (int) strSlider.getValue();
				strLabel.setText("Strength: " + Integer.toString(strength));
			}
		
		
		});
	
		dexSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			
				dexterity = (int) dexSlider.getValue();
				dexLabel.setText("Dexterity: " + Integer.toString(dexterity));
			}
		
		
		});
	
		conSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			
				constitution = (int) conSlider.getValue();
				conLabel.setText("Constitution: " + Integer.toString(constitution));
			}
		
		
		});
	
		intSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			
				intelligence = (int) intSlider.getValue();
				intLabel.setText("Intelligence: " + Integer.toString(intelligence));
			}
		
		
		});
	
		wisSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			
				wisdom = (int) wisSlider.getValue();
				wisLabel.setText("Wisdom: " + Integer.toString(wisdom));
			}
		
		
		});
	
		charismaSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			
				charisma = (int) charismaSlider.getValue();
				charismaLabel.setText("Charisma: " + Integer.toString(charisma));
			}
		
		
		});
		
	
	}
	
}