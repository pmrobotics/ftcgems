package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class HuskyAutonDemo extends LinearOpMode {

    public RobotDrive bot;
    public HuskyLens huskylens;

    @Override
    public void runOpMode() {
        bot = new RobotDrive();
        bot.init(hardwareMap);
        
        huskylens = hardwareMap.get(HuskyLens.class, "huskylens");
        huskylens.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        // waitForStart();

        String randomization = "NONE";
        while (!isStarted()) {
            HuskyLens.Block[] currentBlocks = huskylens.blocks();
            for (HuskyLens.Block block : currentBlocks) {
                int blockCenter = block.left + block.width/2;
                if (blockCenter < 80) randomization = "LEFT";
                else if (blockCenter < 160) randomization = "CENTER";
                else randomization = "RIGHT";
            }
            // if (!randomization.equals("NONE")) break;
            telemetry.addData("randomization", randomization);
            telemetry.update();
        }

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.addData("randomization", randomization);
            telemetry.update();
        }
    }
}
