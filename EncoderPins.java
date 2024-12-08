package frc.robot;

import edu.wpi.first.wpilibj.Encoder;

public class EncoderPins {
    public int channelA;
    public int channelB;
    public EncoderPins(int a, int b) {
        this.channelA = a;
        this.channelB = b;
    }

    public Encoder createEncoder() {
        return new Encoder(channelA, channelB);
    }
}
