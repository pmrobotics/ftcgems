RobotDrive 2 - initDcMotor method
=================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8-14

      public class RobotDrive {

          DcMotorEx lf;
          DcMotorEx rf;
          DcMotorEx lb;
          DcMotorEx rb;

          public DcMotorEx initDcMotor(HardwareMap hardwareMap, 
                                       String name, 
                                       DcMotor.Direction dir) {
              DcMotorEx m = hardwareMap.get(DcMotorEx.class, name);
              m.setDirection(dir);
              return m;
          }

