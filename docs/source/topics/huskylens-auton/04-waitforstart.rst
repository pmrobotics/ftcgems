HuskyAutonDemo 4 - check block for left/center/right
====================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 5-9

              // ...
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              // Wait for the game to start (driver presses PLAY)
              // waitForStart();
              while (!isStarted()) {
                  telemetry.addLine("Press PLAY to start");
                  telemetry.update();
              }

              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
