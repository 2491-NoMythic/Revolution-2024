package frc.robot.subsystems;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
	TalonFX driveLeftMotor1;
	TalonFX driveRightMotor1;
	TalonFX driveLeftMotor2;
	TalonFX driveRightMotor2;
	XiaohanArcade m_robotDrive;
	TalonFXConfigurator leftConfigurator;
	TalonFXConfigurator rightConfigurator;

	public DrivetrainSubsystem() {

		// creating motors
		driveLeftMotor1 = new TalonFX(Constants.Drivetrain.driveTalonLeftMotor1);
		driveRightMotor1 = new TalonFX(Constants.Drivetrain.driveTalonRightMotor1);
		driveLeftMotor2 = new TalonFX(Constants.Drivetrain.driveTalonLeftMotor2);
		driveRightMotor2 = new TalonFX(Constants.Drivetrain.driveTalonRightMotor2);
		driveLeftMotor1.setInverted(false);
		driveRightMotor1.setInverted(true);
		driveLeftMotor1.setNeutralMode(NeutralModeValue.Brake);
		driveRightMotor1.setNeutralMode(NeutralModeValue.Brake);
		driveLeftMotor2.setNeutralMode(NeutralModeValue.Brake);
		driveRightMotor2.setNeutralMode(NeutralModeValue.Brake);

		leftConfigurator = driveLeftMotor1.getConfigurator();
		leftConfigurator.apply(
		new Slot0Configs().
			withKP(Constants.Drivetrain.Drivetrain_KP).
			withKI(Constants.Drivetrain.Drivetrain_KI).
			withKD(Constants.Drivetrain.Drivetrain_KP));
		rightConfigurator = driveRightMotor1.getConfigurator();
		rightConfigurator.apply(
			new Slot0Configs().
			withKP(Constants.Drivetrain.Drivetrain_KP).
			withKI(Constants.Drivetrain.Drivetrain_KI).
			withKD(Constants.Drivetrain.Drivetrain_KP));
		
		// Setting Followers

		driveLeftMotor2.setControl(new Follower(driveLeftMotor1.getDeviceID(), false));
		driveRightMotor2.setControl(new Follower(driveRightMotor1.getDeviceID(), false));

		m_robotDrive = new XiaohanArcade(driveLeftMotor1, driveRightMotor1);
	}

	public void DifferentialDrive(double speed, double rotation) {
		m_robotDrive.arcadeDrive(speed, rotation);
	}

	public void DifferentialDriveStop(double speed, double rotation) {
		m_robotDrive.arcadeDrive(0, 0);
	}

}
