Minibot class 1 - create a class to hold other robot parts
==========================================================

.. container:: pmslide

   | Add a "New File" to OnBotJava:
   |   - name it "Minibot" (.java)
   |   - use "None" as the Sample
   |   - select "Not an OpMode"

   .. code-block::
      :emphasize-lines: 3-4

      public class Minibot {
          
          public AprilTagProcessor aprilTag;
          private VisionPortal visionPortal;
      
      }
      
