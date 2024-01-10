// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;


public class NeoBoard extends SubsystemBase {
  CANSparkMax spinMotor1;
  CANSparkMax spinMotor2;
  CANSparkMax spinMotor3;
  CANSparkMax spinMotor4;
  /** Creates a new ExampleSubsystem. */
  public NeoBoard() {
    this.spinMotor1 = new CANSparkMax(1, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    this.spinMotor2 = new CANSparkMax(2, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    this.spinMotor3 = new CANSparkMax(3, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    this.spinMotor4 = new CANSparkMax(4, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    SmartDashboard.getNumber("motor speed", 0);
  }

  public void NeoBoardSetSpeed(double speed) {
    spinMotor1.set(speed);;
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
