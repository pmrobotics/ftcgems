LED 5 - rotated marquee text, different font
============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 12-21

      public class ConceptAdafruitLedMatrix extends LinearOpMode {

          AdafruitLedMatrix matrix;
      
          @Override
          public void runOpMode() {
              // ...
              waitForStart();
      
              // run until the end of the match (driver presses STOP)
              while (opModeIsActive()) {
                  matrix.setRotation(1);
                  int x0 = matrix.width()-1;
                  while (opModeIsActive()) {
                      if (!matrix.drawString(LedMatrix.font3x5, 
                                          "GRACIOUS PROFESSIONALISM", 
                                          x0, 0, 1, 0)) break;
                      matrix.show();
                      sleep(50);
                      x0--;
                  }

                  matrix.setRotation(0);
                  int x = matrix.width()-1;
                  while (opModeIsActive()) {
                      if (!matrix.drawString("Hello World", x, 0, 1, 0)) break;
                      matrix.show();
                      sleep(75);
                      x--;
                  }                  

                  // ...
