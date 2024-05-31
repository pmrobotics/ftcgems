April Tag 8 - have robot drive to target 
========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 14

                  // ...
                  if (gpad.start) {
                      if (gpad.dpad_up) bot.setHeading(0);
                  }
                  
                  int targetId = -1;
                  if (gpad.x) targetId = 4;
                  
                  List<AprilTagDetection> currentDetections =
                          bot.aprilTag.getDetections();
                  for (AprilTagDetection detection : currentDetections) {
                      if (detection.id == targetId) {
                          jw = detection.ftcPose.bearing * 0.02;
                          jx = (detection.ftcPose.range - 20) * 0.02; 
                      }
                      telemetry.addData("tag", bot.format(detection));
                  }
      
                  bot.driveXYW(jx, jy, jw);
