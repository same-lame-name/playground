package stringandmath.challenge16;

import commons.utils.executionutil.Approach;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public final class FindLongestCommonPrefix {
    private FindLongestCommonPrefix(){
        throw new AssertionError("Class cannot be instantiated.");
    }

    static List<Approach<String>> approaches = List.of(new PrefixBasedApproach(), new BinarySearchBased());

    static class PrefixBasedApproach implements Approach<String> {

        @Override
        public String getDescription() {
            return "FindLongestCommonPrefix: Prefix match based approach.";
        }

        @Override
        public String apply(Object... args) {
            String[] texts = (String[]) args[0];

            sanitizeInput(texts);

            String reference = texts[0];
            int lengthOfString = reference.length();

            return IntStream
                    .iterate(lengthOfString, length -> length - 1)
                    .limit(lengthOfString)
                    //This is int stream from lengthOfString -> 1
                    .mapToObj(idx -> reference.substring(0, idx))
                    //This is List of Prefixes of "reference" string in decreasing length
                    .filter(
                            prefix -> Arrays.stream(texts)
                                        .allMatch(str -> str.startsWith(prefix))
                    )
                    .findFirst()
                    .orElse("");
        }
    }

    static class BinarySearchBased implements Approach<String> {

        @Override
        public String getDescription() {
            return "FindLongestCommonPrefix: Binary search based approach.";
        }

        @Override
        public String apply(Object... args) {
            String[] texts = (String[])args[0];

            sanitizeInput(texts);

            String reference = texts[0];

            int left = 0, right = reference.length(), matchIdx = 0;
            Predicate<String> allMatchPrefix = prefix -> Arrays.stream(texts).allMatch(str -> str.startsWith(prefix));

            while(left <= right){
                int mid = left + (right - left) / 2;
                String prefix = reference.substring(0, mid);

                if(allMatchPrefix.test(prefix)){
                    matchIdx = mid;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            return reference.substring(0, matchIdx);
        }
    }
    private static void sanitizeInput(String[] texts) {
        if(texts == null || texts.length == 0){
            throw new IllegalArgumentException("Input list of strings cannot be null/empty");
        }
    }
}
