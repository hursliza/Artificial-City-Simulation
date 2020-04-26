package simulation;

import java.util.Random;

public class Car {
    private int carID;
    private int roadID;

    private int progress;
    private int target;

    public enum Color {
        BLACK, WHITE, GRAY, SILVER, GOLD, RED, GREEN, BLUE;
    }

    private Color color;

    private int velocity;
    private int maxVelocity;

    private static int idCounter = 0;

    public Car(int velocity, int maxVelocity){
        idCounter++;
        this.carID = idCounter;
        this.progress = 0;
        this.target = new Random().nextInt(1);
        this.color = Color.values()[new Random().nextInt(Color.values().length)];
        this.velocity = velocity;
        this.maxVelocity = maxVelocity;
    }

    public void putOnRoad(int roadID){
        this.roadID = roadID;
    }
}
