package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class DriveLogging extends LinearOpMode {

    public RobotDrive bot;
    public SimpleLogger log;

    @Override
    public void runOpMode() {
        bot = new RobotDrive();
        bot.init(hardwareMap);
        
        log = new SimpleLogger();

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        
        log.open();
        log.add("loop").add("apress")
            .add("lf").add("rf").add("lb").add("rb")
            .headerLine();
        int loopCount = 0;
        int logUntil = 0;

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            loopCount++;
            double jx = -gamepad1.left_stick_y - gamepad1.right_stick_y;
            double jy = -gamepad1.left_stick_x;
            double jw = -gamepad1.right_stick_x;

            boolean apress = gamepad1.a;
            if (apress) {
               jx = 0.5;
               logUntil = loopCount + 100;
            }

            if (loopCount < logUntil) {
               log.add(loopCount).add(apress)
                  .add(bot.lf.getCurrentPosition())
                  .tsLine();
            }

            bot.driveXYW(jx, jy, jw);

            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
