HuskyAutonDemo 5 - display husky blocks during init()
=====================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 6-9

              // ...
              // Wait for the game to start (driver presses PLAY)
              // waitForStart();
              while (!isStarted()) {
                  telemetry.addData("Status", "Running");
                  HuskyLens.Block[] currentBlocks = huskylens.blocks();
                  for (HuskyLens.Block block : currentBlocks) {
                      telemetry.addData("block", block.toString());
                  }
                  telemetry.update();
              }
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.addData("randomization", randomization);
                  telemetry.update();
              }
