// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.AntiJamerSubsystem;

public class AntiJamerCommand extends Command {
  
  AntiJamerSubsystem antiJamer;

  public AntiJamerCommand(AntiJamerSubsystem antiJamer) {
    this.antiJamer = antiJamer;
    addRequirements(antiJamer);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    antiJamer.RunAntiJamer(Constants.AntiJamer.RunAntiJamer);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    antiJamer.StopAntiJamer();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
