Scale robot drive velocities
============================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 9

      public class RobotDrive {
          // ...
      
          public DcMotorEx initDcMotor(HardwareMap hardwareMap,
                                       String name,
                                       DcMotor.Direction dir) {
              DcMotorEx m = hardwareMap.get(DcMotorEx.class, name);
              m.setDirection(dir);
              m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
              return m;
          }
      
