package stringandmath.challenge13;

import commons.utils.executionutil.Approach;

import java.util.List;
import java.util.regex.Pattern;

public final class CheckStringContainsSubstring {
    private CheckStringContainsSubstring(){
        throw new AssertionError("Class cannot be instantiated.");
    }

    public static List<Approach<Boolean>> approaches = List.of(new PatternBasedSolution(), new StringUtilityBasedSolution());

    static class PatternBasedSolution implements Approach<Boolean> {

        @Override
        public String getDescription() {
            return "CheckStringContainsSubstring: Pattern based solution.";
        }

        @Override
        public Boolean apply(Object... args) {
            String text = (String)args[0];
            String subtext = (String)args[1];

            sanitizeInput(text, subtext);

            //Matcher.matches() is exact, it will check if text matches the regex, it doesn't check if text contains regex.
            //So for the regex we prepare, ....subtext... case insensitive match
            return Pattern
                    .compile(".*" + Pattern.quote(subtext) + ".*", Pattern.CASE_INSENSITIVE)
//                    Alternatively
//                    .compile("(?i).*" + Pattern.quote(subtext) + ".*") (?i) is used for case-insensitive searches
                    .matcher(text)
                    .matches();
        }
    }

    static class StringUtilityBasedSolution implements Approach<Boolean> {

        @Override
        public String getDescription() {
            return "CheckStringContainsSubstring: String utility based solution.";
        }

        @Override
        public Boolean apply(Object... args) {
            String text = (String)args[0];
            String subtext = (String)args[1];

            sanitizeInput(text, subtext);

            return text
                    .toLowerCase()
                    .contains(subtext.toLowerCase());
        }
    }
    private static void sanitizeInput(String text, String subtext) {
        if(text == null || text.isEmpty()){
            throw new IllegalArgumentException("Input text cannot be null/empty.");
        }

        if(subtext == null){
            throw new IllegalArgumentException("Input subtext cannot be null.");
        }
    }
}
