package ch.unifr.algo2023.students.search;

import ch.unifr.algo2023.teacher.priorityQueue.HeapPQMin;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Leipzig {
    public static void main(String[] args) throws IOException {
        // Pass the file as program argument. If you don't know how to pass arguments, pass "src/ch/unifr/algo2022/students/data/leipzig1M-p.txt" to  File()
        Scanner input = new Scanner(new File(args[0]));

        // Create your symbol table here (name it "st")
        // Todo: Create symbol table (st)


        // Loop over all words from the file
        while (input.hasNext()) {
            String word = input.next();
            // Add the words to your symbol table
            // Todo: Add words to symbol table
        }
        input.close();


        // Todo: Find the 10 most frequent words and display them


        // Loop over all words (useful for testing your symbol table)
        // 1) Using an iterator
        if (st.size() > 0) {

            HeapPQMin<Pair> pq = new HeapPQMin<>(10); //need at least 10 elements
            Iterator<String> iter = st.keys().iterator();
            while (iter.hasNext()) {
                String word = iter.next();
                //System.out.println(word + " - " + st.get(word));
                // Todo:
                // Here, you should insert to the priority queue a new Pair(...) object (See below)
                // Now think: Later, we'll use pq.delMin() to get the minimum value from the heap.
                // Imagine we have a 4 element Heap like: { word1: 100, word2: 150, word3: 95, word4: 270 }
                // How can we change/manipulate the numbers, such that when we call delMin() we should get "word4"...?

            }

            //Now go through the prioQueue
            Pair max;
            for (int i = 0; i < 10; i++) {
                max = pq.delMin();
                // Todo:
                // print.... and don't forget to undo the manipulation you did above to the word count ...
            }
        }

        // 2) If iterator does not work, use this enhanced for loop instead
//        for (String s : st.keys()) {
//            System.out.println(s + " - " + st.get(s));
//        }





    }

    public static class Pair implements Comparable<Pair> {

        String key;
        int value;

        private Pair(String k, int v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.value, p.value);
        }
    }
}

