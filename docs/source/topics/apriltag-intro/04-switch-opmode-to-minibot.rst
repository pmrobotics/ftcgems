.. rst-class:: pmslide

Minibot class 4 - switch ATeleop to use Minibot
===============================================

.. container:: pmbox

   .. code-block::
      :emphasize-lines: 3, 8

      public class ATeleop extends LinearOpMode {
      
          public Minibot bot;
      
          @Override
          public void runOpMode() {
              
              bot = new Minibot();
              bot.init(hardwareMap);
              
              // ...
