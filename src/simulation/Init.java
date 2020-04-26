package simulation;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Init {
    int limit;
    HashMap<Car, Boolean> cars; //<Car, Available>
    ArrayList<Road> roads;

    public void initRoads(){
        Road road1 = new Road(1, new Point2D.Double(52.297220, 21.033074), new Point2D.Double(52.296679, 21.032992));
        Road road2 = new Road(2, new Point2D.Double(52.297221, 21.033079), new Point2D.Double(52.296751, 21.033053));
        Road road3 = new Road(3, new Point2D.Double(52.296679, 21.032992), new Point2D.Double(52.295995, 21.032879));
        Road road4 = new Road(4, new Point2D.Double(52.295992, 21.032924), new Point2D.Double(52.296282, 21.032989));
        Road road5 = new Road(5, new Point2D.Double(52.296839, 21.033116), new Point2D.Double(52.297215, 21.033173));
        Road road6 = new Road(6, new Point2D.Double(52.296227, 21.033016), new Point2D.Double(52.296594, 21.033079));
        Road road7 = new Road(7, new Point2D.Double(52.295991, 21.032974), new Point2D.Double(52.296227, 21.033016));
        Road road8 = new Road(8, new Point2D.Double(52.296100, 21.042073), new Point2D.Double(52.296679, 21.033973));
        Road road9 = new Road(9, new Point2D.Double(52.296709, 21.033792), new Point2D.Double(52.296745, 21.033300));
        Road road10 = new Road(10, new Point2D.Double(52.296674, 21.033783), new Point2D.Double(52.296714, 21.033296));
        Road road11 = new Road(11, new Point2D.Double(52.296685, 21.033296), new Point2D.Double(52.296105, 21.041202));
        Road road12 = new Road(12, new Point2D.Double(52.296097, 21.041343), new Point2D.Double(52.296073, 21.042069));
        Road road13 = new Road(13, new Point2D.Double(52.296072, 21.041332), new Point2D.Double(52.296039, 21.042064));
        Road road14 = new Road(14, new Point2D.Double(52.296573, 21.042312), new Point2D.Double(52.296214, 21.042284));
        Road road15 = new Road(15, new Point2D.Double(52.295949, 21.042263), new Point2D.Double(52.294924, 21.042150));
        Road road16 = new Road(16, new Point2D.Double(52.296563, 21.042351), new Point2D.Double(52.296217, 21.042319));
        Road road17 = new Road(17, new Point2D.Double(52.295480, 21.042274), new Point2D.Double(52.295961, 21.042309));
        Road road18 = new Road(18, new Point2D.Double(52.294918, 21.042216), new Point2D.Double(52.295255, 21.042275));
        Road road19 = new Road(19, new Point2D.Double(52.296118, 21.042379), new Point2D.Double(52.296570, 21.042410));
        Road road20 = new Road(20, new Point2D.Double(52.295482, 21.042328), new Point2D.Double(52.296094, 21.042380));

        road1.setNextRoads(new ArrayList<Road>(Arrays.asList(road2)));
        road3.setNextRoads(new ArrayList<Road>(Arrays.asList(road11)));
        road4.setNextRoads(new ArrayList<Road>(Arrays.asList(road6)));
        road7.setNextRoads(new ArrayList<Road>(Arrays.asList(road6)));
        road8.setNextRoads(new ArrayList<Road>(Arrays.asList(road9, road10)));
        road9.setNextRoads(new ArrayList<Road>(Arrays.asList(road5)));
        road10.setNextRoads(new ArrayList<Road>(Arrays.asList(road2)));
        road11.setNextRoads(new ArrayList<Road>(Arrays.asList(road12, road13)));
        road12.setNextRoads(new ArrayList<Road>(Arrays.asList(road19)));
        road13.setNextRoads(new ArrayList<Road>(Arrays.asList(road15)));
        road14.setNextRoads(new ArrayList<Road>(Arrays.asList(road8)));
        road16.setNextRoads(new ArrayList<Road>(Arrays.asList(road15)));
        road17.setNextRoads(new ArrayList<Road>(Arrays.asList(road8)));
        road18.setNextRoads(new ArrayList<Road>(Arrays.asList(road17, road20)));
        road20.setNextRoads(new ArrayList<Road>(Arrays.asList(road19)));

        roads.addAll(Arrays.asList(road1, road2, road3, road4, road5, road6,
                road7, road8, road9, road10, road11, road12, road13, road14,
                road15, road16, road17, road18, road19, road20));
    }

    public void initCars(int numCars){
        cars = new HashMap<>();
        for (int i = 0; i < numCars; i++){
            cars.put(new Car(new Random().nextInt(limit) + 2, limit), Boolean.TRUE);
        }

    }

    Init(int numCars){
        initRoads();
        initCars(numCars);
    }

}
