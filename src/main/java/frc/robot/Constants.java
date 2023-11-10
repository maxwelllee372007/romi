// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class Runtime{
    static boolean gateZoneRow1[] = {false,false,false,false};
    static boolean gateZoneRow2[] = {false,false,false,false};
    static boolean gateZoneRow0[] = {false,false,false,false};
    static boolean gateZoneRow3[] = {false,false,false,false};
    public static boolean gateZones[][] = {gateZoneRow0,gateZoneRow1,gateZoneRow2,gateZoneRow3};
    public static double time = 60;
  }
  // m
  public static double fieldSquareLength = 0.5;
  public static double turningScale = 1/Math.PI;
  
  
}
