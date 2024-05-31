Odometry paths 4 - add a followPath() function to AAuton
========================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 5-19

          public void runOpMode() {
              // ...
          }
      
          public void followPath(Minibot.Pose[] path) {
              int i = 0;
              while (i < path.length) {
                  if (!opModeIsActive()) return;
                  bot.updateTracking();
                  double dist = bot.driveToPose(path[i], 0.25);
                  telemetry.addData("path target", i);
                  telemetry.addData("target pose", path[i]);
                  telemetry.addData("field pose", bot.field);
                  telemetry.addData("dist", dist);
                  telemetry.update();
                  if (dist < 1.5) i++;
              }
              bot.driveXYW(0,0,0);
          }
      }

   | Now try running this autonomous mode.  
   |  * Place the robot on tile F4 (red alliance near backdrop)

   You can modify the path or add new ones to be followed.     

