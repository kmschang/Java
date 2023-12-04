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
  public void add(T item, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Invalid index");
    }

    Node<T> newNode = new Node<>(item);
    if (index == 0) {
      newNode.next = head;
      head = newNode;
    } else {
      Node<T> temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      newNode.next = temp.next;
      temp.next = newNode;
    }
    size++;
  }

  @Override
  public T remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size || isEmpty()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }

    Node<T> removedNode;
    if (index == 0) {
      removedNode = head;
      head = head.next;
    } else {
      Node<T> temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      removedNode = temp.next;
      temp.next = temp.next.next;
    }
    size--;
    return removedNode.data;
  }

  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= size || isEmpty()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }

    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
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

  @Override
  public void clear() {
    head = null;
    size = 0;
  }

  @Override
  public boolean remove(T item) {
    if (isEmpty()) {
      return false;
    }

    if (head.data.equals(item)) {
      head = head.next;
      size--;
      return true;
    }

    Node<T> current = head;
    while (current.next != null) {
      if (current.next.data.equals(item)) {
        current.next = current.next.next;
        size--;
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override
  public boolean isFull() {
    // This is a linked list, it does not have a fixed size, so it cannot be full
    return false;
  }

}
