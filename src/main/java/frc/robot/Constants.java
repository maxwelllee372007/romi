// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.awt.geom.Point2D;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  private static Point2D.Double yes(double x, double y) {
    return new Point2D.Double(x, y);
  }

  public static Point2D.Double[] conversion(String path){
    String[] dirs1 = path.split(" ");
    Direction[] dirs = new Direction[dirs1.length];
    for (int i = 0; i < dirs1.length; i++){
      Direction curr = null;
      switch(dirs1[i]){
        case "D":
          curr = Direction.D;
          break;
        case "U":
          curr = Direction.U;
          break;
        case "R":
          curr = Direction.R;
          break;
        case "L":
          curr = Direction.L;
          break;
        case "IN":
          curr = Direction.IN;
          break;
      }
      dirs[i] = curr;
      System.out.println("String splice:" + dirs1[i]);
      System.out.println("Dirs:"+dirs[i]);
    }
    Point2D.Double[] ret = new Point2D.Double[dirs.length];
    Point2D.Double curr = Runtime.start;
    for (int i = 0; i < dirs.length; i++){
      switch (dirs[i]){
        case D:
          curr.y -= 1;
          break;
        case U:
          curr.y += 1;
          break;
        case R:
          curr.x += 1;
          break;
        case L:
          curr.x -= 1;
          break;
        case IN:
          curr.y += .5 - startingOffset;
          break;
      }
      ret[i] = (Point2D.Double) curr.clone();
      System.out.println(ret[i]);
    }
    return ret;
  }

  public static enum Direction{
    R,
    U,
    D,
    L,
    IN,
  }
  
  // // public final class Movement{
  // //   private double dist;
  // //   private Direction dir;

  // //   Movement Movement(char c){
  // //     this.dist = 0.5;
  // //     switch (c){
  // //       case 'R':

  // //     }
  // //   }
  // }

  

  public static final class Runtime {
    // static boolean gateZoneRow1[] = {false,false,false,false};
    // static boolean gateZoneRow2[] = {false,false,false,false};
    // static boolean gateZoneRow0[] = {false,false,false,false};
    // static boolean gateZoneRow3[] = {false,false,false,false};
    // // public static Point2D.Double gateZonePath[] = { yes(3.5, 0.5), yes(2.5, 0.5), yes(2.5, 2.5), yes(3.5, 2.5),
    //     yes(3.5, 3.5) };
    // public static boolean gateZones[][] =
    // {gateZoneRow0,gateZoneRow1,gateZoneRow2,gateZoneRow3};
    public static String basePath = "IN R R R U L U D R D L L U U U L D U R R R D U"; 
    public static double time = 60.0;
    public static Point2D.Double start = new Point2D.Double(0.5, startingOffset);
    public static Point2D.Double end = new Point2D.Double(3.5, 3.5);
    public static double wallDistMeters = Runtime.start.getX() / 2;
    public static Pose2d startingPose = new Pose2d(new Translation2d(wallDistMeters, startingOffset),
        new Rotation2d(.5 * Math.PI));
  }

  // // cm
  // public static int fieldSquareLength = 50;
  // public static double wallDistMeters = 0;
  // public static Pose2d startingPose = new Pose2d(new Translation2d(0,
  // wallDistMeters),null);
  // m
  public static double startingOffset = -0.05;
  public static double fieldSquareLength = 0.5;
  public static double turningScale = 0.35;
  public static double maxTurningSpeed = 0.3;

}