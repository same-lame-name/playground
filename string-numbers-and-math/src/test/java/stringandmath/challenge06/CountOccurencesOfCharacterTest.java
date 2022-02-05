package stringandmath.challenge06;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOccurencesOfCharacterTest {
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";
    private static final String CHAR_TO_COUNT = "u";

    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_TO_COUNT_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_TO_COUNT_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149

    private final List<Approach<Integer>> approaches = CountOccurencesOfCharacter.approaches;
    private final ApproachRunner<Integer> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT + "\nSymbol to find is: " + CHAR_TO_COUNT +  "\n");

        for(Approach<Integer> approach : approaches){
            Integer result = runner.run(approach, TEXT, CHAR_TO_COUNT);
            assertEquals(5, result);
        }
    }

    @Test
    public void testApproachForSurrogatePairs1(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_CP + "\nSymbol to find is: " + CHAR_TO_COUNT_CP +  "\n");

        for(Approach<Integer> approach : approaches){
            Integer result = runner.run(approach, TEXT_CP, CHAR_TO_COUNT_CP);
            assertEquals(1, result);
        }
    }

    @Test
    public void testApproachForSurrogatePairs2(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_CP + "\nSymbol to find is: " + CHAR_TO_COUNT_CPS +  "\n");

        for(Approach<Integer> approach : approaches){
            Integer result = runner.run(approach, TEXT_CP, CHAR_TO_COUNT_CPS);
            assertEquals(2, result);

        }
    }
}
