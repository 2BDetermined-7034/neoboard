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
  private final Logger logMessage = Logger.getLogger(NeoBoard.class.getName());
  boolean messageEnabled = true;


  /**
   * Prepares the NeoBoard by adding the SmartDashboard speed and adding the subsystem requirements.
   *
   * @param subsystem The subsystem added in requirements.
   */
  public NeoBoardCommand(NeoBoard subsystem) {
    neoboard = subsystem;
    SmartDashboard.putNumber("Speed", 0);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
//    neoboard.NeoBoardSetSpeed(Constants.motorSpeeds.NeoBoardSpeed);;
//     perhaps more code later.
    neoboard.NeoBoardSetSpeed(SmartDashboard.getNumber("Speed", 0));
    if (messageEnabled) {
      logMessage.info("NeoBoard activated\nCurrent speed: " + SmartDashboard.getNumber("Speed",0));
      if (SmartDashboard.getNumber("Speed",0) >= 1.01) {
        SmartDashboard.putNumber("Speed",0.5);
        logMessage.warning("""
                NeoBoard speed was at an unnecessarily high value.\s
                Continuing the NeoBoard at this speed may result in unsafe measures to the current prototyping build.\s
                Due to this, the speed has been heavily reduced to 0.5.""");
      }
      messageEnabled = false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     neoboard.NeoBoardSetSpeed(0);
     logMessage.info("NeoBoard deactivated");
     messageEnabled = true;

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
