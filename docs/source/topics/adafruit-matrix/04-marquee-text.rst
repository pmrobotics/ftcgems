LED 4 - display marquee text
============================

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
                  int x = matrix.width()-1;
                  while (opModeIsActive()) {
                      if (!matrix.drawString("Hello World", x, 0, 1, 0)) break;
                      matrix.show();
                      sleep(75);
                      x--;
                  }                  

                  matrix.drawChar('3', 0, 0, 1, 0);
                  matrix.show();
                  sleep(1000);
                  
                  matrix.drawChar('2', 0, 0, 1, 0);
                  matrix.show();
                  sleep(1000);
                  
                  matrix.drawChar('1', 0, 0, 1, 0);
                  matrix.show();
                  sleep(1000);

                  // ...
