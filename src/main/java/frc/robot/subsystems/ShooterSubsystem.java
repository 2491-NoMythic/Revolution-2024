// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants;

/** Add your docs here. */
public class ShooterSubsystem {
    TalonFX leftShooterMotor;
    TalonFX rightShooterMotor;
    TalonFXConfigurator leftShooterConfigurator;
	TalonFXConfigurator rightShooterConfigurator;

public ShooterSubsystem() {

    //setting the motors
    leftShooterMotor = new TalonFX(Constants.Shooter.leftShooterMotor);
    rightShooterMotor = new TalonFX(Constants.Shooter.rightShooterMotor);
    leftShooterMotor.setNeutralMode(NeutralModeValue.Coast);
    rightShooterMotor.setNeutralMode(NeutralModeValue.Brake);
    rightShooterMotor.setControl(new Follower(4, true));

    //PID tuning
    leftShooterConfigurator = leftShooterMotor.getConfigurator();
	leftShooterConfigurator.apply(new Slot0Configs().withKP(0).withKI(0).withKD(0));
    rightShooterConfigurator = rightShooterMotor.getConfigurator();
	rightShooterConfigurator.apply(new Slot0Configs().withKP(0).withKI(0).withKD(0));
	

}
}
