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
                  gpad.update(gamepad1, gamepad2);
                  double jx = -gpad.left_stick_y - gpad.right_stick_y;
                  double jy = -gpad.left_stick_x;
                  double jw = -gpad.right_stick_x;

		  if (gpad.start) {
                      if (gpad.dpad_up) bot.setHeading(0);
                  }
                  
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.addData("heading", bot.getHeading());
                  telemetry.addData("IMU heading", bot.getIMUHeading());
                  telemetry.update();
              }
          }
      }
