package application;

import java.util.ArrayList;

public class CharacterSheet {

	
	private String name;
	private String race;
	private int raceOp;
	private String background;
	private int[] backOps;
	private String mainClass;
	private String subClass;
	private int level;
	private int profBonus;
	private int armorClass;
	private int initiative;
	private int speed;
	private int maxHP;
	private int gold;
	
	
	/*
	 * Slot 0 = Strength
	 * Slot 1 = Dexterity
	 * Slot 2 = Constitution
	 * slot 3 = Intelligence
	 * slot 4 = Wisdom
	 * slot 5 = Charisma
	 */
	private int[] statValues;
	private int[] modValues;
	private int[] savingThrows; //not done

	
	/*
	 * Slot 0 = Acrobatics
	 * Slot 1 = Animal Handling
	 * Slot 2 = Arcana
	 * Slot 3 = Athletics
	 * Slot 4 = Deception
	 * Slot 5 = History
	 * Slot 6 = Insight
	 * Slot 7 = Intimidation
	 * Slot 8 = Investigation
	 * Slot 9 = Medicine
	 * Slot 10 = Nature
	 * Slot 11 = Perception
	 * Slot 12 = Performance
	 * Slot 13 = Persuasion
	 * Slot 14 = Religion
	 * Slot 15 = Sleight of Hand
	 * Slot 16 = Stealth
	 * Slot 17 = Survival
	 */
	private boolean[] skillProf = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	
	
	/*
	 * Slot 0 = Common
	 * Slot 1 = Dwarvish
	 * Slot 2 = Elvish
	 * Slot 3 = Giant
	 * Slot 4 = Gnomish
	 * Slot 5 = Goblin
	 * Slot 6 = Halfling
	 * Slot 7 = Orc
	 * Slot 8 = Abyssal
	 * Slot 9 = Celestial
	 * Slot 10 = Draconic
	 * Slot 11 = Deep Speach
	 * Slot 12 = Infernal
	 * Slot 13 = Primordial
	 * Slot 14 = Sylvan
	 * Slot 15 = Undercommon
	 */
	private boolean[] langProf = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	
	
	/*
	 * Slot 1 = Light
	 * Slot 2 = Medium
	 * Slot 3 = Heavy
	 * Slot 4 = Shield
	 */
	private boolean[] armorProf;
	private ArrayList<String> toolProf = new ArrayList<>();
	
	
	/*
	 * Slot 1 = Simple
	 * Slot 2 = Martial
	 */
	private boolean[] weaponProf;
	
	private ArrayList<Ability> actionAbilities = new ArrayList<>();
	private ArrayList<Ability> bonusActionAbilities = new ArrayList<>();
	private ArrayList<Ability> reactionAbilities = new ArrayList<>();
	private ArrayList<Ability> freeActionAbilities = new ArrayList<>();
	private ArrayList<Ability> specialAbilities = new ArrayList<>();
	
	private ArrayList<Equipment> equipment = new ArrayList<>();
	
	public CharacterSheet(String nameInput, String raceInput, String backgroundInput, String classInput,
							String subClassInput, int levelInput, int[] statValuesInput, int[] backOpsInput) {
		
		name = nameInput;
		race = raceInput;
		background = backgroundInput;
		mainClass = classInput;
		subClass = subClassInput;
		level = levelInput;
		statValues = statValuesInput;
		backOps = backOpsInput;
		speed = 25;
		
		profBonus = 1 + ((level-1)/4);
		modValues = new int[] {(statValues[0]/2)-5,(statValues[1]/2)-5, (statValues[2]/2)-5, (statValues[3]/2)-5, (statValues[4]/2)-5, (statValues[5]/2)-5};
		savingThrows = new int[] {modValues[0],modValues[1],modValues[2],modValues[3],modValues[4],modValues[5]};
		for (int i = 0; i < 6; i++) {
			
		}
		initiative = modValues[1];
		armorClass = 10 + modValues[1];
		
		createCharacter();
		
	}
	
	private void createCharacter() {
		FiveEditionLibrary.makeLibrary(this);
	}
	
	
	//Adders
	public void addLanguage(int[] lang) {
		for(int x : lang) {
			langProf[x] = true;
		}
	}
	
	public void addSkillProf(int[] prof) {
		for(int x : prof) {
			skillProf[x] = true;
		}
	}
	
	public void addToolProf(String tool) {
		toolProf.add(tool);
	}
	
	public void addAbility(Ability ability) {
		if(ability.getActionType() == 1) {
			actionAbilities.add(ability);
		}else if(ability.getActionType() == 2) {
			bonusActionAbilities.add(ability);
		}else if(ability.getActionType() == 3) {
			reactionAbilities.add(ability);
		}else if(ability.getActionType() == 4) {
			freeActionAbilities.add(ability);
		}else if(ability.getActionType() == -1) {
			specialAbilities.add(ability);
		}
	}
	
	public void addEquipment(Equipment e) {
		equipment.add(e);
	}
	
	public void changeStat(int stat, int change) {
		statValues[stat] += (change);
	}
	
	
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
    public int getRaceOp() {
    	return raceOp;
    }
    
    public void setRaceOp(int raceOp) {
    	this.raceOp = raceOp;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int[] getBackOps() {
        return backOps;
    }

    public void setBackOps(int[] backOps) {
        this.backOps = backOps;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getProficiency() {
        return profBonus;
    }

    public void setProficiency(int proficiency) {
        this.profBonus = proficiency;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int[] getStatValues() {
        return statValues;
    }

    public void setStatValues(int[] statValues) {
        this.statValues = statValues;
    }

    public int[] getModValues() {
        return modValues;
    }

    public void setModValues(int[] modValues) {
        this.modValues = modValues;
    }

    public int[] getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(int[] savingThrows) {
        this.savingThrows = savingThrows;
    }

    public boolean[] getSkillProf() {
        return skillProf;
    }

    public void setSkillProf(boolean[] skillProf) {
        this.skillProf = skillProf;
    }

    public boolean[] getLangProf() {
        return langProf;
    }

    public void setLangProf(boolean[] langProf) {
        this.langProf = langProf;
    }

    public ArrayList<String> getToolProf() {
        return toolProf;
    }

    public void setToolProf(ArrayList<String> toolProf) {
        this.toolProf = toolProf;
    }

    public boolean[] getArmorProf() {
        return armorProf;
    }

    public void setArmorProf(boolean[] armorProf) {
        this.armorProf = armorProf;
    }

    public boolean[] getWeaponProf() {
        return weaponProf;
    }

    public void setWeaponProf(boolean[] weaponProf) {
        this.weaponProf = weaponProf;
    }

    public ArrayList<Ability> getActionAbilities() {
        return actionAbilities;
    }

    public ArrayList<Ability> getBonusActionAbilities() {
        return bonusActionAbilities;
    }

    public ArrayList<Ability> getReactionAbilities() {
        return reactionAbilities;
    }

    public ArrayList<Ability> getFreeActionAbilities() {
        return freeActionAbilities;
    }

    public ArrayList<Ability> getSpecialAbilities() {
        return specialAbilities;
    }

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}

	
}
