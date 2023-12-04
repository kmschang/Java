public interface LinkedListInterface<T> {

    /**
     * Adds the item to the end of the list.
     * @param item the item to add to the list.
     */
    void add(T item);

    /**
     * Adds the item at the specified index.
     * @param item the item to add to the list.
     * @param index the index at which to add the item.
     */
    void add(T item, int index);

    /**
     * Removes the item at the specified index and returns
     * its contents. If the index is out of bounds, this
     * method throws an IndexOutOfBoundsException.
     * @param index the index at which to remove an item.
     * @return the item that was removed.
     * @throws IndexOutOfBoundsException
     */
    T remove(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the item at the specified index.
     * @param index the index of the item to return.
     * @return the item at the specified index.
     * @throws IndexOutOfBoundsException
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the number of items in this list.
     * @return the number of items in this list.
     */
    int size();

    /**
     * Returns true if this list is empty, false otherwise.
     * @return true if this list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns true if this list is full, false otherwise.
     * @return true if this list is full, false otherwise.
     */
    boolean isFull();

    /**
     * Returns a String representation of this list.
     * @return a String representation of this list.
     */
    String toString();

    /**
     * Returns true if the item is in this list, false otherwise.
     * @param item the item to search for.
     * @return true if the item is in this list, false otherwise.
     */
    boolean contains(T item);

    /**
     * Removes all items from this list.
     */
    void clear();

    /**
     * Removes the first occurrence of the specified item from this list.
     * @param item the item to remove.
     * @return true if the item was removed, false otherwise.
     */
    boolean remove(T item);


 }

