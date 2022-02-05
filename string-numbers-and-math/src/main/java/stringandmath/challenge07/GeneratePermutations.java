package stringandmath.challenge07;

import commons.utils.executionutil.Approach;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public final class GeneratePermutations {
    private GeneratePermutations() { throw new AssertionError("Class cannot be instantiated."); }
    public static List<Approach<Collection<String>>> approaches = List.of(new RecursiveBased());

    static class RecursiveBased implements Approach<Collection<String>> {

        @Override
        public String getDescription() {
            return "GeneratePermutations: Recursion based solution.";
        }

        @Override
        public Collection<String> apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string cannot be empty/null");
            }

            char[] inputChars = input.toCharArray();
            int lengthOfInput = input.length();
            List<StringBuilder> allPermutations = generatePermutations(inputChars, lengthOfInput - 1);

            return allPermutations
                    .stream()
                    .map(StringBuilder::toString)
                    .collect(toList());
        }

        private List<StringBuilder> generatePermutations(char[] input, int index){
            if(index < 0){
                return List.of(new StringBuilder(""));
            }

            List<StringBuilder> previousPermutations = generatePermutations(input, index - 1);

//            List<StringBuilder> currentPermutations = new ArrayList<>();
//            char currentCharacter = input[index];
//
//            for(StringBuilder prevPermutation: previousPermutations){
//                for(int insertPosition = 0; insertPosition <= index; ++insertPosition){
//
//                    StringBuilder permutation = new StringBuilder(prevPermutation);
//                    permutation.insert(insertPosition, currentCharacter);
//                    currentPermutations.add(permutation);
//
//                }
//            }
//            Converting imperative implementation to functional

            Function<StringBuilder, Stream<StringBuilder>> insertAtPositions =
                builder -> IntStream
                            .rangeClosed(0, index)
                            .mapToObj(insertPosition -> new StringBuilder(builder).insert(insertPosition, input[index]))
                            .collect(
                                    collectingAndThen(
                                            toList(),
                                            Collection::stream
                                    )
                            );


//                    Equivalent imperative implementation
//                    List<StringBuilder> permutations = new ArrayList<>();
//                    for(int insertPosition = 0; insertPosition <= index; ++insertPosition){
//                        permutations.add(
//                                new StringBuilder(builder)
//                                        .insert(insertPosition, input[index])
//                        );
//                    }
//
//                    return permutations.stream();



            return previousPermutations
                    .stream()
                    .flatMap(insertAtPositions)
                    .collect(toList());
        }
    }
}
