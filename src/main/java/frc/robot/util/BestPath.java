package frc.robot.util;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import edu.wpi.first.math.Pair;
import frc.robot.Constants;


public abstract class BestPath {
  public static Pair<ArrayList<Point2D.Double>,Double> getBestPath(Point2D.Double gateZonePath[], Point2D.Double start, double time){
    ArrayList<Point2D.Double> path = new ArrayList<Point2D.Double>();
    ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
    points.add((Point2D.Double) start.clone());
    System.out.println("hi");
    for (int i = 0; i < gateZonePath.length; i++){
      points.add(gateZonePath[i]);
    }
    System.out.println("hi2");
    // int gatesLeft;
    // do {
    //   gatesLeft = 0;
    //   Point2D.Double lastPoint = points.get(points.size()-1); 
    //   Point2D.Double nextPoint = new Point2D.Double(100,100);
    //   double shortestDistance = lastPoint.distance(nextPoint);
    //   for (int i = 0; i < gateZones.length; i++){
    //     for (int j = 0; j < gateZones[i].length; j++){
    //       if (gateZones[i][j]){
    //         gatesLeft++;
    //         Point2D.Double newPoint = new Point2D.Double(i+.5,j+.5);
    //         if (lastPoint.distance(newPoint) < shortestDistance){
    //           nextPoint = newPoint;
    //           gateZones[i][j] = false;
    //         }
    //       }
    //     }
    //   }
    //   if (gatesLeft - 1 > 0){
    //     points.add(nextPoint);
    //   }
    // } while (gatesLeft - 1 > 0);
    // points.add(end);
    double totalDistance = 0;
    for (int i = 0; i < points.size() - 1; i++){
      totalDistance += points.get(i).distance(points.get(i+1));
    }
    System.out.println("hi3");
    for (int i = 0; i < points.size(); i++){
      Point2D.Double scaledPoint = new Point2D.Double(points.get(i).getX()*Constants.fieldSquareLength,points.get(i).getY()*Constants.fieldSquareLength);
      path.add(scaledPoint);
    }
    System.out.println(path);
    System.out.println(totalDistance);
    return new Pair<ArrayList<Point2D.Double>,Double>(path,totalDistance*Constants.fieldSquareLength);
  }
};
