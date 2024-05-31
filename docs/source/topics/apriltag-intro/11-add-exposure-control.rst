April Tag 11 - add gain/exposure control
========================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 3-

      public class Minibot extends RobotDrive {
          // ...
          public boolean setManualExposure(LinearOpMode op, 
                                           int exposureMS, 
                                           int gain) {
              if (visionPortal == null) { return false; }
              while (!op.isStopRequested() 
                         && (visionPortal.getCameraState() 
                              != VisionPortal.CameraState.STREAMING)) {
                  op.sleep(20);
              }
              if (!op.isStopRequested()) {
                  ExposureControl exposureControl = 
                      visionPortal.getCameraControl(ExposureControl.class);
                  if (exposureControl.getMode() != ExposureControl.Mode.Manual) {
                      exposureControl.setMode(ExposureControl.Mode.Manual);
                      op.sleep(50);
                  }
                  exposureControl.setExposure((long)exposureMS, 
                                              TimeUnit.MILLISECONDS);
                  op.sleep(20);
                  GainControl gainControl = 
                      visionPortal.getCameraControl(GainControl.class);
                  gainControl.setGain(gain);
                  op.sleep(20);
                  return (true);
              }
              return (false);
          }
