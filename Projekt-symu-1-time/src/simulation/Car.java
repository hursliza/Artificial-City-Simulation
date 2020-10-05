package simulation;

import java.util.Random;

public class Car {
    private boolean availability = true;
    private int progress;
    private int target;

    public enum Color {
        BLACK, WHITE, GRAY, SILVER, GOLD, RED, GREEN, BLUE
    }

    private Color color;
    private int velocity;
    private final int maxVelocity;


    public Car(int velocity, int maxVelocity,int target){
        this.progress = 0;
        this.target = new Random().nextInt(2);

        //this.target = target%2;
        this.color = Color.values()[new Random().nextInt(Color.values().length)];
        this.velocity = velocity;
        this.maxVelocity = maxVelocity;
    }


    public void setAvailability(boolean newState){
        availability = newState;
    }


    public void setVelocity(int newVelocity){
         velocity = newVelocity;
    }

    public void setProgress(int newPrograss){
        progress = newPrograss;
    }


    public int getMaxVelocity(){
        return maxVelocity;
    }

    public int getVelocity(){
        return velocity;
    }

    public int getTarget(){
        return target;
    }

    public boolean getAvailability(){
        return availability;
    }

    public int getProgress(){
        return progress;
    }



}
