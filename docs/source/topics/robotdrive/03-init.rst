RobotDrive 3 - init method
==========================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8-13

      public class RobotDrive {

          DcMotorEx lf;
          DcMotorEx rf;
          DcMotorEx lb;
          DcMotorEx rb;

          public void init(HardwareMap hardwareMap) {
              lf = initDcMotor(hardwareMap, "lf", DcMotor.Direction.REVERSE);
              rf = initDcMotor(hardwareMap, "rf", DcMotor.Direction.FORWARD);
              lb = initDcMotor(hardwareMap, "lb", DcMotor.Direction.REVERSE);
              rb = initDcMotor(hardwareMap, "rb", DcMotor.Direction.FORWARD);
          }

          // ...
