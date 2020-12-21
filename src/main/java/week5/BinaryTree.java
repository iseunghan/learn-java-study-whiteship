package week5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진 탐색트리의 조건
 *  - 자식 노드의 개수는 2개 이하이다.
 *  - 모든 원소는 중복된 값을 가져서는 안된다.
 *  - 그 트리의 루트 값보다 작은 값이 -> 왼쪽 노드
 *  - 그 트리의 루트 값보다  큰 값이 -> 오른쪽 노
 */
public class BinaryTree {
    private Node root;

    public void dfs(Node node) {    // 깊이 우선 탐색 = In-order 방식과 동일
        if (node != null) {
            dfs(node.getLeft());
            System.out.print(node.getValue() + " -> ");
            dfs(node.getRight());
        }
    }

    public void bfs(Node node) {    // 너비 우선 탐색
        // left, right 방문 여부 체크할 배열
        boolean[] visit = {false, false};
        // bfs는 Queue를 이용한다.
        Queue<Node> queue = new LinkedList<Node>();
        Node temp = root;
        // root를 Queue에 넣고 시작
        queue.add(temp);

        while (!queue.isEmpty()) {

            if (!visit[0]) {
                // 왼쪽 방문 할 차례
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                    visit[0] = true;
                }else {
                    System.out.print(queue.poll().getValue() + " -> ");
                }
            } else if (!visit[1]) {
                // 오른쪽 방문 할 차례
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                    visit[1] = true;
                }else {
                    System.out.print(queue.poll().getValue() + " -> ");
                }
            } else {
                // 둘다 방문 완료
                visit[0] = false; // 초기화 시켜주기!
                visit[1] = false;
                System.out.print(queue.poll().getValue() + " -> "); // 출력 시켜주고,
                temp = queue.peek(); // temp 교환
            }
        }
    }

    public void diff_bfs(Node root) {
        Queue<Node> qu = new LinkedList<Node>();
        Node temp = root;
        qu.add(temp);

        while (!qu.isEmpty()) {

            /* 큐에서 첫번째를 뽑아서 temp에 넣고, 출력을 해준다. */
            temp = qu.poll();
            System.out.print(temp.getValue() + " -> ");

            if (temp.getLeft() != null)
                qu.add(temp.getLeft());

            if (temp.getRight() != null)
                qu.add(temp.getRight());
        }
    }

    public void preOrderSearch(Node node, int depth) {
        if (node != null) {
            System.out.print(node.getValue() + " -> ");
            preOrderSearch(node.getLeft(), depth + 1);
            preOrderSearch(node.getRight(), depth + 1);
        }
    }

    public void inOrderSearch(Node node, int depth) {
        if (node != null) {
            inOrderSearch(node.getLeft(), depth + 1);
            System.out.print(node.getValue() + " -> ");
            inOrderSearch(node.getRight(), depth + 1);
        }
    }

    public void postOrderSearch(Node node, int depth) {
        if (node != null) {
            postOrderSearch(node.getLeft(), depth + 1);
            postOrderSearch(node.getRight(), depth + 1);
            System.out.print(node.getValue() + " -> ");
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return "";
    }

    public void insertNode(int value) {

        // root가 없을 경우
        if (root == null) {
            root = new Node(value);
        } else {
            Node temp = root;

            // 노드의 위치를 정하기 위해 값 비교
            while(true){
                // 중복 값이 있는 경우
                if (temp.getValue() == value) {
                    System.out.println("중복된 노드는 삽입할 수 없습니다.");
                    break;
                }// 왼쪽으로 빠져야 하는 경우
                else if (temp.getValue() > value) {
                    if (temp.getLeft() == null) {   // 왼쪽이 비었으면 node를 생성해 넣어준다.
                        temp.setLeft(new Node(value));
                        break;
                    }
                    temp = temp.getLeft();
                } // 오른쪽으로 빠져야 하는 경우
                else{
                    if (temp.getRight() == null) {  // 오른쪽이 비었으면 node를 생성해 넣어준다.
                        temp.setRight(new Node(value));
                        break;
                    }
                    temp = temp.getRight();
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
