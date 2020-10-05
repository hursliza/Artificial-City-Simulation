package simulation;

import java.awt.*;

public class Lights {
    static int time = 0;
    boolean state_on_this_road = false;


     public boolean state_lights(int roadID, int target) {
        int state = (time / 30) % 3;
        switch (roadID) {
            case 0:
                state_on_this_road = (state == 1);
                break;
            case 1:
                state_on_this_road = true;
                break;
            case 2:
                state_on_this_road = (state == 2);
                break;
            case 3:
                state_on_this_road = true;
                break;
            case 4:
                state_on_this_road = true;
                break;
            case 5:
                if(target == 4) {
                    state_on_this_road = (state == 1);
                }else{
                    state_on_this_road = (state == 0);
                }
                break;
            case 6:
                state_on_this_road = true;
                break;
            case 7:
                state_on_this_road = true;
                break;
            case 8:
                state_on_this_road = (state == 2);
                break;
            case 9:
                state_on_this_road = (state == 0);
                break;
            case 10:
                state_on_this_road = true;
                break;
            case 11:
                state_on_this_road = (state == 2);
                break;
            case 12:
                state_on_this_road = (state == 1);
                break;
            case 13:
                state_on_this_road = (state == 2);
                break;
            case 14:
                state_on_this_road = true;
                break;
            case 15:
                state_on_this_road = (state == 0);
                break;
            case 16:
                state_on_this_road = (state == 1);
                break;
            case 17:
                state_on_this_road = true;
                break;
            case 18:
                state_on_this_road = true;
                break;
            case 19:
                state_on_this_road = (state == 0);
                break;
        }
        return state_on_this_road;
    }
     public boolean car_lights(int roadID, int target) {
        int state = (time / 30) % 3;
        switch (roadID) {
            case 0:
                state_on_this_road = (state == 1);
                break;
            case 1:
                state_on_this_road = true;
                break;
            case 2:
                state_on_this_road = (state == 2);
                break;
            case 3:
                if(target == 4) {
                    state_on_this_road = (state == 1);
                }else{
                    state_on_this_road = (state == 0);
                }
                break;
            case 4:
                state_on_this_road = true;
                break;
            case 5:
                if(target == 4) {
                    state_on_this_road = (state == 1);
                }else{
                    state_on_this_road = (state == 0);
                }
                break;
            case 6:
                if(target == 4) {
                    state_on_this_road = (state == 1);
                }else{
                    state_on_this_road = (state == 0);
                }
                break;
            case 7:
                if(target == 1) {
                    state_on_this_road = (state == 0);
                }else{
                    state_on_this_road = (state == 2);
                }break;
            case 8:
                state_on_this_road = (state == 2);
                break;
            case 9:
                state_on_this_road = (state == 0);
                break;
            case 10:
                if(target == 11) {
                    state_on_this_road = (state == 2);
                }else{
                    state_on_this_road = (state == 1);
                }
                break;
            case 11:
                state_on_this_road = (state == 2);
                break;
            case 12:
                state_on_this_road = (state == 1);
                break;
            case 13:
                state_on_this_road = (state == 2);
                break;
            case 14:
                state_on_this_road = true;
                break;
            case 15:
                state_on_this_road = (state == 0);
                break;
            case 16:
                state_on_this_road = (state == 1);
                break;
            case 17:
                if(target == 16) {
                    state_on_this_road = (state == 1);
                }else{
                    state_on_this_road = (state == 0);
                }break;
            case 18:
                state_on_this_road = true;
                break;
            case 19:
                state_on_this_road = (state == 0);
                break;
        }
        return state_on_this_road;
    }


    public void changeTime() {
        time++;
    }
}
