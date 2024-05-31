Odometry paths 3 - create a path for the robot to follow
========================================================

.. container:: pmslide

   .. code-block::
      :emphasize-lines: 5-15

               // ...
               // Wait for the game to start (driver presses PLAY)
               waitForStart();
               
               // bot starts in tile F4 with a initial heading of 90 degrees
               bot.setHeading(90);
               bot.setFieldXY(12, -60);
               
               Minibot.Pose[] path = new Minibot.Pose[]{
                   new Minibot.Pose(12, -36),
                   new Minibot.Pose(20, -36),
                   new Minibot.Pose(20, -56)
               };
               
               followPath(path);
               
           }
