DriveLogging 2 - add DualPad initialization
=========================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 5,13

      @TeleOp
      public class ATeleop extends LinearOpMode {
      
          public RobotDrive bot;
          public DualPad gpad;
      
          @Override
          public void runOpMode() {
              
              bot = new RobotDrive();
              bot.init(hardwareMap);
              
              gpad = new DualPad();
      
              telemetry.addData("Status", "Initialized");
              telemetry.update();
