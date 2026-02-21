package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor motor;

    public Intake(HardwareMap hardwareMap) {

        motor = hardwareMap.dcMotor.get("intake");
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void in() {
        motor.setPower(1);
    }

    public void out() {
        motor.setPower(-1);
    }
    public void stop() {
        motor.setPower(0);
    }
}

