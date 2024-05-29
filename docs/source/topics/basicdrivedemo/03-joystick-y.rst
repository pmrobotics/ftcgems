BasicDriveDemo 3 - Joystick strafe left/right (y)
=================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 11-13
     
          public void runOpMode() {
              bot = new RobotDrive();
              bot.init(hardwareMap);
              
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              waitForStart();

              while (opModeIsActive()) {
                  double jx = - gamepad1.left_stick_y;
                  double jy = - gamepad1.left_stick_x;

                  bot.driveXYW(jx, jy, 0);

                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
          }

