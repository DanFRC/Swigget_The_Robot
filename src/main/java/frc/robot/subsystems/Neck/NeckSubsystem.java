package frc.robot.subsystems.Neck;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

// import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NeckSubsystem extends SubsystemBase {
    public NeckSubsystem() {}

    // Elastic / Shuffleboard
    private ShuffleboardTab tab_pid = Shuffleboard.getTab("PID Tuning");
    private GenericEntry tab_kP = tab_pid.add("kP", TankDrivebaseConstants.d_kP).getEntry();
    private GenericEntry tab_kI = tab_pid.add("kI", TankDrivebaseConstants.d_kI).getEntry();
    private GenericEntry tab_kD = tab_pid.add("kD", TankDrivebaseConstants.d_kD).getEntry();
    // private GenericEntry tab_kS = tab_pid.add("kS", TankDrivebaseConstants.d_kS).getEntry();
    // private GenericEntry tab_kV = tab_pid.add("kV", TankDrivebaseConstants.d_kV).getEntry();
    // private GenericEntry tab_kA = tab_pid.add("kA", TankDrivebaseConstants.d_kA).getEntry();

    // Motors and Drivebase
    private final VictorSPX lm1 = new VictorSPX(TankDrivebaseConstants.d_LeftMotor1);
    private final VictorSPX lm2 = new VictorSPX(TankDrivebaseConstants.d_LeftMotor2);
    private final VictorSPX rm1 = new VictorSPX(TankDrivebaseConstants.d_RightMotor1);
    private final VictorSPX rm2 = new VictorSPX(TankDrivebaseConstants.d_RightMotor2);

    private final DifferentialDrive drivebase = new DifferentialDrive((double output1) -> {
      lm1.set(ControlMode.PercentOutput, output1);
      lm2.set(ControlMode.PercentOutput, output1);
    }, (double output2) -> {
      rm1.set(ControlMode.PercentOutput, output2);
      rm2.set(ControlMode.PercentOutput, output2);
    });

    // Feedback
    // private final SimpleMotorFeedforward drivebaseFeedforward =
    //     new SimpleMotorFeedforward(
    //         tab_kS.getDouble(TankDrivebaseConstants.d_kS), tab_kV.getDouble(TankDrivebaseConstants.d_kV), tab_kA.getDouble(TankDrivebaseConstants.d_kA));

  public Command exampleMethodCommand() {
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public boolean exampleCondition() {
    return false;
  }

  public void driveManual(double ySpeed, double zRotation) {
    drivebase.arcadeDrive(ySpeed, zRotation);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Retrieved kP", tab_kP.getDouble(0));
    SmartDashboard.putNumber("Retrieved kI", tab_kI.getDouble(0));
    SmartDashboard.putNumber("Retrieved kD", tab_kD.getDouble(0));
  }

  @Override
  public void simulationPeriodic() {
    
  }
}
