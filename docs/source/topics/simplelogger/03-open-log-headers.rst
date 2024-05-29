DriveLogging 3 - open log file and output headers
=================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4-9, 13
      
              // Wait for the game to start (driver presses PLAY)
              waitForStart();
     
              log.open();
              log.add("loop").add("apress")
                  .add("lf")
                  .headerLine();
              int loopCount = 0;
              int logUntil = 0;         
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  loopCount++;
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;
      
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              } 
