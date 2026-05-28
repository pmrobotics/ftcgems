.. rst-class:: pmslide

April Tag 7 - have robot turn toward selected tag
=================================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 6-7, 12-14

                  // ...
                  double jx = - gamepad1.left_stick_y;
                  double jw = - gamepad1.left_stick_x;
                  double jy = - gamepad1.right_stick_x;
                  
                  int targetId = -1;
                  if (gamepad1.x) targetId = 11;
                  
                  List<AprilTagDetection> currentDetections =
                          bot.aprilTag.getDetections();
                  for (AprilTagDetection detection : currentDetections) {
                      if (detection.id == targetId) {
                          jw = detection.ftcPose.bearing * 0.02;
                      }
                      telemetry.addData("tag", bot.format(detection));
                  }
      
                  bot.driveXYW(jx, jy, jw);
