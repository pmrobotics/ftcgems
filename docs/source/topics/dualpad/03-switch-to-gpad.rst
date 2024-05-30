DriveLogging 3 - switch to using DualPad (gpad)
===============================================

.. container:: pmslide

   Now we switch all of usages of "gamepad1" to be "gpad" instead:

   .. code-block::
      :emphasize-lines: 6-9

              // Wait for the game to start (driver presses PLAY)
              waitForStart();
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  gpad.update(gamepad1, gamepad2);
                  double jx = -gpad.left_stick_y - gpad.right_stick_y;
                  double jy = -gpad.left_stick_x;
                  double jw = -gpad.right_stick_x;
                  
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
