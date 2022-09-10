public class Main {
    public static void main(String[] args) {
      

        MyLinkedList ls=new MyLinkedList();
        ls.addAtHead(2);
        ls.deleteAtIndex(1);
        ls.addAtHead(2);
        ls.addAtHead(7);
        ls.addAtHead(3);
        ls.addAtHead(2);
        ls.addAtHead(5);
        ls.addAtTail(5);
        ls.get(5);
        ls.deleteAtIndex(6);
        ls.deleteAtIndex(4);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        return getNode(index).val;
    }

    private ListNode getNode(int index) {
        ListNode node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, this.head);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            this.head = newNode;
        }
        this.size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size-1) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == this.size) {
            addAtTail(val);
        } else {
            ListNode node = getNode(index - 1);
            ListNode newNode = new ListNode(val, node.next);
            node.next = newNode;
            this.size++;
        }

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        if (this.size == 1) {
            this.head = this.tail = null;
        } else if (index == 0) {
            this.head = this.head.next;
        } else {
            ListNode node = getNode(index - 1);
            node.next = node.next.next;
            if (index == size - 1) {
                this.tail = node;
            }
        }
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */