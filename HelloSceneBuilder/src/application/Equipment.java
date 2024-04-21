package application;

public class Equipment {
	private String name;
	private String desc;
	private boolean[] armorProfReq = {false, false, false, false};
	private boolean[] weaponProfReq = {false, false};
	private boolean finesse;
	private int numDice;
	private int diceSize;
	private int quantity;
	private Ability[] equipAbilities;
	

    // Constructor
	 public Equipment(String name, String desc, boolean[] armorProfReq, boolean[] weaponProfReq, boolean finesse,
             int numDice, int diceSize, int quantity, Ability[] equipAbilities) 
	 {
		 this.name = name;
		 this.desc = desc;
		 this.armorProfReq = armorProfReq;
		 this.weaponProfReq = weaponProfReq;
		 this.finesse = finesse;
		 this.numDice = numDice;
		 this.diceSize = diceSize;
		 this.quantity = quantity;
		 this.equipAbilities = equipAbilities;
	 	}

// Getters and setters for each field
	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getDesc() {
		 return desc;
	 }

	 public void setDesc(String desc) {
		 this.desc = desc;
	 }

	 public boolean[] getArmorProfReq() {
		 return armorProfReq;
	 }

	 public void setArmorProfReq(boolean[] armorProfReq) {
		 this.armorProfReq = armorProfReq;
	 }

	 public boolean[] getWeaponProfReq() {
		 return weaponProfReq;
	 }

	 public void setWeaponProfReq(boolean[] weaponProfReq) {
		 this.weaponProfReq = weaponProfReq;
	 }

	 public boolean isFinesse() {
		 return finesse;
	 }

	 public void setFinesse(boolean finesse) {
		 this.finesse = finesse;
	 }

	 public int getNumDice() {
		 return numDice;
	 }

	 public void setNumDice(int numDice) {
		 this.numDice = numDice;
	 }

	 public int getDiceSize() {
		 return diceSize;
	 }

	 public void setDiceSize(int diceSize) {
		 this.diceSize = diceSize;
	 }

	 public int getQuantity() {
		 return quantity;
	 }
	 
	 public void setQuantity(int quantity) {
		 this.quantity = quantity;
	 }
	 
	 public Ability[] getEquipAbilities() {
		 return equipAbilities;
	 }

	 public void setEquipAbilities(Ability[] equipAbilities) {
		 this.equipAbilities = equipAbilities;
	 }
}
