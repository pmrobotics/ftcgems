BasicDriveDemo 1 - RobotDrive variable and initialization
==============================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 3,7-8

      public class BasicDriveDemo extends LinearOpMode {

          public RobotDrive bot;

          @Override
          public void runOpMode() {
              bot = new RobotDrive();
              bot.init(hardwareMap);
              
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              waitForStart();

              while (opModeIsActive()) {

