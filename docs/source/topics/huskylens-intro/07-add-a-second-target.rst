HuskyDriveDemo 7 - add button to target color #2
================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8

              while (opModeIsActive()) {
                  double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
                  double jy = -gamepad1.left_stick_x;
                  double jw = -gamepad1.right_stick_x;

                  int targetId = -1;
                  if (gamepad1.x) targetId = 1;
                  if (gamepad1.y) targetId = 2;

                  HuskyLens.Block[] currentBlocks = huskylens.blocks();
                  telemetry.addData("blocks.length", currentBlocks.length);

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

                  telemetry.addData("Status", "Running");
                  telemetry.update();
              }

