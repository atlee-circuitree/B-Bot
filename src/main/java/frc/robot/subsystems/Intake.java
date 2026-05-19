// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.Slot1Configs;
import com.ctre.phoenix6.hardware.TalonFX;

public class Intake extends SubsystemBase {

  private final TalonFX feedMotor;
  private final TalonFX deployMotor;
  /** Creates a new Intake. */

 private final VoltageOut m_voltageOut = new VoltageOut(0);

  public Intake() {

    feedMotor   = new TalonFX(Constants.CAN_IDS.feedIntakeMotor, "FRC 1599B");
    deployMotor = new TalonFX(Constants.CAN_IDS.deployMotor,     "FRC 1599B");
    
    Slot0Configs slot0ConfigsUp = new Slot0Configs();
    slot0ConfigsUp.kP = Constants.Intake.DEPLOY_SLOT0_KP;
    slot0ConfigsUp.kI = 0.0;
    slot0ConfigsUp.kD = 0.0;

    Slot1Configs slot1ConfigsDown = new Slot1Configs();
    slot1ConfigsDown.kP = Constants.Intake.DEPLOY_SLOT1_KP;
    slot1ConfigsDown.kI = 0.0;
    slot1ConfigsDown.kD = 0.0;


  }

public void intake() {
    feedMotor.set(Constants.Intake.INTAKE_SPEED);
  }

public void stopWheels() {
    feedMotor.setControl(m_voltageOut.withOutput(0));
  
  }
  
   public void deployManual(double speed) {
    deployMotor.set(speed);
  }

  public void stopDeploy() {
    deployMotor.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
