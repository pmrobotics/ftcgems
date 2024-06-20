HuskyAutonDemo 7 - let gamepad select alliance
=================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 5, 8-9, 17

              // ...
              // Wait for the game to start (driver presses PLAY)
              // waitForStart();
              String randomization = "NONE";
              String alliance = "NEITHER";
              while (!isStarted()) {
                  telemetry.addData("Status", "Running");
                  if (gamepad1.x) alliance = "BLUE";
                  if (gamepad1.b) alliance = "RED";
                  HuskyLens.Block[] currentBlocks = huskylens.blocks();
                  for (HuskyLens.Block block : currentBlocks) {
                      telemetry.addData("block", block.toString());
                      if (block.x < 105) randomization = "LEFT";
                      else if (block.x < 215) randomization = "CENTER";
                      else randomization = "RIGHT";
                  }
                  telemetry.addData("alliance", alliance);
                  telemetry.addData("randomization", randomization);
                  telemetry.update();
              }
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.addData("randomization", randomization);
                  telemetry.update();
              }
