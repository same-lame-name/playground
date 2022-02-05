package stringandmath.challenge11;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindCharacterWithMostAppearancesTest {
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";
    private static final String TEXT_WITH_5As = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science. aaaaa";
    private final List<Approach<Map<Integer, List<String>>>> approaches = FindCharacterWithMostAppearances.approaches;
    private final ApproachRunner<Map<Integer, List<String>>> runner = new ApproachRunner<>();

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT);
        for(Approach<Map<Integer, List<String>>> approach : approaches){
            String result = runner.run(approach, TEXT).toString();
            assertEquals("{29=[e]}", result);
        }
    }

    @Test
    public void testApproachWith5As(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_WITH_5As);
        for(Approach<Map<Integer, List<String>>> approach : approaches){
            Map<Integer, List<String>> result = runner.run(approach, TEXT_WITH_5As);
            assertTrue(result.containsKey(29));
            List<String> symbolList = result.get(29);
            Set<String> symbolSet = new HashSet<>(symbolList);
            assertEquals(symbolSet.size(), symbolList.size());
            for(String symbol : symbolList){
                assertTrue(symbol.equals("a") || symbol.equals("e"));
            }
        }
    }
}
