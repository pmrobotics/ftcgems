.. rst-class:: pmslide

April Tag 9 - add code to initialize AprilTag processing
============================================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 1-2, 6-7, 14

      import org.firstinspires.ftc.robotcore.external.navigation.Position;
      import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

      public class Minibot {

          Position cameraPosition = new Position(DistanceUnit.INCH, 0, 0, 0, 0);
          YawPitchRollAngles cameraOrientation = new YawPitchRollAngles(AngleUnit.DEGREES, 0, -90, 0, 0);
          
          public AprilTagProcessor aprilTag;
          private VisionPortal visionPortal;

          public void initAprilTag(HardwareMap hardwareMap) {
              aprilTag = new AprilTagProcessor.Builder()
                 .setCameraPose(cameraPosition, cameraOrientation)
                 .setTagLibrary(AprilTagGameDatabase.getIntoTheDeepTagLibrary())
                 .build();
              visionPortal = VisionPortal.easyCreateWithDefaults(
                      hardwareMap.get(WebcamName.class, "Webcam 1"), aprilTag);
          }
      
      }
      
