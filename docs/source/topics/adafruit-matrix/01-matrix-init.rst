LED 1 - add code to initialize LED device
=========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 3,7-19

      public class ConceptAdafruitLedMatrix extends LinearOpMode {

          AdafruitLedMatrix matrix;
      
          @Override
          public void runOpMode() {
              matrix = hardwareMap.get(AdafruitLedMatrix.class, "matrix");
      
              // Uncomment the line corresponding to your backpack
              // matrix.setFlavor(matrix.flavor.MINI8X8);
              // matrix.setFlavor(matrix.flavor.SMALL8X8);
              // matrix.setFlavor(matrix.flavor.SMALL8X16);
              // matrix.setFlavor(matrix.flavor.BICOLOR);
      
              matrix.setAutoClear(true);
              matrix.setBrightness(0x40);
              matrix.setRotation(0);
              matrix.drawBitmap(0x3c42a98585a9423cL, 0, 0, 1, 0);
              matrix.show();
      
              telemetry.addData("Status", "Initialized");
              telemetry.update();

              waitForStart();
              // ... 
