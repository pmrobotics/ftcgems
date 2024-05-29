RobotDrive 4 - driveXYW() method
================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 1-

          public void driveXYW(double rx, double ry, double rw) {
              double lfPower = rx - ry - rw;
              double rfPower = rx + ry + rw;
              double lbPower = rx + ry - rw;
              double rbPower = rx - ry + rw;

              lf.setPower(lfPower);
              rf.setPower(rfPower);
              lb.setPower(lbPower);
              rb.setPower(rbPower);
          }


