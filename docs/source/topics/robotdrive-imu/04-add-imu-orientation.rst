IMU 4 - define IMU orientation
==============================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4,5,10,11

      package org.firstinspires.ftc.teamcode;
      
      import com.qualcomm.robotcore.hardware.DcMotor;
      import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.LogoFacingDirection;
      import com.qualcomm.hardware.rev.RevHubOrientationOnRobot.UsbFacingDirection;
      
      public class RobotValues {
          public static DcMotor.Direction LEFTDIR = DcMotor.Direction.REVERSE;
          public static DcMotor.Direction RIGHTDIR = DcMotor.Direction.FORWARD;
          public static LogoFacingDirection LOGO_DIR = LogoFacingDirection.UP; 
          public static UsbFacingDirection USB_DIR = UsbFacingDirection.BACKWARD;               

          // ...
      }
