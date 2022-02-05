package stringandmath.challenge08;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPalindromeTest {
    private static final String TEXT = "ABCDEFEDCBA";
    private static final String TEXT_N = "ABCDEFEDCBAX";
    private List<Approach<Boolean>> approaches = CheckPalindrome.approaches;
    private ApproachRunner<Boolean> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT + "\n");
        for(Approach<Boolean> approach : approaches){
            assertTrue(runner.run(approach, TEXT));
        }
    }


    @Test
    public void testApproachForNonPalindrome(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_N + "\n");
        for(Approach<Boolean> approach : approaches){
            assertFalse(runner.run(approach, TEXT_N));
        }
    }
}
