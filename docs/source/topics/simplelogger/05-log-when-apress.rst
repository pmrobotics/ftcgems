DriveLogging 5 - log data for 100 loops after apress
====================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 11, 14-18
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  loopCount++;
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;

                  boolean apress = gamepad1.a;
                  if (apress) {
                     jx = 0.5;
                     logUntil = loopCount + 100;
                  }

                  if (loopCount < logUntil) {
                     log.add(loopCount).add(apress)
                        .add(bot.lf.getCurrentPosition())
                        .tsLine();
                  }
      
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              } 
