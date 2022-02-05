package stringandmath.challenge12;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortArrayOfStringsByLengthTest {
    private static String[] strs = {"one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten"};

    private static String[] ascStrs = {"one", "two", "six", "ten", "four", "five", "nine", "three", "seven", "eight"};
    private static String[] desStrs = {"three", "seven", "eight", "four", "five", "nine", "one", "two", "six", "ten"};

    private static List<Approach<String[]>> approaches = SortArrayOfStringsByLength.approaches;
    private static ApproachRunner<String[]> runner = new ApproachRunner<>();

    @Test
    public void testAscending(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input array: " + Arrays.toString(strs));
        System.out.println("Order or sort is " + SortArrayOfStringsByLength.Sort.ASC);
        for(Approach<String[]> approach : approaches){
            String[] result = runner.run(approach, strs, SortArrayOfStringsByLength.Sort.ASC);
            assertArrayEquals(result, ascStrs);
        }
    }

    @Test
    public void testDescending(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input array: " + Arrays.toString(strs));
        System.out.println("Order or sort is " + SortArrayOfStringsByLength.Sort.DESC);
        for(Approach<String[]> approach : approaches){
            String[] result = runner.run(approach, strs, SortArrayOfStringsByLength.Sort.DESC);
            assertArrayEquals(result, desStrs);
        }
    }
}
