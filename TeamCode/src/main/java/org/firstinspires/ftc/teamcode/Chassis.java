package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Chassis {
    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;
    IMU imu;

    public Chassis(HardwareMap hardwareMap) {
        fl = hardwareMap.dcMotor.get("front left");
        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        fr = hardwareMap.dcMotor.get("front right");
        bl = hardwareMap.dcMotor.get("back left");
        bl.setDirection(DcMotorSimple.Direction.REVERSE);
        br = hardwareMap.dcMotor.get("back right");


        // Retrieve the IMU from the hardware map
        imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);
    }

    public void robotDrive(double x, double y, double rx) {
        fl.setPower(y + x + rx);
        bl.setPower(y - x + rx);
        fr.setPower(y - x - rx);
        br.setPower(y + x - rx);

    }

    public void fieldDrive(double x, double y, double rx) {

        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        // Rotate the movement direction counter to the bot's rotation
        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;  // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;

        fl.setPower(frontLeftPower);
        bl.setPower(backLeftPower);
        fr.setPower(frontRightPower);
        br.setPower(backRightPower);
    }

    public void resetIMU() {
        imu.resetYaw();
    }

    public void forward(double pow) {
        fl.setPower(pow);
        bl.setPower(pow);
        fr.setPower(pow);
        br.setPower(pow);
    }

    public void backward(double pow) {
        fl.setPower(-pow);
        bl.setPower(-pow);
        fr.setPower(-pow);
        br.setPower(-pow);
    }

    public void stop() {
        fl.setPower(0);
        bl.setPower(0);
        fr.setPower(0);
        br.setPower(0);
    }

    public boolean turnAngle(double goal) {

        double current = imu.getRobotYawPitchRollAngles().getYaw();
        double error = goal - current;

        double pass = 0.01 * error;

        robotDrive(0, 0, -pass);

        if (error < 5 && error > -5) {
            stop();
            return true;
        } else { return false; }
    }


}
