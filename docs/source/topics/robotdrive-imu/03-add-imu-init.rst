IMU 3 - add initIMU() function
==============================

.. container:: pmslide

   .. code-block::
      :name: RobotDrive.java
      :emphasize-lines: 9,12-17

      public class RobotDrive {
          // ...
      
          public void init(HardwareMap hardwareMap) {
              lf = initDcMotor(hardwareMap, "lf", LEFTDIR);
              rf = initDcMotor(hardwareMap, "rf", RIGHTDIR);
              lb = initDcMotor(hardwareMap, "lb", LEFTDIR);
              rb = initDcMotor(hardwareMap, "rb", RIGHTDIR);
              initIMU(hardwareMap);
          }
          
          public void initIMU(HardwareMap hardwareMap) {
              imu = hardwareMap.get(IMU.class, "imu");
              IMU.Parameters params = new IMU.Parameters(
                  new RevHubOrientationOnRobot(LOGO_DIR, USB_DIR));
              imu.initialize(params);
          }
