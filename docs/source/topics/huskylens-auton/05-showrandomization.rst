HuskyAutonDemo 5 - display randomization
========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 17

              // ...
              // Wait for the game to start (driver presses PLAY)
              waitForStart();

              String randomization = "NONE";              
              HuskyLens.Block[] currentBlocks = huskylens.blocks();
              for (HuskyLens.Block block : currentBlocks) {
                  int blockCenter = block.left + block.width/2;
                  if (blockCenter < 80) randomization = "LEFT";
                  else if (blockCenter < 160) randomization = "CENTER";
                  else randomization = "RIGHT";
              }
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.addData("randomization", randomization);
                  telemetry.update();
              }
