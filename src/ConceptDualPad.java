package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Concept: DualPad", group = "Concept")

public class ConceptDualPad extends LinearOpMode {
    
    DualPad gpad;

    @Override
    public void runOpMode() {
        
        gpad = new DualPad();

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            gpad.update(gamepad1, gamepad2);
            telemetry.addData("Status", "Running");
            telemetry.addData("gpad.count", gpad.count);
            telemetry.addData("gpad", gpad.toString());
            telemetry.addData("gpad.shift", gpad.shift.toString());
            telemetry.update();
        }
    }
}
