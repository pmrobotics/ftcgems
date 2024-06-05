LED 2 - display a "1" on the matrix
=========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 12-15

      public class ConceptAdafruitLedMatrix extends LinearOpMode {

          AdafruitLedMatrix matrix;
      
          @Override
          public void runOpMode() {
              // ...
              waitForStart();
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  matrix.setRotation(0);
                  matrix.drawChar('1', 0, 0, 1, 0);
                  matrix.show();
                  sleep(1000);
                 
                  // ...
              } 
