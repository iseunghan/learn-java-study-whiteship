package week4;

public class Stack {
    int size = 0;
    Element tail;

    public class Element {
        Element down;
        int data;

        public Element(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Element temp = new Element(data);

        if (size == 0) {
            this.tail = temp; // 비어있는 상태라서 바로 tail로 설정
        } else { // 데이터가 있을 때
            temp.down = tail;
            this.tail = temp;
        }
        size++;
    }

    public int pop() {
        Element pop = tail;

        if (size > 0) {
            this.tail = tail.down;
        } else {
            throw new NullPointerException("Size를 확인 해주세요");
        }
        pop.down = null;
        size--;

        return pop.data;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (size == 0) {
            return "|    |" + "\n------";
        }

        Element temp = tail;
        while (temp != null) {
            sb.append("| " + temp.data + " |" + "\n");
            temp = temp.down;
        }
        sb.append("------");
        String result = sb.toString();

        return result;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("=== push ===");
        stack.push(10);
        stack.push(10);
        stack.push(10);

        System.out.println("=== pop ====");
        System.out.println(stack.pop() + "  size : " + stack.size);
        System.out.println(stack);
        System.out.println(stack.pop() + "  size : " + stack.size);
        System.out.println(stack);
        System.out.println(stack.pop() + "  size : " + stack.size);
        System.out.println(stack);
    }
}

