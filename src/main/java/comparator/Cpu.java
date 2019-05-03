package comparator;

public class Cpu {

    private float baseClockInGHz;
    private float boostClockInGHz;
    private short numberOfCore;
    private short numberOfThread;

    public Cpu(float baseClockInGHz, float boostClockInGHz, short numberOfCore, short numberOfThread) {
        this.baseClockInGHz = baseClockInGHz;
        this.boostClockInGHz = boostClockInGHz;
        this.numberOfCore = numberOfCore;
        this.numberOfThread = numberOfThread;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "baseClockInGHz=" + baseClockInGHz +
                ", boostClockInGHz=" + boostClockInGHz +
                ", numberOfCore=" + numberOfCore +
                ", numberOfThread=" + numberOfThread +
                '}';
    }

    public float getBaseClockInGHz() {
        return baseClockInGHz;
    }

    public float getBoostClockInGHz() {
        return boostClockInGHz;
    }

    public short getNumberOfCore() {
        return numberOfCore;
    }

    public short getNumberOfThread() {
        return numberOfThread;
    }
}
