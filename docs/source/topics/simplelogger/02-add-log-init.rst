DriveLogging 2 - add SimpleLogger variable and initialize
=========================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4,11

      public class DriveLogging extends LinearOpMode {
      
          public RobotDrive bot;
          public SimpleLogger log;
      
          @Override
          public void runOpMode() {
              bot = new RobotDrive();
              bot.init(hardwareMap);
              
              log = new SimpleLogger();
      
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              // Wait for the game to start (driver presses PLAY)
              waitForStart();

              // ...
