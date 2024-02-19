package ch.unifr.algo2023.teacher.fundamentals;

/**
 * The {@code IQueue} interface represents the functionality of a
 * first-in-first-out (FIFO) queue of generic items. It supports the typical
 * <em>enqueue</em> and <em>dequeue</em> operations, along with methods for
 * peeking at the first item, testing if the queue is empty, and iterating
 * through the items in FIFO order.
 *
 * Comments copied / inspired by Sedgewick-Wayne
 * 
 * @author Reinhard Bürgy
 *
 * @param <Item>
 *            the generic type of an item in this queue
 */
public interface IQueue<Item> extends Iterable<Item> {

    /**
     * Adds the item to this queue.
     *
     * @param item
     *            the item to add
     */
    void enqueue(Item item); // inserts the element at the end (tail) of the queue

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added or null if no
     *         such item exists (no correct exception handling)
     */
    Item dequeue(); // removes the first (head) element of the queue, returns null if queue is empty

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue or null if no such item
     *         exists (no correct exception handling)
     */
    Item peek();

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    int size();

}
