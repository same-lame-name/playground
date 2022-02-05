package stringandmath.challenge11;

import commons.utils.executionutil.Approach;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public final class FindCharacterWithMostAppearances {
    private FindCharacterWithMostAppearances(){
        throw new AssertionError("Class cannot be instantiated.");
    }

    static final List<Approach<Map<Integer, List<String>>>> approaches = List.of(new FunctionalStyleBased());

    static class FunctionalStyleBased implements Approach<Map<Integer, List<String>>> {

        @Override
        public String getDescription() {
            return "FindCharacterWithMostAppearances: Functional style based solution.";
        }

        @Override
        public Map<Integer, List<String>> apply(Object... args) {
            String input = (String)args[0];

            sanitizeInput(input);

            Map<String, Integer> frequencyMap = input
                    .codePoints()
                    .mapToObj(Character::toString)
                    .filter(symbol -> !symbol.isBlank())
                    .collect(
                            groupingBy(
                                    identity(),
                                    collectingAndThen(
                                            counting(),
                                            Long::intValue
                                    )
                            )
                    );

            Map<Integer, List<String>> inverseMapCountToList = frequencyMap
                    .entrySet()
                    .stream()
                    .collect(
                            groupingBy(
                                    Map.Entry::getValue,
                                    mapping(
                                            Map.Entry::getKey,
                                            toList()
                                    )
                            )
                    );

//            Optional<Map.Entry<Integer, List<String>>> maxOptional = inverseMapCountToList
//                    .entrySet()
//                    .stream()
//                    .max(Map.Entry.comparingByKey());
//
//            Map<Integer, List<String>> resultViaStream = maxOptional
//                    .stream()
//                    .collect(
//                            toMap(
//                                    Map.Entry::getKey,
//                                    Map.Entry::getValue
//                            )
//                    );

            //Finds max-by-key entry from Map and returns it as a Map.
            return inverseMapCountToList
                    .entrySet()
                    .stream()
                    .collect(
                            collectingAndThen(
                                    maxBy(Map.Entry.comparingByKey()),
                                    Optional::stream
                            )
                    ) //Chaining two collect, alternative (preferred) implementation commented above
                    .collect(
                            toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue
                            )
                    );
        }
    }

    private static void sanitizeInput(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("Input string cannot be null/empty.");
        }
    }
}
