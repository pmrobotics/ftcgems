April Tag 7 - have robot turn toward selected tag
=================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 6-7, 12-14

                  // ...
                  if (gamepad1.start) {
                      if (gamepad1.dpad_up) bot.setHeading(0);
                  }
                  
                  int targetId = -1;
                  if (gamepad1.x) targetId = 4;
                  
                  List<AprilTagDetection> currentDetections =
                          bot.aprilTag.getDetections();
                  for (AprilTagDetection detection : currentDetections) {
                      if (detection.id == targetId) {
                          jw = detection.ftcPose.bearing * 0.02;
                      }
                      telemetry.addData("tag", bot.format(detection));
                  }
      
                  bot.driveXYW(jx, jy, jw);
