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

        System.out.println("DFS 탐색입니다.");
        bt.dfs(bt.getRoot());
        System.out.println();
        System.out.println("BFS(1) 탐색입니다.");
        bt.bfs(bt.getRoot());
        System.out.println();
        System.out.println("BFS(2) 탐색입니다.");
        bt.diff_bfs(bt.getRoot());
    }
}
