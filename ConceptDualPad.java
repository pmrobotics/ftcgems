package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class ConceptDualPad extends LinearOpMode {

    DualPad dpad;
    ElapsedTime timer;

    @Override
    public void runOpMode() {
        dpad = new DualPad();
        dpad.init();
        timer = new ElapsedTime();
        
        int count = 0;
        int apress = 0;

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            dpad.update(gamepad1, gamepad2);
            count++;
            
            if (dpad.a && !dpad.previous.a) { apress++; }
            
            if (timer.seconds() > 1) {
                timer.reset();
                telemetry.addData("count", count);
                telemetry.addData("apress", apress);
                telemetry.addData("dpad", dpad);
                telemetry.addData("dpad.shift", dpad.shift);
                telemetry.update();
                count = 0;
            }
        }
    }
}
