package datastruct;

/**
 * Interface defining a list where items are not sorted
 */
public interface UnsortedList<E> {

    /**
     * @return true if the list contains no elements
     */
    boolean isEmpty();

    /**
     * @return the number of elements in the list
     */
    int size();

    /**
     * Add one element at the beginning of the list
     *
     * @param element the element to be added
     */
    void prepend(E element);

    /**
     * Add one element at the end of the list
     *
     * @param element the element to be added
     */
    void append(E element);

    /**
     * Insert an element at a specific position in the list.
     * if pos==0, then the element is inserted at first position.
     * if pos==list.size(), then insert is equivalent to append().
     *
     * @param element the element to insert
     * @param position the position where to insert
     * @throws IndexOutOfBoundsException if position is not valid
     */
    void insert(E element, int position) throws IndexOutOfBoundsException;

    /**
     * Remove the first element in the list and returns it
     *
     * @return the first element in the list
     * @throws EmptyListException if the list is empty
     */
    E pop() throws EmptyListException;

    /**
     * Remove the last element in the list and returns it
     *
     * @return the last element in the list
     * @throws EmptyListException if the list is empty
     */
    E popLast() throws EmptyListException;

    /**
     * Remove the element found at the given position
     *
     * @param position the position of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if position is not valid
     */
    E remove(int position) throws IndexOutOfBoundsException;
}
