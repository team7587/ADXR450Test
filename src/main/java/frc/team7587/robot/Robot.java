package frc.team7587.robot;

//essentials?
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team7587.robot.commands.AutonGroup;
//subsystems
import frc.team7587.robot.subsystems.DriveTrain;

public class Robot extends TimedRobot {

  public static DriveTrain m_driveTrain = new DriveTrain();
  public static OI m_oi = new OI();

  private Command m_autoCommand;
  // SendableChooser<Command> m_chooser = new SendableChooser<>();

  public Robot(){
    super();
    Utl.log("robot constructed");
  }


  @Override
  public void robotInit() {
    Utl.log("robotInit() called");
    m_autoCommand = new AutonGroup();

  }

  @Override
  public void robotPeriodic() {

    // Utl.log("robotPeriodic() called",100);
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void autonomousInit() {
    // schedule the autonomous command
    Utl.log("robot autonomousInit() called");
    if (m_autoCommand != null) {
      m_autoCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    Utl.log("robot.teleopInit() called");
    if (m_autoCommand != null) {
      m_autoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    // Utl.log("robot.teleopPeriodic() call", 100);
    Scheduler.getInstance().run();
  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {

  }

  public void log() {
    
    // m_driveTrain.log();
  }
}
