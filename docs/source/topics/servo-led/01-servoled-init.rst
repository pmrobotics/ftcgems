LED 1 - add code to initialize LED device
=========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 3,8-9

      public class HuskyLed extends LinearOpMode {

          ServoImplEx huskyled;
      
          @Override
          public void runOpMode() {

              huskyled = hardwareMap.get(ServoImplEx.class, "huskyled");
              huskyled.setPosition(0);
      
              telemetry.addData("Status", "Initialized");
              telemetry.update();

              waitForStart();
              // ... 
