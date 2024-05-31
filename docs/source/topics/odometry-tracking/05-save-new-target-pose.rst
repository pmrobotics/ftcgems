Odometry 5 - update the target pose
===================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4-7

              while (opModeIsActive()) {
                  // ...

                  // use current pose as new target
                  if (gpad.shift.back) {
                      targetPose = new Minibot.Pose(bot.field);
                  }
                  
                  if (gpad.back) {
                      bot.driveToPose(targetPose, 0.3);
                  }
                  else { 
                      bot.driveXYW(jx, jy, jw);
                  }

                  // ...
                  
              }

   Pressing "shift+back"  (left bumper + shift) will save the current
   robot's location as the new target.
