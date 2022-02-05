package stringandmath.challenge08;

import commons.utils.executionutil.Approach;

import java.util.List;
import java.util.stream.IntStream;

public final class CheckPalindrome {
    private CheckPalindrome() { throw new AssertionError("Class cannot be instantiated."); }

    static List<Approach<Boolean>> approaches = List.of(new ForLoopBased(), new FunctionalStyleBased());

    static class ForLoopBased implements Approach<Boolean> {

        @Override
        public String getDescription() {
            return "CheckPalindrome: For loop based solution.";
        }

        @Override
        public Boolean apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string cannot be null/empty");
            }

            int leftPointer = 0, rightPointer = input.length() - 1;
            while(leftPointer < rightPointer){
                if(input.charAt(leftPointer) != input.charAt(rightPointer)){
                    return false;
                }

                leftPointer++;
                rightPointer--;
            }

            return true;
        }
    }

    static class FunctionalStyleBased implements Approach<Boolean> {

        @Override
        public String getDescription() {
            return "CheckPalindrome: Functional style based solution.";
        }

        @Override
        public Boolean apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string cannot be null/empty.");
            }

            int lengthOfInput = input.length();
            return IntStream
                    .range(0, lengthOfInput / 2)
                    .allMatch(index -> input.charAt(index) == input.charAt(lengthOfInput - index - 1));
        }
    }
}
