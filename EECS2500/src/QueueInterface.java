
public interface QueueInterface<T> {
  /**
   * Adds the item T to the end of the Queue assuming
   * the queue is not Full.  If the queue is full a
   * QueueOverflowException is thrown.
   *
   */
  void enqueue(T item) throws QueueOverflowException;
  /**
   * Removes the item at the front of this Queue and returns
   * its contents. If the queue is empty this method throws a
   * QueueUnderflowException.
   * @return the value that was at the head of this queue.
   * @throws QueueUnderflowException
   */
  T dequeue() throws QueueUnderflowException;
  /**
   * Returns the size of this Queue.
   * @return  the size of this Queue.
   */
  int size();
  /**
   *
   * @return true if this queue is empty, false otherwise.
   */
  boolean isEmpty();
  /**
   *
   * @return  true if this queue is full, false otherwise.
   */
  boolean isFull();
}
