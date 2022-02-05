package stringandmath.challenge01;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDuplicateCharactersTest {
    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";
    private static final String TEXT_SP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    private final List<Approach<Map<String, Integer>>> approaches = CountDuplicateCharacters.approaches;
    private final ApproachRunner<Map<String, Integer>> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT + "\n");
        System.out.println("\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");

        for(Approach<Map<String, Integer>> approach : approaches){
            String result = runner.run(approach, TEXT).toString();
            assertEquals("{ =22, A=1, a=5, b=5, B=1, d=1, e=17, f=2, g=3, h=7, i=6, l=5, ,=2, .=2, n=5, o=7, p=5, r=5, s=7, t=10, u=5, v=2, w=1, y=3}", result);
        }
    }

    @Test
    public void testApproachForSurrogatePairs(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_SP + "\n");
        System.out.println("\nIncluding Unicode surrogate pairs examples:\n");

        for(Approach<Map<String, Integer>> approach : approaches){
            String result = runner.run(approach, TEXT_SP).toString();
            assertEquals("{A=1, B=1, I=1, \uD83C\uDFBC=3, Ӝ=1,  =32, !=1, a=5, b=5, c=1, \uD83D\uDC95=2, d=1, e=18, f=2, g=3, h=8, i=6, \uD83D\uDE0D=2, l=6, ,=2, m=1, .=2, n=5, o=10, p=5, r=5, s=8, t=10, u=7, v=3, w=1, y=4}", result);
        }
    }
}
