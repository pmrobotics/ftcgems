package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous

public class ConceptTFAuto extends LinearOpMode {

    public TFAuto tfAuto = null;
    private static String VUFORIA_KEY = 
        " -- YOUR NEW VUFORIA KEY GOES HERE  --- ";

    @Override
    public void runOpMode() {
        tfAuto = new TFAuto();
        tfAuto.init(hardwareMap, "Webcam 1", VUFORIA_KEY);
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        int scansize = 0;
        int autoChoice = 0;
        String lastSignal = "";
        
        // Wait for the game to start (driver presses PLAY)
        while (!opModeIsActive() && !isStopRequested()) {
            // scan for an object, select the one with highest confidence
            if (tfAuto.scan(TFAuto.Select.MAXCONF) != null) {
                scansize = tfAuto.scanRecognitions.size();
                lastSignal = tfAuto.scanResult.getLabel();
                if (lastSignal.equals("1 Bolt"))  autoChoice = 1;
                if (lastSignal.equals("2 Bulb"))  autoChoice = 2;
                if (lastSignal.equals("3 Panel")) autoChoice = 3;
            }
            telemetry.addData("autoChoice", autoChoice);
            telemetry.addData("lastSignal", lastSignal);
            telemetry.addData("scansize", scansize);
            telemetry.update();
        }
        
        // Driver has pressed play, so turn off TensorFlow
        // and start autonomous tasks
        tfAuto.stop();

        if (autoChoice == 1) {
            // run code for zone 1 here
            while (opModeIsActive()) {
                telemetry.addData("Auto", "Running autonomous zone 1");
                telemetry.update();
            }
        }

        if (autoChoice == 2) {
            // run code for zone 2 here
            while (opModeIsActive()) {
                telemetry.addData("Auto", "Running autonomous zone 2");
                telemetry.update();
            }
        }
        
        if (autoChoice == 3) {
            // run code for zone 1 here
            while (opModeIsActive()) {
                telemetry.addData("Auto", "Running autonomous zone 3");
                telemetry.update();
            }
        }
        
    }
}
