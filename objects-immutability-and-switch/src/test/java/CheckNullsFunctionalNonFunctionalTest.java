import challenge01.CheckNullsFunctionalNonFunctional;
import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckNullsFunctionalNonFunctionalTest {
    private final List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);

    private final List<Approach<List<Integer>>> approaches = CheckNullsFunctionalNonFunctional.approaches;
    private final ApproachRunner<List<Integer>> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){

        System.out.println("----------------------------------------------\n");
        System.out.println("Input list containing nulls is : \n" + numbers + "\n");
        for(Approach<List<Integer>> approach : approaches){
            List<Integer> result = runner.run(approach, numbers);
            assertEquals(result, List.of(1, 2, 4, 16, 7));
        }
    }

}
