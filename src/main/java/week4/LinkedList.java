package week4;

public class LinkedList {
    private int size = 0; // 전체적인 사이즈
    private ListNode head;
    private ListNode tail;

    public static class ListNode {
        private int data; // 현재 노드의 데이터
        private ListNode next; // next 노드
        private int position; // 현재 인덱스

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

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        // TODO 1. addFirst head에
        //      2. addLast tail에
        //      3. addIndex 원하는 인덱스에
        if (position == 0) {
            if (this.head == null) {
                this.head = nodeToAdd;
                this.tail = nodeToAdd;
                nodeToAdd.setPosition(position);
                size++;
                return nodeToAdd;
            }
            // 만약에 head가 존재.
            // 근데 size가 1이면 head가 곧 tail이라는 뜻
            if (size == 0) {
                this.tail.position += 1; // tail 포지션 ++
                this.head = nodeToAdd;
                this.head.position = 0;
                nodeToAdd.next = this.tail;
                size++;
                return nodeToAdd;
            }
            ListNode temp = head;
            for (int i = 0; i < size; i++) {
                temp.position += 1;
                temp = temp.next;
            }
            nodeToAdd.next = head;
            this.head = nodeToAdd;
            this.head.position = 0;
            size++;
            return nodeToAdd;
        } else if(position == size) {
            // tail에 넣는다.
            this.tail.next = nodeToAdd;
            this.tail = nodeToAdd;
            nodeToAdd.position = size;
            size++;
            return nodeToAdd;
        } else{
            // 중간에 추가
            ListNode preNode = findByPosition(position - 1);
            ListNode temp = preNode.next;
            for (int i = preNode.next.position; i < size; i++) {
                temp.position += 1;
                temp = temp.next;
            }
            nodeToAdd.next = preNode.next;
            preNode.next = nodeToAdd;
            nodeToAdd.position = position;
            size++;
            return nodeToAdd;

        }
    }

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
        }else if(positionToRemove == (size-1)){
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

    public boolean contains(ListNode head, ListNode nodeTocheck) {
        ListNode temp = head;

        for(int i=0; i<size; i++){
            if (nodeTocheck.equals(temp)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    public void print() {
        ListNode temp = head;
        System.out.print("[ ");

        for(int i=0; i<size; i++){
            System.out.print(temp.data + "(" + temp.position + ")" + " ");
            temp = temp.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 0; i <= 10; i++) {
            list.add(list.head, new ListNode(i), i);
        }
        System.out.println("head : " + list.head.data);
        list.print();

        System.out.println();
        System.out.println("==============================================================");

        list.add(list.head, new ListNode(400), 5);
        list.add(list.head, new ListNode(500), 5);
        list.add(list.head, new ListNode(1000), list.size);
        list.print();

        System.out.println();
        System.out.println();
        list.remove(list.head, 13);
        list.print();

        System.out.println();
        System.out.println();
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 5);
        list.remove(list.head, 0);
        list.print();

        ListNode newNode = new ListNode(456);
        list.add(list.head, newNode, 0);
        System.out.println();
        System.out.println();
        list.print();
        System.out.println();
        System.out.println(list.contains(list.head, new ListNode(1000)));
        System.out.println(list.contains(list.head, newNode));
    }
}
