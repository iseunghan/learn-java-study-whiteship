package week4;

public class LinkedList {
    private int size = 0; // 전체적인 사이즈
    private ListNode head;
    private ListNode tail; // 빠른 접근을 위해 tail을 만들었다.

    public static class ListNode {
        private int data; // 현재 노드의 데이터
        private ListNode next; // next 노드를 저장 할 변수
        private int position; // 현재 노드의 위치(index)

        public ListNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    //=======================================================================
    //                               add Area
    //=======================================================================

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        // TODO 1. addFirst head에 추가
        //      2. addLast tail에 추가
        //      3. addPosition 중간에 추가
        if (position == 0) {
            addFirst(nodeToAdd);
        } else if (position == size) {
            addLast(nodeToAdd);
        } else {
            addPosition(nodeToAdd, position);
        }
        return nodeToAdd;
    }

    public void addFirst(ListNode nodeToAdd) {
        // TODO 1. head null ? -> list.size = 0
        //      2. head not null ? -> change head
        if (this.head == null) {
            this.tail = nodeToAdd; // list에 1개밖에 없다보니까 head와 tail 역할까지 한다.
        } else {
            if (head == tail) {
                nodeToAdd.next = this.head;
                this.head.position += 1;
            }
            nodeToAdd.next = this.head;
            increasePosition(this.head); // head부터 마지막 까지 position을 하나씩 증가시켜준다.
        }
        this.head = nodeToAdd;
        nodeToAdd.position = 0;
        size++;
    }

    public void addLast(ListNode nodeToAdd) {
        this.tail.next = nodeToAdd;
        this.tail = nodeToAdd;
        this.tail.position = size;
        size++;
    }

    public void addPosition(ListNode nodeToAdd, int position) {
        ListNode preNode = findByPosition(position - 1);
        increasePosition(preNode.next); // 추가할 위치에 있었던 노드부터 마지막 노드까지 pos+1
        nodeToAdd.next = preNode.next;
        preNode.next = nodeToAdd;
        nodeToAdd.position = position;
        size++;
    }

    //=======================================================================
    //                              remove Area
    //=======================================================================

    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode temp = head;

        if (positionToRemove == 0) {
            this.head = temp.next; // head를 바꿔준다.
            temp.next = null; // 기존 head는 이제 삭제

            temp = this.head; // 임시로 사용할 temp 다시 초기화
            for (int i = 1; i < size; i++) {
                temp.position -= 1;
                temp = temp.next;
            }
            size--;
            return temp;
        } else if (positionToRemove == (size - 1)) {
            ListNode preNode = findByPosition(tail.position - 1);
            this.tail = preNode;
            tail.next = null;
            size--;
            return tail;
        }
        ListNode preNode = findByPosition(positionToRemove - 1);
        ListNode cur = preNode.next;
        preNode.next = cur.next;
        cur.next = null;

        cur = preNode.next; // for문에서 사용할 임시 변수 cur 재활용
        for (int i = preNode.next.position; i < size; i++) {
            cur.position -= 1;
            cur = cur.next;
        }
        size--;

        return cur;
    }

    /**
     * find by position
     *
     * @param position
     * @return ListNode
     */
    public ListNode findByPosition(int position) {
        ListNode temp = head; // head부터 탐색
        while (temp.position != position) {
            temp = temp.next;

            if (temp == null) {
                System.out.println("NullPointerException");
                return null;
            }
        }
        return temp;
    }

    /**
     * start 부터 마지막 노드까지 position을 1씩 증가시켜준다.
     *
     * @param start
     */
    public void increasePosition(ListNode start) {
        ListNode temp = start;
        for (int i = start.position; i < size; i++) {
            temp.position += 1;
            temp = temp.next;
        }
    }

    /**
     * is nodeTocheck contains to list?
     *
     * @param head
     * @param nodeTocheck
     * @return boolean
     */
    public boolean contains(ListNode head, ListNode nodeTocheck) {
        ListNode temp = head;

        for (int i = 0; i < size; i++) {
            if (nodeTocheck.equals(temp)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * print all list
     */
    public void print() {
        ListNode temp = head;
        System.out.print("[ ");

        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + "(" + temp.position + ")" + " ");
            temp = temp.next;
        }
        System.out.print("]");
    }

    public int getSize() {
        return size;
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getTail() {
        return tail;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 0; i <= 10; i++) {
            list.add(list.head, new ListNode(i), i);
        }

        System.out.println("head : " + list.head.data);
        list.print();
        System.out.println();
// [ 0(0) 1(1) 2(2) 3(3) 4(4) 5(5) 6(6) 7(7) 8(8) 9(9) 10(10) ]

        list.add(list.head, new ListNode(400), 5);
        list.print();
        System.out.println();
// [ 0(0) 1(1) 2(2) 3(3) 4(4) 400(5) 5(6) 6(7) 7(8) 8(9) 9(10) 10(11) ]
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 0);
        list.print();
        System.out.println();
// [ 1(0) 2(1) 3(2) 4(3) 9(4) 10(5) ]
        ListNode add = new ListNode(200);
        list.add(list.head, add, 0);
        System.out.println(list.contains(list.head, new ListNode(1000))); // false
        System.out.println(list.contains(list.head, add)); // true
    }
}
