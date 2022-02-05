package stringandmath.challenge15;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckTwoStringsAnagramsTest {
    private static final String TEXT1 = "hello world";
    private static final String TEXT2 = "dh\n le rlo l wo";

    private List<Approach<Boolean>> approaches = CheckTwoStringsAnagrams.approaches;
    private ApproachRunner<Boolean> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){

        System.out.println("----------------------------------------------\n");
        System.out.println("First Input String is :" + TEXT1);
        System.out.println("Second Input String is :" + TEXT2);
        for(Approach<Boolean> approach : approaches){
            assertTrue(runner.run(approach, TEXT1, TEXT2));
        }
    }
}
