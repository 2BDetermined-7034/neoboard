// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.subsystems.NeoBoard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
/** An example command that uses an example subsystem. */
public class NeoBoardIndexerCommand extends Command {
    private final NeoBoard neoboard;
    public boolean Alternative = false;


    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public NeoBoardIndexerCommand(NeoBoard subsystem) {
        this.neoboard = subsystem;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        /**
         * Takes data from smart dashboard.
         */
        neoboard.NeoBoardIndexerCurrentSpeed(SmartDashboard.getNumber("Indexer Speed", 0.0));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        neoboard.NeoBoardIndexerCurrentSpeed(0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
