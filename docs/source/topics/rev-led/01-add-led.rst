LED 1 - add code to initialize LED device
=========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 6-7, 12-15

      public class Minibot extends RobotDrive {
      
          public AprilTagProcessor aprilTag;
          public VisionPortal visionPortal;
          
          public LED ledr;
          public LED ledg;
          
          public void init(HardwareMap hardwareMap) {
              super.init(hardwareMap);
              initAprilTag(hardwareMap);
              ledr = hardwareMap.get(LED.class, "ledr");
              ledg = hardwareMap.get(LED.class, "ledg");
              ledr.enable(false);
              ledg.enable(false);
          }
      
          // ...
