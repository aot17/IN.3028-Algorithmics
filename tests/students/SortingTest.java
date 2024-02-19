package students;

import ch.unifr.algo2023.students.sort.*;
import org.junit.Test;

import java.util.Random;
import java.util.function.Consumer;

public class SortingTest {
    @Test
    public void testAll() {
        //Remove the comment once implemented
        Consumer<Double[]>[] algorithms = new Consumer[]{
//                (Consumer<Double[]>) InsertionSort::sort,
//                (Consumer<Double[]>) InsertionSortSentinel::sort,
//                (Consumer<Double[]>) SelectionSort::sort,
//                (Consumer<Double[]>) ShellSort::sort,
        };

        int[] sizes = {2, 10, 50, 200, 1000};

        for (Consumer algorithm : algorithms) {
            for (int size : sizes) {
                test(size, algorithm);
            }
        }

    }

    public void test(int count, Consumer<Double[]> sortingAlgorithm) {
        Random random = new Random();

        Double[] array = new Double[count];

        for (int i = 0; i < count; i++)
            array[i] = random.nextDouble();

        sortingAlgorithm.accept(array);

        boolean passedTest = GenericSort.isSorted(array, 0, array.length - 1);

        assert passedTest;

        System.out.printf("Size = %d\t pass=%b%n", count, passedTest);
    }

}
