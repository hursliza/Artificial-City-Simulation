package simulation;

import java.util.Random;

public class Car {
    private int position;
    private int nextPosition;

    private int velocity;
    private int nextVelocity;
    private int maxVelocity;

    private int acceleration;
    private int maxAcceleration;

    int p;  //rule of random, e.g. probability of deceleration is 1/3 then p is 3

    public Car(int _position, int _velocity, int _acceleration)
    {
        this.position = _position;
        this.velocity = _velocity;
        this.acceleration = _acceleration;
    }

    void calculateNextVelocity(Car nextCar)
    {
        int nextVelocity = this.getVelocity();
        int gap = nextCar.getPosition() - this.getPosition();

        //rule of acceleration:
        if (this.getVelocity() <= this.getMaxVelocity())
        {
            nextVelocity = Math.min(this.getMaxVelocity(), this.getVelocity() + 1);
        }

        //rule of deceleration
        if (this.getVelocity() > gap)
        {
            nextVelocity = gap;
        }

        //rule of random
        boolean randDeceleration = new Random().nextInt(p) == 0;
        if (randDeceleration)
        {
            nextVelocity = Math.max(nextVelocity - 1, 0);
        }

        this.setNextVelocity(nextVelocity);
    }

    void calculateNextPosition()
    {
        this.setNextPosition(this.getPosition() + this.getVelocity());
    }

    void applyCalculations()
    {
        this.setPosition(this.getNextPosition());
        this.setVelocity(this.getNextVelocity());
    }

    public int getPosition() {
        return position;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public int getNextVelocity() {
        return nextVelocity;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }


    public void setPosition(int position) {
        this.position = position;
    } //availability of the position must be checked

    public void setNextPosition(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    public void setVelocity(int velocity) {
        if (velocity > 0)
        {
            this.velocity = velocity;
        }
        else
        {
            this.velocity = 0;
        }
    }

    public void setNextVelocity(int nextVelocity) {
        if (nextVelocity < this.getMaxVelocity())
        {
            this.nextVelocity = nextVelocity;
        }
        else
        {
            this.nextVelocity = this.getMaxVelocity();
        }
    }

    public void setMaxVelocity(int maxVelocity) {
        if (maxVelocity > 0) {
            this.maxVelocity = maxVelocity;
        }
    }

    @Override
    public String toString() {
        String info = new String("");
        info += "Current position: ";
        info += this.position;
        info += "\nVelocity: ";
        info += this.velocity;
        info += "\nAcceleration";
        info += this.nextVelocity - this.velocity;
        info += "\n";
        return info;
    }
}
