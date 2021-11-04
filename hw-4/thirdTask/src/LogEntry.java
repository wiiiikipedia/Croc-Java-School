public class LogEntry {
    private int start;
    private int end;

    public LogEntry(String line) {
        if (line == null || line.length() == 0) {
            throw new IllegalArgumentException("Line is empty or null.");
        }
        String[] l = line.trim().split(",",2);
        this.start = Integer.parseInt(l[0]);
        this.end = Integer.parseInt(l[1]);
    }

    public int getStartTime() {
        return start;
    }

    public int getEndTime() {
        return end;
    }
}
