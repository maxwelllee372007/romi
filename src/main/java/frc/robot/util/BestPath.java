package frc.robot.util;

import java.awt.geom.Point2D;
import java.util.Queue;
import java.util.ArrayList;
import java.util.PriorityQueue;
import edu.wpi.first.math.Pair;
import frc.robot.Constants;

import edu.wpi.first.math.geometry.Pose2d;

public abstract class BestPath {
  // Returns a queue containing a Pose2d and a double
  // The Pose2d is a vector that points from the end point of the previous Pose2d (or the starting point for the first one) to the next end point
  // The double is the proportion of the total distance that this is, which you can use to calculate the time that should be spent on this path
  public Queue<Pair<Pose2d,Double>> getBestPath(boolean gateZones[][], Point2D.Double start, Point2D.Double end, double time){
    Queue<Pair<Pose2d,Double>> path = new PriorityQueue<Pair<Pose2d,Double>>();
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
    for (int i = 0; i < points.size() - 1; i++){
      //Make poses in here
    }
    // Get best path from the info in the class and push each Pose2d of the wanted targets to the queue in the data structure
    return path;
  }
};
