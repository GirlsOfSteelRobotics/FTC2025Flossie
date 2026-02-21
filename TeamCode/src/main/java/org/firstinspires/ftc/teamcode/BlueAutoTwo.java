
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto (blue, small triangle)", group="Robot")
public class BlueAutoTwo extends LinearOpMode {

    @Override
    public void runOpMode() {

        Intake intake = new Intake(hardwareMap);
        Chassis chassis = new Chassis(hardwareMap);
        Shooter shooter = new Shooter(hardwareMap);
        Spinner spinner = new Spinner(hardwareMap);

        waitForStart();

        chassis.forward(0.7);
        sleep(400);

        chassis.stop();


    }
}
