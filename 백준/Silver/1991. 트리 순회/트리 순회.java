import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Character[]> trees = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            trees.add(new Character[2]);
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char parent = str.charAt(0);
            char left = str.charAt(2);
            char right = str.charAt(4);
            trees.get(parent - 65)[0] = left;
            trees.get(parent - 65)[1] = right;
        }

        preorder('A');
        bw.write("\n");

        inorder('A');
        bw.write("\n");

        postorder('A');
        bw.flush();
        bw.close();

    }

    static void preorder(Character c) throws IOException {
        if (!hasChild(c)) {
            bw.write(c);
            return;
        }

        Character[] children = trees.get(c - 65);
        bw.write(c);
        if(children[0] != '.') {
            preorder(children[0]);
        }
        if(children[1] != '.') {
            preorder(children[1]);
        }
    }

    static void inorder(Character c) throws IOException {
        if (!hasChild(c)) {
            bw.write(c);
            return;
        }

        Character[] children  = trees.get(c - 65);
        if(children[0] != '.') {
            inorder(children[0]);
        }
        bw.write(c);
        if(children[1] != '.') {
            inorder(children[1]);
        }

    }

    static void postorder(Character c) throws IOException {
        if (!hasChild(c)) {
            bw.write(c);
            return;
        }

        Character[] children  = trees.get(c - 65);

        if(children[0] != '.') {
            postorder(children[0]);
        }
        if(children[1] != '.') {
            postorder(children[1]);
        }
        bw.write(c);
    }

    private static boolean hasChild(Character c) throws IOException {
        boolean flag = false;
        for(Character child : trees.get(c -65)){
            if(child != '.'){
                flag = true;
                break;
            }
        }

        return flag;
    }
}