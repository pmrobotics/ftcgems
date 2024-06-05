LED 3 - make a countdown
========================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 13-20

      public class ConceptAdafruitLedMatrix extends LinearOpMode {

          AdafruitLedMatrix matrix;
      
          @Override
          public void runOpMode() {
              // ...
              waitForStart();
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  matrix.setRotation(0);
                  matrix.drawChar('3', 0, 0, 1, 0);
                  matrix.show();
                  sleep(1000);
                  
                  matrix.drawChar('2', 0, 0, 1, 0);
                  matrix.show();
                  sleep(1000);
                  
                  matrix.drawChar('1', 0, 0, 1, 0);
                  matrix.show();
                  sleep(1000);
                  
