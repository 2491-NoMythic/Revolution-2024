// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

  SparkMax intakeMotor;
  SparkMaxConfig intakeConfig;

  public IntakeSubsystem() {
    intakeMotor = new SparkMax(Constants.Intake.IntakeMotorID, com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless);
    intakeConfig.apply(new ClosedLoopConfig().pidf(
      Constants.Intake.Intake_kP,
      Constants.Intake.Intake_kI,
      Constants.Intake.Intake_kD,
      Constants.Intake.Intake_kFF));
    intakeConfig.idleMode(IdleMode.kCoast);
    intakeConfig.smartCurrentLimit(25, 40, 1000);
    intakeConfig.encoder.positionConversionFactor(1);
  }

  public void Intaking(double intakeSpeed) {
    intakeMotor.set(intakeSpeed);
    SmartDashboard.putNumber("Intake Speed", intakeSpeed);
  }

  public void Outtaking(double intakeSpeed) {
    intakeMotor.set(intakeSpeed);
    SmartDashboard.putNumber("Intake Speed", intakeSpeed);
  }

  public void Stopintake(double intakeSpeed) {
    intakeMotor.set(0);
    SmartDashboard.putNumber("Intake Speed", intakeSpeed);
  }

  public void setIntakeVelocity(double intakeVelocity) {
    intakeConfig.setReference(intakeVelocity, SparkMax.ControlType.kVelocity);
  }

  @Override
  public void periodic() {
  }
}
