LED 2 - turn on LED when tag detected
=====================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 12, 14, 21

      public class ATeleop extends LinearOpMode {
          // ...
      
          public void runOpMode() {
              // ...
      
              while (opModeIsActive()) {
                  // ...
      
                  List<AprilTagDetection> currentDetections =
                          bot.aprilTag.getDetections();
                  boolean tagSeen = false;
                  for (AprilTagDetection detection : currentDetections) {
                      tagSeen = true;
                      if (detection.id == targetId) {
                          jw = detection.ftcPose.bearing * 0.02;
                          jx = (detection.ftcPose.range - 20) * 0.02;
                      }
                      telemetry.addData("tag", bot.format(detection));
                  }
                  bot.ledg.enable(tagSeen);
     
   Try driving the robot around the field or placing an AprilTag in front
   of the camera.

   The LED should light green whenever a tag is detected. 
