IMU 2 - add IMU handle to RobotDrive
====================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 8

      public class RobotDrive {
      
          DcMotorEx lf;
          DcMotorEx rf;
          DcMotorEx lb;
          DcMotorEx rb;
          
          IMU imu;
          
          public void init(HardwareMap hardwareMap) {
              // ...
          }


