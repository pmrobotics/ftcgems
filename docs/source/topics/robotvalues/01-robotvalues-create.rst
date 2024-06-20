RobotValues 1 - RobotValues class and robot constants
=====================================================

.. container:: pmslide

   | Add a "New File" to OnBotJava:
   |   - name it "RobotValues" (.java)
   |   - use "None" as the Sample
   |   - select "Not an OpMode"

   .. code-block::
      :emphasize-lines: 1-12

      public class RobotValues {
          // define robot-specific motor/wheel constants
          public static final double TICKS_PER_REVOLUTION = 537.7;
          public static final double GEAR_RATIO = 1.0;
          public static final double WHEEL_DIAMETER = 96 / 25.4;

          // define calculated constants
          public static final double WHEEL_CIRCUMFERENCE = 
		WHEEL_DIAMETER * Math.PI;
          public static final double DISTANCE_PER_REVOLUTION = 
		WHEEL_CIRCUMFERENCE * GEAR_RATIO;
      }

