// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.Drivetrain;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SpinDexerSubsystem;
import frc.robot.subsystems.XiaohanArcade;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final boolean intakeExists = Preferences.getBoolean("Intake", true);
  private final boolean shooterExists = Preferences.getBoolean("Shooter", true);
  private final boolean spindexerExists = Preferences.getBoolean("Spindexer", true);



  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private DrivetrainSubsystem driveTrainSubsystem;
  private IntakeSubsystem intake;
  private SpinDexerSubsystem spinDexer;
  private ShooterSubsystem shooter;
  DriveCommand defaultDriveCommand;
  private Joystick m_mainJoystick;

  
  BooleanSupplier shootingSupplier;
  BooleanSupplier intakeSupplier;
  BooleanSupplier outtakSupplier;
  DoubleSupplier moveDoubleSupplier;
  DoubleSupplier turnDoubleSupplier;
  ParallelCommandGroup intakeCommand;
  ParallelCommandGroup shootingCommand;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    Preferences.initBoolean("Intake", false);
    Preferences.initBoolean("Shooter", false);

  if(intakeExists) {intakeInst();}
  if(shooterExists) {shooterInst();}
  if(spindexerExists) {spindexerInst();}

    m_mainJoystick = new Joystick(Constants.OperatorConstants.kMainControllerPort);
    shootingSupplier = m_mainJoystick::getTrigger;
    intakeSupplier = ()-> m_mainJoystick.getPOV() == 0;
    outtakSupplier = ()-> m_mainJoystick.getPOV() == 180;

    driveTrainInst();
    intakeInst();
    shooterInst();
    spindexerInst();


 //configure the trigger bindings
    configureBindings();


  }

  private void driveTrainInst() {
    driveTrainSubsystem = new DrivetrainSubsystem();
    defaultDriveCommand = new DriveCommand(
    driveTrainSubsystem, 
        moveDoubleSupplier = ()-> m_mainJoystick.getY(), 
        turnDoubleSupplier = ()-> m_mainJoystick.getX());
    driveTrainSubsystem.setDefaultCommand(defaultDriveCommand);
   }

  private void intakeInst() {
    intake = new IntakeSubsystem();
  }

  private void shooterInst() {
    shooter = new ShooterSubsystem();
  }

  private void spindexerInst() {
    spinDexer = new SpinDexerSubsystem();
  }



  
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
