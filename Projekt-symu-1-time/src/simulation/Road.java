package simulation;


import java.util.ArrayList;

public class Road {
    public double cellSize = 1.0;
    private final int length;
    private final int beginning;
    private final int end;

    public int[] flow = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


    public Road(int beginning, int end){
        this.length = end - beginning;
        this.beginning = beginning;
        this.end = end;
    }
    public int getLength(){
        return length;
    }
}
