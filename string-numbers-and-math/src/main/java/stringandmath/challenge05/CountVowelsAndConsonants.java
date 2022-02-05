package stringandmath.challenge05;

import commons.utils.executionutil.Approach;
import commons.utils.stringutil.IterableCharSequence;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public final class CountVowelsAndConsonants {
    private CountVowelsAndConsonants() { throw new AssertionError("Class cannot be instantiated."); }

    public static List<Approach<Map<String, Long>>> approaches = List.of(new FunctionalStyleBased(), new ForLoopBased());
    private static final List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

    static class FunctionalStyleBased implements Approach<Map<String, Long>> {

        @Override
        public String getDescription() {
            return "CountVowelsAndConsonants: Functional style based solution.";
        }

        @Override
        public Map<String, Long> apply(Object... args) {
            String input = (String)args[0];

            if(input == null){
                throw new IllegalArgumentException("Input string cannot be null");
            }

            Function<Map<Boolean, Long>, Map<String, Long>> modifyMapKey =
                    map -> map
                        .entrySet()
                        .stream()
                        .collect(
                                toMap(
                                        entry -> entry.getKey() ? "Vowel count" : "Consonant count",
                                        Map.Entry::getValue
                                )
                        );

            return input
                    .chars()
                    .filter(Character::isAlphabetic)
                    .mapToObj(val -> Character.toLowerCase((char) val))
                    .collect(
                            collectingAndThen(
                                partitioningBy(
                                        vowels::contains,
                                        counting()
                                ), modifyMapKey
                            )
                    );
        }
    }

    static class ForLoopBased implements Approach<Map<String, Long>> {

        @Override
        public String getDescription() {
            return "CountVowelsAndConsonants: For loop based solution.";
        }

        @Override
        public Map<String, Long> apply(Object... args) {
            String input = (String)args[0];

            if(input == null){
                throw new IllegalArgumentException("Input string cannot be null");
            }

            Long vowelCount = 0L;
            Long consonantCount = 0L;

            input = input.toLowerCase();

            for(char c : new IterableCharSequence(input)){
                if(Character.isAlphabetic(c)){
                   if(vowels.contains(c)) vowelCount++;
                   else consonantCount++;
                }
            }

            Map<String, Long> result = new HashMap<>();
            result.put("Vowel count", vowelCount);
            result.put("Consonant count", consonantCount);

            return result;
        }
    }

}
