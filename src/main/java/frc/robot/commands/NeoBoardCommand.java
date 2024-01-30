// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.NeoBoard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import java.util.logging.Logger;

/** An example command that uses an example subsystem. */
public class NeoBoardCommand extends Command {
  private final NeoBoard neoboard;
  boolean messageAccess = true;
  Logger messageCommand = Logger.getLogger(NeoBoardCommand.class.getName());

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public NeoBoardCommand(NeoBoard subsystem) {
    neoboard = subsystem;
    SmartDashboard.putNumber("Speed", 0);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  public void emergencyCommand() {
    neoboard.emergencyProtocol();
    neoboard.NeoBoardSetSpeed(0);
    messageCommand.warning("NeoBoard has emergency stopped. Due to this, the robot will have to be power-cycled. Please restart the FRC Driver Station and RoboRio.");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
//    neoboard.NeoBoardSetSpeed(Constants.motorSpeeds.NeoBoardSpeed);;
//     perhaps more code later.
    neoboard.NeoBoardSetSpeed(Constants.motorSpeeds.NeoBoardSpeed);
    if (messageAccess) {
      messageCommand.info("NeoBoard activated with speed value: " + Constants.motorSpeeds.NeoBoardSpeed);
      messageAccess = false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     neoboard.NeoBoardSetSpeed(0);
     messageAccess = true;
     messageCommand.info("NeoBoard disabled");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
