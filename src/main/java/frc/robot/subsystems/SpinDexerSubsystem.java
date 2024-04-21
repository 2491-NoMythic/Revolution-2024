// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/** Add your docs here. */
public class SpinDexerSubsystem extends SubsystemBase{
	CANSparkMax spinDexerMotor;

	public void Spindexer() {
		//spinDexerMotor = new CANSparkMax(Constants.SpinDexer.spindDexerMotor, MotorType.kBrushless);
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
}
