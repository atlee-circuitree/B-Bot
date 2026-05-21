// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants;

public class KickUp extends SubsystemBase {
  
  public final TalonFX KickUpMotor;
   
  /** Creates a new KickUp. */
  public KickUp() {
    KickUpMotor = new TalonFX(Constants.CAN_IDS.KickUp, "FRC 1599B")
  }

  public void shoot(){
    KickUpMotor.set(-Constants.KickUp.SHOOT_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
