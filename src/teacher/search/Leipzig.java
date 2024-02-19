

package ch.unifr.algo2023.teacher.search;

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
        BinarySearchTree<String, Integer> st = new BinarySearchTree<>();


        // Loop over all words from the file
        Integer val;
        while (input.hasNext()) {
            String word = input.next();
            // Add the words to your symbol table
            val = st.get(word);
            if (val == null) {
                st.put(word, 1); // start the counter at 1 if word doesn't exist
            } else {
                st.put(word, val + 1); //increase the counter
            }
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
                // Imagine we have a 4 element Heap like: { word1: -100, word2: -150, word3: -95, word4: -270 }
                // How can we change/manipulate the numbers, such that when we call delMin() we should get "word4"...?
                pq.insert(new Pair(word, -1 * st.get(word)));
            }

            //Now go through the prioQueue
            Pair max;
            int wordsPrinted = 0;
            while(true){
                max = pq.delMin();
                if(max.key.length() < 8) continue; // if word is less than 8 letters
                System.out.println(String.format("Word \"%s\" occurs %d times", max.key, -1 * max.value));
                wordsPrinted++;
                if(wordsPrinted==10) break; //exit loop once 10 words have been printed
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

