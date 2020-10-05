package simulation;

import java.awt.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Render extends JPanel {
    Lights lights;
    static JFrame jf = new JFrame();
    private Image image;
    private LinkedList<LinkedList<Integer>> queues;
    private ArrayList<Car> cars;
    private ArrayList<Road> roads;
    static int time = 0;
    int[][] ways = {{1,-2},{-1,-1},{10,-2},{5,-2},{-1,-1},{4,10},{5,-2},{9,8},{4,-2},{1,-2},{11,12},{18,-2},{14,-2},{7,-2},{-1,-1},{14,-2},{7,-2},{16,19},{-1,-1},{18,-2}};

    public Render(LinkedList<LinkedList<Integer>> queues, ArrayList<Car> cars, ArrayList<Road> roads,Lights lights) {
        this.cars = cars;
        this.queues = queues;
        this.roads = roads;
        this.lights = lights;

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image = new ImageIcon(getClass().getResource("/simulation/mapa1.png")).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setColor(Color.black);
        show_time(g, time);
        g.setColor(Color.red);
        draw_cars(g);
    }

    public void render_it(Render render, int i) {
        time = i;
        jf.setTitle("Symulacja");
        jf.setSize(900, 500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(render);
        repaint();
    }

    public void show_time(Graphics g, int i){
        Date time = new Date(TimeUnit.SECONDS.toMillis(i) - TimeUnit.HOURS.toMillis(1));
        String pattern = " HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        g.setFont(new Font("Verdana", Font.BOLD, 16));
        g.drawString(simpleDateFormat.format(time), 400, 30);
    }


    public void draw_cars(Graphics g){

        int roadID = 0;
        for(LinkedList<Integer> que : queues) {
            for(int i : que) {
                int targ = cars.get(i).getTarget();
                int target;
                if (ways[roadID][targ] == -2) {
                    target = ways[roadID][0];
                } else {
                    target = ways[roadID][targ];
                }
                if(target == -1 ){
                    target = 0;
                }
                int future_target;
                if (ways[target][targ] == -2) {
                    future_target = ways[target][0];
                } else {
                    future_target = ways[target][targ];
                }
                switch (roadID) {
                    case 0:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(13, 0 + cars.get(i).getProgress(), 10, 10); //1 droga
                        g.fillRect(13, 0 + cars.get(i).getProgress(), 10, 10);
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),13, 10 + cars.get(i).getProgress());
                        break;
                    case 1:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(13, 250 + cars.get(i).getProgress(), 10, 10); //2 droga
                        g.fillRect(13, 250 + cars.get(i).getProgress(), 10, 10); //2 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),13, 260 + cars.get(i).getProgress());
                        break;
                    case 2:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(33, 0 + cars.get(i).getProgress(), 10, 10); //3 droga
                        g.fillRect(33, 0 + cars.get(i).getProgress(), 10, 10); //3 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),33, 10 + cars.get(i).getProgress());
                        break;
                    case 3:
                        if(lights.car_lights(5,future_target)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(33, 450 - cars.get(i).getProgress(), 10, 10); //4 droga
                        g.fillRect(33, 450 - cars.get(i).getProgress(), 10, 10); //4 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),33, 460 - cars.get(i).getProgress());
                        break;
                    case 4:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(53, 200 - cars.get(i).getProgress(), 10, 10); //5 droga
                        g.fillRect(53, 200 - cars.get(i).getProgress(), 10, 10); //5 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),53, 210 - cars.get(i).getProgress());
                        break;
                    case 5:
                        if(lights.car_lights(roadID,target)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(53, 320 - cars.get(i).getProgress(), 10, 10); //6 droga
                        //g.setColor(Color.black);
                        g.fillRect(53, 320 - cars.get(i).getProgress(), 10, 10);
                        //g.drawString(Integer.toString(i),53, 330 - cars.get(i).getProgress());

                        break;
                    case 6:
                        if(lights.car_lights(5,future_target)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(53, 450 - cars.get(i).getProgress(), 10, 10); //7 droga
                        g.fillRect(53, 450 - cars.get(i).getProgress(), 10, 10); //7 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),53, 460 - cars.get(i).getProgress());
                        break;
                    case 7:
                        if(lights.car_lights(roadID,future_target)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(805 - cars.get(i).getProgress(), 215, 10, 10); //8 droga
                        g.fillRect(805 - cars.get(i).getProgress(), 215, 10, 10); //8 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),805 - cars.get(i).getProgress(), 225);
                        break;
                    case 8:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(125 - cars.get(i).getProgress(), 198, 10, 10); //9 droga
                        g.fillRect(125 - cars.get(i).getProgress(), 198, 10, 10); //9 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),125 - cars.get(i).getProgress(), 208);

                        break;
                    case 9:
                        if(lights.car_lights(roadID,future_target)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(125 - cars.get(i).getProgress(), 215, 10, 10); //10 droga
                        g.fillRect(125 - cars.get(i).getProgress(), 215, 10, 10); //10 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),125 - cars.get(i).getProgress(), 225);
                        break;
                    case 10:
                        if(lights.car_lights(roadID,target)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(70 + cars.get(i).getProgress(), 233, 10, 10); //11 droga
                        g.fillRect(70 + cars.get(i).getProgress(), 233, 10, 10); //11 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),70 + cars.get(i).getProgress(), 243);
                        break;
                    case 11:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(745 + cars.get(i).getProgress(), 235, 10, 10); //12 droga
                        g.fillRect(745 + cars.get(i).getProgress(), 235, 10, 10); //12 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),745 + cars.get(i).getProgress(), 245);
                        break;
                    case 12:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(745 + cars.get(i).getProgress(), 253, 10, 10); //13 droga
                        g.fillRect(745 + cars.get(i).getProgress(), 253, 10, 10); //13 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),745 + cars.get(i).getProgress(), 263);
                        break;
                    case 13:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(820, 0 + cars.get(i).getProgress(), 10, 10); //14 droga
                        g.fillRect(820, 0 + cars.get(i).getProgress(), 10, 10); //14 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),820, 10 + cars.get(i).getProgress());
                        break;
                    case 14:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(820, 250 + cars.get(i).getProgress(), 10, 10); //15 droga
                        g.fillRect(820, 250 + cars.get(i).getProgress(), 10, 10); //15 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),820, 260 + cars.get(i).getProgress());
                        break;
                    case 15:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(840, 0 + cars.get(i).getProgress(), 10, 10); //16 droga
                        g.fillRect(840, 0 + cars.get(i).getProgress(), 10, 10); //16 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),840, 10 + cars.get(i).getProgress());
                        break;
                    case 16:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(840, 350 - cars.get(i).getProgress(), 10, 10); //17 droga
                        g.fillRect(840, 350 - cars.get(i).getProgress(), 10, 10); //17 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),840, 360 - cars.get(i).getProgress());
                        break;
                    case 17:
                        if(lights.car_lights(roadID,target)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(840, 450 - cars.get(i).getProgress(), 10, 10); //18 droga
                        g.fillRect(840, 450 - cars.get(i).getProgress(), 10, 10); //18 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),840, 460 - cars.get(i).getProgress());
                        break;
                    case 18:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(860, 200 - cars.get(i).getProgress(), 10, 10); //19 droga
                        g.fillRect(860, 200 - cars.get(i).getProgress(), 10, 10); //19 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),860, 210 - cars.get(i).getProgress());
                        break;
                    case 19:
                        if(lights.car_lights(roadID,0)){
                            g.setColor(Color.green);
                        }
                        else{
                            g.setColor(Color.red);
                        }
                        g.drawRect(860, 350 - cars.get(i).getProgress(), 10, 10); //20 droga
                        g.fillRect(860, 350 - cars.get(i).getProgress(), 10, 10); //20 droga
                        //g.setColor(Color.black);
                        //g.drawString(Integer.toString(i),860, 360 - cars.get(i).getProgress());
                        break;
                }
            }
        roadID++;
        }
    }




    public void draw_1_category_of_roads(Graphics g, int k){
        g.drawRect(13,0+10*k,10,10); //1 droga
        g.drawRect(33,0+10*k,10,10); //3 droga
        g.drawRect(13,250+10*k,10,10); //2 droga
        g.drawRect(820,0+10*k,10,10); //14 droga
        g.drawRect(840,0+10*k,10,10); //16 droga
        g.drawRect(820,250+10*k,10,10); //15 droga
    }
    public void draw_2_category_of_roads(Graphics g){
        g.drawRect(33,450,10,10); //4 droga
        g.drawRect(53,450,10,10); //7 droga
        g.drawRect(53,300,10,10); //6 droga
        g.drawRect(53,200,10,10); //5 droga
        g.drawRect(840,450,10,10); //18 droga
        g.drawRect(840,350,10,10); //17 droga
        g.drawRect(860,350,10,10); //20 droga
        g.drawRect(860,200,10,10); //19 droga
    }
    public void draw_3_category_of_roads(Graphics g){
        g.drawRect(805,215,10,10); //8 droga
        g.drawRect(125,215,10,10); //10 droga
        g.drawRect(125,198,10,10); //9 droga

    }
    public void draw_4_category_of_roads(Graphics g){
        g.drawRect(70,233,10,10); //11 droga
        g.drawRect(745,235,10,10); //12 droga
        g.drawRect(745,253,10,10); //13 droga

    }





}
