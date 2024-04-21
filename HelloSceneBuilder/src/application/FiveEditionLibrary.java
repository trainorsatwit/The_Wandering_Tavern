package application;

public class FiveEditionLibrary {
	
	public static void makeLibrary(CharacterSheet sheet) {
		
		boolean[] emptyArmorReq = new boolean[4];
		boolean[] emptyWeaponReq = new boolean[2];
		int[] emptyMods = new int[6];
		Ability[] emptyAbil = new Ability[0];
		
		/*
		 * Races
		 */
		
		//Dwarf
		if(sheet.getRace().equals("Dwarf"))
		{

			//Stat Increase, Speed, & Language Prof
			sheet.changeStat(2, 2); //Con + 2
			sheet.changeStat(4, 1); //Wis + 1
			sheet.setSpeed(25); 
			sheet.addLanguage(new int[] {0,1}); //Common, Dwarvish
			
			
			//Race Option
			if(sheet.getRaceOp() == 1) {
				sheet.addToolProf("Smith's Tools");}
			else if(sheet.getRaceOp() == 2) {
				sheet.addToolProf("Brewer's Supplies");}
			else {
				sheet.addToolProf("Mason's Tools");}
			
			
			//List of Racial Abilities
			sheet.addAbility(createAbility("Dark Vision", "Accustomed to life underground, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can�t discern color in darkness, only shades of gray.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			sheet.addAbility(createAbility("Dwarven Resilience", "You have advantage on saving throws against poison, and you have resistance against poison damage.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			sheet.addAbility(createAbility("Dwarven Combat Training", "You have proficiency with the battleaxe, handaxe, light hammer, and warhammer.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			sheet.addAbility(createAbility("Tool Proficiency	", "You gain proficiency with the artisan�s tools of your choice: smith�s tools, brewer�s supplies, or mason�s tools.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			sheet.addAbility(createAbility("Dwarven Resilience", "Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
		}
		
		
		//(Race)
		if(sheet.getRace().equals("(Race)")) {
			
			
			//Stat Increase, Speed, & Language Prof
			
			
			//Race Option
			
			
			//List of Racial Abilities
			
			
		}
		
		
		//(Race)
		if(sheet.getRace().equals("(Race)")) {
			
			
			//Stat Increase, Speed, & Language Prof
			
			
			//Race Option
			
			
			//List of Racial Abilities
			
			
		}
		
		
		//(Race)
		if(sheet.getRace().equals("(Race)")) {
			
			
			//Stat Increase, Speed, & Language Prof
			
			
			//Race Option
			
			
			//List of Racial Abilities
			
			
		}
		
		
		//(Race)
		if(sheet.getRace().equals("(Race)")) {
			
			
			//Stat Increase, Speed, & Language Prof
			
			
			//Race Option
			
			
			//List of Racial Abilities
			
			
		}
		
		
		/*
		 * Equipment
		 */
		
		Equipment holySymbol = createEquipment("A Holy Symbol", "A holy symbol (a gift to you when you entered the priesthood)", emptyArmorReq, emptyWeaponReq, false, 0, 0, 1, emptyAbil);
		Equipment prayerBook = createEquipment("A Prayer Book", "A prayer book", emptyArmorReq, emptyWeaponReq, false, 0, 0, 1, emptyAbil);
		Equipment prayerWheel = createEquipment("A Prayer Wheel", "A prayer wheel", emptyArmorReq, emptyWeaponReq, false, 0, 0, 1, emptyAbil);
		Equipment incense = createEquipment("Incense", "A Stick	of	incense", emptyArmorReq, emptyWeaponReq, false, 0, 0, 5, emptyAbil);
		Equipment clothes = createEquipment("Common Clothes", "A set of common clothes", emptyArmorReq, emptyWeaponReq, false, 0, 0, 1, emptyAbil);
		
		
		/*
		 * Backgrounds
		 */
		
		//Acolyte
		if(sheet.getBackground().equals("Acolyte"))
		{

			//Skill Proficiencies & Gold
			sheet.addSkillProf(new int[] {6,14});//Insight & Religion
			sheet.setGold(15);

			
			//Background Options
			int[] backOps = sheet.getBackOps();
			
			if(backOps[0] == 1) { //Acolyte chooses between these two.
				sheet.addEquipment(prayerBook);}
			else{
				sheet.addEquipment(prayerWheel);}
			
			sheet.addLanguage(new int[] {backOps[1],backOps[2]}); //Acolytes pick two languages.
			
			
			//Abilities
			sheet.addAbility(createAbility("Shelter of the Faithful", "As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle. You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your temple.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));

			
			//Equipment
			sheet.addEquipment(holySymbol);
			sheet.addEquipment(incense);
			sheet.addEquipment(clothes);
			
			//back = createBackground("Acolyte","You have spent your life in the service of a temple to a specific god or pantheon of gods.You act as an	intermediary between the realm of the holy and the mortal world, performing sacred rites and offering sacrifices in order to conduct worshipers into the presence of the divine. You are not necessarily a cleric � performing sacred rites is not the same thing as channeling divine power.", acoProf, acoLang, emptyTool, backEquip, backAbil);
		}
		
		
		/*
		 * Classes & Subclasses
		 */
		
		//Barbarian
		if(sheet.getMainClass().equals("Barbarian"))
		{
			
			//Class Proficiencies & Armor
			int[] savingThrows = sheet.getModValues();
			savingThrows[0] += sheet.getProficiency(); //Strength Prof
			savingThrows[2] += sheet.getProficiency(); //Constitution Prof
			sheet.setSavingThrows(savingThrows);
			sheet.setArmorProf(new boolean[] {true,true,false,true}); //Light, Medium, Shield
			
			//Hit Points Calculation: (hit die) + (AVG hit die * lvl) + (constitution * lvl)
			int max = (12) + (7 * sheet.getLevel() + (sheet.getModValues()[2] * sheet.getLevel()));
			sheet.setMaxHP(max);
			
			int amountOfChoices = 2;
			
			/* 
			 * [1] = Animal Handling
			 * [3] = Athletics
			 * [7] = Intimidation
			 * [10] = Nature
			 * [11] = Perception
			 * [17] = Survival
			 */
			sheet.addSkillProf(new int[] {0,1});//Acrobatics & Animal Handling
			
			
			//Class Abilities
			if(sheet.getLevel() == 20)
			{
				int[] primalMods = {4,0,4,0,0,0};
				sheet.addAbility(createAbility("Primal Champion", "At 20th level, you embody the power of the wilds. Your Strength and Constitution scores increase by 4. Your maximum for those scores is now 24.", -1, primalMods, 0, 0, 0, 0, 0, 0, 0, ""));
			}
			if(sheet.getLevel() >= 18)
			{
				sheet.addAbility(createAbility("Indomitable Might", "Beginning at 18th level, if your total for a Strength check is less than your Strength score, you can use that score in place of the total.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			}
			if(sheet.getLevel() >= 15)
			{
				sheet.addAbility(createAbility("Persistent Rage", "Beginning at 15th level, your rage is so fierce that it ends early only if you fall unconscious or if you choose to end it.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			}
			if(sheet.getLevel() >= 11)
			{
				sheet.addAbility(createAbility("Relentless Rage", "Starting at 11th level, your rage can keep you fighting despite grievous wounds. If you drop to 0 hit points while you�re raging and don�t die outright, you can make a DC 10 Constitution saving throw. If you succeed, you drop to 1 hit point instead. Each time you use this feature after the first, the DC increases by 5. When you finish a short or long rest, the DC resets to 10.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			}
			if(sheet.getLevel() >= 9)
			{
				sheet.addAbility(createAbility("Brutal Critical", "Starting at 9th level, you can roll one additional weapon damage die when determining the extra damage for a critical hit with a melee attack. This increases to two additional dice at 13th level and three additional dice at 17th level.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			}
			if(sheet.getLevel() >= 7)
			{
				sheet.addAbility(createAbility("Feral Instinct", "By 7th level, your instincts are so honed that you have advantage on initiative rolls. Additionally, if you are surprised at the beginning of combat and aren�t incapacitated, you can act normally on your first turn, but only if you enter your rage before doing anything else on that turn.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			}
			if(sheet.getLevel() >= 5)
			{
				sheet.addAbility(createAbility("Extra Attack", "Starting at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
				sheet.addAbility(createAbility("Fast Movement", "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 10, ""));
			}
			if(sheet.getLevel() >= 2)
			{
				sheet.addAbility(createAbility("Reckless Attack", "Starting at 2nd level, you can throw aside all concern for defense to attack with fierce desperation. When you make your first attack on your turn, you can decide to attack recklessly. Doing so gives you advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against you have advantage until your next turn.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
				sheet.addAbility(createAbility("DangerSense", "At 2nd level, you gain an uncanny sense of when things nearby aren�t as they should be, giving you an edge when you dodge away from danger. You have advantage on Dexterity saving throws against effects that you can see, such as traps and spells. To gain this benefit, you can�t be blinded, deafened, or incapacitated.", -1, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			}
			sheet.addAbility(createAbility("Unarmored Defense", "While you are not wearing any armor, your Armor Class equals 10 + your Dexterity modifier + your Constitution modifier. You can use a shield and still gain this benefit.", -1, emptyMods, (10 + sheet.getModValues()[1] + sheet.getModValues()[2]), 0, 0, 0, 0, 0, 0, ""));
			sheet.addAbility(createAbility("Rage", "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.\r\n"
					+ "\r\n"
					+ "While raging, you gain the following benefits if you aren't wearing heavy armor:\r\n"
					+ "\r\n"
					+ "You have advantage on Strength checks and Strength saving throws.\r\n"
					+ "When you make a melee weapon attack using Strength, you gain a bonus to the damage roll that increases as you gain levels as a barbarian.\r\n"
					+ "You have resistance to bludgeoning, piercing, and slashing damage.\r\n"
					+ "If you are able to cast spells, you can't cast them or concentrate on them while raging.\r\n"
					+ "\r\n"
					+ "Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action.\r\n"
					+ "\r\n"
					+ "Once you have raged the number of times shown for your barbarian level in the Rages column of the Barbarian table, you must finish a long rest before you can rage again.", 2, emptyMods, 0, 0, 0, 0, 0, 0, 0, ""));
			
			
			//Subclass Abilities
			if(sheet.getLevel() >= 3)
			{
				if(sheet.getSubClass().equals("Berserker"))
				{
					if(sheet.getLevel() >= 14)
					{
						
					}
					if(sheet.getLevel() >= 10)
					{
						
					}
					if(sheet.getLevel() >= 6)
					{
					
					}
				}		
			}
		}
		
		
		//(Class)
		if(sheet.getClass().equals("(Class)")) {
			
			
			//Class Proficiencies (incomplete)
			
			
			//Class Abilities
			
			
			//Subclass Abilities
			
			
		}
		
		
		//(Class)
		if(sheet.getClass().equals("(Class)")) {
			
			
			//Class Proficiencies (incomplete)
			
			
			//Class Abilities
			
			
			//Subclass Abilities
			
			
		}
		
		
		//(Class)
		if(sheet.getClass().equals("(Class)")) {
			
			
			//Class Proficiencies (incomplete)
			
			
			//Class Abilities
			
			
			//Subclass Abilities
			
			
		}
		
		
		//(Class)
		if(sheet.getClass().equals("(Class)")) {
			
			
			//Class Proficiencies (incomplete)
			
			
			//Class Abilities
			
			
			//Subclass Abilities
			
			
		}
		
		
		
		
		
		//Create the ASI. MOVE TO UI
		
		/*
		int numOfASI;
		if(sheet.getClass().equals("Fighter"))
		{
			if(sheet.getLevel() == 19)
				numOfASI=7;
			else if(sheet.getLevel() == 16)
				numOfASI=6;
			else if(sheet.getLevel() == 14)
				numOfASI=5;
			else if(sheet.getLevel() == 12)
				numOfASI=4;
			else if(sheet.getLevel() == 8)
				numOfASI=3;
			else if(sheet.getLevel() == 6)
				numOfASI=2;
			else if(sheet.getLevel() == 4)
				numOfASI=1;
			else
				numOfASI=0;
		}
		else if(sheet.getClass().equals("Rogue"))
		{
			if(sheet.getLevel() == 19)
				numOfASI=6;
			else if(sheet.getLevel() == 16)
				numOfASI=5;
			else if(sheet.getLevel() == 12)
				numOfASI=4;
			else if(sheet.getLevel() == 10)
				numOfASI=3;
			else if(sheet.getLevel() == 8)
				numOfASI=2;
			else if(sheet.getLevel() == 4)
				numOfASI=1;
			else
				numOfASI=0;
		}
		else
		{
			if(sheet.getLevel() >= 19)
				numOfASI=5;
			else if(sheet.getLevel() >= 16)
				numOfASI=4;
			else if(sheet.getLevel() >= 12)
				numOfASI=3;
			else if(sheet.getLevel() >= 8)
				numOfASI=2;
			else if(sheet.getLevel() >= 4)
				numOfASI=1;
			else
				numOfASI=0;
		}
		for(int i = 0; i < numOfASI; i++)
		{
			if(inASI.equals("Grappler"))
			{
				asiList[asiP] = createASI("Grappler", "", 4, emptyMods, emptyAbil);
				asiP++;
			}
			else
			{
				for(int j = 0; j < asiIncrease.length; j++)
				{
					asiMods[j] = asiMods[j] + asiIncrease[j];
				}
				break;
			}
		}
		*/
		
		//Create basic actions
	}
	
	public static Ability createAbility(String name, String desc, int actionType, int[] statModifier,int acCalc, int acBonus, int saBonus, int profBonus, int diceNum, int diceSize, int bonusVal, String bonusText) {
		return new Ability(name, desc, actionType, statModifier, acCalc, acBonus, saBonus, profBonus, diceNum, diceSize,bonusVal, bonusText);
	}
	
	public static Equipment createEquipment(String name, String desc, boolean[] armorProfReq, boolean[] weaponProfReq, boolean finesse, int numDice, int diceSize, int quantity, Ability[] equipAbilities){
		return new Equipment(name,desc,armorProfReq,weaponProfReq,finesse,numDice,diceSize,quantity, equipAbilities);
	}

}
