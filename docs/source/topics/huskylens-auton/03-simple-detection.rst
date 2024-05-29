HuskyAutonDemo 3 - scan for randomization 
=========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 7-10

              // ...
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              // Wait for the game to start (driver presses PLAY)
              waitForStart();
              
              HuskyLens.Block[] currentBlocks = huskylens.blocks();
              for (HuskyLens.Block block : currentBlocks) {

              }
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
