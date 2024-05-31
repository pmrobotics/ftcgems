Load the RobotDrivePm code
==========================

.. container:: pmslide

   #. Upload "RobotDrivePm.java" from src/ subdirectory
   #. Change Minibot class to extend RobotDrivePm

   .. code-block::
      :emphasize-lines: 1

      public class Minibot extends RobotDrivePm {
      
          public AprilTagProcessor aprilTag;
          public VisionPortal visionPortal;

          // ...
          
