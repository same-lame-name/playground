package stringandmath.challenge02;

import commons.utils.executionutil.Approach;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public final class FirstNonRepeatedCharacter {
    private FirstNonRepeatedCharacter(){ throw new AssertionError("Class cannot be instantiated."); }
    public static List<Approach<String>> approaches = List.of(new LinkedHashMapBased(), new FunctionalStyleBased());

    static class LinkedHashMapBased implements Approach<String> {

        @Override
        public String getDescription() {
            return "FirstNonRepeatedCharacter: LinkedHashMap based solution.";
        }

        @Override
        public String apply(Object... args) {
            String input = (String)args[0];
            if(input == null || input.isEmpty()) {
                throw new IllegalArgumentException("Input string should not be empty/null");
            }

            String defaultValue = String.valueOf(Character.MIN_VALUE);

            Map<String, Integer> symbolMap = new LinkedHashMap<>();
            int lengthOfInput = input.length();

            for(int index = 0; index < lengthOfInput; ++index){
                int codepoint = input.codePointAt(index);
                String symbol = String.valueOf(Character.toChars(codepoint));
                symbolMap.compute(symbol, (key, value) -> value == null ? 1 : ++value);

                if(Character.charCount(codepoint) > 1) index++;
            }

            Set<Map.Entry<String, Integer>> entrySet = symbolMap.entrySet();

            for(Map.Entry entry : entrySet){
                if(entry.getValue().equals(Integer.valueOf(1))){
                    return (String) entry.getKey();
                }
            }
            return defaultValue;
        }
    }

    static class FunctionalStyleBased implements Approach<String> {

        @Override
        public String getDescription() {
            return "FirstNonRepeatedCharacter: Functional style based solution.";
        }

        @Override
        public String apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string should not be empty/null");
            }

            String defaultValue = String.valueOf(Character.MIN_VALUE);
            Map<String, Long> symbolMap = input
                    .codePoints()
                    .mapToObj(codepoint -> String.valueOf(Character.toChars(codepoint)))
                    .collect(groupingBy(identity(), LinkedHashMap::new, counting()));

            String firstUnique = symbolMap
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equals(1L))
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElse(defaultValue);

            return firstUnique;
        }
    }
}
