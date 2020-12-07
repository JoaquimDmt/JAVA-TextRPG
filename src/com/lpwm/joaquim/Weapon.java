package com.lpwm.joaquim;

public abstract class Weapon {
    //Variables / Attributes all characters have
	public String name;
	public int price, bonus;
	
	//Constructor for character
	public Weapon (String name, int price, int bonus) {
		this.name = name;
		this.price = price;
		this.bonus = bonus; //weapon xp bonus boost the attack of the player but also his defense (attack is the best defense ^^)
	}
}
