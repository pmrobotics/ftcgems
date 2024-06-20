April Tag 12 - better recognition set C270 exposure and gain
============================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 11

      public class ATeleop extends LinearOpMode {
      
          public Minibot bot;
          public DualPad gpad;
      
          @Override
          public void runOpMode() {
              
              bot = new Minibot();
              bot.init(hardwareMap);
              bot.setManualExposure(this, 6, 120);
              
              gpad = new DualPad();
