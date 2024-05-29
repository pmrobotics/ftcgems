BasicDriveDemo 2 - Joystick forward/reverse (x)
===============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 10-12
     
          public void runOpMode() {
              bot = new RobotDrive();
              bot.init(hardwareMap);
              
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              waitForStart();

              while (opModeIsActive()) {
                  double jx = - gamepad1.left_stick_y;

                  bot.driveXYW(jx, 0, 0);

                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
          }

