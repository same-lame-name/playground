package commons.utils.executionutil;

import static commons.utils.displayutil.DisplayUtil.displayExecutionTime;

public class ApproachRunner<T> {
    public T run(Approach<T> approach, Object... args){
        long startTime = System.nanoTime();
        T firstUnique = approach.apply(args);
        long endTime = System.nanoTime();
        System.out.println(approach.getDescription());
        System.out.println("Result is: " + firstUnique);
        displayExecutionTime(endTime - startTime);

        return firstUnique;
    }
}
