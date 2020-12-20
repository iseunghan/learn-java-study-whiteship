package week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    Node root;

    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public void insertNode(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node temp = this.root;
            while (true) {
                if (temp.value > value) {
                    // 왼쪽으로 가야한다.
                    if (temp.left == null) {
                        temp.left = new Node(value);
                        break;
                    } else {
                        temp = temp.left;
                    }

                } else if (temp.value < value) {
                    // 오른쪽으로 가야한다.

                    if (temp.right == null) {
                        temp.right = new Node(value);
                        break;
                    } else {
                        temp = temp.right;
                    }

                }
            }
        }
    }

    public void bfs(Node node) {
        Queue<Node> qu = new LinkedList<Node>();
        boolean[] visit = {false, false};

        Node temp = this.root;
        qu.add(temp);

        while (!qu.isEmpty()) {

            if (!visit[0]) {
                if (temp.left != null) {
                    qu.add(temp.left);
                    visit[0] = true;
                } else {
                    // null이면 현재 peek 되어있는 값 출력!
                    System.out.println(qu.poll().value);
                }
            } else if (!visit[1]) {
                if (temp.right != null) {
                    qu.add(temp.right);
                    visit[1] = true;
                } else {
                    // null이면 현재 peek 되어있는 값 출력!
                    System.out.println(qu.poll().value);
                }
            } else {
                // 둘 다 방문 완료!
                visit[0] = false;
                visit[1] = false;
                System.out.println(qu.poll().value);
                temp = qu.peek();
            }
        }
    }

    public void dfs(Node node) {

        if(node != null) {
            dfs(node.left);
            System.out.println(node.value);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertNode(4);
        tree.insertNode(2);
        tree.insertNode(6);
        tree.insertNode(1);
        tree.insertNode(3);
        tree.insertNode(5);
        tree.insertNode(7);

        System.out.println("========= bfs ===========");
        tree.bfs(tree.root);
        System.out.println("========= dfs ===========");
        tree.dfs(tree.root);
    }
}
