package week4;

public class ListNodeStack {
    ListNode head;
    int size = 0;

    public class ListNode {
        ListNode down;
        int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        ListNode add = new ListNode(data);

        if (this.head == null) {
            this.head = add;
        } else {
            add.down = this.head;
            this.head = add;
        }
        size++;
    }

    public int pop() {
        ListNode temp = this.head;
        if (size > 1) {
            this.head = temp.down;
            size--;
            return temp.data;
        } // else if (size == 1)
        this.head = null;
        size--;
        return temp.data;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode temp = this.head;
        for (int i = 0; i < size; i++) {
            sb.append("| " + temp.data + " |\n");
            temp = temp.down;
        }
        if (size != 0) {
            sb.append("------");
        } else {
            sb.append("[    ]");
        }
        String result = sb.toString();

        return result;
    }

    public static void main(String[] args) {
        ListNodeStack lns = new ListNodeStack();
        lns.push(30);
        lns.push(20);
        lns.push(10);

        System.out.println("head : " + lns.head.data); // head : 10
        lns.pop(); // 10 -> pop
        System.out.println(lns); // 20, 30

        System.out.println("---------------------------------------");
        System.out.println("head : " + lns.head.data); // head : 20
        lns.pop(); // 20 -> pop
        System.out.println(lns); // 30

        System.out.println("---------------------------------------");
        System.out.println("head : " + lns.head.data); // head : 30
        lns.pop(); // 30 -> pop
        System.out.println(lns); // [   ]

        System.out.println("---------------------------------------");
        System.out.println("head : " + lns.head); // head : null
    }
}
