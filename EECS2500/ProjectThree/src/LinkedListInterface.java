public interface LinkedListInterface<T> {

    /**
     * Adds the item to the end of the list.
     * @param item the item to add to the list.
     */
    void add(T item);

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
     * Returns true if the item is in this list, false otherwise.
     * @param item the item to search for.
     * @return true if the item is in this list, false otherwise.
     */
    boolean contains(T item);


 }

