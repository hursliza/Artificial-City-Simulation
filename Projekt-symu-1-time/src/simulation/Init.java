package simulation;


import java.util.*;

public class Init {
    //int limit = 5;
     ArrayList<Car> cars;
     ArrayList<Road> roads;


    public void initRoads(){
        Road road1 = new Road( 1 ,200);
        Road road2 = new Road( 1 ,200);
        Road road3 = new Road( 1, 200);
        Road road4 = new Road( 1, 130);
        Road road5 = new Road( 1, 200);
        Road road6 = new Road( 1, 73);
        Road road7 = new Road( 1, 120);
        Road road8 = new Road( 1, 660);
        Road road9 = new Road( 1, 60);
        Road road10 = new Road( 1, 60);
        Road road11 = new Road( 1, 660);
        Road road12 = new Road( 1, 60);
        Road road13 = new Road( 1, 60);
        Road road14 = new Road( 1, 200);
        Road road15 = new Road( 1, 200);
        Road road16 = new Road( 1, 200);
        Road road17 = new Road( 1, 100);
        Road road18 = new Road( 1, 90);
        Road road19 = new Road( 1, 200);
        Road road20 = new Road( 1, 100);
        roads = new ArrayList<>(Arrays.asList(road1,road2,road3,road4,road5,road6,road7,road8,road9,road10,road11,road12,road13,road14,road15,road16,road17,road18,road19,road20));
        }

    public void initCars(int numCars){
        cars = new ArrayList<>();
        for (int i = 0; i < numCars; i++){
            cars.add(new Car(1 + new Random().nextInt(2), 7 + new Random().nextInt(3),i));
        }
    }

    public Init(int numCars){
        initRoads();
        initCars(numCars);

    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    public ArrayList<Road> getRoads(){
        return roads;
    }


}
