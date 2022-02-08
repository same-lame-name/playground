package stringandmath.challenge17;

import commons.utils.executionutil.Approach;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public final class StringIndentation {
    private StringIndentation(){
        throw new AssertionError("Class cannot be instantiated.");
    }

    public static List<Approach<String>> approaches = List.of(new StringUtilityBasedApproach(), new StringRepeatBasedApproach());

    public static class StringUtilityBasedApproach implements Approach<String> {

        @Override
        public String getDescription() {
            return "StringIndentation: String utility (Java 12 onwards)  method based approach.";
        }

        @Override
        public String apply(Object... args) {
            List<String> listOfString = (List<String>)args[0];

            sanitizeInput(listOfString);

            return IntStream.range(0, listOfString.size())
                    .mapToObj(idx -> listOfString.get(idx).indent(idx))
                    .collect(joining());
        }
    }

    public static class StringRepeatBasedApproach implements Approach<String> {

        @Override
        public String getDescription() {
            return "StringIndentation: String repeat utility method based approach.";
        }

        @Override
        public String apply(Object... args) {
            List<String> listOfString = (List<String>)args[0];

            sanitizeInput(listOfString);

//            Alternatively instead of String.repeat we could have used Stream.generate(() -> " ").limit(idx)
//            IntFunction<String> line = index -> Stream.generate(() -> " ").limit(index).collect(joining()) + listOfString.get(index) + "\n";
            IntFunction<String> line = index -> " ".repeat(index) + listOfString.get(index) + "\n";

            return IntStream.range(0, listOfString.size())
                    .mapToObj(line)
                    .collect(
                            joining()
                    );
        }
    }
    private static void sanitizeInput(List<String> listOfString) {
        if(listOfString == null || listOfString.isEmpty()){
            throw new IllegalArgumentException("Input list cannot be null/empty.");
        }
    }

}
