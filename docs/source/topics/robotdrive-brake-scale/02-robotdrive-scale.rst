Scale robot drive velocities
============================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 9

      public class RobotDrive {
          // ...
     
       double denom = Math.max(
                            1,
                            (Math.abs(rx)+Math.abs(ry)+Math.abs(rw))
                        );
        
        double lfPower = (rx - ry - rw) / denom;
        double rfPower = (rx + ry + rw) / denom;
        double lbPower = (rx + ry - rw) / denom;
        double rbPower = (rx - ry + rw) / denom; 
