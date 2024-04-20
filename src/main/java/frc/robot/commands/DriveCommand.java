// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends Command {
    private DrivetrainSubsystem m_robotDrive;
    private Joystick m_Joystick;
    Double throttle;

    /**
     * Creates a new ExampleCommand.
     *
     * @param Drivetrain The subsystem used by this command.
     * @return
     */
    public DriveCommand(DrivetrainSubsystem drivetrain, Joystick joystick) {
        m_robotDrive = drivetrain;
        m_Joystick = joystick;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        m_robotDrive.DifferentialDrive(m_Joystick.getX(), m_Joystick.getZ());
        SmartDashboard.putNumber("Throttle Value", m_Joystick.getThrottle());
        SmartDashboard.putNumber("Joystick Input speed", m_Joystick.getX());
        SmartDashboard.putNumber("Joystick Input Rotation", m_Joystick.getZ());

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}