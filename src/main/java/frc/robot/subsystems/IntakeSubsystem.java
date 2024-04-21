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


public class IntakeSubsystem extends SubsystemBase {
  	
	CANSparkMax intakeMotor;
	SparkPIDController intakeController;

	public void Intake() {
		//intakeMotor = new CANSparkMax(Constants.Intake.intakeMotor, MotorType.kBrushless);
    intakeMotor.restoreFactoryDefaults();
    intakeController.setP(Constants.Intake.INTAKE_kP);
    intakeController.setI(Constants.Intake.INTAKE_kI);
    intakeController.setD(Constants.Intake.INTAKE_kD);
    intakeController.setFF(Constants.Intake.INTAKE_kFF);
    intakeController = intakeMotor.getPIDController();
    intakeMotor.setIdleMode(IdleMode.kCoast);
    intakeMotor.setSmartCurrentLimit(25, 40, 1000);
    intakeMotor.getEncoder().setPositionConversionFactor(1);
    intakeMotor.burnFlash();
	}

	public void Intaking(double intakerunspeed){
		intakeMotor.set(intakerunspeed);
		SmartDashboard.putNumber("Intake %", intakerunspeed);
	}
  public void Outtaking(double intakerunspeed){
		intakeMotor.set(intakerunspeed);
		SmartDashboard.putNumber("Intake %", intakerunspeed);
	}
  public void Stopintaking(double intakerunspeed){
		intakeMotor.set(0);
		SmartDashboard.putNumber("Intake %", intakerunspeed);
	}
  public void setVelocity(double velocity) {
    intakeController.setReference(velocity, CANSparkMax.ControlType.kVelocity);
  }
  @Override
  public void periodic() {
    SmartDashboard.putNumber("INTAKE/leading roller speed", intakeMotor.getEncoder().getVelocity());
  }
}
