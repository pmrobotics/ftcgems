IMU 6 - Create ATeleop, display IMU heading
===========================================

.. container:: pmslide

   Copy BasicDriveDemo.java to ATeleop.java

   Edit ATeleop.java to include IMU display

   .. code-block::
      :emphasize-lines: 16

      public class ATeleop extends LinearOpMode {
          // ...
          public void runOpMode() {
              // ...

              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;
                  
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.addData("IMU heading", bot.getIMUHeading());
                  telemetry.update();
              }
          }
      }
