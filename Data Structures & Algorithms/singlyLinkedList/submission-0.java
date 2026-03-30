class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
    ListNode curr = this.head.next;
    for (int i = 0; i < index; i++) {
        if (curr == null) {
            return -1;
        }
        curr = curr.next;
    }
    if (curr == null) {
        return -1;
    }
    return curr.val;
}

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head.next;
        this.head.next = newNode;
        if (this.tail == this.head) {
            this.tail = newNode;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public boolean remove(int index) {
        ListNode curr = this.head;
        for (int i = 0; i < index; i++) {
            if (curr.next == null) {
                return false;
            }
            curr = curr.next;
        }

        if (curr.next == null) {
            return false;
        }

        if (curr.next == this.tail) {
            this.tail = curr;
        }
        curr.next = curr.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode curr = this.head.next;
        while (curr != null) {
            result.add(curr.val);
            curr = curr.next;
        }
        return result;
    }
}