package week4;

public class Queue {
    int[] queue;
    int first = 0;
    int index = 0;
    int size = 0;

    public Queue(int size) {
        queue = new int[size];
        this.size = size;
        System.out.println("--- System : Queue size (" + size + ") 가 생성 되었습니다. ---");
    }

    public void add(int data) {
        queue[index++] = data;
        System.out.println("ADD : " + data);
    }

    public int pop() {
        if (queue[first] == 0) {
            throw new NullPointerException("queue가 비어있습니다.");
        }
        System.out.println("Pop : " + queue[first]);
        return queue[first++];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Queue의 모든 원소를 출력합니다.\n");
        sb.append("--------------------------\n");
        for (int i = first; i < size; i++) {
            if (queue[i] != 0) {
                sb.append(queue[i] + " ");
            } else {
                break;
            }

        }
        sb.append("\n--------------------------");
        String result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        Queue q1 = new Queue(100);

        q1.add(1);
        q1.add(2);
        q1.add(3);

        q1.pop();
        q1.pop();
        q1.pop();
        q1.pop();
        System.out.println(q1);
    }
}
