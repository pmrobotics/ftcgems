April Tag 10 - calculate robot's position on field
=================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8-14

      public class Minibot extends RobotDrive {
          // ...

          public String format(AprilTagDetection detection) {
              double range = detection.ftcPose.range;
              double bearing = detection.ftcPose.bearing;
              double yaw = detection.ftcPose.yaw;
              double tagx = detection.metadata.fieldPosition.get(0);
              double tagy = detection.metadata.fieldPosition.get(1);
              double theta = Math.toRadians(getHeading() + bearing);
              double fx = tagx - Math.cos(theta) * range;
              double fy = tagy - Math.sin(theta) * range;        
              return String.format("id=%d R=%.2f B=%.2f Y=%.2f\n   fx=%.2f fy=%.2f",
                                   detection.id, range, bearing, yaw, fx, fy );
          }
      }
