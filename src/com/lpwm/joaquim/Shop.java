package com.lpwm.joaquim;

import java.util.ArrayList;

import com.lpwm.joaquim.weapons.DamagedIronAxe;
import com.lpwm.joaquim.weapons.DestinySword;
import com.lpwm.joaquim.weapons.ElderWand;
import com.lpwm.joaquim.weapons.IstariRing;
import com.lpwm.joaquim.weapons.SharpShield;
import com.lpwm.joaquim.weapons.WizardStaff;

public class Shop extends Game {

    //shop list items
    private ArrayList<Weapon> weapons = new ArrayList<>();
    public int weaponNumber = 0;

    // generating every weapon to store them in the shop
    public void generateWeapons() {
        if (Player.playerRole.equalsIgnoreCase("mage")) {
            weapons.add(new WizardStaff());
            weapons.add(new IstariRing());
            weapons.add(new ElderWand());
        } else if (Player.playerRole.equalsIgnoreCase("warrior")) {
            weapons.add(new DamagedIronAxe());
            weapons.add(new SharpShield());
            weapons.add(new DestinySword());
        }
    }

    public void enter() {
        clearConsole();
        System.out.println("     88                                                  88     ");
        System.out.println(" .d88888b.          _____ _   _ ___________          .d88888b.  ");
        System.out.println("d88P 88\"88b        /  ___| | | |  _  | ___ \\        d88P 88\"88b");
        System.out.println("Y88b.88            \\ `--.| |_| | | | | |_/ /        Y88b.88     ");
        System.out.println(" \"Y88888b.          `--. \\  _  | | | |  __/          \"Y88888b. ");
        System.out.println("     88\"88b        /\\__/ / | | \\ \\_/ / |                 88\"88b");
        System.out.println("Y88b 88.88P        \\____/\\_| |_/\\___/\\_|            Y88b 88.88P ");
        System.out.println(" \"Y88888P\"                                           \"Y88888P\"");
        System.out.println("     88                                                  88     \n");

        printSeperator(63);
        System.out.println("Gold : " + player.gold + " ©\t🛈 keep your money for potions you'll need it lol ");
        printSeperator(63);

        generateWeapons();

        System.out.printf("%-5s %-15s %20s %20s %n", "#", "WEAPON", "BONUS", "PRICE");
        printSeperator(63);

        for (Weapon weapon : weapons) {
            weaponNumber++;
            System.out.printf("%-5s %-15s %20d %20s %n", "("+weaponNumber+")", weapon.name, weapon.bonus, weapon.price+" ©");
        }
        printSeperator(63);

        while(true){
            int input = readInt("\nSelect the weapon you want or press (4) to return to menu : ", weapons.size()+1);

            if(input == 1)
                try {
                    buy(weapons.get(0));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            else if(input == 2)
                try {
                    buy(weapons.get(1));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            else if(input == 3)
                try {
                    buy(weapons.get(2));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            else if(input == 4)
                return;
        }
    }

    public void buy(Weapon newWeapon) {
        if (player.gold >= newWeapon.price) {
            player.gold -= newWeapon.price;
            System.out.println("You bought the "+newWeapon.name+" for "+newWeapon.price+" ©.");
            player.getNewWeapon(newWeapon);
        }
        else {
            System.out.println("Sorry but you don't have enough gold to buy this weapon.");
        }
    }

	public class enter {
	}
}