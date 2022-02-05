package stringandmath.challenge03;

import commons.utils.executionutil.Approach;
import commons.utils.executionutil.ApproachRunner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsTest {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    private final ApproachRunner<String> runner = new ApproachRunner<>();
    private final List<Approach<String>> approaches = ReverseWords.approaches;

    @Test
    public void testApproach(){
        System.out.println("----------------------------------------------\n");
        System.out.println("Input text: \n" + TEXT + "\n");
        for(Approach<String> approach : approaches){
            String result = runner.run(approach, TEXT);
            assertEquals("yM hgih ,loohcs eht sionillI scitamehtaM dna ecneicS ,ymedacA dewohs em taht gnihtyna si elbissop dna taht er'uoy reven oot gnuoy ot kniht .gib tA ,51 I dekrow sa a retupmoc remmargorp ta eht imreF lanoitaN rotareleccA ,yrotarobaL ro .balimreF retfA ,gnitaudarg I dednetta drofnatS rof a eerged ni scimonoce dna retupmoc .ecneics", result);
        }
    }
}
