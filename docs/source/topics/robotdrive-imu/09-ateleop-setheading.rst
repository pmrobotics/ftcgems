IMU 9 - display IMU Heading in ATeleop
======================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 13-15, 20

      public class ATeleop extends LinearOpMode {
          // ...
          public void runOpMode() {
              // ...

              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;

		  if (gamepad1.start) {
                      if (gamepad1.dpad_up) bot.setHeading(0);
                  }
                  
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.addData("heading", bot.getHeading());
                  telemetry.addData("IMU heading", bot.getIMUHeading());
                  telemetry.update();
              }
          }
      }
