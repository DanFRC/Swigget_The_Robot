package frc.robot.subsystems.Drivebase;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrivebase extends SubsystemBase {
    public TankDrivebase() {}

    // Elastic / Shuffleboard
    private ShuffleboardTab tab_pid = Shuffleboard.getTab("PID Tuning");
    private GenericEntry tab_kP = tab_pid.add("kP", 0.0).getEntry();
    private GenericEntry tab_kI = tab_pid.add("kI", 0.0).getEntry();
    private GenericEntry tab_kD = tab_pid.add("kD", 0.0).getEntry();
    private GenericEntry tab_kS = tab_pid.add("kS", 0.0).getEntry();
    private GenericEntry tab_kV = tab_pid.add("kV", 0.0).getEntry();
    private GenericEntry tab_kA = tab_pid.add("kA", 0.0).getEntry();

    // Feedback
    private final SimpleMotorFeedforward drivebaseFeedforward =
        new SimpleMotorFeedforward(
            tab_kS.getDouble(0), tab_kV.getDouble(0), tab_kA.getDouble(0));

  public Command exampleMethodCommand() {
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public boolean exampleCondition() {
    return false;
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
