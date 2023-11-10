// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import java.awt.geom.Point2D;

import org.opencv.core.Point;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  private static Point2D.Double yes(double x, double y){
    return new Point2D.Double(x,y);
  }
  public static final class Runtime{
    // static boolean gateZoneRow1[] = {false,false,false,false};
    // static boolean gateZoneRow2[] = {false,false,false,false};
    // static boolean gateZoneRow0[] = {false,false,false,false};
    // static boolean gateZoneRow3[] = {false,false,false,false};
    // public static boolean gateZones[][] = {gateZoneRow0,gateZoneRow1,gateZoneRow2,gateZoneRow3};
    public static Point2D.Double gateZonePath[] = {};
    public static double time = 20;
    public static Point2D.Double start = new Point2D.Double(1.5, 0);
    public static Point2D.Double end = new Point2D.Double(1.5,3.5);
  }
  // m
  public static double fieldSquareLength = 0.5;
  public static double turningScale = 0.4 * 0.9;
  public static double wallDistMeters = Runtime.start.getX()/2;
  public static Pose2d startingPose = new Pose2d(new Translation2d(wallDistMeters,0), new Rotation2d(.5*Math.PI));
  
  
}
