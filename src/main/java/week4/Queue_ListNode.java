package week4;

public class Queue_ListNode {
    int size;
    ListNode top;

    public class ListNode {
        ListNode pre;
        int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        ListNode node = new ListNode(data);
        if (top == null) {
            top = node;
        } else {
            ListNode temp = top;
            for (int i = 0; i < size - 1; i++) {
                temp = temp.pre;
            }
            temp.pre = node;
        }
        size++;
    }

    public int pop() {
        if (size > 0) {
            ListNode temp = top;
            top = temp.pre;
            temp.pre = null;
            return temp.data;
        }
        throw new NullPointerException("size : 0");
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("스택의 모든 원소를 출력합니다.\n");
        ListNode temp = top;
        if (temp == null) {
            sb.append("[   ]");
        }
        while (temp != null) {
            sb.append(temp.data + " ");
            temp = temp.pre;
        }
        String result = sb.toString();

        return result;
    }

    public static void main(String[] args) {
        Queue_ListNode sl = new Queue_ListNode();
        sl.push(10);
        sl.push(20);
        sl.push(30);

        sl.pop();
        sl.pop();
        sl.pop();
        System.out.println(sl); // 스택의 모든 원소를 출력합니다.
        // [   ]
    }
}
