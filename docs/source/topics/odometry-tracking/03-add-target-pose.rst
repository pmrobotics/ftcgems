Odometry 3 - add a "target" pose variable
=============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4,11

              // Wait for the game to start (driver presses PLAY)
              waitForStart();
              
              Minibot.Pose targetPose = new Minibot.Pose(24, 0);
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  gpad.update(gamepad1, gamepad2);
                  bot.updateTracking();
                  telemetry.addData("fieldPose", bot.field);
                  telemetry.addData("targetPose", targetPose);
                  double jx = -gpad.left_stick_y - gpad.right_stick_y;
                  double jy = -gpad.left_stick_x;
                  double jw = -gpad.right_stick_x;
      
                  // ...
                    
