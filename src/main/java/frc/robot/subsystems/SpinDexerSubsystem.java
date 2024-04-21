// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** Add your docs here. */
public class SpinDexerSubsystem extends SubsystemBase{
	CANSparkMax spinDexerMotor;
	SparkPIDController spinDexerController;

	public void Spindexer() {
		spinDexerMotor = new CANSparkMax(Constants.SpinDexer.spindDexerMotorID, MotorType.kBrushless);
		spinDexerMotor.restoreFactoryDefaults();
		spinDexerController.setP(Constants.SpinDexer.SpinDexer_kP);
		spinDexerController.setI(Constants.SpinDexer.SpinDexer_kI);
		spinDexerController.setD(Constants.SpinDexer.SpinDexer_kD);
		spinDexerController.setFF(Constants.SpinDexer.SpinDexer_kFF);
		spinDexerController = spinDexerMotor.getPIDController();
		spinDexerMotor.setIdleMode(IdleMode.kCoast);
		spinDexerMotor.setSmartCurrentLimit(25, 40, 1000);
		spinDexerMotor.getEncoder().setPositionConversionFactor(1);
		spinDexerMotor.burnFlash();
	}

	/**
	 * makes the main part of the spindexer spin
	 * 
	 * @param motorPercent is the speed of the motor
	 * 
	 */
	public void rotateClockWise(double motorPercent) {
		spinDexerMotor.set(motorPercent);
		SmartDashboard.putNumber("Spindexer %", motorPercent);
	}

	public void rotateCounterClockWise(double motorPercent) {
		spinDexerMotor.set(motorPercent);
		SmartDashboard.putNumber("Spindexer %", motorPercent);
	}

	public void stopRotating(double motorPercent) {
		spinDexerMotor.set(0);
	}
	public void setVelocity(double velocity) {
		spinDexerController.setReference(velocity, CANSparkMax.ControlType.kVelocity);
	  }
	@Override
	public void periodic() {
	  SmartDashboard.putNumber("Shooter Feeder Speed", spinDexerMotor.getEncoder().getVelocity());
	}
}
