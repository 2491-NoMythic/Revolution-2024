// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kMainControllerPort = 0;
  }

  public final class Drivetrain {
    public final static int driveTalonLeftMotor1 = 0;
    public final static int driveTalonLeftMotor2 = 1;
    public final static int driveTalonRightMotor1 = 2;
    public final static int driveTalonRightMotor2 = 3;
    public final static double driveSpeed = 1;
    public final static double turnSpeed = .5;
    public static final double MAX_POWER_OUTPUT = 0.3;
    
    public static final double Drivetrain_KP = .2;
    public static final double Drivetrain_KI = 1;
    public static final double Drivetrain_KD = .01;
  }

  public final class Shooter {
    public final static int leftShooterMotorID = 4;
    public final static int rightShooterMotorID = 5;
    public final static int servo1PwmID = 6;
    public final static int servo2PwmID = 7;
    public final static int photonCannonPwmID = 8;

    public final static double shooterEncoderTicks = 2048.0; // Encoder ticks per wheel rotation is 2048
    public final static double shooterWheelDiameter = 4.0; // Inches
    public final static double shooterEncoderToInches = shooterWheelDiameter * Math.PI / shooterEncoderTicks; // Makes number of inches
    public final static double shooterEncoderVelocityToRPS = 1.0 / shooterEncoderTicks * 10;
    public static final double shootSpeedRpm = 20000; // Rpm
    public static final double shootSpeedRps = 19500;// TODO change for reality.

    public static final double Shooter_kP = 0.00002;
    public static final double Shooter_kI = 0;
    public static final double Shooter_kD = 0.0008;
  }

  public final class SpinDexer {
    public final static int spindDexerMotorID = 9;
    public final static double rotateClockWise = .33; 
		public final static double rotateCounterClockWise = -.33;
    public static final double SpinDexer_kP = 0.00002;
    public static final double SpinDexer_kI = 0;
    public static final double SpinDexer_kD = 0.0008;
    public static final double SpinDexer_kFF = 0.000085;
  }

  public final class Intake {
    public final static int intakeMotorID = 10;
    public final static double intakeSpeed = .25;
    public final static double outtakeSpeed = -.25;
    public static final double Intake_kP = 0.00002;
    public static final double Intake_kI = 0;
    public static final double Intake_kD = 0.0008;
    public static final double Intake_kFF = 0.000085;
  }

  public final class ShooterFeeder {
    public final static int ShooterFeederMotorID = 11;
    public final static double shooterFeeding = .5;
    public static final double ShooterFeeder_kP = 0;
    public static final double ShooterFeeder_kI = 0;
    public static final double ShooterFeeder_kD = 0;
    public static final double ShooterFeeder_kFF = 0;
  }
}
