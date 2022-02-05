package stringandmath.challenge13;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckStringContainsSubstringTest {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    private static final String SUBTEXT = "programmer";
    private static final String CASE_INSENSITIVE_SUBTEXT = "PrOGRammeR";

    List<Approach<Boolean>> approaches = CheckStringContainsSubstring.approaches;
    ApproachRunner<Boolean> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text is :" + TEXT);
        System.out.println("Subtext to search is :" + SUBTEXT);
        for(Approach<Boolean> approach : approaches){
            assertTrue(runner.run(approach, TEXT, SUBTEXT));
        }
    }


    @Test
    public void testCaseInsensitiveApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text is :" + TEXT);
        System.out.println("Subtext to search is :" + CASE_INSENSITIVE_SUBTEXT);
        for(Approach<Boolean> approach : approaches){
            assertTrue(runner.run(approach, TEXT, CASE_INSENSITIVE_SUBTEXT));
        }
    }
}
