package stringandmath.challenge01;

import commons.utils.executionutil.Approach;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public final class CountDuplicateCharacters {
    private CountDuplicateCharacters(){ throw new AssertionError("Cannot be instantiated."); }

    public static List<Approach<Map<String, Integer>>> approaches = List.of(new HashMapBased(), new FunctionalStyleBased());

    static class HashMapBased implements Approach<Map<String, Integer>> {
        @Override
        public String getDescription() {
            return "CountDuplicateCharacters: HashMap based solution";
        }

        @Override
        public Map<String, Integer> apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string should not be empty/null");
            }

            Map<String, Integer> symbolCount = new HashMap<>();
            int lengthOfInput = input.length();
            for(int index = 0; index < lengthOfInput; ++index){
                int codepoint = input.codePointAt(index);
                String symbol = String.valueOf(Character.toChars(codepoint));
                if(Character.charCount(codepoint) > 1) index++;

                symbolCount.compute(symbol, (key, value) -> value == null ? 1 : ++value);
            }

            return symbolCount;
        }
    }

    static class FunctionalStyleBased implements Approach<Map<String, Integer>> {
        @Override
        public String getDescription() {
            return "CountDuplicateCharacters: Functional style solution";
        }

        @Override
        public Map<String, Integer> apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string should not be empty/null");
            }

            return  input
                    .codePoints()
                    .mapToObj(c -> String.valueOf(Character.toChars(c)))
                    .collect(
                            groupingBy(
                                    c -> c,
                                    collectingAndThen(
                                            counting(),
                                            Long::intValue
                                    )
                            )
                    );
        }
    }

}