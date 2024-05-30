IMU 7 - add setHeading() / getHeading()
=======================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8-14

      public class RobotDrive {
          // ...
     
          public double getIMUHeading() {
              return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
          }

          public void setHeading(double h) {
              headingOffset = h - getIMUHeading();
          }

          public double getHeading() {
              return headingOffset + getIMUHeading();
          }
                
