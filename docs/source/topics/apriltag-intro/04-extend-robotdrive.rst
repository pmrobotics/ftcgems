.. rst-class:: pmslide

April Tag 4 - inherit from RobotDrive class
===============================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 1, 6-9

      public class Minibot extends RobotDrive {
          
          public AprilTagProcessor aprilTag;
          private VisionPortal visionPortal;

          public void init(HardwareMap hardwareMap) {
              super.init(hardwareMap);
              initAprilTag(hardwareMap);
          }

          public void initAprilTag(HardwareMap hardwareMap) {
              aprilTag = new AprilTagProcessor.Builder()
                  .setTagLibrary(AprilTagGameDatabase.getIntoTheDeepTagLibrary())
                  .build();
              visionPortal = VisionPortal.easyCreateWithDefaults(
                      hardwareMap.get(WebcamName.class, "Webcam 1"), aprilTag);
          }
      
      }
      
