package com.lpwm.joaquim;

import java.util.ArrayList;

public class Player extends Character{
	
	//player class
	public static String playerRole;
	public String playerSpecialAttack;

	// integers to store number of upgrades/skills in each path
	public int numAtkUpgrades, numDefUpgrades;

	// additional player stats
	int gold, restsLeft, pots;

	// Arrays to store skill names
	public String[] atkUpgrades = { "Strength", "Power", "Might", "Godlike Strength" };
	public String[] defUpgrades = { "Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura" };

	// Array to store purchased weapons
	public ArrayList<Weapon> weapons = new ArrayList<>();

	// Player specific constructor
	public Player(String name, String type) {
		// calling constructor of superclass
		super(name, 100, 0);
		playerRole = type;

		// Setting # of upgrades to 0
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		// set additional stats
		this.gold = 5;
		this.restsLeft = 0;
		this.pots = 0;
		// let the player choose a trait when creating a new character
		chooseTrait();
	}

	// let the player choose a trait of either skill path
	public static void selectRole() {
		Game.clearConsole();
		Game.printHeading("Choose your hero type:");
		System.out.println("(1) Mage");
		System.out.println("(2) Warrior");
		// get the players choice:
		int input = Game.readInt("-> ", 2);
		Game.clearConsole();
		// deal with both cases
		if (input == 1) {
			Game.printHeading("You chose Mage !");
			playerRole = "mage";
		}else{
			Game.printHeading("You chose Warrior !");
			playerRole = "warrior";
		}
		Game.anythingToContinue();
	}

	//Player specific methods (more in the next part)
	@Override
	public int attack() {
		if (!weapons.isEmpty()) {
			System.out.println(weapons.get(0).name);
			return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1 + (weapons.get(0).bonus/2));
		}
		else {
			return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
		}
	}

	@Override
	public int defend() {
		if (!weapons.isEmpty()) {
			return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1 + (weapons.get(0).bonus/2));
		}
		else {
			return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
		}
	}
	
	//let the player choose a trait of either skill path
	public void chooseTrait(){
		Game.clearConsole();
		Game.printHeading("Choose a trait:");
		if(numAtkUpgrades < 4)
			System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		if(numDefUpgrades < 4)
			System.out.println("(2) " + defUpgrades[numDefUpgrades]);
			
		//get the players choice:
		int input = Game.readInt("-> ", 2);
		Game.clearConsole();
		//deal with both cases
		if(input == 1){
			Game.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
			numAtkUpgrades++;
		}else{
			Game.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
			numDefUpgrades++;
		}
		Game.anythingToContinue();
	}

	//method to add the purchased weapons in the player inventory
	public void getNewWeapon(Weapon newWeapon) {
		weapons.clear(); //Temporary clearing weapons list to only have one weapon at a time //Todo: Allow to keep several weapons and switch from one to another
		weapons.add(newWeapon);
		System.out.println(newWeapon.name+" has been added to your inventory !");
	}
}