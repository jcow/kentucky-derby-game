package com.mygdx.kdg.lib.creatures;

public class Creature {

    private static final int SPEED_CHANGE_MODIFIER = 1;

    private final String name;
    private final int startingDistance;

    private int x;
    private int y;


    private int distanceLeft;

    private int currentSpeed;
    private int designatedSpeed;



    public Creature(
        String name,
        int startingDistance,
        int x,
        int y
    ) {
        this.name = name;
        this.startingDistance = startingDistance;
        this.distanceLeft = startingDistance;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getStartingDistance() {
        return startingDistance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistanceLeft() {
        return distanceLeft;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void traverseDistance(int amount) {
        this.x += amount;
        this.distanceLeft -= amount;
    }

    public void tickSpeed() {
        if(currentSpeed != designatedSpeed) {
            if(currentSpeed - designatedSpeed < 1) {
                this.currentSpeed += SPEED_CHANGE_MODIFIER;
            }
            else {
                this.currentSpeed -= SPEED_CHANGE_MODIFIER;
            }
        }
    }

    public void changeSpeed(int newDesignatedSpeed) {
        this.designatedSpeed = newDesignatedSpeed;
    }

}
