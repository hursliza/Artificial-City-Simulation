
import simulation.*;

import java.util.Arrays;


public class Main {
    Init Data = new Init(150);
    Lights lights = new Lights();
    Algo algo = new Algo(Data.getCars(),Data.getRoads(),lights);
    newCar neww = new newCar(Data.getCars());
    Render render = new Render(algo.getQueues(),Data.getCars(),Data.getRoads(),lights);

    Main(){
        //frameWork(frame);
        buildGui();
    }

    void buildGui(){
        for(int i= 0; i < 86400; i++ ) { //ilość updatów

            neww.NEWcar(i, Data.getCars(), algo.getQueues(), algo);
            // System.out.println("---------------------------" + i + "------------------------");
            algo.update();
            // algo.printlist();
            render.render_it(render, i);
            try {
                Thread.sleep(10); // SPEED OF SYMULATION //minimum - 5  //40 not too slow not too fast// optimal - 80 // 200 slow
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            lights.changeTime();
        }
    }

    public static void main(String[] args) {
        Main main=new Main();

    }

}