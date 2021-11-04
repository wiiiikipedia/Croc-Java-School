public class Time {
    private int time;
    private LogType type;

    public Time(int time, LogType type) {
        this.time = time;
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public LogType getType() {
        return type;
    }

}
