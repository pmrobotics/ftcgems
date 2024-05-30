April Tag 8 - add more targets
==============================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8-9

                  // ...
                  if (gpad.start) {
                      if (gpad.dpad_up) bot.setHeading(0);
                  }
                  
                  int targetId = -1;
                  if (gpad.x) targetId = 4;
                  if (gpad.y) targetId = 5;
                  if (gpad.b) targetId = 6;
                  
                  List<AprilTagDetection> currentDetections =
                          bot.aprilTag.getDetections();
                  for (AprilTagDetection detection : currentDetections) {
                      if (detection.id == targetId) {
                          jw = detection.ftcPose.bearing * 0.02;
                          jx = (detection.ftcPose.range - 20) * 0.02; 
                      }
                      telemetry.addData("tag",
                                        String.format("id=%d R=%.2f B=%.2f Y=%.2f",
                                                      detection.id,
                                                      detection.ftcPose.range,
                                                      detection.ftcPose.bearing,
                                                      detection.ftcPose.yaw));
                  }
      
                  bot.driveXYW(jx, jy, jw);
