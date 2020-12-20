package week5;

public class BinaryTree {
    Node root;
    boolean[] visit;

    public BinaryTree(int size) {
        visit = new boolean[size + 1];
    }
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node (int value) {
            this.value = value;
        }

    }

    void bfs(Node node) {

    }

    void dfs(Node node) {
        // TODO left, mid, right print()
        if (node == null) {
            return ;
        }

        for (int i = 1; i <= 7; i++) {
            if (!visit[node.value]) {
                visit[node.value] = true;
                dfs(node.left);
                System.out.println(node.value);
                dfs(node.right);
            }

        }


    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(7);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        bt.root = n1;
        bt.root.left = n2;
        bt.root.right = n3;
        bt.root.left.left = n4;
        bt.root.left.right = n5;
        bt.root.right.left = n6;
        bt.root.right.right = n7;

        bt.dfs(n1);
    }
}
