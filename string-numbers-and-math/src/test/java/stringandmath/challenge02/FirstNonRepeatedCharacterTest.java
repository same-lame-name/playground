package stringandmath.challenge02;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstNonRepeatedCharacterTest {
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    // Ӝ -> Unicode: \u04DC, Code Point: 1244
    // 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
    private static final String TEXT_SP = "😍 💕 I Ӝ love you Ӝ so much 😍";

    List<Approach<String>> approaches = FirstNonRepeatedCharacter.approaches;
    ApproachRunner<String> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT + "\n");
        System.out.println("\n\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");

        for(Approach<String> approach : approaches){
            String result = runner.run(approach, TEXT);
            assertEquals("'", result);
        }
    }

    @Test
    public void testApproachForSurrogatePairs(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_SP + "\n");
        System.out.println("\n\nIncluding Unicode surrogate pairs examples:\n");

        for(Approach<String> approach : approaches){
            String result = runner.run(approach, TEXT_SP);
            assertEquals("\uD83D\uDC95", result);
        }
    }
}
