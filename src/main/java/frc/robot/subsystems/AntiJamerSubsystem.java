// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class AntiJamerSubsystem extends SubsystemBase {
  	
	SparkMax antiJamMotor;
	SparkMaxConfig antiJamConfig;
  

	public AntiJamerSubsystem() {
		antiJamMotor = new SparkMax(Constants.AntiJamer.AntiJamerMotorID, MotorType.kBrushless);
    antiJamConfig.apply(new ClosedLoopConfig().pidf(
      Constants.AntiJamer.Antijamer_kP,
      Constants.AntiJamer.Antijamer_kI,
      Constants.AntiJamer.Antijamer_kD,
      Constants.AntiJamer.Antijamer_kFF));
    antiJamMotor.restoreFactoryDefaults();
    antiJamConfig.
    antiJamConfig.s(Constants.AntiJamer.Antijamer_kP);
    antiJamConfig.setI(Constants.AntiJamer.Antijamer_kI);
    antiJamConfig.setD(Constants.AntiJamer.Antijamer_kD);
    antiJamConfig.setFF(Constants.AntiJamer.Antijamer_kFF);
    antiJamConfig = antiJamMotor.getPIDController();
    antiJamMotor.setIdleMode(IdleMode.kCoast);
    antiJamMotor.setSmartCurrentLimit(25, 40, 1000);
    antiJamMotor.getEncoder().setPositionConversionFactor(1);
    antiJamMotor.burnFlash();
	}

	public void RunAntiJamer(double antiJamerSpeed){
		antiJamMotor.set(antiJamerSpeed);
		SmartDashboard.putNumber("AntiJamer Speed", antiJamerSpeed);
	}
  public void StopAntiJamer(){
        antiJamMotor.set(0);
		SmartDashboard.putNumber("AntiJamer Speed", 0);
	}
  public void setVelocity(double antiJamerVelocity) {
    antiJamConfig.setReference(antiJamerVelocity, CANSparkMax.ControlType.kVelocity);
  }
  @Override
  public void periodic() {
  }
}
