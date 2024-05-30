Field Centric Driving
=====================

.. container:: pmslide

   With field centric drive, the translation joystick controls the direction of the robot relative to the field instead of the robot frame.

   To achieve this, we adjust the x and y components of the robot's desired motion by the current heading of the robot.  

   If the field-oriented components are given by :math:`field_x` and :math:`field_y`, and the robot's heading is :math:`\theta`, then the robot-oriented components are calculated as

   .. math::  

      r_x = field_x \ cos(-\theta) - field_y \ sin(-\theta) \\
      r_y = field_x \ sin(-\theta) + field_y \ cos(-\theta) \\


.. toctree::   
   :glob:

   ??-*
