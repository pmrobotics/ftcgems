.. rst-class:: pmslide

April Tag 10 - calculate robot's position on field
==================================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 8-12

      public class Minibot extends RobotDrive {
          // ...

          public String format(AprilTagDetection detection) {
              double range = detection.ftcPose.range;
              double bearing = detection.ftcPose.bearing;
              double yaw = detection.ftcPose.yaw;
              double fx = detection.robotPose.getPosition().x;
              double fy = detection.robotPose.getPosition().y;
              double fh = detection.robotPose.getOrientation().getYaw(AngleUnit.DEGREES);
              return String.format("id=%d R=%.2f B=%.2f Y=%.2f\n   fx=%.2f fy=%.2f fh=%.2f",
                                   detection.id, range, bearing, yaw, fx, fy, fh );
          }
      }
