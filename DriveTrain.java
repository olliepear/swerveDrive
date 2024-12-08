package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.EncoderPins;
import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    
    static PWMSparkMax frontRightMotor = new PWMSparkMax(Constants.driveConstants.FRONT_RIGHT_MOTOR);
    static PWMSparkMax frontLeftMotor = new PWMSparkMax(Constants.driveConstants.FRONT_LEFT_MOTOR);
    static PWMSparkMax frontRightMotorAngle = new PWMSparkMax(Constants.driveConstants.FRONT_RIGHT_MOTOR_ANGLE);
    static PWMSparkMax frontLeftMotorAngle = new PWMSparkMax(Constants.driveConstants.FRONT_LEFT_MOTOR_ANGLE);

    static PWMSparkMax backRightMotor = new PWMSparkMax(Constants.driveConstants.BACK_RIGHT_MOTOR);
    static PWMSparkMax backLeftMotor = new PWMSparkMax(Constants.driveConstants.BACK_LEFT_MOTOR);
    static PWMSparkMax backRightMotorAngle = new PWMSparkMax(Constants.driveConstants.BACK_RIGHT_MOTOR_ANGLE);
    static PWMSparkMax backLeftMotorAngle = new PWMSparkMax(Constants.driveConstants.BACK_LEFT_MOTOR_ANGLE);

    static ADIS16448_IMU gyro = new ADIS16448_IMU(); // ADIS16448 plugged into the MXP port

    static Encoder frmEncoder = new EncoderPins(0, 1).createEncoder(); 
    static Encoder flmEncoder = new EncoderPins(2, 3).createEncoder();
    static Encoder brmEncoder = new EncoderPins(4, 5).createEncoder();
    static Encoder blmEncoder = new EncoderPins(6, 7).createEncoder();

    public DriveTrain() {
        
        frontRightMotor.setInverted(false);
        frontLeftMotor.setInverted(true);
        
        backRightMotor.setInverted(false);
        backLeftMotor.setInverted(true);

    }

    public static void FRMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            frontRightMotor.set(speed);
        }
         else
        {
            frontRightMotor.set(0);
        }
    }

    public static void FLMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            frontLeftMotor.set(speed);
        }
         else
        {
            frontLeftMotor.set(0);
        }
    }

    public static void BRMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            backRightMotor.set(speed);
        }
         else
        {
            backRightMotor.set(0);
        }
    }

    public static void BLMsetV(double speed) {
        if (speed >= -1 && speed <= 1)
        {
            backLeftMotor.set(speed);
        }
        else
        {
           backLeftMotor.set(0);
        }
    }

    // input angle measure variables and find out how to measure them
    // to make field centric subtract gyro.getangle()

    public static void FRMsetA(double angle) {
        if (angle >= (frmEncoder.getDistance() % 360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            frontRightMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= (frmEncoder.getDistance() % 360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            frontRightMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            frontRightMotorAngle.set(0);
        }
    }       

    public static void FLMsetA(double angle) {
        if (angle >= (flmEncoder.getDistance() % 360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            frontLeftMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= (flmEncoder.getDistance() % 360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            frontLeftMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            frontLeftMotorAngle.set(0);
        }
    }       
    public static void BRMsetA(double angle) {
        if (angle >= (brmEncoder.getDistance() % 360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            backRightMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= (brmEncoder.getDistance() % 360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            backRightMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            backRightMotorAngle.set(0);
        }
    }   
    public static void BLMsetA(double angle) {
        if (angle >= (blmEncoder.getDistance() % 360 + Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            backLeftMotorAngle.set(Constants.SwerveConstants.AngleChange);
        }
        if (angle <= (blmEncoder.getDistance() % 360 - Constants.SwerveConstants.turnThreshold - gyro.getAngle()) ){
            backLeftMotorAngle.set(-Constants.SwerveConstants.AngleChange);
        }
        else {
            backLeftMotorAngle.set(0);
        }
    }               
}
