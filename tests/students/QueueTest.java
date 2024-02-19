package students;

import students.fundamentals.ArrayQueue;
import students.fundamentals.IQueue;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

public class QueueTest
{
    // Simple test, basic functionality
    @Test
    public void test0()
    {
        IQueue<Integer> integerQueue = new ArrayQueue<>();
        integerQueue.enqueue(1);

        assert !integerQueue.isEmpty();

        integerQueue.enqueue(2);
        integerQueue.enqueue(3);

        assert integerQueue.dequeue() == 1;
        assert integerQueue.dequeue() == 2;
        assert integerQueue.dequeue() == 3;
        assert integerQueue.isEmpty();

        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);

        assert integerQueue.dequeue() == 1;
        assert integerQueue.dequeue() == 2;
        assert integerQueue.dequeue() == 3;
        assert integerQueue.dequeue() == 4;
        assert integerQueue.isEmpty();
    }

    // A bit more complex
    @Test
    public void test1()
    {
        IQueue<Integer> queue = new ArrayQueue<>();
        int count = 1000;

        Random rand = new Random();

        int lastIn = 0;
        int lastOut = 0;

        for (int i = 0; i < count; ) {
            if (queue.isEmpty() || rand.nextDouble() < .7) {
                i++;
                //System.out.println("adding " + (lastIn + 1));
                queue.enqueue(++lastIn);
            } else {
                int out = queue.dequeue();
                assert out == lastOut + 1;
                //System.out.println("removing " + out);
                lastOut = out;
            }
        }

        assert lastIn == count;

        while (!queue.isEmpty()) {
            int out = queue.dequeue();
            assert out == lastOut + 1;
            //System.out.println("removing " + out);
            lastOut = out;
        }

        assert  lastOut == count;
    }

    // Test the peek() method
    @Test
    public void test2(){
        IQueue<Integer> queue = new ArrayQueue<>();

        queue.enqueue(100);
        queue.enqueue(101);
        queue.enqueue(102);

        assert queue.peek() == 100;
        queue.dequeue();
        assert queue.peek() == 101;
        queue.dequeue();
        assert queue.peek() == 102;
        queue.dequeue();
        assert queue.peek() == null;
    }

    // Test the iter method
    @Test
    public void test3(){
        IQueue<String> queueOfStrings = new ArrayQueue<String>();
        queueOfStrings.enqueue("Sun");
        queueOfStrings.enqueue("Star");
        queueOfStrings.enqueue("Cloud");
        queueOfStrings.enqueue("Lightning");

        Iterator iterator = queueOfStrings.iterator();

        String[] verify = {"Sun", "Star", "Cloud", "Lightning"}; // exactly in this order
        int i = 0;

        while(iterator.hasNext()) {
            assert iterator.next() == verify[i];
            i++;
        }

    }
}