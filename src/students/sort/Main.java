package ch.unifr.algo2023.students.sort;

import ch.unifr.algo2023.students.tools.SimpleFileWriter;
import ch.unifr.algo2023.students.tools.Stopwatch;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Define the sizes of the arrays to sort
        int[] sizes = {200, 500, 1000, 5000, 10000, 50000, 100000, 200000};
        String[] sortingAlgo = {"InsertionSort", "SelectionSort", "ShellSort"};

        // Will be used to save the output
        StringBuilder builder = new StringBuilder();
        builder.append("Algorithm,Size,Time\n");

        // Add here the methods we want to test
        Consumer<Double[]>[] algorithms = new Consumer[]{
                (Consumer<Double[]>) InsertionSort::sort,
                (Consumer<Double[]>) SelectionSort::sort,
                (Consumer<Double[]>) ShellSort::sort};

        // For each sorting algorithm...
        for (int i = 0; i < sortingAlgo.length; i++) {

            //test the algorithm on every defined size..
            for (int size : sizes) {

                //on some random numbers.
                Random random = new Random();
                Double[] array = new Double[size];
                for (int j = 0; j < size; j++)
                    array[j] = random.nextDouble();

                // Start the stopwatch
                Stopwatch stopwatch = new Stopwatch();

                // Start now the sorting - here your code gets applied to the array!
                algorithms[i].accept(array);

                // Stop time
                double time = stopwatch.elapsedTime();

                // Print and add data to our buffer
                System.out.println("Algorithm: " + sortingAlgo[i] + ", Size: " + size + ", Time: " + time);
                String line = String.format("%s,%d,%f", sortingAlgo[i], size, time); //%s= string, %d = integer, %f= float
                builder.append(line).append("\n");
            }
        }

        // Finally, store the output.
        SimpleFileWriter writer = new SimpleFileWriter("src/ch/unifr/algo2023/students/sort/output.csv");
        writer.overwrite(builder.toString());

    }
}
