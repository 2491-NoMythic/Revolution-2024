// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpinDexer;

/** Add your docs here. */
public class SpinDexerSubsystem extends SubsystemBase{
	SparkMax spinDexerMotor;
	SparkMaxConfig spinDexerConfig;

	public SpinDexerSubsystem() {
		spinDexerMotor = new SparkMax(SpinDexer.SpindDexerMotorID, MotorType.kBrushless);
		spinDexerConfig.apply(new ClosedLoopConfig().pidf(
			SpinDexer.SpinDexer_kP,
			SpinDexer.SpinDexer_kI,
			SpinDexer.SpinDexer_kD,
			SpinDexer.SpinDexer_kFF));
		spinDexerConfig.idleMode(IdleMode.kCoast);
		spinDexerConfig.smartCurrentLimit(25, 40, 1000);
		spinDexerConfig.encoder.positionConversionFactor(1);
	}

	public void rotateClockWise(double spinDexerSpeed) {
		spinDexerMotor.set(spinDexerSpeed);
		SmartDashboard.putNumber("Spindexer Speed", spinDexerSpeed);
	}

	public void rotateCounterClockWise(double spinDexerSpeed) {
		spinDexerMotor.set(spinDexerSpeed);
		SmartDashboard.putNumber("Spindexer Speed", spinDexerSpeed);
	}

	public void stopRotating(double spinDexerSpeed) {
		spinDexerMotor.set(0);
	}
	public void setSpinDexerVelocity(double spinDexerVelocity) {
		spinDexerConfig.setReference(spinDexerVelocity, SparkMax.ControlType.kVelocity);
	  }
	@Override
	public void periodic() {
	}
}
