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
	TalonFXConfigurator left1Configurator;
	TalonFXConfigurator left2Configurator;
	TalonFXConfigurator right1Configurator;
	TalonFXConfigurator right2Configurator;


	public void Drivetrain() {

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
		
		left1Configurator = driveLeftMotor1.getConfigurator();
		left1Configurator.apply(new Slot0Configs().withKP(0).withKI(0).withKD(0));
		left2Configurator = driveLeftMotor2.getConfigurator();
		left2Configurator.apply(new Slot0Configs().withKP(0).withKI(0).withKD(0));
		right1Configurator = driveRightMotor1.getConfigurator();
		right1Configurator.apply(new Slot0Configs().withKP(0).withKI(0).withKD(0));
		right2Configurator = driveRightMotor2.getConfigurator();
		right2Configurator.apply(new Slot0Configs().withKP(0).withKI(0).withKD(0));

		// Setting Followers

		driveLeftMotor2.setControl(new Follower(driveLeftMotor1.getDeviceID(), false));
		driveRightMotor2.setControl(new Follower(driveRightMotor1.getDeviceID(), false));

		m_robotDrive = new XiaohanArcade(driveLeftMotor1, driveRightMotor1);
	}

	public void DifferentialDrive(double speed, double rotation) {
		m_robotDrive.arcadeDrive(Constants.Drivetrain.driveSpeed, Constants.Drivetrain.turnSpeed);
	}

	public void DifferentialDriveStop(double speed, double rotation) {
		m_robotDrive.arcadeDrive(0, 0);
	}

	}
