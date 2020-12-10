package com.lpwm.joaquim;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Map (2D)
 * 
 * Mini game between each Act through which the player must find his way among the obstacles 
 */

public class Map {

    public int size, x , y;
    public String direction;
    public boolean generated = false;
    public static boolean lost = true;
    static Scanner scanner = new Scanner(System.in);

    ArrayList<Obstacle> obstacles = new ArrayList<>();

    public Map(int size, int x, int y) {
        this.size = size; //number of ligns & columns
        this.x = x;
        this.y = y;
    }

    public void start(String scenario) {
        Map m = new Map(size, x, y);
        while (lost) {
            m.showMap(scenario);
            String input = scanner.next();
                if(input.equalsIgnoreCase("z"))
                    m.moveUp(2);
                else if(input.equalsIgnoreCase("q"))
                    m.moveLeft(3);
                else if(input.equalsIgnoreCase("s"))
                    m.moveDown(2);
                else if (input.equalsIgnoreCase("d"))
                    m.moveRight(3);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            m.finishPoint();
        }
        lost=true; //reseting lost value to true for the next map
    }

	public void showMap(String scenario) {
        System.out.println(scenario);
        System.out.println(".---------------------------------------------.");
        //print ligns
		for (int i = 0; i < size; i++) {
            System.out.print("|");
            //print columns in each lign
			for (int j = 0; j < size*3; j++) {
                if (this.y == i && this.x == j)
                    System.out.print("X");
                else{
                    //first time need to create obstacle
                    if (generated == false){
                        if (i== 0 && j == 43)
                            System.out.print("░");
                        else if (Math.random()*20 > 18.5){
                            System.out.print("■");
                            obstacles.add(new Obstacle(j, i));
                        }
                        else
                            System.out.print(" ");
                    }
                    //then we need to keep the obstacles each time at the same place
                    else if (generated == true){
                        if (i== 0 && j == 43)
                            System.out.print("░");
                        else if (equivObstaclePosition(j,i)) //!
                            System.out.print("■");
                        else
                            System.out.print(" ");
                    }
                }
			}
			System.out.println("|");
        }
        generated = true;
        // System.out.println(obstacles.size());
        System.out.println("'---------------------------------------------'");
        System.out.println("      UP: Z | LEFT: Q | DOWN: S | RIGHT: D");
        Game.printSeperator(48);
	}
	
	private boolean equivObstaclePosition(int j, int i) {
        for (Obstacle obstacle : obstacles){
            if (j == obstacle.x && i == obstacle.y)
                return true;
        }
        return false;
    }

    private boolean hitObstacle(int j, int i) {
        switch (direction) {
            case "top":
                if (equivObstaclePosition(j, this.y+2))
                    return true;
                break;
            case "left":
                if (equivObstaclePosition(this.x-3, i))
                    return true;
                break;
            case "bottom":
                if (equivObstaclePosition(j, this.y-2))
                    return true;
                break;
            case "right":
                if (equivObstaclePosition(this.x+3, i))
                    return true;
                break;
            default:
                break;
        }
        return false;
    }

    public void moveUp(int step) {
        direction = "top";
		if(this.y>1 && !hitObstacle(this.x, this.y)){ 
			this.y-=step;
		}
	}

    public void moveLeft(int step) {
        direction = "left";
		if(this.x>1 && !hitObstacle(this.x, this.y)){ 
			this.x-=step;
		}
	}
	
	public void moveDown(int step) {
        direction = "top";
		if(this.y<14 && !hitObstacle(this.x, this.y)){ 
			this.y+=step;
		}
    }
    
    public void moveRight(int step) {
        direction = "right";
		if(this.x<42 && !hitObstacle(this.x, this.y)){ 
			this.x+=step;
		}
    }
    
    public void finishPoint(){
        if(this.x == 43 && this.y == 0){
            lost = false;
        }
    }

}