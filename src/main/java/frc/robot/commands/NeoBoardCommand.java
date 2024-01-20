// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.NeoBoard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class NeoBoardCommand extends Command {
  private final NeoBoard neoboard;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public NeoBoardCommand(NeoBoard subsystem) {
    this.neoboard = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    neoboard.NeoBoardSetSpeed(Constants.OperatorConstants.motorSpeed);
    // perhaps more code later.
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    neoboard.NeoBoardSetSpeed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
