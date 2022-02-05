package stringandmath.challenge09;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateCharactersTest {
    private final String stringWithDuplicates = "!ABCBA;C D E-D  D  DFA;";
    private final String stringWithoutDuplicates = "!ABC; DE-F";

    private final List<Approach<String>> approaches = RemoveDuplicateCharacters.approaches;
    private final ApproachRunner<String> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + stringWithDuplicates + "\n");
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, stringWithDuplicates);
            assertEquals("!ABC; DE-F", result);
        }
    }

    @Test
    public void testApproachWithoutDuplicates(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + stringWithoutDuplicates + "\n");
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, stringWithoutDuplicates);
            assertEquals("!ABC; DE-F", result);
        }
    }

}
