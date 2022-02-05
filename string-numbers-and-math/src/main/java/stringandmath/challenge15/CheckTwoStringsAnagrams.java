package stringandmath.challenge15;

import commons.utils.executionutil.Approach;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.naturalOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public final class CheckTwoStringsAnagrams {
    private CheckTwoStringsAnagrams(){
        throw new AssertionError("Class cannot be instantiated.");
    }

    static List<Approach<Boolean>> approaches = List.of(new SortBasedApproach(), new MapBasedApproach());

    static class SortBasedApproach implements Approach<Boolean> {

        @Override
        public String getDescription() {
           return "CheckTwoStringsAnagrams: Sort based approach.";
        }

        @Override
        public Boolean apply(Object... args) {
            String fstString = (String)args[0];
            String secString = (String)args[1];

            sanitizeInput(fstString, secString);
            return sortAndTrim(fstString).equals(sortAndTrim(secString));
        }

        private String sortAndTrim(String fstString) {
            return fstString
                    .codePoints()
                    .mapToObj(Character::toString)
                    .filter(symbol -> !symbol.isBlank())
                    .sorted(naturalOrder())
                    .collect(
                            joining()
                    );
        }
    }

    static class MapBasedApproach implements Approach<Boolean> {

        @Override
        public String getDescription() {
            return "CheckTwoStringsAnagrams: Map based approach.";
        }

        @Override
        public Boolean apply(Object... args) {
            String fstString = (String)args[0];
            String secString = (String)args[1];

            sanitizeInput(fstString, secString);

//            Map<String, Long> freqFst = frequencyCount(fstString);
//            Map<String, Long> freqSec = frequencyCount(secString);

//            Alternative way to check equality of two Maps
//            if(freqFst.size() != freqSec.size()){
//                return false;
//            }
//
//            return freqFst
//                    .entrySet()
//                    .stream()
//                    .allMatch(
//                            entry -> entry.getValue().equals(freqSec.get(entry.getKey()))
//                    );

            return frequencyCount(fstString).equals(frequencyCount(secString));
        }

        private Map<String, Long> frequencyCount(String fstString) {
            return fstString
                    .codePoints()
                    .mapToObj(Character::toString)
                    .filter(symbol -> !symbol.isBlank())
                    .collect(
                            groupingBy(
                                    identity(),
                                    counting()
                            )
                    );
        }
    }

    private static void sanitizeInput(String fstString, String secString) {
        if(fstString == null || secString == null || secString.isBlank() || fstString.isBlank()){
            throw new IllegalArgumentException("Input strings cannot be empty/null.");
        }
    }

}
