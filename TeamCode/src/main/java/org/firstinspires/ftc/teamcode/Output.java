package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Output {
    DcMotor motor;

    public Output(HardwareMap hardwareMap) {
        motor = hardwareMap.dcMotor.get("output");
    }

    public void forward() {
        motor.setPower(1);
    }
    public void backward() {
        motor.setPower(-1);
    }
    public void stop() {
        motor.setPower(0);
    }
}
