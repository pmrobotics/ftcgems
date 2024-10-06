Odometry 5 - update the target pose
===================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4-7

              while (opModeIsActive()) {
                  // ...

                  // use current pose as new target
                  if (gamepad1.guide) {
                      targetPose = new Minibot.Pose(bot.field);
                  }
                  
                  if (gamepad1.back) {
                      bot.driveToPose(targetPose, 0.3);
                  }
                  else { 
                      bot.driveXYW(jx, jy, jw);
                  }

                  // ...
                  
              }

   Pressing "guide" will save the current robot's location as the new target.
