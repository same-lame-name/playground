package stringandmath.challenge12;

import commons.utils.executionutil.Approach;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static stringandmath.challenge12.SortArrayOfStringsByLength.Sort.ASC;

public final class SortArrayOfStringsByLength {
    private SortArrayOfStringsByLength(){
        throw new AssertionError("Class cannnot be instantiated.");
    }

    public static final List<Approach<String[]>> approaches = List.of(new FunctionalStyleBased(), new UtilityMethodBased());

    public static enum Sort {
        ASC, DESC
    }

    static class FunctionalStyleBased implements Approach<String[]> {

        @Override
        public String getDescription() {
            return "SortArrayStringsByLength: Functional style based approach";
        }

        @Override
        public String[] apply(Object... args) {
            String[] input = (String[])args[0];
            Sort order = (Sort)args[1];

            sanitizeInput(input, order);
            Comparator<String> comparator = ASC.equals(order) ? comparing(String::length) : comparing(String::length).reversed();

            return Arrays
                    .stream(input)
                    .sorted(comparator)
//                    toArray method takes int function
//                    .toArray(length -> new String[length]);
                    .toArray(String[]::new);
        }
    }

    static class UtilityMethodBased implements Approach<String[]> {

        @Override
        public String getDescription() {
            return "SortArrayOfStringsByLength: Utility based approach.";
        }

        @Override
        public String[] apply(Object... args) {
            String[] input = (String[])args[0];
            Sort order = (Sort)args[1];

            sanitizeInput(input, order);

            Comparator<String> comparator = ASC.equals(order) ? comparing(String::length) : comparing(String::length).reversed();

            Arrays.sort(input, comparator);
            return input;
        }
    }

    private static void sanitizeInput(String[] input, Sort order) {
        if(input == null){
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        if(order == null || Stream.of(Sort.values()).noneMatch(value -> value.equals(order))){
            throw new IllegalArgumentException("Order should be one of the enum values.");
        }
    }

}
