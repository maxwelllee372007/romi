package frc.robot.util;

import java.awt.Point;
import java.util.Queue;
import java.util.PriorityQueue;
import edu.wpi.first.math.Pair;

import edu.wpi.first.math.geometry.Pose2d;

public abstract class BestPath {
  public Queue<Pair<Pose2d,Double>> getBestPath(int gateZones[][], Point start, Point end, double time){
    Queue<Pair<Pose2d,Double>> path = new PriorityQueue<Pair<Pose2d,Double>>();
    // Get best path from the info in the class and push each Pose2d of the wanted targets to the queue in the data structure
    return path;
  }
};
