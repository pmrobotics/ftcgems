Odometry 2 - add tracking to ATeleop 
====================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 3-4

              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  bot.updateTracking();
                  telemetry.addData("field pose", bot.field);
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;

                  // ...

   Now test your robot on the field; drive around and notice how
   it keeps track of its location ("field pose") on the field.

   You may want to remember to set a zero heading.
