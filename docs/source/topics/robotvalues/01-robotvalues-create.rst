RobotDrive 1 - RobotDrive class and motor variables
===================================================

.. container:: pmslide

   | Add a "New File" to OnBotJava:
   |   - name it "RobotValues" (.java)
   |   - use "None" as the Sample
   |   - select "Not an OpMode"

   .. code-block::
      :emphasize-lines: 1-4

      public class RobotValues {
          public static DcMotor.Direction LEFTDIR = DcMotor.Direction.REVERSE;
          public static DcMotor.Direction RIGHTDIR = DcMotor.Direction.FORWARD;
      }

