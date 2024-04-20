// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Constants;

/** Add your docs here. */
public class ShooterSubsystem {
    TalonFX leftShooterMotor;
    Follower rightShooterMotor;

public ShooterSubsystem() {
    leftShooterMotor = new TalonFX(Constants.Shooter.leftShooterMotor);
    rightShooterMotor = new Follower(4, true);

}
}
