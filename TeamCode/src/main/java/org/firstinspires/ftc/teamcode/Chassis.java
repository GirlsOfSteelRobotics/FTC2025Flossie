package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis {
    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;

    public Chassis(HardwareMap hardwareMap) {
        fl = hardwareMap.dcMotor.get("chassis");
        fr = hardwareMap.dcMotor.get("chassis");
        bl = hardwareMap.dcMotor.get("chassis");
        br = hardwareMap.dcMotor.get("chassis");
    }

    public void drive(double x,double y, double rx) {
        fl.setPower(y + x + rx);
        bl.setPower(y - x + rx);
        fr.setPower(y - x - rx);
        br.setPower(y + x - rx);

    };
}
