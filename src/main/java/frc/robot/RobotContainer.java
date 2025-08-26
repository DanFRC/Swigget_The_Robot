// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.subsystems.Drivebase.TankDrivebase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final TankDrivebase _drivebase = new TankDrivebase();

  private final CommandXboxController _controller =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
    _drivebase.setDefaultCommand(new ArcadeDriveCmd(_drivebase, _controller));
  }

  private void configureBindings() {

    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    _controller.b().whileTrue(_drivebase.exampleMethodCommand());
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
