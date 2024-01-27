// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.RomiDrivetrain;
import frc.robot.util.BestPath;

/** An example command that uses an example subsystem. */
public class RunBestPath extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final RomiDrivetrain m_subsystem;
  private boolean startRunning = false;
  private Timer startTime;
  private ArrayList<Point2D.Double> path;
  private double totalDistance, distanceRemaining;
  private int currentIndex = 1;
  private boolean bigTurn = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunBestPath(RomiDrivetrain subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!startRunning && m_subsystem.getButton()) {
      startTime = new Timer();
      startTime.start();
      String dirs = Constants.Runtime.basePath;
      var gateZonePath = Constants.conversion(dirs);
      var temp = BestPath.getBestPath(gateZonePath, Constants.Runtime.start, Constants.Runtime.end, Constants.Runtime.time);
      System.out.println(temp);
      path = temp.getFirst();
      System.out.println(path);
      totalDistance = temp.getSecond();
      distanceRemaining = totalDistance;
      startRunning = true;
    }
    if (startRunning && !m_subsystem.getButton()) {
      Point2D target = path.get(currentIndex);
      Translation2d target2 = new Translation2d(target.getX(), target.getY());
      Translation2d dist = m_subsystem.getPose().getTranslation().minus(target2).div(-1);
      if (dist.getNorm() < 0.05) {
        currentIndex++;
        var temp = m_subsystem.getPose().getTranslation();
        System.out.println("Turning\nx: " + temp.getX() + " y: " + temp.getY());
      }else {
        double angleDiff = dist.getAngle().minus(m_subsystem.getAbsoluteAngle()).getRadians();
        double setZ = angleDiff * Constants.turningScale;
        setZ = MathUtil.clamp(setZ, -Constants.maxTurningSpeed, Constants.maxTurningSpeed);
        // setZ = Math.abs(setZ) > Constants.maxTurningSpeed && setZ < 0 ? -Constants.maxTurningSpeed : (Math.abs(setZ) > Constants.turningScale && setZ > 0) ? ;
        m_subsystem.drive((8.0/6.0)*totalDistance/Constants.Runtime.time, setZ);
        // m_subsystem.arcadeDrive(0.5, setZ);
        // System.out.println("Gyro angle:" + m_subsystem.getAbsoluteAngle().getDegrees());
        // System.out.println("x: "+dist.getX()+" y: "+dist.getY());
        // System.out.println("set Z:" + setZ);
      }

    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
