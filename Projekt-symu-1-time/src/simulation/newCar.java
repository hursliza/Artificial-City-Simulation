package simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class newCar {
    static int i =-1;
    ArrayList<Car> cars;

    public newCar(ArrayList<Car> cars) {
        this.cars = cars;
    }



    public void NEWcar( int j,ArrayList<Car> cars, LinkedList<LinkedList<Integer>> queues , Algo algo ) {
        int id_od_road = new Random().nextInt(100);
        //int id_od_road = j%7;
        if (whatroad(id_od_road, cars, queues) == -1) {

        } else if (canAdd(j)){
            algo.addCar(get_id_of_newCar(), whatroad(id_od_road, cars, queues));
        }
    }

    public int get_id_of_newCar() {
        for(int carID= 0; carID<400; carID++){
            if(cars.get(carID).getAvailability()){
                return carID;
            }
        }
        return -1;
    }


    public int whatroad(int idRoad, ArrayList<Car> cars, LinkedList<LinkedList<Integer>> queues ) {
        // int[] poczatki = {0, 2, 3, 6, 13, 15, 17};
        int roadID;
        if (idRoad <= 28){
            roadID = 0;
        }
        else if (idRoad <= 41){
            roadID = 2;
        }
        else if (idRoad <= 51){
            roadID = 3;
        }
        else if (idRoad <= 61){
            roadID = 6;
        }
        else if (idRoad <= 70){
            roadID = 13;
        }
        else if (idRoad <= 80){
            roadID = 15;
        }
        else{
            roadID = 17;
        }

        if (queues.get(roadID).isEmpty()) {
            return roadID;
        } else {
            if (cars.get(queues.get(roadID).getFirst()).getProgress() > 10) {
                return roadID;
            }
            return -1;

        }
    }

    boolean canAdd(int time){
        double timeCoeff = 0;
        if (time <= 21600 || time >= 75600){ //przed 6 i po 21
            timeCoeff = 0.03;
        }
        else if(time <= 25200){ // 6-7
            timeCoeff = 0.2;
        }
        else if(time <= 32400){ // 7-9
            timeCoeff = 0.4;
        }
        else if(time <= 39600){ // 9-11
            timeCoeff = 0.3;
        }
        else if(time <= 54000){ // 11-15
            timeCoeff = 0.15;
        }
        else if(time <= 61200){ //15-17
            timeCoeff = 0.35;
        }
        else if(time <= 68400){ //17-19
            timeCoeff = 0.6;
        }
        else if(time <= 72000){ //19-20
            timeCoeff = 0.35;
        }
        else if(time <= 75600){
            timeCoeff = 0.15;
        }
        double rand = Math.random();
        if (rand <= timeCoeff) {return true;}
        return false;
    }
}