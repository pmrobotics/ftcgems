HuskyAutonDemo 6 - wait for object to be detected
=================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4, 10-12, 14, 21

              // ...
              // Wait for the game to start (driver presses PLAY)
              // waitForStart();
              String randomization = "NONE";
              while (!isStarted()) {
                  telemetry.addData("Status", "Running");
                  HuskyLens.Block[] currentBlocks = huskylens.blocks();
                  for (HuskyLens.Block block : currentBlocks) {
                      telemetry.addData("block", block.toString());
                      if (block.x < 105) randomization = "LEFT";
                      else if (block.x < 215) randomization = "CENTER";
                      else randomization = "RIGHT";
                  }
                  telemetry.addData("randomization", randomization);
                  telemetry.update();
              }
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.addData("randomization", randomization);
                  telemetry.update();
              }
