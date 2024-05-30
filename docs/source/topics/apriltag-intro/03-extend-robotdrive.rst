Minibot class 3 - inherit from RobotDrive class
===============================================

.. container:: pmslide

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
              // Create the AprilTag processor the easy way.
              aprilTag = AprilTagProcessor.easyCreateWithDefaults();
              visionPortal = VisionPortal.easyCreateWithDefaults(
                      hardwareMap.get(WebcamName.class, "Webcam 1"), aprilTag);
          }
      
      }
      
