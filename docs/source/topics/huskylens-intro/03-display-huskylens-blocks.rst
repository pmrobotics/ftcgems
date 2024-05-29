HuskyDriveDemo 3 - read HuskyLens blocks and display
====================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 6-11

              while (opModeIsActive()) {
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;

                  HuskyLens.Block[] currentBlocks = huskylens.blocks();
                  telemetry.addData("blocks.length", currentBlocks.length);

                  for(HuskyLens.Block block : currentBlocks) {
                      telemetry.addData("block", block.toString());
                  }

                  bot.driveXYW(jx, jy, jw);

                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }

