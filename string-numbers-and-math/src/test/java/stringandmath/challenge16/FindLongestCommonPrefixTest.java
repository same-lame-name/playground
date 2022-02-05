package stringandmath.challenge16;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLongestCommonPrefixTest {
    private String[] texts = {"abc", "abcd", "abcde", "ab", "abcd", "abcdef"};
    private String[] textsEntireMatch = {"abcd", "abcdh", "abcde", "abcdef"};
    private String[] textsWithNoMatch = {"xyz", "abcd", "efgh", "highklmnosp"};
    private List<Approach<String>> approaches = FindLongestCommonPrefix.approaches;
    private ApproachRunner<String> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){

        System.out.println("----------------------------------------------\n");
        System.out.println("List of texts is :" + Arrays.toString(texts));
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, (Object)texts);
            assertEquals("ab", result);
        }
    }

    @Test
    public void testApproachWithNoMatch(){

        System.out.println("----------------------------------------------\n");
        System.out.println("List of texts is :" + Arrays.toString(textsWithNoMatch));
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, (Object)textsWithNoMatch);
            assertEquals("", result);
        }
    }


    @Test
    public void testApproachWithEntireMatch(){

        System.out.println("----------------------------------------------\n");
        System.out.println("List of texts is :" + Arrays.toString(textsEntireMatch));
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, (Object)textsEntireMatch);
            assertEquals("abcd", result);
        }
    }
}
