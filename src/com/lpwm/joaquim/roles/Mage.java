package com.lpwm.joaquim.roles;

import com.lpwm.joaquim.Player;
//Hero type (role) doesn't change his attack points or his life because those values are manage with xp.

public class Mage extends Player {

    private static String type = "Mage";

    public Mage(String name) {
        super(name, type);

        this.playerSpecialAttack = "You cast a spell on the enemy.";
        // this.playerSpecialAttack = "You throw a fireball at the enemy.";
    }

}
