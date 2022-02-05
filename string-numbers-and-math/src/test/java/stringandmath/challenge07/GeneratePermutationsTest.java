package stringandmath.challenge07;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import commons.utils.stringutil.IterableCharSequence;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratePermutationsTest {
    private static final String TEXT = "ABC";
    private static final String ANOTHER_TEXT = "ABCD";
    private List<Approach<Collection<String>>> approaches = GeneratePermutations.approaches;
    private ApproachRunner<Collection<String>> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT + "\n");
        for(Approach<Collection<String>> approach : approaches){
            Collection<String> result = runner.run(approach, TEXT);
            Collection<String> check = List.of("CBA", "BCA", "BAC", "CAB", "ACB", "ABC");
            assertEquals(check.size(), result.size());
            for(String permutation : result){
                assertTrue(check.contains(permutation));
            }
        }
    }


    @Test
    public void testApproachForLongerString(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + ANOTHER_TEXT + "\n");
        for(Approach<Collection<String>> approach : approaches){
            Collection<String> result = runner.run(approach, ANOTHER_TEXT);
            int expectedNumberOfPermutations = factorial(ANOTHER_TEXT.length());

            Set<String> distinctPermutations = new HashSet<>(result);
            assertEquals(expectedNumberOfPermutations, distinctPermutations.size());

            String sortedInput = ANOTHER_TEXT
                    .codePoints()
                    .mapToObj(Character::toString)
                    .sorted()
                    .collect(joining());

            for(String permutation : distinctPermutations){
                String sortedPermutation = permutation
                        .codePoints()
                        .mapToObj(Character::toString)
                        .sorted()
                        .collect(joining());

                assertEquals(sortedInput, sortedPermutation);
            }
        }
    }

    int factorial(int number){
        return IntStream
                .rangeClosed(1, number)
                .reduce(
                        1,
                        (acc, num) -> acc * num
                );
    }

}
