package com.lpwm.joaquim.roles;

import com.lpwm.joaquim.Player;
//Hero type (role) doesn't change his attack points or his life because those values are manage with xp.

public class Warrior extends Player {

    private static String type = "Warrior";

    public Warrior(String name) {
        super(name, type);

        this.playerSpecialAttack = "You charge the enemy.";
    }

}