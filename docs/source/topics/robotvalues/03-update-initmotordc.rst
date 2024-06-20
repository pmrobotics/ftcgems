RobotValues 3 - using RobotValues in other files
================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 1, 11-14

      import static org.firstinspires.ftc.teamcode.RobotValues.*;
      
      public class RobotDrive {
      
          DcMotorEx lf;
          DcMotorEx rf;
          DcMotorEx lb;
          DcMotorEx rb;
      
          public void init(HardwareMap hardwareMap) {
              lf = initDcMotor(hardwareMap, "lf", LEFTDIR);
              rf = initDcMotor(hardwareMap, "rf", RIGHTDIR);
              lb = initDcMotor(hardwareMap, "lb", LEFTDIR);
              rb = initDcMotor(hardwareMap, "rb", RIGHTDIR);
          }

          // ...
      
