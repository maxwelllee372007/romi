package frc.robot.util;

import java.awt.geom.Point2D;
import java.util.Queue;
import java.util.ArrayList;
import java.util.PriorityQueue;
import edu.wpi.first.math.Pair;
import frc.robot.Constants;


public abstract class BestPath {
  public static Pair<ArrayList<Point2D.Double>,Double> getBestPath(boolean gateZones[][], Point2D.Double start, Point2D.Double end, double time){
    ArrayList<Point2D.Double> path = new ArrayList<Point2D.Double>();
    ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
    points.add(start);
    int gatesLeft;
    do {
      gatesLeft = 0;
      Point2D.Double lastPoint = points.get(points.size()-1); 
      Point2D.Double nextPoint = new Point2D.Double(100,100);
      double shortestDistance = lastPoint.distance(nextPoint);
      for (int i = 0; i < gateZones.length; i++){
        for (int j = 0; j < gateZones[i].length; j++){
          if (gateZones[i][j]){
            gatesLeft++;
            Point2D.Double newPoint = new Point2D.Double(i+.5,j+.5);
            if (lastPoint.distance(newPoint) < shortestDistance){
              nextPoint = newPoint;
              gateZones[i][j] = false;
            }
          }
        }
      }
      points.add(nextPoint);
    } while (gatesLeft - 1 > 0);
    points.add(end);
    double totalDistance = 0;
    for (int i = 0; i < points.size() - 1; i++){
      totalDistance += points.get(i).distance(points.get(i+1));
    }
    for (int i = 1; i < points.size() - 1; i++){
      Point2D.Double scaledPoint = new Point2D.Double(points.get(i).getX()*Constants.fieldSquareLength,points.get(i).getY()*Constants.fieldSquareLength);
      path.add(scaledPoint);
    }
    return new Pair<ArrayList<Point2D.Double>,Double>(path,totalDistance);
  }
};
