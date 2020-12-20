package week5;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insertNode(5);
        bt.insertNode(3);
        bt.insertNode(7);
        bt.insertNode(2);
        bt.insertNode(4);
        bt.insertNode(6);
        bt.insertNode(8);
        bt.dfs(bt.getRoot());
    }
}
