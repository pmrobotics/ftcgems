Odometry 2 - add tracking to ATeleop 
====================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 4-6

              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  gpad.update(gamepad1, gamepad2);
                  bot.updateTracking();
                  telemetry.addData("field pose", bot.field);
                  double jx = -gpad.left_stick_y - gpad.right_stick_y;
                  double jy = -gpad.left_stick_x;
                  double jw = -gpad.right_stick_x;

                  // ...

   Now test your robot on the field; drive around and notice how
   it keeps track of its location ("field pose") on the field.

   You may want to remember to set a zero heading.
