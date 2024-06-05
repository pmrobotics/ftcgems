LED 2 - use gamepad right trigger to control LED brightness
===========================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 11-12

      public class HuskyLed extends LinearOpMode {

          ServoImplEx huskyled;
      
          @Override
          public void runOpMode() {
              // ...
              waitForStart();

              while (opModeIsActive()) {
                  double val = gamepad1.right_trigger;
                  huskyled.setPosition(val);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
          }
      }
