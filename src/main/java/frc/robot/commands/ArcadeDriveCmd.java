// 10316

package frc.robot.commands;

import frc.robot.subsystems.Drivebase.TankDrivebase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ArcadeDriveCmd extends Command {
  private final TankDrivebase _Drivebase;
  private final CommandXboxController controller;

  public ArcadeDriveCmd(TankDrivebase subsystem, CommandXboxController _controller) {
    _Drivebase = subsystem;
    controller = _controller;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    _Drivebase.driveManual(controller.getLeftY(), controller.getRightX());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
