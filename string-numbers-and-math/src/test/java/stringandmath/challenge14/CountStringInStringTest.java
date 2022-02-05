package stringandmath.challenge14;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountStringInStringTest {
    private static final String STRING = "111111";
    private static final String SUBSTRING = "11";

    private List<Approach<Integer>> approaches = CountStringInString.approaches;
    private ApproachRunner<Integer> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){

        System.out.println("----------------------------------------------\n");
        System.out.println("Input text is :" + STRING);
        System.out.println("Subtext to search is :" + SUBSTRING);
        for(Approach<Integer> approach : approaches){
            Integer result = runner.run(approach, STRING, SUBSTRING);
            assertEquals(5, result);
        }
    }
}
