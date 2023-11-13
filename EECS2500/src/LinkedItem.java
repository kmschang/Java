
public class LinkedItem<T> {

  private T data;
  private LinkedItem<T> next;

  public LinkedItem(T data) {
    this.data = data;
    this.next = null;
  }

  public T getData() { return data; }

  public void setData(T data) { this.data = data; }

  public LinkedItem<T> getNext() { return next; }

  public void setNext(LinkedItem<T> next) { this.next = next; }
}
