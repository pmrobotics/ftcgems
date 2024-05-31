April Tag 6 - helper function to telemetry AprilTagDetections
=============================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4-10

      public class Minibot extends RobotDrive {
          // ...

          public String format(AprilTagDetection detection) {
              double range = detection.ftcPose.range;
              double bearing = detection.ftcPose.bearing;
              double yaw = detection.ftcPose.yaw;
              return String.format("id=%d R=%.2f B=%.2f Y=%.2f",
                                   detection.id, range, bearing, yaw );
          }          
      }
