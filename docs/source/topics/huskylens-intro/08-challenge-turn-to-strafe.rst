HuskyDriveDemo 8 - challenge: strafe instead of turn
====================================================

.. container:: pmslide

   Q: How would you change this code so that the robot *strafes* to
   the target color instead of turning?

   .. code-block::
      :force:

                  for (HuskyLens.Block block : currentBlocks) {
                      int center = block.left + block.width / 2;
                      if (block.id == targetId) {
                          jw = (160 - center) * 0.004;
                          if (gamepad1.right_bumper) {
                              jx = (220 - block.top) * 0.002;
                          }
                      }
                      telemetry.addData("block", block.toString());
                  }

                  bot.driveXYW(jx, jy, jw);

.. dropdown:: Click to view answer

   .. container:: pmslide

      .. code-block::
         :emphasize-lines: 4

                     for (HuskyLens.Block block : currentBlocks) {
                         int center = block.left + block.width / 2;
                         if (block.id == targetId) {
                             jy = (160 - center) * 0.004;
                             if (gamepad1.right_bumper) {
                                 jx = (220 - block.top) * 0.002;
                             }
                         }
                         telemetry.addData("block", block.toString());
                     }
   
                     bot.driveXYW(jx, jy, jw);

