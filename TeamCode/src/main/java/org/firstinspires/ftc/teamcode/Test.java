package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@TeleOp
public class Test extends LinearOpMode
{
    @Override
    public void runOpMode() {
        Intake intake = new Intake(hardwareMap);
        Chassis chassis = new Chassis(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Spinner spinner = new Spinner(hardwareMap);
        Odometry odometry = new Odometry();
        // Wait for the game to start (driver presses START)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            odometry.loop();

            YawPitchRollAngles imuAngles = chassis.imu.getRobotYawPitchRollAngles();
            double yaw = imuAngles.getYaw(AngleUnit.DEGREES);
            chassis.fieldDrive(x, y, rx);

            telemetry.addData("Output Velocity", shooter.getVelocity());
            telemetry.addData("Output Power", shooter.getPower());
            telemetry.addData("IMU", chassis.imu.getRobotYawPitchRollAngles().getYaw());
            telemetry.update();

            if (gamepad1.options) {
                chassis.resetIMU();
                odometry.init();
            }

            if (gamepad1.left_trigger > 0.1) {
                intake.in();
                spinner.forward();
            } else if (gamepad1.a) {
                intake.out();
                spinner.backward();
            } else if (gamepad1.left_bumper) {
                intake.stop();
                spinner.stop();
            }

            if (gamepad1.right_trigger > 0.1) {
                shooter.shoot(2300);
            } else if (gamepad1.b) {
                shooter.reverse();
            } else if (gamepad1.right_bumper) {
                shooter.stop();
            }

            if (gamepad1.y) {
                spinner.backward();
            }


        }


    }
}
