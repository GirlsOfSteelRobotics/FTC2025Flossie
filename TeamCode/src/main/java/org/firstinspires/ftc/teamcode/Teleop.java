package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Teleop extends LinearOpMode
{
    @Override
    public void runOpMode() {
        Intake intake = new Intake(hardwareMap);
        Chassis chassis = new Chassis(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Spinner spinner = new Spinner(hardwareMap);
        Hood hood = new Hood(hardwareMap);
        Feeder feeder = new Feeder(hardwareMap);

        hood.setPosition(0);

        // Wait for the game to start (driver presses START)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double y = -gamepad2.left_stick_y; // Remember, Y stick is reversed!
            double x = gamepad2.left_stick_x;
            double rx = gamepad2.right_stick_x;

            //shooter.setPower(-gamepad1.left_stick_y);


            chassis.fieldDrive(x, y, rx);

            telemetry.addData("Shooter Velocity", shooter.getVelocity());
            telemetry.addData("Shooter Power", shooter.getPower());
            telemetry.addData("Hood Position", hood.getPosition());
            telemetry.addData("Feeder Power", feeder.getPower());
            telemetry.addData("IMU", chassis.imu.getRobotYawPitchRollAngles().getYaw());
            telemetry.update();

            if (gamepad2.options) {
                chassis.resetIMU();
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
                shooter.setPower(1);
            } else if (gamepad1.b) {
                shooter.reverse();
            } else if (gamepad1.right_bumper) {
                shooter.stop();
            }

            if (gamepad1.dpad_up) {
                hood.setPosition(hood.getPosition() + 0.01);
            } else if (gamepad1.dpad_down) {
                hood.setPosition(hood.getPosition() - 0.01);
            }

            if (gamepad1.dpad_left) {
                feeder.setPower(1);
            } else if (gamepad1.dpad_right){
                feeder.setPower(-1);
            } else {
                feeder.setPower(0);
            }


        }


    }
}
