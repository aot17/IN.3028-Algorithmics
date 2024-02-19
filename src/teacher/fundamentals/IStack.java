package ch.unifr.algo2023.teacher.fundamentals;

/**
 * The {@code IStack} interface represents the functionality of a
 * last-in-first-out (LIFO) stack of generic items. It supports the typical
 * <em>push</em> and <em>pop</em> operations, along with methods for peeking at
 * the top item, testing if the stack is empty, and iterating through the items
 * in LIFO order.
 * 
 * @author Reinhard Bürgy
 *
 * @param <Item>
 *            the generic type of an item in this stack
 */
public interface IStack<Item> extends Iterable<Item> {

    /**
     * Adds the item to this stack.
     *
     * @param item
     *            the item to add
     */
    void push(Item item); // pushes the item onto the stack


    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added or null if stack is empty
     */
    Item pop();

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack or null if the stack is empty
     */
    Item peek();

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    boolean isEmpty(); // returns true if no element is on stack and false, otherwise

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    int size(); // returns the number of elements on the stack

}
