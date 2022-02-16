package challenge01;

import commons.utils.executionutil.Approach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public final class CheckNullsFunctionalNonFunctional {
    private CheckNullsFunctionalNonFunctional(){
        throw new AssertionError("Class cannot be instantiated.");
    }

    public static List<Approach<List<Integer>>> approaches = List.of(new FunctionalStyleApproach(), new NonFunctionalApproach());

    public static class FunctionalStyleApproach implements Approach<List<Integer>> {

        @Override
        public String getDescription() {
            return "CheckNullsFunctionalNonFunctional: Checking nulls using functional approach";
        }

        @Override
        public List<Integer> apply(Object... args) {
            List<Integer> list = (List<Integer>)args[0];
            sanitizeInput(list);

            return list.stream()
                    .filter(Objects::nonNull)
                    .collect(toList());
        }
    }

    public static class NonFunctionalApproach implements Approach<List<Integer>> {

        @Override
        public String getDescription() {
            return "CheckNullsFunctionalNonFunctional: Checking nulls using non-functional approach";
        }

        @Override
        public List<Integer> apply(Object... args) {
            List<Integer> list = (List<Integer>)args[0];

            sanitizeInput(list);

            List<Integer> nonNullList = new ArrayList<>();
            for(Integer value : list){
                if(value != null) nonNullList.add(value);
            }

            return nonNullList;
        }
    }

    private static void sanitizeInput(List<Integer> list) {
        if(Objects.isNull(list)){
            throw new IllegalArgumentException("Input list cannot be null");
        }
    }
}
