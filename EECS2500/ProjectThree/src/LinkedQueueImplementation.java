
public class LinkedQueueImplementation<T> implements QueueInterface<T> {

  // Variables
  // Linked Front Item
  private LinkedItem<T> front;
  // Linked Back Item
  private LinkedItem<T> back;
  // Number of items in the queue
  private int count;
  // Max size of queue
  private int maxCount = 1091;

  // Default Constructor
  public LinkedQueueImplementation() {
    front = null;
    back = null;
    count = 0;
  }

  @Override
  public int size() {
    // returns the size(count) of the queue
    return count;
  }

  @Override
  public boolean isEmpty() {
    // returns if the queue is empty
    return count == 0;
  }

  @Override
  public boolean isFull() {
    // returns if the queue is larger than a given value
    return count == maxCount;
  }

  @Override
  // Adds to the queue
  public void enqueue(T data) throws QueueOverflowException {
    // makes a new item to be added to the linked list and sets it to the passed in data
    LinkedItem<T> newItem = new LinkedItem<>(data);

    // If empty, sets both to zero and sets count to 1
    if (isEmpty()) {
      front = newItem;
      back = newItem;
      count = 1;
      // if not, sets back plus one and front stays the same. Also adds to the count
    } else {
      back.setNext(newItem);
      back = newItem;
      count++;
    }
  }

  @Override
  // Remove item from queue
  public T dequeue() throws QueueUnderflowException {
    // Checks to see if the queue is empty and if so, throws exception
    if (isEmpty()) {
      throw new QueueUnderflowException("Queue is empty. Could not remove item");
    }

    // Sets the item to be removed to a variable so it can be returned later, then deletes the front one and decreases
    // the count
    T itemToRemove = front.getData();
    front = front.getNext();
    count--;

    // Resets the front and back if the queue is empty
    if (isEmpty()) {
      front = back = null;
    }

    // returns the item that was removed
    return itemToRemove;
  }


  @Override
    public boolean contains(T item) {
      boolean found = false;

      if (isEmpty()) {
        return false;
      } else {
        LinkedItem<T> current = front;
        while (current != null) {
          if (current.getData().equals(item)) {
            found = true;
            break;
          }
          current = current.getNext();
        }
      }
      return found;
    }
}
