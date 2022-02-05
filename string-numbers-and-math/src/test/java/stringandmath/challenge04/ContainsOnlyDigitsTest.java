package stringandmath.challenge04;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsOnlyDigitsTest {
    private List<Approach<Boolean>> approaches = ContainsOnlyDigits.approaches;
    private final ApproachRunner<Boolean> runner = new ApproachRunner<>();

    private static final String ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326";

    private static final String NOT_ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326A";

    private static final String EMPTY_STRING = "";

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + ONLY_DIGITS + "\n");
        for(Approach<Boolean> approach : approaches){
            Boolean result = runner.run(approach, ONLY_DIGITS);
            assertEquals(Boolean.TRUE, result);
        }
    }

    @Test
    public void testApproachForNonDigit(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + NOT_ONLY_DIGITS + "\n");
        for(Approach<Boolean> approach : approaches){
            Boolean result = runner.run(approach, NOT_ONLY_DIGITS);
            assertEquals(Boolean.FALSE, result);
        }
    }

    @Test
    public void testApproachEmpty(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + EMPTY_STRING + "\n");
        for(Approach<Boolean> approach : approaches){
            Boolean result = runner.run(approach, EMPTY_STRING);
            assertEquals(Boolean.TRUE, result);
        }
    }


}
