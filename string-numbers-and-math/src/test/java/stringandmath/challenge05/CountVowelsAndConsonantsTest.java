package stringandmath.challenge05;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVowelsAndConsonantsTest {
    // 14 vowels, 19 consonants
    private static final String TEXT = " ... Illinois Mathematics & Science Academy ... ";

    private final List<Approach<Map<String, Long>>> approaches = CountVowelsAndConsonants.approaches;
    private final ApproachRunner<Map<String, Long>> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT + "\n");
        for(Approach<Map<String, Long>> approach : approaches){
            Map<String, Long> result = runner.run(approach, TEXT);
            assertEquals("{Vowel count=14, Consonant count=19}", result.toString());
        }
    }
}
