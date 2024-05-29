HuskyAutonDemo 2 - remove teleop code
=====================================

.. container:: pmslide

   Change "@Teleop" to read "@Autonomous", and remove all of the teleop code to leave this basic framework:

   .. code-block::
      :emphasize-lines: 1-

      @Autonomous
      public class HuskyAutonDemo extends LinearOpMode {
      
          public RobotDrive bot;
          public HuskyLens huskylens;
      
          @Override
          public void runOpMode() {
              bot = new RobotDrive();
              bot.init(hardwareMap);
              
              huskylens = hardwareMap.get(HuskyLens.class, "huskylens");
              huskylens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);
      
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
