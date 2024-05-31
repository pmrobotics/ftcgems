Odometry 4 - drive to the "target" pose
=======================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 12-17

             while (opModeIsActive()) {
                 // ...

                 for (AprilTagDetection detection : currentDetections) {
                      if (detection.id == targetId) {
                          jw = detection.ftcPose.bearing * 0.02;
                          jx = (detection.ftcPose.range - 20) * 0.02;
                      }
                      telemetry.addData("tag", bot.format(detection));
                  }
                  
                  if (gpad.back) {
                      bot.driveToPose(targetPose, 0.3);
                  }
                  else { 
                      bot.driveXYW(jx, jy, jw);
                  }
                  
                  telemetry.addData("Status", "Running");
                  telemetry.addData("heading", bot.getHeading());
                  telemetry.addData("IMU heading", bot.getIMUHeading());
                  telemetry.update();
              }

   Now place the robot on the field, run ATeleop, and press the "back"
   button on the gamepad.

