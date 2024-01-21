// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.romi.RomiGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RomiDrivetrain extends SubsystemBase {
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75591; // 70 mm

  // The Romi has the left and right motors set to
  // PWM channels 0 and 1 respectively
  private final Spark m_leftMotor = new Spark(0);
  private final Spark m_rightMotor = new Spark(1);

  // The Romi has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private final Encoder m_leftEncoder = new Encoder(4, 5);
  private final Encoder m_rightEncoder = new Encoder(6, 7);

  private final DigitalInput button = new DigitalInput(8);

  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  private final RomiGyro gyro = new RomiGyro();
  private final DifferentialDriveOdometry odometer = new DifferentialDriveOdometry(gyro.getRotation2d(), 0, 0);

  /** Creates a new RomiDrivetrain. */
  public RomiDrivetrain() {
    // Use inches as unit for encoder distances
    m_leftEncoder.setDistancePerPulse((Math.PI * .070) / kCountsPerRevolution);
    m_rightEncoder.setDistancePerPulse((Math.PI * .070) / kCountsPerRevolution);
    resetOdometry();

    // Invert right side since motor is flipped
    m_rightMotor.setInverted(true);
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate, false);
    // System.out.println("movement speed: " + xaxisSpeed);
  }

  // Speed in meters/second
  public void drive(double speed, double zaxisRotate) {
    arcadeDrive(speed * 1.81891365, zaxisRotate);
  }

  public void stop() {
    m_diffDrive.arcadeDrive(0, 0);
  }

  public Rotation2d getAbsoluteAngle() {
    return gyro.getRotation2d().plus(new Rotation2d(.5 * Math.PI));
  }

  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public double getLeftDistanceMeters() {
    return m_leftEncoder.getDistance();
  }

  public double getRightDistanceMeters() {
    return m_rightEncoder.getDistance();
  }

  public boolean getButton() {
    return !button.get();
  }

  public void resetOdometry() {
    gyro.reset();
    resetEncoders();
    odometer.resetPosition(getAbsoluteAngle(), 0, 0, Constants.Runtime.startingPose);
  }

  public Pose2d getPose() {
    return odometer.getPoseMeters();
  }

  @Override
  public void periodic() {
    odometer.update(getAbsoluteAngle(), getLeftDistanceMeters(), getRightDistanceMeters());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    odometer.update(getAbsoluteAngle(), getLeftDistanceMeters(), getRightDistanceMeters());
  }
}
