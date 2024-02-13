// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkLowLevel;
import com.ctre.phoenix6.hardware.TalonFX;;
import com.ctre.phoenix6.signals.NeutralModeValue;


public class NeoBoard extends SubsystemBase {
  TalonFX spinMotor1;
  TalonFX spinMotor2;
  TalonFX spinMotor3;

  /** Creates a new ExampleSubsystem. */
  public NeoBoard() {
    this.spinMotor1 = new TalonFX(1);
    this.spinMotor2 = new TalonFX(2);

    this.spinMotor1.setNeutralMode(NeutralModeValue.Coast);
    this.spinMotor2.setNeutralMode(NeutralModeValue.Coast);
  }

  public void NeoBoardSetSpeed(double speed) {
    spinMotor1.set(speed);;
    spinMotor2.set(speed);;
    //spinMotor3.set(speed);;
    //spinMotor4.set(speed);;
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
