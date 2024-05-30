April Tag 5 - display AprilTag detections from minibot
======================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 11-20

              while (opModeIsActive()) {
                  gpad.update(gamepad1, gamepad2);
                  double jx = -gpad.left_stick_y - gpad.right_stick_y;
                  double jy = -gpad.left_stick_x;
                  double jw = -gpad.right_stick_x;
                  
                  if (gpad.start) {
                      if (gpad.dpad_up) bot.setHeading(0);
                  }
                  
                  List<AprilTagDetection> currentDetections = 
                          bot.aprilTag.getDetections();
                  for (AprilTagDetection detection : currentDetections) {
                      telemetry.addData("tag", 
                                        String.format("id=%d R=%.2f B=%.2f Y=%.2f",
                                                      detection.id,
                                                      detection.ftcPose.range,
                                                      detection.ftcPose.bearing,
                                                      detection.ftcPose.yaw));
                  }
      
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.addData("heading", bot.getHeading());
                  telemetry.addData("IMU heading", bot.getIMUHeading());
                  telemetry.update();
              }
