package stringandmath.challenge14;

import commons.utils.executionutil.Approach;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;

public final class CountStringInString {
    private CountStringInString(){
        throw new AssertionError("Class cannot be instantiated.");
    }

    public static List<Approach<Integer>> approaches = List.of(new PatternBasedApproach());

    public static class PatternBasedApproach implements Approach<Integer> {

        @Override
        public String getDescription() {
            return "CountStringInString: Pattern based approach";
        }

        @Override
        public Integer apply(Object... args) {
            String text = (String)args[0];
            String subtext = (String)args[1];

            sanitizeInput(text, subtext);
            /**
            *Using positive look ahead regex => "(?=(" + REGEX + "))."
            *Could also be done without look-ahead-regex, by matcher.find(matcher.start() + 1)
            *Such that next matching starts from one index ahead of previous match
            *By default after a match, matcher starts again at matcher.end() (Non overlapping matches)
            */

//            Alternative implementation
//            int occurrences = 0;
//            Matcher subStringMatcher = Pattern.compile("(?=(" + Pattern.quote(subtext) + ")).")
//                    .matcher(text);
//            while(subStringMatcher.find()){
//                occurrences++;
//            }
//            return occurences;

            return  Pattern
                    .compile("(?=(" + Pattern.quote(subtext) + ")).")
                    .matcher(text)
                    .results() // Stream<MatchResult>, MatchResult.group() gives match-group, has .start() .end() methods
                    .collect(
                            collectingAndThen(
                                    counting(),
                                    Long::intValue
                            )
                    );
        }
    }

    private static void sanitizeInput(String text, String subtext) {
        if(text == null || text.isEmpty()){
            throw new IllegalArgumentException("Input text cannot be null/empty.");
        }

        if(subtext == null || subtext.isEmpty()){
            throw new IllegalArgumentException("Input subtext cannot be null/empty.");
        }
    }
}
