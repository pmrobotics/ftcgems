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

    DualPad gpad;

    @Override
    public void runOpMode() {
        gpad = new DualPad();
        gpad.init();
        ElapsedTime loopTimer = new ElapsedTime();
        int loopCount = 0;
        
        int apress = 0;

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        waitForStart();
        
        loopTimer.reset();
        while (opModeIsActive()) {
            gpad.update(gamepad1, gamepad2);
            loopCount++;
            
            if (gpad.a && !gpad.previous.a) { apress++; }
            
            double s = loopTimer.seconds();
            if (s > 1) {
                loopTimer.reset();
                telemetry.addData("loopcycle", "avg loop cycle: %.0fμs", s/loopCount * 1000000);
                telemetry.addData("apress", apress);
                telemetry.addData("gpad", gpad);
                telemetry.addData("gpad.shift", gpad.shift);
                telemetry.update();
                loopCount = 0;
            }
        }
    }
}
