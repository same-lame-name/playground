package stringandmath.challenge04;

import commons.utils.executionutil.Approach;
import commons.utils.stringutil.IterableCharSequence;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ContainsOnlyDigits {
    private ContainsOnlyDigits() { throw new AssertionError("Class cannot be instantiated."); }
    public static List<Approach<Boolean>> approaches = List.of(new ForLoopBased(), new FunctionStyleBased(), new PatternMatchBased());

    static class ForLoopBased implements Approach<Boolean> {

        @Override
        public String getDescription() {
            return "ContainsOnlyDigits: For loop based solution.";
        }

        @Override
        public Boolean apply(Object... args) {
            String input = (String)args[0];

            if(input == null){
                throw new IllegalArgumentException("Input string cannot be null");

            }

            IterableCharSequence iterableInput = new IterableCharSequence(input);
            for(char c : iterableInput){
                if(!Character.isDigit(c)) return Boolean.FALSE;
            }

            return Boolean.TRUE;
        }
    }

    static class FunctionStyleBased implements Approach<Boolean> {

        @Override
        public String getDescription() {
            return "ContainsOnlyDigits: Functional style based solution.";
        }

        @Override
        public Boolean apply(Object... args) {
            String input = (String)args[0];

            if(input == null){
                throw new IllegalArgumentException("Input string cannot be null");
            }

            return input.codePoints().allMatch(Character::isDigit);
        }
    }

    static class PatternMatchBased implements Approach<Boolean> {
        private final String REGEX = "[0-9]*";

        @Override
        public String getDescription() {
            return "ContainsOnlyDigits: Pattern match based solution.";
        }

        @Override
        public Boolean apply(Object... args) {
            String input = (String)args[0];

            if(input == null){
                throw new IllegalArgumentException("Input string cannot be null");
            }

            //return input.matches(REGEX);
            //alternatively
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(input);

            return matcher.matches();
        }
    }
}
