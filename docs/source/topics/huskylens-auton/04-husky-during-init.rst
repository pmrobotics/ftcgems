HuskyAutonDemo 8 - detect randomization during init
===================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 3,6,14

              // ...
              // Wait for the game to start (driver presses PLAY)
              // waitForStart();

              String randomization = "NONE";
              while (!isStarted()) {
                  HuskyLens.Block[] currentBlocks = huskylens.blocks();
                  for (HuskyLens.Block block : currentBlocks) {
                      telemetry.addData("husky", block);
                  }
              }
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.addData("randomization", randomization);
                  telemetry.update();
              }
