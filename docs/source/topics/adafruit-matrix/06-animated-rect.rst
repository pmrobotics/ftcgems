LED 6 - animated rectangle
==========================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 12-24

      public class ConceptAdafruitLedMatrix extends LinearOpMode {

          AdafruitLedMatrix matrix;
      
          @Override
          public void runOpMode() {
              // ...
              waitForStart();
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  matrix.setRotation(0);
                  matrix.drawRect(3,3,2,2,1);
                  matrix.show();
                  sleep(250);
                  matrix.drawRect(2,2,4,4,1);
                  matrix.show();
                  sleep(250);
                  matrix.drawRect(1,1,6,6,1);
                  matrix.show();
                  sleep(250);
                  matrix.drawRect(0,0,8,8,1);
                  matrix.show();
                  sleep(250);

		  // ...

