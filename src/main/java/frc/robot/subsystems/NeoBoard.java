// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

import java.util.logging.Logger;

public class NeoBoard extends SubsystemBase {
  CANSparkMax spinMotor1;
  CANSparkMax spinMotor2;

  Logger messageDevice = Logger.getLogger(NeoBoard.class.getName());
//  CANSparkMax spinMotor3;
//  CANSparkMax spinMotor4;
  /** Creates a new ExampleSubsystem. */
  public NeoBoard() {
    messageDevice.info("Preparing NeoBoard...");
    this.spinMotor1 = new CANSparkMax(1, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    this.spinMotor2 = new CANSparkMax(2, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    this.spinMotor1.setInverted(true);
    this.spinMotor2.setInverted(true);
    this.spinMotor1.setIdleMode(CANSparkBase.IdleMode.kCoast);
    this.spinMotor2.setIdleMode(CANSparkBase.IdleMode.kCoast);
    messageDevice.info("""
                       NeoBoard Ready \n
                       CURRENT DEVICES ONLINE:\n
                       """
                       + spinMotor1.getDeviceId() + "\n"
                       + spinMotor2.getDeviceId());


//    SmartDashboard.putBoolean("M2 Inverted", true);
//    SmartDashboard.putBoolean("M1 Inverted", false);
//    this.spinMotor3 = new CANSparkMax(3, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    //this.spinMotor4 = new CANSparkMax(4, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    //SmartDashboard.getNumber("motor speed", 0);
  }

  public void NeoBoardSetSpeed(double speed) {
    spinMotor1.set(speed);;
    spinMotor2.set(speed);;
//    spinMotor3.set(speed);;
//    spinMotor4.set(speed);;
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

  public void reverse(boolean input) {
    if (input) {
      spinMotor1.setInverted(true);
      spinMotor2.setInverted(true);
    }else {
      spinMotor1.setInverted(false);
      spinMotor2.setInverted(false);
    }
  }

  public void emergencyProtocol() {
    this.spinMotor2.setIdleMode(CANSparkBase.IdleMode.kBrake);
    this.spinMotor1.setIdleMode(CANSparkBase.IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

//    log("Battery Voltage", edu.wpi.first.wpilibj.RobotController.getBatteryVoltage());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
