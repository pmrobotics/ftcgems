Minibot class 2 - add code to initialize AprilTag processing
============================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 6-11

      public class Minibot {
          
          public AprilTagProcessor aprilTag;
          private VisionPortal visionPortal;

          public void initAprilTag(HardwareMap hardwareMap) {
              // Create the AprilTag processor the easy way.
              aprilTag = AprilTagProcessor.easyCreateWithDefaults();
              visionPortal = VisionPortal.easyCreateWithDefaults(
                      hardwareMap.get(WebcamName.class, "Webcam 1"), aprilTag);
          }
      
      }
      
