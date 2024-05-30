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
        boolean aToggle = false;
        int aToggleCount = 0;
        
        while (opModeIsActive()) {
            gpad.update(gamepad1, gamepad2);
            
            if (gpad.a && !gpad.previous.a) {
                aToggle = !aToggle;
                aToggleCount++;
            }
            
            telemetry.addData("aToggle", aToggle ? "on" : "off");
            telemetry.addData("aToggleCount", aToggleCount);
            telemetry.addLine("-----");
            telemetry.addData("gpad.a", gpad.a);
            telemetry.addData("gpad.shift.a", gpad.shift.a);
            telemetry.addLine("-----");
            telemetry.addData("gpad", gpad);
            telemetry.addData("gpad.shift", gpad.shift);
            telemetry.update();
        }
    }
}
