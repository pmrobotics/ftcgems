HuskyAutonDemo 7 - waitForStart() equivalent loop
=================================================

.. container:: pmslide

   The statement

   .. code-block::

      waitForStart();

   is essentially the same as writing

   .. code-block::

      while (!isStarted()) {
          // do stuff here!
      }

   except you can specify things for the program to do while it's waiting...

   ... like looking for randomization. 


