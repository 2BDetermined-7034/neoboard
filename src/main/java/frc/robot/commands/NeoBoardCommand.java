// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.NeoBoard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import java.sql.Driver;
import java.util.logging.Logger;

/** An example command that uses an example subsystem. */
public class NeoBoardCommand extends Command {
  private final NeoBoard neoboard;
  Logger messageDevice = Logger.getLogger(NeoBoard.class.getName());
  boolean messageAccess = true;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public NeoBoardCommand(NeoBoard subsystem) {
    neoboard = subsystem;
    SmartDashboard.putNumber("Speed", 0);
    SmartDashboard.putBoolean("Reverse Motors", false);
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
    neoboard.reverse(SmartDashboard.getBoolean("Reverse Motors", false));
    neoboard.NeoBoardSetSpeed(SmartDashboard.getNumber("Speed", 0));
    if (messageAccess) {
      messageDevice.info("NeoBoard Activated");
      messageAccess = false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     neoboard.NeoBoardSetSpeed(0);
     messageDevice.info("NeoBoard Deactivated");
     messageAccess = true;
  }

  public Command emergencyStop() {
    neoboard.emergencyProtocol();
    neoboard.NeoBoardSetSpeed(0);
    return null;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
