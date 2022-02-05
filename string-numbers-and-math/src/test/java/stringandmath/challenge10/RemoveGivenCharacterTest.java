package stringandmath.challenge10;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveGivenCharacterTest {
    private static final String TEXT = "oobotooorogshŜoootorgo";
    private static final String CHAR = "Ŝ";

    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍.";
    private static final String CHAR_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_CPS = "."; // Unicode: \uD83D\uDC95, Code Point: 128149

    private final List<Approach<String>> approaches = RemoveGivenCharacter.approaches;
    private final ApproachRunner<String> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT);
        System.out.println("Character to remove: " + CHAR + "\n");
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, TEXT, CHAR);
            assertEquals("oobotooorogshoootorgo", result);
        }
    }

    @Test
    public void testApproachForSurrogatePairs(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_CP);
        System.out.println("Character to remove: " + CHAR_CP+ "\n");
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, TEXT_CP, CHAR_CP);
            assertEquals("\uD83D\uDE0D I love \uD83D\uDC95 you  so much \uD83D\uDC95 \uD83D\uDE0D.", result);
        }
    }

    @Test
    public void testApproachForSurrogatePairsV2(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_CP);
        System.out.println("Character to remove: " + CHAR_CPS + "\n");
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, TEXT_CP, CHAR_CPS);
            assertEquals("😍 I love 💕 you Ӝ so much 💕 😍", result);
        }
    }
}
