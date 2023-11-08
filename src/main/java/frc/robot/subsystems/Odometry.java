// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.math.geometry.Pose2d;
// import edu.wpi.first.math.geometry.Transform2d;
// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.interfaces.Gyro;
// import edu.wpi.first.wpilibj.motorcontrol.Spark;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class Odometry extends SubsystemBase{
//     public Pose2d pose = new Pose2d();
//     public double xPos = 0;
//     private double yPos = 0;
//     public double prevLeft = 0;
//     private double prevRight = 0;
//     public Odometry() {

//     }

//     public void update(double leftEncoder, double rightEncoder, double gyroAngle) {
//         double dist = ((leftEncoder - prevLeft) + (rightEncoder - prevRight))/2;
//         pose.plus(new Transform2d());
//         this.xPos += Math.cos(gyroAngle)*dist;
//         this.yPos += Math.sin(gyroAngle)*dist;
//         this.prevLeft = leftEncoder;
//         this.prevRight = rightEncoder;
//     }

//     // public Pose2d position() {
//         // return Pose2d thid = new Pose2d();
//     // }
// }