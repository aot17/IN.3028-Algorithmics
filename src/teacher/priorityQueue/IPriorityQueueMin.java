package ch.unifr.algo2023.teacher.priorityQueue;

public interface IPriorityQueueMin<T extends Comparable<? super T>> {

    void insert(T v); // inserts element T into the priority queue

    T min(); // returns a smallest item

    T delMin(); // removes and returns a minimal item

    boolean isEmpty(); // checks whether the priority queue is empty

    int size(); // number of items in the priority queue
}
