LED 3 - Adjust the pwm range for brighter LED
=============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 1,11

      import com.qualcomm.robotcore.hardware.PwmControl;

      public class HuskyLed extends LinearOpMode {
          ServoImplEx huskyled;
      
          @Override
          public void runOpMode() {
              
              huskyled = hardwareMap.get(ServoImplEx.class, "huskyled");
              huskyled.setPosition(0);
              huskyled.setPwmRange(new PwmControl.PwmRange(0,4000,5000));
      
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              // Wait for the game to start (driver presses PLAY)
              waitForStart();

              // ...
