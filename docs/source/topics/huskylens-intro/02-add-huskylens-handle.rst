HuskyDriveDemo 2 - add HuskyLens variable and initialize
========================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4,10-12

      public class HuskyDriveDemo extends LinearOpMode {

          public RobotDrive bot;
          public HuskyLens huskylens;

          @Override
          public void runOpMode() {
              bot = new RobotDrive();
              bot.init(hardwareMap);

              huskylens = hardwareMap.get(HuskyLens.class, "huskylens");
              huskylens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

              // ...

