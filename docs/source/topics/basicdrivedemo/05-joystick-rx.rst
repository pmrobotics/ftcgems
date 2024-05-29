BasicDriveDemo 4 - Joystick forward/backward on right joystick
==============================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 10
     
          public void runOpMode() {
              bot = new RobotDrive();
              bot.init(hardwareMap);
              
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              waitForStart();

              while (opModeIsActive()) {
                  double jx = - gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = - gamepad1.left_stick_x;
                  double jw = - gamepad1.right_stick_x;

                  bot.driveXYW(jx, jy, jw);

                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
          }

