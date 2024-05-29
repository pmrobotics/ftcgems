DriveLogging 4 - drive at 50% speed when A button pressed
=========================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8-11
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  loopCount++;
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;

                  boolean apress = gamepad1.a;
                  if (apress) {
                     jx = 0.5;
                  }
      
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              } 
