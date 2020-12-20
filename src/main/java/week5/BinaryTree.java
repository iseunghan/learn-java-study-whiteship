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

    public void dfs(Node node) {    // 깊이 우선 탐색

    }

    public void bfs(Node node) {    // 너비 우선 탐색
        // left, right를 체크할 배열
        int[] check_bfs = {0, 0};

        // bfs는 Queue를 이용한다.
        Queue<Node> queue = new LinkedList<Node>();

        Node searchNode = root;

        // root를 Queue에 넣고 시작
        queue.add(searchNode);
        Node tempNode = searchNode;

        while (true) {
            if (check_bfs[0] == 0) {
                // 왼쪽을 탐색하지 않았다면 왼쪽 탐색
                tempNode = queue.poll();

                if (tempNode == null) {
                    System.out.println("찾으려는 데이터가 없습니다.");
                    break;
                } else if (tempNode.getValue() == node.getValue()) {
                    System.out.print(tempNode.getValue());
                    break;
                } else {
                    System.out.println(tempNode.getValue() + " -> ");
                }

                searchNode = tempNode.getLeft();
                check_bfs[0] = 1;

                if (searchNode != null) {
                    queue.add(searchNode);
                }
            } else if (check_bfs[0] == 1 && check_bfs[1] == 0) {
                // 오른쪽 탐색 할 차례
                searchNode = tempNode.getRight();
                check_bfs[1] = 1;

                if (searchNode != null) {
                    queue.add(searchNode);
                }else {
                    // left, right 값 초기화
                    check_bfs[0] = 0;
                    check_bfs[1] = 0;

                }
            }
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
