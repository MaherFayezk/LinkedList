public class LinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  int size;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  private Node<T> treversToIndex(int index) {
    Node<T> current = head;
    int counter = 0;
    while (current.hasNext() && counter < index) {
      current = current.next;
      counter++;
    }
    return current;
  }

  public void prepend(T value) {
    if (this.head == null) {
      this.head = new Node<T>(value);
      this.tail = this.head;
    } else {
      Node<T> newNde = new Node<T>(value);
      newNde.next = this.head;
      this.head = newNde;
    }
    this.size++;
  }

  public void append(T value) {
    if (this.head == null) {
      this.head = new Node<T>(value);
      this.tail = this.head;
    } else {
      Node<T> newNde = new Node<T>(value);
      this.tail.next = newNde;
      this.tail = newNde;
    }
    this.size++;
  }

  public void insert(T value, int index) {
    if (index == 0) {
      this.prepend(value);
      return;
    } else if (index >= this.size) {
      this.append(value);
      return;
    }
    Node<T> current = treversToIndex(index - 1);
    Node<T> newNode = new Node<T>(value);
    newNode.next = current.next;
    current.next = newNode;
    this.size++;
  }

  public T getHead() {
    return this.head.getValue();
  }

  public T getTail() {
    return this.tail.getValue();
  }

  public T get(int index) {
    if (index < 0 || index > this.size - 1) {
      return null;
    } else if (index == this.size - 1) {
      return this.getTail();
    }
    Node<T> current = treversToIndex(index);
    return current.getValue();
  }

  public void remove(int index) {
    if (index < 0) {
      return;
    } else if (index == 0) {
      this.head = this.head.next;
    } else {
      Node<T> beforeCurrent = treversToIndex(index - 1);
      beforeCurrent.next = beforeCurrent.next.next;
    }
    this.size--;
  }

  public void reverse() {
    Node<T> leader = this.head;
    Node<T> follower = leader.next;
    while (follower != null) {
      Node<T> temp = follower.next;
      follower.next = leader;
      leader = follower;
      follower = temp;
    }
    Node<T> temp = this.head;
    this.head.next = null;
    this.head = this.tail;
    this.tail = temp;

  }

}
