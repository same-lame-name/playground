package stringandmath.challenge09;

import commons.utils.executionutil.Approach;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;

public final class RemoveDuplicateCharacters {
    private RemoveDuplicateCharacters() { throw new AssertionError("Class cannot be instantiated."); }

    static List<Approach<String>> approaches = List.of(new FunctionalStyleBased());

    static class FunctionalStyleBased implements Approach<String> {

        @Override
        public String getDescription() {
            return "RemoveDuplicateCharactes: Functional style based approach.";
        }

        @Override
        public String apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string cannot be null/empty");
            }

            Set<String> alreadyPresent = new HashSet<>();
            Predicate<String> takeFirstOccurence = symbol -> {
                if(alreadyPresent.contains(symbol)) return false;
                alreadyPresent.add(symbol);
                return true;
            };

            return input
                    .chars()
                    .mapToObj(c -> Character.toString((char) c))
                    .filter(takeFirstOccurence)
//                    .distinct()
//                    Alternatively
//                    We could use distinct() instead of filter(takeFirstOccurence)
                    .collect(
                            joining()
                    );
        }
    }
}
