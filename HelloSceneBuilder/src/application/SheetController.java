package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class SheetController implements Initializable {

	// Character Details
	@FXML
	private Label charName;
	@FXML
	private Label charRaceClass;
	@FXML
	private Label charBackground;
	@FXML
	private Label charLevel;
	@FXML
	private ImageView charPicture;

	// HP box
	@FXML
	private Spinner<Integer> hpSpinner = new Spinner<>();
	@FXML
	private Label currentLabel;
	@FXML
	private Label maxLabel;
	int currentValue;
	int currentHP = 0;
	int maxHP = 0;
	@FXML
	private Label tempLabel;
	int tempHP = 0;

	// Character stats
	@FXML
	private Label strMod;
	@FXML
	private Label dexMod;
	@FXML
	private Label conMod;
	@FXML
	private Label intMod;
	@FXML
	private Label wisMod;
	@FXML
	private Label chaMod;
	@FXML
	private Label strValue;
	@FXML
	private Label dexValue;
	@FXML
	private Label conValue;
	@FXML
	private Label intValue;
	@FXML
	private Label wisValue;
	@FXML
	private Label chaValue;
	@FXML
	private Label strSave;
	@FXML
	private Label dexSave;
	@FXML
	private Label conSave;
	@FXML
	private Label intSave;
	@FXML
	private Label wisSave;
	@FXML
	private Label chaSave;
	@FXML
	private Label profBonus;
	@FXML
	private Label armorClass;
	@FXML
	private Label initiative;
	@FXML
	private Label walkingSpeed;

	@FXML
	private Label acrobaticsBonus;
	@FXML
	private Label animalBonus;
	@FXML
	private Label arcanaBonus;
	@FXML
	private Label athleticsBonus;
	@FXML
	private Label deceptionBonus;
	@FXML
	private Label historyBonus;
	@FXML
	private Label insightBonus;
	@FXML
	private Label intimidationBonus;
	@FXML
	private Label investigationBonus;
	@FXML
	private Label medicineBonus;
	@FXML
	private Label natureBonus;
	@FXML
	private Label perceptionBonus;
	@FXML
	private Label performanceBonus;
	@FXML
	private Label persuasionBonus;
	@FXML
	private Label religionBonus;
	@FXML
	private Label sleightBonus;
	@FXML
	private Label stealthBonus;
	@FXML
	private Label survivalBonus;

	@FXML
	private Circle acrobaticsProf;
	@FXML
	private Circle animalProf;
	@FXML
	private Circle arcanaProf;
	@FXML
	private Circle athleticsProf;
	@FXML
	private Circle deceptionProf;
	@FXML
	private Circle historyProf;
	@FXML
	private Circle insightProf;
	@FXML
	private Circle intimidationProf;
	@FXML
	private Circle investigationProf;
	@FXML
	private Circle medicineProf;
	@FXML
	private Circle natureProf;
	@FXML
	private Circle perceptionProf;
	@FXML
	private Circle performanceProf;
	@FXML
	private Circle persuasionProf;
	@FXML
	private Circle religionProf;
	@FXML
	private Circle sleightProf;
	@FXML
	private Circle stealthProf;
	@FXML
	private Circle survivalProf;

	public void setup(CharacterSheet sheet) {
		
		maxHP = sheet.getMaxHP();
		currentHP = maxHP;
		currentLabel.setText(Integer.toString(currentHP));
		maxLabel.setText(Integer.toString(maxHP));
		
		Image pfp = new Image(sheet.getRace() + ".png");
		charPicture.setImage(pfp);
		charName.setText(sheet.getName());
		charRaceClass.setText(sheet.getRace() + " " + sheet.getMainClass());
		charBackground.setText(sheet.getBackground());
		charLevel.setText("Level " + Integer.toString(sheet.getLevel()));
		strMod.setText(createMod(sheet.getModValues()[0]));
		dexMod.setText(createMod(sheet.getModValues()[1]));
		conMod.setText(createMod(sheet.getModValues()[2]));
		intMod.setText(createMod(sheet.getModValues()[3]));
		wisMod.setText(createMod(sheet.getModValues()[4]));
		chaMod.setText(createMod(sheet.getModValues()[5]));
		strValue.setText(Integer.toString(sheet.getStatValues()[0]));
		dexValue.setText(Integer.toString(sheet.getStatValues()[1]));
		conValue.setText(Integer.toString(sheet.getStatValues()[2]));
		intValue.setText(Integer.toString(sheet.getStatValues()[3]));
		wisValue.setText(Integer.toString(sheet.getStatValues()[4]));
		chaValue.setText(Integer.toString(sheet.getStatValues()[5]));
		strSave.setText(createMod(sheet.getSavingThrows()[0]));
		dexSave.setText(createMod(sheet.getSavingThrows()[1]));
		conSave.setText(createMod(sheet.getSavingThrows()[2]));
		intSave.setText(createMod(sheet.getSavingThrows()[3]));
		wisSave.setText(createMod(sheet.getSavingThrows()[4]));
		chaSave.setText(createMod(sheet.getSavingThrows()[5]));
		profBonus.setText(createMod(sheet.getProficiency()));
		armorClass.setText(Integer.toString(sheet.getArmorClass()));
		initiative.setText(createMod(sheet.getInitiative()));
		walkingSpeed.setText("30");
		
		if(sheet.getSkillProf()[0] == true) {
			acrobaticsBonus.setText(Integer.toString(sheet.getModValues()[1] + sheet.getProficiency()));
			acrobaticsProf.setFill(Color.MAROON);
		}else {
			acrobaticsBonus.setText(Integer.toString(sheet.getModValues()[1]));
		}
		if(sheet.getSkillProf()[1] == true) {
			animalBonus.setText(Integer.toString(sheet.getModValues()[4] + sheet.getProficiency()));
			animalProf.setFill(Color.MAROON);
		}else {
			animalBonus.setText(Integer.toString(sheet.getModValues()[4]));
		}
		if(sheet.getSkillProf()[2] == true) {
			arcanaBonus.setText(Integer.toString(sheet.getModValues()[3] + sheet.getProficiency()));
			arcanaProf.setFill(Color.MAROON);
		}else {
			arcanaBonus.setText(Integer.toString(sheet.getModValues()[3]));
		}
		if(sheet.getSkillProf()[3] == true) {
			athleticsBonus.setText(Integer.toString(sheet.getModValues()[0] + sheet.getProficiency()));
			athleticsProf.setFill(Color.MAROON);
		}else {
			athleticsBonus.setText(Integer.toString(sheet.getModValues()[0]));
		}
		if(sheet.getSkillProf()[4] == true) {
			deceptionBonus.setText(Integer.toString(sheet.getModValues()[5] + sheet.getProficiency()));
			deceptionProf.setFill(Color.MAROON);
		}else {
			deceptionBonus.setText(Integer.toString(sheet.getModValues()[5]));
		}
		if(sheet.getSkillProf()[5] == true) {
			historyBonus.setText(Integer.toString(sheet.getModValues()[3] + sheet.getProficiency()));
			historyProf.setFill(Color.MAROON);
		}else {
			historyBonus.setText(Integer.toString(sheet.getModValues()[3]));
		}
		if(sheet.getSkillProf()[6] == true) {
			insightBonus.setText(Integer.toString(sheet.getModValues()[4] + sheet.getProficiency()));
			insightProf.setFill(Color.MAROON);
		}else {
			insightBonus.setText(Integer.toString(sheet.getModValues()[4]));
		}
		if(sheet.getSkillProf()[7] == true) {
			intimidationBonus.setText(Integer.toString(sheet.getModValues()[5] + sheet.getProficiency()));
			intimidationProf.setFill(Color.MAROON);
		}else {
			intimidationBonus.setText(Integer.toString(sheet.getModValues()[5]));
		}
		if(sheet.getSkillProf()[8] == true) {
			investigationBonus.setText(Integer.toString(sheet.getModValues()[3] + sheet.getProficiency()));
			investigationProf.setFill(Color.MAROON);
		}else {
			investigationBonus.setText(Integer.toString(sheet.getModValues()[3]));
		}
		if(sheet.getSkillProf()[9] == true) {
			medicineBonus.setText(Integer.toString(sheet.getModValues()[4] + sheet.getProficiency()));
			medicineProf.setFill(Color.MAROON);
		}else {
			medicineBonus.setText(Integer.toString(sheet.getModValues()[4]));
		}
		if(sheet.getSkillProf()[10] == true) {
			natureBonus.setText(Integer.toString(sheet.getModValues()[3] + sheet.getProficiency()));
			natureProf.setFill(Color.MAROON);
		}else {
			natureBonus.setText(Integer.toString(sheet.getModValues()[3]));
		}
		if(sheet.getSkillProf()[11] == true) {
			perceptionBonus.setText(Integer.toString(sheet.getModValues()[4] + sheet.getProficiency()));
			perceptionProf.setFill(Color.MAROON);
		}else {
			perceptionBonus.setText(Integer.toString(sheet.getModValues()[4]));
		}
		if(sheet.getSkillProf()[12] == true) {
			performanceBonus.setText(Integer.toString(sheet.getModValues()[5] + sheet.getProficiency()));
			performanceProf.setFill(Color.MAROON);
		}else {
			performanceBonus.setText(Integer.toString(sheet.getModValues()[5]));
		}
		if(sheet.getSkillProf()[13] == true) {
			persuasionBonus.setText(Integer.toString(sheet.getModValues()[5] + sheet.getProficiency()));
			persuasionProf.setFill(Color.MAROON);
		}else {
			persuasionBonus.setText(Integer.toString(sheet.getModValues()[5]));
		}
		if(sheet.getSkillProf()[14] == true) {
			religionBonus.setText(Integer.toString(sheet.getModValues()[3] + sheet.getProficiency()));
			religionProf.setFill(Color.MAROON);
		}else {
			religionBonus.setText(Integer.toString(sheet.getModValues()[3]));
		}
		if(sheet.getSkillProf()[15] == true) {
			sleightBonus.setText(Integer.toString(sheet.getModValues()[1] + sheet.getProficiency()));
			sleightProf.setFill(Color.MAROON);
		}else {
			sleightBonus.setText(Integer.toString(sheet.getModValues()[1]));
		}
		if(sheet.getSkillProf()[16] == true) {
			stealthBonus.setText(Integer.toString(sheet.getModValues()[1] + sheet.getProficiency()));
			stealthProf.setFill(Color.MAROON);
		}else {
			stealthBonus.setText(Integer.toString(sheet.getModValues()[1]));
		}
		if(sheet.getSkillProf()[17] == true) {
			survivalBonus.setText(Integer.toString(sheet.getModValues()[4] + sheet.getProficiency()));
			survivalProf.setFill(Color.MAROON);
		}else {
			survivalBonus.setText(Integer.toString(sheet.getModValues()[4]));
		}
		
		/*acrobaticsBonus;
		animalBonus;
		arcanaBonus;
		athleticsBonus;
		deceptionBonus;
		historyBonus;
		insightBonus;
		intimidationBonus;
		investigationBonus;
		medicineBonus;
		natureBonus;
		perceptionBonus;
		performanceBonus;
		persuasionBonus;
		religionBonus;
		sleightBonus;
		stealthBonus;
		survivalBonus;
		acrobaticsProf;
		animalProf;
		arcanaProf;
		thleticsProf;
		deceptionProf;
		historyProf;
		insightProf;
		intimidationProf;
		investigationProf;
		medicineProf;
		natureProf;
		perceptionProf;
		performanceProf;
		persuasionProf;
		religionProf;
		sleightProf;
		stealthProf;
		survivalProf;*/
		
	}

	private String createMod(int x) {
		String str = "";
		if (x <= 0) {
			str = "" + x;
			return str;
		} else {
			str = "+" + x;
			return str;
		}
	}

	public void heal(ActionEvent e) {

		if (currentHP + currentValue > maxHP) {
			currentHP = maxHP;
		} else {
			currentHP = currentHP + currentValue;
		}

		currentLabel.setText(Integer.toString(currentHP));
	}

	public void damage(ActionEvent e) {

		if (currentHP - currentValue < 0) {
			currentHP = 0;
		} else {
			currentHP = currentHP - currentValue;
		}

		currentLabel.setText(Integer.toString(currentHP));
	}

	public void addTemp(ActionEvent e) {
		tempHP++;
		tempLabel.setText(Integer.toString(tempHP));
	}

	public void subtractTemp(ActionEvent e) {
		if (tempHP > 0) {
			tempHP--;
			tempLabel.setText(Integer.toString(tempHP));
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Spinner setup
		SpinnerValueFactory<Integer> hpFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
		hpFactory.setValue(0);
		hpSpinner.setValueFactory(hpFactory);
		currentValue = hpSpinner.getValue();

		hpSpinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				currentValue = hpSpinner.getValue();
			}

		});

	}

}
