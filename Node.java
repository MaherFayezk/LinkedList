
public class Node<T> {
  private T value;
  Node<T> next;
  Node<T> previous;

  public Node(T value) {
    this.value = value;
    this.next = null;
    this.previous = null;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public boolean hasNext() {
    if (this.next == null) {
      return false;
    }
    return true;
  }

}
