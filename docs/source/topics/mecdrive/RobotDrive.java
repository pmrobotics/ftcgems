package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class RobotDrive {

    DcMotorEx lf;
    DcMotorEx rf;
    DcMotorEx lb;
    DcMotorEx rb;
    
    public void init(HardwareMap hardwareMap) { 
        lf = initDcMotor(hardwareMap, "lf", DcMotor.Direction.REVERSE);
        rf = initDcMotor(hardwareMap, "rf", DcMotor.Direction.FORWARD);
        lb = initDcMotor(hardwareMap, "lb", DcMotor.Direction.REVERSE);
        rb = initDcMotor(hardwareMap, "rb", DcMotor.Direction.FORWARD);
    }
    
    public DcMotorEx initDcMotor(HardwareMap hardwareMap, 
                                 String name, 
                                 DcMotor.Direction dir) {
        DcMotorEx m = hardwareMap.get(DcMotorEx.class, name);
        m.setDirection(dir);
        m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        return m;
    }
    
    public void driveXYW(double rx, double ry, double rw) {
        double lfPower = rx - ry - rw;
        double rfPower = rx + ry + rw;
        double lbPower = rx + ry - rw;
        double rbPower = rx - ry + rw;
        
        lf.setPower(lfPower);
        rf.setPower(rfPower);
        lb.setPower(lbPower);
        rb.setPower(rbPower);
    }
    
    public static double scaleclip(double n, double x1, double x2, double y1, double y2) {
        double result = Range.scale(n, x1, x2, y1, y2);
        double maxy = Math.max(y1,y2);
        double miny = Math.min(y1,y2);
        if (result > maxy) result = maxy;
        if (result < miny) result = miny;
        return result;
    }
    
}
