package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    DcMotorEx leftMotor; // left one has the encoder
    DcMotorEx rightMotor;

    // max velocity around 2400

    public Shooter(HardwareMap hardwareMap) {

        leftMotor = (DcMotorEx) hardwareMap.dcMotor.get("outputLeft");
        rightMotor = (DcMotorEx) hardwareMap.dcMotor.get("outputRight");
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void shoot(double goal) {

        double error = goal - leftMotor.getVelocity();

        double pass = 0.00041 * goal + 0 * error;

        leftMotor.setPower(pass);
        rightMotor.setPower(pass);


    }

    public void setPower(double pow) {
        leftMotor.setPower(pow);
        rightMotor.setPower(pow);
    }

    public void reverse() {
        leftMotor.setPower(-1);
        rightMotor.setPower(-1);
    }

    public void stop() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public double getVelocity() {
        return leftMotor.getVelocity();
    }

    public double getPower() {
        return leftMotor.getPower();
    }

}
