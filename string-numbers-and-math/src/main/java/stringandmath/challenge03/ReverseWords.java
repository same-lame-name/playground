package stringandmath.challenge03;

import commons.utils.executionutil.Approach;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public final class ReverseWords {
    private ReverseWords(){ throw new AssertionError("Class cannot be instantiated."); }

    public static List<Approach<String>> approaches = List.of(new ForLoopBased(), new FunctionalStyleBased());

    static class ForLoopBased implements Approach<String> {
        @Override
        public String getDescription() {
            return "ReverseWords: For loop based solution.";
        }

        @Override
        public String apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string cannot be empty/null");
            }

            StringBuilder wordReversed = new StringBuilder(4096);
            StringBuilder word = new StringBuilder(4096);

            int lengthOfInput = input.length();
            boolean isLastWord = false;
            boolean isNonBlank;

            for(int index = 0; index <= lengthOfInput; ++index){
                isNonBlank = index < lengthOfInput && !Character.isSpaceChar(input.charAt(index));
                if(index == lengthOfInput || isNonBlank ^ isLastWord) {
                    // End-Of-Line OR <blank><non-blank> scenario OR <non-blank><blank> scenario
                    if(isLastWord) word.reverse();
                    wordReversed.append(word);
                    word.delete(0, word.length());
                }

                if(index < lengthOfInput) word.append(input.charAt(index));
                isLastWord = isNonBlank;
            }

            return wordReversed.toString();
        }
    }

    static class FunctionalStyleBased implements Approach<String> {
        Pattern PATTERN = Pattern.compile(" +");
        String WHITESPACE = " ";

        @Override
        public String getDescription() {
            return "ReverseWords: Functional style based solution.";
        }

        @Override
        public String apply(Object... args) {
            String input = (String)args[0];

            if(input == null || input.isEmpty()){
                throw new IllegalArgumentException("Input string cannot be empty/null");
            }

            return PATTERN
                    .splitAsStream(input)
                    .map(word -> new StringBuilder(word).reverse().toString())
                    .collect(joining(WHITESPACE));
        }
    }

}
