April Tag 12 - better recognition set C270 exposure and gain
============================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 10

      public class ATeleop extends LinearOpMode {
      
          public Minibot bot;
      
          @Override
          public void runOpMode() {
              
              bot = new Minibot();
              bot.init(hardwareMap);
              bot.setManualExposure(this, 6, 120);
              
