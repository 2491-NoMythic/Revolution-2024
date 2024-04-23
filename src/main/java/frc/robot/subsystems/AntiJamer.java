// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class AntiJamer extends SubsystemBase {
  	
	CANSparkMax antiJamMotor;
	SparkPIDController antiJamController;

	public AntiJamer() {
		antiJamMotor = new CANSparkMax(Constants.AntiJamer.AntiJamerMotorID, MotorType.kBrushless);
        antiJamMotor.restoreFactoryDefaults();
    antiJamController.setP(Constants.AntiJamer.Antijamer_kP);
    antiJamController.setI(Constants.AntiJamer.Antijamer_kI);
    antiJamController.setD(Constants.AntiJamer.Antijamer_kD);
    antiJamController.setFF(Constants.AntiJamer.Antijamer_kFF);
    antiJamController = antiJamMotor.getPIDController();
    antiJamMotor.setIdleMode(IdleMode.kCoast);
    antiJamMotor.setSmartCurrentLimit(25, 40, 1000);
    antiJamMotor.getEncoder().setPositionConversionFactor(1);
    antiJamMotor.burnFlash();
	}

	public void RunAntiJamer(double antiJamSpeed){
		antiJamMotor.set(antiJamSpeed);
		SmartDashboard.putNumber("Intake %", antiJamSpeed);
	}
  public void StopAntiJamer(double antiJamSpeed){
        antiJamMotor.set(0);
		SmartDashboard.putNumber("Intake %", antiJamSpeed);
	}
  public void setVelocity(double velocity) {
    antiJamController.setReference(velocity, CANSparkMax.ControlType.kVelocity);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("INTAKE/leading roller speed", antiJamMotor.getEncoder().getVelocity());
  }
}
