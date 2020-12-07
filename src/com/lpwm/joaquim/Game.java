package com.lpwm.joaquim;

import java.util.Scanner;

import com.lpwm.joaquim.roles.Mage;
import com.lpwm.joaquim.roles.Warrior;

/**
 * Game
 * 
 * The core of the project
 */

public class Game {
    
    static Scanner scanner = new Scanner(System.in);

    static Player player;
    
    public static boolean isRunning;
    
    //random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Battle", "Battle"}; // values in Act I.
    
    //enemy names
    public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"}; // values in Act I.
    
    //Story elements
    public static int place = 0, act = 1;
    public static boolean escape_possible = true, shop_open = true;
    private static Shop shop;
    public static String[] places = {"Everlasting Mountains", "Haunted Lands", "Castle of the Evil Emperor", "Throne Room"};

    /**
     * startGame()
     * 
     * method to start the game
     */
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //print title screen
        clearConsole();
        System.out.println("        _    .  ,   .           .");
        System.out.println("    *  / \\_ *  / \\_      _  *        *   /\\'__        * ");
        System.out.println("      /    \\  /    \\,   ((        .    _/  /  \\  *'.");
        System.out.println(" .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.");
        System.out.println("    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *");
        System.out.println("  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\");
        System.out.println(" /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-");
        System.out.println("/        `.  / /       `.~-^=-=~=^=.-'      '-._ `._");
        printSeperator(55);
        System.out.println("                RISE OF THE EVIL EMPEROR");
        System.out.println("              TEXT RPG BY JOAQUIM DIMITROV");
        printSeperator(55);
        anythingToContinue();
        
        //getting the player name
        do{
            clearConsole();
            printHeading("What's your name?");
            name = scanner.next();
            //asking the player if he wants to correct his choice
            clearConsole();
            printHeading("Your name is " + name.substring(0, 1).toUpperCase() + name.substring(1) + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> " , 2);
            if(input == 1)
                nameSet = true;
        }while(!nameSet);
        
        //print story intro
        Story.printIntro();
        
        //let the player choose a class (Mage or Warrior)
        Player.selectRole();

        //create new player object with the name
        if(Player.playerRole.equalsIgnoreCase("mage"))
            player = new Mage(name);
        else
            player = new Warrior(name);
        
        //print first story act intro
        Story.printFirstActIntro();

        clearConsole();
        Map walk = new Map(15, 1, 14);
        walk.start("\t\tLeaving the village");
        
        //setting isRunning to true, so the game loop can continue
        isRunning = true;
        
        //start main game loop
        gameLoop();
    }


    /**
     * Scanner & Print methods
     */
    
        //method to get user input from console
        public static int readInt(String prompt, int userChoices){
            int input;
            
            do{
                System.out.println(prompt);
                try{
                    input = Integer.parseInt(scanner.next());
                }catch(Exception e){
                    input = -1;
                    System.out.println("Please enter an integer!");
                }
            }while(input < 1 || input > userChoices);
            return input;
        }
        
        //method to simulate clearing out the console
        public static void clearConsole(){
            for(int i = 0; i < 100; i++)
                System.out.println();
        }
        
        //method to print a seperator with length n
        public static void printSeperator(int n){
            for(int i = 0; i < n; i++)
                System.out.print("-");
            System.out.println();
        }
        
        //method to print a heading
        public static void printHeading(String title){
            printSeperator(30);
            System.out.println(title);
            printSeperator(30);
        }
        
        //method to stop the game until user enters anything
        public static void anythingToContinue(){
            System.out.println("\nEnter anything to continue...");
            scanner.next();
        }


    /**
     * Menu choices methods
     */
    
    //main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            if(shop_open == true){
                int input = readInt("-> ", 4);
                if(input == 1)
                    continueJourney();
                else if(input == 2)
                    characterInfo();
                else if(input == 3) {
                    shop = new Shop(); //new instance to avoid the increment of shop items each time (avoiding static)
                    shop.enter();
                }
                else {
                    System.out.println("\033[0;31mGAME OVER\033[0m");
                    isRunning = false;
                }
            // dealing with the case of the Boss: not allowed to purchase at this moment
            } else {
                int input = readInt("-> ", 3);
                if(input == 1)
                    continueJourney();
                else if(input == 2)
                    characterInfo();
                else {
                    System.out.println("\033[0;31mGAME OVER\033[0m");
                    isRunning = false;
                }
            }
        }
    }

    //printing the main menu
    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeperator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        if(shop_open == true){
            System.out.println("(3) Shop");
            System.out.println("(4) Exit Game");
        }
        else {
            System.out.println("(3) Exit Game");
        }
    }

    //printing out the most important information about the player character
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO - Name : " + player.name.substring(0, 1).toUpperCase() + player.name.substring(1));
        System.out.println("Class: " + Player.playerRole + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperator(20);
        //player xp and gold
        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        printSeperator(20);
        //# of pots
        System.out.println("# of Potions: " + player.pots);
        printSeperator(20);
        
        //printing the chosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeperator(20);
        }

        //printing the inventory (weapons)
        if(player.weapons.size() > 0){
            String weaponsList = "";
            for(Weapon weapon : player.weapons){
                weaponsList += weapon.name;
            }
            System.out.println("Weapons: " + weaponsList + " (bonus: "+player.weapons.get(0).bonus+")");
        }
        
        anythingToContinue();
    }

    //method to continue the journey (more next part)
    public static void continueJourney(){
        //check if act must be increased
        checkAct();
        //check if game isn't in "last" act (Act IV)
        if(act != 4)
            randomEncounter();
    }


    /**
     * In-game methods
     */
    
    //method that changes the game's values based on player xp
    public static void checkAct(){
        //change acts based on xp
        if(player.xp >= 10 && act == 1){

            clearConsole();
            Map m = new Map(15, 1, 14);
            m.start("\tCrossing the Frozen Caves");

            //increment act and place
            act = 2;
            place = 1;
            //story
            Story.printFirstActOutro();
            //let the player "level up"
            player.chooseTrait();
            //story
            Story.printSecondActIntro();
            //assign new values to enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Ork";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Emperor's Minion";
            enemies[4] = "Scary Stranger";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Rest";
            encounters[4] = "Merchant";

        }else if(player.xp >= 50 && act == 2){

            clearConsole();
            Map walk = new Map(15, 1, 14);
            walk.start("\t\tThe Last Bastion");

            //increment act and place
            act = 3;
            place = 2;
            //story
            Story.printSecondActOutro();
            //lvl up
            player.chooseTrait();
            //Story
            Story.printThirdActIntro();
            //assign new values to enemies
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Evil Mercenary";
            enemies[2] = "Henchman of the Evil Emperor";
            enemies[3] = "Henchman of the Evil Emperor";
            enemies[4] = "Henchman of the Evil Emperor";
            //assign new values to encounters
            encounters[0] = "Merchant";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Battle";

            //fully heal the player
            // player.hp = player.maxHp;

        }else if(player.xp >= 100 && act == 3){
            //increment act and place
            act = 4;
            place = 3;
            //story
            Story.printThirdActOutro();
            //lvl up
            player.chooseTrait();
            //story
            Story.printFourthActIntro();
            //fully heal the player
            player.hp = player.maxHp;
            //calling the final battle
            shop_open = false;
            finalBattle();
        }
    }
    
    //method to calculate a random encounter
    public static void randomEncounter(){
        //random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random()* encounters.length);
        //calling the respective methods
        if(encounters[encounter].equals("Battle")){
            randomBattle();
        }else if(encounters[encounter].equals("Rest")){
            takeRest();
        }else{
            merchant();
        }
    }
    
    //shopping / encountering a travelling trader
    public static void merchant(){
        clearConsole();
        printHeading("You meet a mysterious stranger.\nHe offers you something:");
        int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Magic Potion: " + price + " gold.");
        printSeperator(20);
        //ask the player to buy one
        System.out.println("Do you want to buy one? ("+player.gold+" © left)\n(1) Yes!\n(2) No thanks.");
        int input = readInt("-> ", 2);
        //check if player wants to buy
        if(input == 1){
            clearConsole();
            //check if player has enough gold
            if(player.gold >= price){
                printHeading("You bought a magical potion for " + price + " gold.");
                player.pots++;
                player.gold -= price;
            }else
                printHeading("You don't have enough gold to buy this...");
            anythingToContinue();
        }
    }
    
    //taking a rest
    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).");
            System.out.println("(1) Yes\n(2) No, not now.");
            int input = readInt("-> ", 2);
            if(input == 1){
                //player actually takes rest
                clearConsole();
                if(player.hp < player.maxHp){
                    int hpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.hp += hpRestored;
                    if(player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("You took a rest and restored up to " + hpRestored + " health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
                    player.restsLeft--;
                }else
                    System.out.println("You're at full health. You don't need to rest now!");
            }
            anythingToContinue();
        }
    }


    /**
     * Battle Management methods
     */
    
    //creating a random battle
    public static void randomBattle(){
        clearConsole();
        printHeading("You encountered an evil minded creature. You'll have to fight it!");
        anythingToContinue();
        //creating new enemy with random name
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }
    
    //the main BATTLE method
    public static void battle(Enemy enemy){
        //main battle loop
        while(true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name.substring(0, 1).toUpperCase() + player.name.substring(1) + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("\nChoose an action:");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion ("+player.pots+" left)");
            if (escape_possible == true)
                System.out.println("(3) Run Away");

            int input = readInt("-> ", 3);
            //react accordingly to player input
            if(input == 1){
                //FIGHT
                //calculate dmg and dmgTook (dmg enemy deals to player)
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                //check that dmg and dmgTook isn't negative
                if(dmgTook < 0){
                    //add some dmg if player defends very well
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0)
                    dmg = 0;
                //deal damage to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                //print the info of this battle round
                clearConsole();
                printHeading("BATTLE");
                System.out.println(player.playerSpecialAttack);
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeperator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingToContinue();
                //check if player is still alive or dead
                if(player.hp <= 0){
                    playerDied(); //method to end the game
                    break;
                }else if(enemy.hp <= 0){
                    //tell the player he won
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    //increase player xp
                    player.xp += enemy.xp;
                    System.out.println("You earned "+ enemy.xp + " XP!");
                    //random drops
                    boolean addRest = (Math.random()*5 + 1 >= 4.25);
                    int goldEarned = (int) (Math.random()*enemy.xp+1);
                    if(addRest){
                        player.restsLeft++;
                        System.out.println("You earned the chance to get an additional rest!");
                    }
                    if(goldEarned > 0){
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + " gold from the " + enemy.name + "'s corpse!");
                    }
                    anythingToContinue();
                    break;
                }
            }else if(input == 2){
                //USE POTION
                clearConsole();
                if(player.pots > 0 && player.hp < player.maxHp){
                    //player CAN take a potion
                    //make sure player wants to drink the potion
                    printHeading("Do you want to drink a potion? (" + player.pots + " left).");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("-> ", 2);
                    if(input == 1){
                        //player actually took it
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a magic potion. It restored your health back to " + player.maxHp);
                        anythingToContinue();
                    }
                }else{
                    //player CANNOT take a potion
                    printHeading("You don't have any potions or you're at full health.");
                    anythingToContinue();
                }
            }else{
                //RUN AWAY
                clearConsole();
                //check that player isn't in last act (final boss battle)
                if(act != 4){
                    //chance of 35% to escape
                    if(Math.random()*10 + 1 <= 3.5){
                        printHeading("You ran away from the " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    }else{
                        printHeading("You didn't manage to escape.");
                        //calculate dmage the player takes
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry you took " + dmgTook + " damage!");
                        player.hp -= dmgTook;
                        anythingToContinue();
                        //check if player's still alive
                        if(player.hp <= 0)
                            playerDied();
                    }
                }else{
                    printHeading("YOU CANNOT ESCAPE THE EVIL EMPEROR !!!");
                    anythingToContinue();
                }
                
            }
        }
    }
    
    
    //the big fight against the Evil Emperor
    public static void finalBattle(){
        //creating the evil emperor and letting the player fight against him
        battle(new Enemy("THE EVIL EMPEROR", 210));
        
        //story
        Story.printFourthActOutro();
        //lvl up
        player.chooseTrait();
        //story
        Story.printFinalActIntro();
        //fully heal the player
        player.hp = player.maxHp;

        //summoning Balgor Gothmog (Melkor servant)
        trueEnemyBattle();

        //printing the proper ending
        Story.printEnd(player);
        isRunning = false;
        System.exit(0);
    }

    //final battle against the true ennemy (last of the entire game)
    public static void trueEnemyBattle(){
        //creating the Lord of Darkness and letting the player fight against him
        escape_possible = false;
        battle(new Enemy("THE LORD OF DARKNESS", 280));
    }



    
    //method that gets called when the player is dead
    public static void playerDied(){
        clearConsole();
        printHeading("You died...");
        printHeading("You earned " + player.xp + " XP on your journey. Try to earn more next time!");
        System.out.println("Thank you for playing my game. I hope you enjoyed it :)");
        isRunning = false;
        System.exit(0);
    }
    
    
}
