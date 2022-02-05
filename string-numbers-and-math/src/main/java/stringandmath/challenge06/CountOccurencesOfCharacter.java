package stringandmath.challenge06;

import commons.utils.executionutil.Approach;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;

public final class CountOccurencesOfCharacter {
    private CountOccurencesOfCharacter() { throw new AssertionError("Class cannot be instantiated."); }
    public static List<Approach<Integer>> approaches = List.of(new FunctionalStyleBased());

    static class FunctionalStyleBased implements Approach<Integer> {

        @Override
        public String getDescription() {
            return "CountOccurencesOfCharacter: Functional style based solution.";
        }

        @Override
        public Integer apply(Object... args) {
            String input = (String)args[0];
            String symbolToFind = (String)args[1];

            if(input == null || symbolToFind == null){
                throw new IllegalArgumentException("Input/Match string cannot be null");
            }

            if(symbolToFind.codePointCount(0, symbolToFind.length()) > 1){
                throw new IllegalArgumentException("There is more than one symbol in find-string");
            }

            return input
                    .codePoints()
                    .mapToObj(Character::toString)
                    //Character.toString(codepoint) was introduced in java 11.
                    //.mapToObj(codepoint -> String.valueOf(Character.toChars(codepoint)))
                    .filter(str -> str.equals(symbolToFind))
                    .collect(
                            collectingAndThen(
                                    counting(),
                                    Long::intValue
                            )
                    );
        }
    }
}
