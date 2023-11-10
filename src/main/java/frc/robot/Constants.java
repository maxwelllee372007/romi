// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public final class Runtime{
    int gateZoneRow0[] = {0,0,0,0};
    int gateZoneRow1[] = {0,0,0,0};
    int gateZoneRow2[] = {0,0,0,0};
    int gateZoneRow3[] = {0,0,0,0};
    public int gateZones[][] = {gateZoneRow0,gateZoneRow1,gateZoneRow2,gateZoneRow3};
  }
  // cm
  public static int fieldSquareLength = 50;
  public static double wallDistMeters = 0;
  public static Pose2d startingPose = new Pose2d(new Translation2d(0, wallDistMeters),null);
  
  
}
