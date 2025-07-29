MecDrive 5 - Joystick strafe (y)
================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 9-12
     
          public void runOpMode() {
              initialize();
              
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              waitForStart();

              while (opModeIsActive()) {
                  double jx = -gamepad1.left_stick_y;
                  double jy = -gamepad1.left_stick_x;

                  driveXYW(jx, jy, 0);

                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
          }

