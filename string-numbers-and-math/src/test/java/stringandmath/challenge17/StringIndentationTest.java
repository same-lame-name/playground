package stringandmath.challenge17;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringIndentationTest {

    List<String> daysList = List.of(
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

    private final List<Approach<String>> approaches = StringIndentation.approaches;
    private final ApproachRunner<String> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){

        System.out.println("----------------------------------------------\n");
        System.out.println("List of texts is :" + daysList);
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, daysList);
            assertEquals("Sunday\n Monday\n  Tuesday\n   Wednesday\n    Thursday\n     Friday\n      Saturday\n", result);
        }
    }
}
