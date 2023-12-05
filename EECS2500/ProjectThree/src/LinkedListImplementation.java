public class LinkedListImplementation<T> implements LinkedListInterface<T> {

  private Node<T> head;
  private int size;

  private static class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  public LinkedListImplementation() {
    this.head = null;
    this.size = 0;
  }

  @Override
  public void add(T item) {
    Node<T> newNode = new Node<>(item);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
    size++;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    // This is a linked list, it does not have a fixed size, so it cannot be full
    return false;
  }

  @Override
  public boolean contains(T item) {
    Node<T> current = head;
    while (current != null) {
      if (current.data.equals(item)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

}
