
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto (blue, goalpost)", group="Robot")
public class BlueAuto extends LinearOpMode {

    @Override
    public void runOpMode() {

        Intake intake = new Intake(hardwareMap);
        Chassis chassis = new Chassis(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Spinner spinner = new Spinner(hardwareMap);

        waitForStart();

        telemetry.addData("Output Velocity", shooter.getVelocity());
        telemetry.update();

        chassis.forward(0.8);
        sleep(300);
        chassis.stop();

        spinner.backward();
        sleep(700);
        shooter.shoot(2300);
        sleep(700);
        telemetry.update();

        intake.in();
        spinner.forward();
        sleep(3000);
        intake.stop();
        spinner.stop();
        sleep(600);
        intake.in();
        spinner.forward();
        sleep(2000);
        telemetry.update();

        /*while (opModeIsActive() && chassis.turnAngle(-60) == false) {
            chassis.turnAngle(-60);
            telemetry.addData("Angle", chassis.imu.getRobotYawPitchRollAngles().getYaw());
            telemetry.update();
        }
        */

        chassis.forward(0.7);
        sleep(300);
        chassis.robotDrive(0, 0, 0.8);
        sleep(200);

        intake.stop();
        spinner.stop();
        shooter.stop();

        chassis.forward(1);
        sleep(800);


        chassis.stop();


    }
}
