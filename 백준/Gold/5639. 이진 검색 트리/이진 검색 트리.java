import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    static class BinaryTree {
        Node root;

        public void push(Node o) {
            if (root == null) {
                root = o;
                return;
            }

            Node cur = root;
            while (true) {
                if (o.value < cur.value) {
                    if (cur.left == null) {
                        cur.left = o;
                        return;
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = o;
                        return;
                    }
                    cur = cur.right;
                }
            }
        }
    }
    static class Node {
        int value;
        Node left, right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree binaryTree = new BinaryTree();
        String input;
        while((input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            binaryTree.push(new Node(value, null, null));
        }
        postOrder(binaryTree.root);
        System.out.println(sb.toString());
    }

    private static void postOrder(Node o) {
        if(o.left != null) postOrder(o.left);
        if(o.right != null) postOrder(o.right);
        sb.append(o.value).append("\n");
    }
}
