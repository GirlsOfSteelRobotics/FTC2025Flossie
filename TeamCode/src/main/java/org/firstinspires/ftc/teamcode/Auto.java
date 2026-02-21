
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto (General)", group="Robot")
public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() {

        Intake intake = new Intake(hardwareMap);
        Chassis chassis = new Chassis(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Spinner spinner = new Spinner(hardwareMap);

        waitForStart();

        chassis.resetIMU();

        telemetry.addData("Output Velocity", shooter.getVelocity());
        telemetry.update();

        spinner.backward();
        sleep(1500);
        shooter.shoot(2300);
        sleep(800);
        telemetry.update();

        intake.in();
        spinner.forward();
        sleep(7000);
        telemetry.update();

        intake.stop();
        spinner.stop();
        shooter.stop();
        chassis.stop();

    }
}
