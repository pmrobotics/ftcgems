Odometry 3 - add a "target" pose variable
=============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4,10

              // Wait for the game to start (driver presses PLAY)
              waitForStart();
              
              Minibot.Pose targetPose = new Minibot.Pose(24, 0);
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  bot.updateTracking();
                  telemetry.addData("fieldPose", bot.field);
                  telemetry.addData("targetPose", targetPose);
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;
      
                  // ...
                    
