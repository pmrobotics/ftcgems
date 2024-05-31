Odometry paths 2 - add Minibot initialization
=============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 5,10-11

      @Autonomous
      
      public class AAuton extends LinearOpMode {
      
          public Minibot bot;
      
          @Override
          public void runOpMode() {
              
              bot = new Minibot();
              bot.init(hardwareMap);
      
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              // Wait for the game to start (driver presses PLAY)
              waitForStart();
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
          }
      }
