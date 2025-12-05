package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Telop extends LinearOpMode
{
    @Override
    public void runOpMode() {
        Intake fjkldafjdkl = new Intake(hardwareMap);
        Chassis chassis = new Chassis(hardwareMap);
        Output output = new Output(hardwareMap);
        Spinner spinner = new Spinner(hardwareMap);
        // Wait for the game to start (driver presses START)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            chassis.drive(x, y, rx);


            if (gamepad1.right_bumper) {
                fjkldafjdkl.intake();
            } else if (gamepad1.left_bumper) {
                fjkldafjdkl.outake();
            } else {
                fjkldafjdkl.stop();
            }

            if (gamepad1.a) {
                output.forward();
            } else if (gamepad1.b) {
                output.backward();
            } else {
                output.stop();

        }
            if (gamepad1.x) {
                spinner.forward();
            } else if (gamepad1.y) {
                spinner.backward();
            }else {
                output.stop();
            }

        }
    }
}
