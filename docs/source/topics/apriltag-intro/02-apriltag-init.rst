.. rst-class:: pmslide

Minibot class 2 - add code to initialize AprilTag processing
============================================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 6-12

      public class Minibot {
          
          public AprilTagProcessor aprilTag;
          private VisionPortal visionPortal;

          public void initAprilTag(HardwareMap hardwareMap) {
              aprilTag = new AprilTagProcessor.Builder()
                  .setTagLibrary(AprilTagGameDatabase.getIntoTheDeepTagLibrary())
                  .build();        
              visionPortal = VisionPortal.easyCreateWithDefaults(
                      hardwareMap.get(WebcamName.class, "Webcam 1"), aprilTag);
          }
      
      }
      
