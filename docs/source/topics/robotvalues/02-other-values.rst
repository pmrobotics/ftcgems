RobotDrive 2 - additional RobotValues examples
==============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 2-3

      public class RobotValues {
          public static DcMotor.Direction LEFTDIR = DcMotor.Direction.REVERSE;
          public static DcMotor.Direction RIGHTDIR = DcMotor.Direction.FORWARD;

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

