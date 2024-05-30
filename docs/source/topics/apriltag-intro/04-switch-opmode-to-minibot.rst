Minibot class 4 - switch ATeleop to use Minibot
===============================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 3, 9

      public class ATeleop extends LinearOpMode {
      
          public Minibot bot;
          public DualPad gpad;
      
          @Override
          public void runOpMode() {
              
              bot = new Minibot();
              bot.init(hardwareMap);
              
              gpad = new DualPad();
              // ...
