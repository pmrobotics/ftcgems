MecDrive 4 - Joystick forward/reverse (x)
=========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 2, 9-11
     
          public void runOpMode() {
              initialize();
              
              telemetry.addData("Status", "Initialized");
              telemetry.update();
              waitForStart();

              while (opModeIsActive()) {
                  double jx = -gamepad1.left_stick_y;

                  driveXYW(jx, 0, 0);

                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }
          }

