import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class Peak {
    Time [] timeValue;
    //int max;

    public Peak (String path) {
        timeValue = getTimeValue(path);
    }

    private int CountMax (Time [] timeValue) {
        Arrays.sort(this.timeValue, Comparator.comparing(Time::getTime));
        int max = 0;
        int cur = 0;
        for (Time v : timeValue) {
            cur += v.getType() == LogType.START ? +1 : -1;
            if (cur > max) {
                max = cur;
            }
        }
        return  max;
    }

    private Time[] getTimeValue(String  path) {
        Time[] timeValue = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Path p = Paths.get(path);
            int numberOfLines = (int) Files.lines(p).count();
            int valuesNumber = numberOfLines * 2;
            timeValue = new Time[valuesNumber];
            for (int i = 0; i < valuesNumber; i += 2) {
                String line = reader.readLine();
                LogEntry entry = new LogEntry(line);
                timeValue[i] = new Time(entry.getStartTime(), LogType.START);
                timeValue[i + 1] = new Time(entry.getEndTime(), LogType.END);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + " not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timeValue;
    }

    public void PrintMax() {
        //max = CountMax(timeValue);
        System.out.println(CountMax(timeValue));
    }
}
