IMU 7 - add setHeading() / getHeading()
=======================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4, 12-18 

      public class RobotDrive {

          IMU imu;
          double headingOffset = 0;

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
                
