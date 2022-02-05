package commons.utils.displayutil;

import java.util.concurrent.TimeUnit;

public class DisplayUtil {
    public static void displayExecutionTime(long time){
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
