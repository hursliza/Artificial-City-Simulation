package simulation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Algo {

     Lights lights;

     LinkedList<Integer> queue1 = new LinkedList<>();
     LinkedList<Integer> queue2 = new LinkedList<>();
     LinkedList<Integer> queue3 = new LinkedList<>();
     LinkedList<Integer> queue4 = new LinkedList<>();
     LinkedList<Integer> queue5 = new LinkedList<>();
     LinkedList<Integer> queue6 = new LinkedList<>();
     LinkedList<Integer> queue7 = new LinkedList<>();
     LinkedList<Integer> queue8 = new LinkedList<>();
     LinkedList<Integer> queue9 = new LinkedList<>();
     LinkedList<Integer> queue10 = new LinkedList<>();
     LinkedList<Integer> queue11 = new LinkedList<>();
     LinkedList<Integer> queue12 = new LinkedList<>();
     LinkedList<Integer> queue13 = new LinkedList<>();
     LinkedList<Integer> queue14 = new LinkedList<>();
     LinkedList<Integer> queue15 = new LinkedList<>();
     LinkedList<Integer> queue16 = new LinkedList<>();
     LinkedList<Integer> queue17 = new LinkedList<>();
     LinkedList<Integer> queue18 = new LinkedList<>();
     LinkedList<Integer> queue19 = new LinkedList<>();
     LinkedList<Integer> queue20 = new LinkedList<>();
     LinkedList<LinkedList<Integer>> queues = new LinkedList<>(Arrays.asList(queue1,queue2,queue3,queue4,queue5,queue6,queue7,queue8,queue9,queue10,queue11,queue12,queue13,queue14,queue15,queue16,queue17,queue18,queue19,queue20));

     ArrayList<Car> cars;
     ArrayList<Road> roads;

    public Algo(ArrayList<Car> cars, ArrayList<Road> roads,Lights lights ){
        this.cars = cars;
        this.roads = roads;
        this.lights = lights;
    }

    public LinkedList<LinkedList<Integer>> getQueues() {
        return queues;
    }


    int[][] ways = {{1,-2},{-1,-1},{10,-2},{5,-2},{-1,-1},{4,10},{5,-2},{9,8},{4,-2},{1,-2},{11,12},{18,-2},{14,-2},{7,-2},{-1,-1},{14,-2},{7,-2},{16,19},{-1,-1},{18,-2}};

   /* public void printlist(){
        System.out.println(queues);


    }
*/
    public void update(){
            int j = 0;
            for(LinkedList<Integer> queue : queues) {
                int k = 0;
                for (int i : queue) {
                    if (queue.getLast().equals(i) && roads.get(j).getLength() - cars.get(i).getProgress() < cars.get(i).getVelocity()) {
                        if (next_road_arefree(j, i)) {
                            changeRoad(i, j, queue);
                        }
                        else{
                            cars.get(i).setProgress(roads.get(j).getLength());
                        }
                    }
                    else {
                        if ((int)(distanse_next_car(queue, j, k)/2) == cars.get(i).getVelocity() + 6) {
                            cars.get(i).setProgress(cars.get(i).getProgress()+ cars.get(i).getVelocity());
                        }
                        else {
                            if ( (int)(distanse_next_car(queue, j, k)/2) > cars.get(i).getVelocity() + 6) {
                                speedUp(i);
                            }
                            else {
                                slowDown(i);
                            }
                        }
                    }
                    k++;
                }
                j++;
            }
    }

    private void slowDown(int i) {
        if(cars.get(i).getVelocity() != 0){
            cars.get(i).setVelocity(cars.get(i).getVelocity()/2);
        }
        cars.get(i).setProgress(cars.get(i).getProgress()+ cars.get(i).getVelocity());
    }

    private void speedUp(int i) {
        if(cars.get(i).getMaxVelocity() > cars.get(i).getVelocity()) {
            cars.get(i).setVelocity(cars.get(i).getVelocity() + 1);
        }
        cars.get(i).setProgress(cars.get(i).getProgress()+ cars.get(i).getVelocity());
    }


    public int distanse_next_car(LinkedList<Integer> road_queue, int roadID, int que_car_number){
        int car1 = road_queue.get(que_car_number);
        if(car1 == road_queue.getLast()){

            //wartosc targetu samochodu
            int targ = cars.get(car1).getTarget();
            // id_of_next_road_where_our_car_will_drive
            int next_road = ways[roadID][targ];
            // jeśli tu kończu się droga return true
            if (next_road == -1){
                return 100;
            }
            //jesli nie ma możliwośc skrętu taj jak w targecie to zmień na drogę która istnieje~~
            if (next_road == -2){
                next_road = ways[roadID][0];
            }
            // jeśli następna droga jest pusta to zwróć true a jeśli nie do zobacz czy odległość od ostatniego samochodu na niej do naszego jest mniejsza od jego prędkości
            if (queues.get(next_road).isEmpty()) {
                return 100;
            }
            else {
                // id_of_last_car_on_next_road
                int last_car = queues.get(next_road).getLast();
                //odleglosc od nastepnego samochodu

                return (cars.get(last_car).getProgress() + (roads.get(roadID).getLength() - cars.get(car1).getProgress()) );
            }

        }
        else{
            int car2 = road_queue.get(que_car_number+1);
            return cars.get(car2).getProgress() - cars.get(car1).getProgress();
        }
    }


    public boolean next_road_arefree( int roadID, int carID) {
        //wartosc targetu samochodu
        int targ = cars.get(carID).getTarget();
        // id_of_next_road_where_our_car_will_drive
        int next_road = ways[roadID][targ];
        // jeśli tu kończu się droga return true
        if (next_road == -1){
            return true;
        }
        //jesli nie ma możliwośc skrętu taj jak w targecie to zmień na drogę która istnieje~~
        if (next_road == -2){
            next_road = ways[roadID][0];
        }
        // jeśli następna droga jest pusta to zwróć true a jeśli nie do zobacz czy odległość od ostatniego samochodu na niej do naszego jest mniejsza od jego prędkości
        if (queues.get(next_road).isEmpty()) {
            return true;
        }
        else {
            // id_of_last_car_on_next_road
            int last_car = queues.get(next_road).getFirst();
            //odleglosc od nastepnego samochodu
            int next_dist = 10;
            //czy jest wystarczajaco miejsca przed samochodem aby mogl zmienic droge
            return (cars.get(last_car).getProgress() > next_dist);
        }
    }



    public void changeRoad(int carID, int roadID, LinkedList<Integer> queue) {
        int targ = cars.get(carID).getTarget();
        int target;
        if (ways[roadID][targ] == -2) {
            target = ways[roadID][0];
        } else {
            target = ways[roadID][targ];
        }
        if(lights.state_lights(roadID,target)) {
            removeCar(carID, queue);
            if (ways[roadID][0] != -1) {
                addCar(carID, target);
            }
        }
    }


    public void removeCar(int carID, LinkedList<Integer> queue){
        queue.removeLast();
        cars.get(carID).setAvailability(true);
        cars.get(carID).setProgress(0);
    }

    public void addCar(int carID,int roadID_n) {
            if(cars.get(carID).getAvailability()){
                queues.get(roadID_n).addFirst(carID);
                cars.get(carID).setAvailability(false);
            }
    }



}
