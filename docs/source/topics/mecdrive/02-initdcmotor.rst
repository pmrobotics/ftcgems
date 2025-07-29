MecDrive 2 - init method
========================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 8-13

      public class MecDrive extends LinearOpMode {

          DcMotorEx lf;
          DcMotorEx rf;
          DcMotorEx lb;
          DcMotorEx rb;

          public void initialize() {
              lf = hardwareMap.get(DcMotorEx.class, "lf");
              rf = hardwareMap.get(DcMotorEx.class, "rf");
              lb = hardwareMap.get(DcMotorEx.class, "lb");
              rb = hardwareMap.get(DcMotorEx.class, "lb");

              lf.setDirection(DcMotorEx.Direction.REVERSE);
              rf.setDirection(DcMotorEx.Direction.FORWARD);
              lb.setDirection(DcMotorEx.Direction.REVERSE);
              rb.setDirection(DcMotorEx.Direction.FORWARD);
         }

         public void runOpMode() {
              // ...
