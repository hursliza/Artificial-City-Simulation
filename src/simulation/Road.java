package simulation;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Road {
    Double cellSize = 1.5;
    private int roadID;
    private int length;
    private Point2D.Double beginning;
    private Point2D.Double end;
    private ArrayList<Road> nextRoads;


    public Road(int roadID, Point2D.Double beginning, Point2D.Double end){
        this.roadID = roadID;
        this.length = (int) Math.floor(distance(beginning.x, end.x, beginning.y, end.y)/cellSize);
        this.beginning = beginning;
        this.end = end;
    }

    public void setNextRoads(ArrayList<Road> nextRoads) {
        this.nextRoads = nextRoads;
    }

    public static double distance(double lat1, double lat2, double lon1, double lon2)
    {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;
        return(c * r);
    }
}
