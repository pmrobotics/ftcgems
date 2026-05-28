.. rst-class:: pmslide

April Tag 5 - display AprilTag detections from minibot
======================================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 1, 11-15

      import java.util.List;

      public class ATeleop extends LinearOpMode {
              // ... 

              while (opModeIsActive()) {
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;
                  
                  List<AprilTagDetection> currentDetections = 
                          bot.aprilTag.getDetections();
                  for (AprilTagDetection detection : currentDetections) {
                      telemetry.addData("tag", bot.format(detection));
                  }
      
                  bot.driveXYW(jx, jy, jw);
                  
                  telemetry.addData("Status", "Running");
                  telemetry.addData("heading", bot.getHeading());
                  telemetry.update();
              }
