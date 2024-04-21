package application;

public class Ability {
	private String name;
	private String desc;
	/*
	 * Action type
	 * 1=Action
	 * 2=Bonus Action
	 * 3=Reaction
	 * 4=Free Action
	 * -1=Special
	 */
	private int actionType;
	/*
	 * slot 1 = str
	 * slot 2 = dex
	 * slot 3 = con
	 * slot 4 = int
	 * slot 5 = wis
	 * slot 6 = cha
	 */
	private int[] statModifier = {0,0,0,0,0,0};
	private int acCalc;
	private int acBonus;
	private int saBonus;
	private int profBonus;
	private int diceNum;
	private int diceSize;
	private int bonusVal;
	private String bonusText;
	
	// Constructor
    public Ability(String name, String desc, int actionType, int[] statModifier, int acCalc, int acBonus, int saBonus,
                   int profBonus, int diceNum, int diceSize, int bonusVal, String bonusText) {
        this.name = name;
        this.desc = desc;
        this.actionType = actionType;
        this.statModifier = statModifier;
        this.acCalc = acCalc;
        this.acBonus = acBonus;
        this.saBonus = saBonus;
        this.profBonus = profBonus;
        this.diceNum = diceNum;
        this.diceSize = diceSize;
        this.bonusVal = bonusVal;
        this.bonusText = bonusText;
    }

    
    
    // Getters
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getActionType() {
        return actionType;
    }

    public int[] getStatModifier() {
        return statModifier;
    }

    public int getAcCalc() {
        return acCalc;
    }

    public int getAcBonus() {
        return acBonus;
    }

    public int getSaBonus() {
        return saBonus;
    }

    public int getProfBonus() {
        return profBonus;
    }

    public int getDiceNum() {
        return diceNum;
    }
    
    public int getDiceSize() {
        return diceSize;
    }
    
    public int getBonusVal() {
        return bonusVal;
    }

    public String getBonusText() {
        return bonusText;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public void setStatModifier(int[] statModifier) {
        this.statModifier = statModifier;
    }

    public void setAcCalc(int acCalc) {
        this.acCalc = acCalc;
    }

    public void setAcBonus(int acBonus) {
        this.acBonus = acBonus;
    }

    public void setSaBonus(int saBonus) {
        this.saBonus = saBonus;
    }

    public void setProfBonus(int profBonus) {
        this.profBonus = profBonus;
    }
    
    public void setDiceNum(int diceNum) {
        this.diceNum = diceNum;
    }
    
    public void setDiceSize(int diceSize) {
        this.diceSize = diceSize;
    }

    public void setBonusVal(int bonusVal) {
        this.bonusVal = bonusVal;
    }

    public void setBonusText(String bonusText) {
        this.bonusText = bonusText;
    }
    
    public String toString() {
		return "" + name + ": " + desc;
    }
}
