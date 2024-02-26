package H;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AVL {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
                 StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                 TreeNode root = new TreeNode(Integer.parseInt(stringTokenizer.nextToken()));
                 while (stringTokenizer.hasMoreTokens()) {
                    int value = Integer.parseInt(stringTokenizer.nextToken());
                    if (value != 0) {
                        addElement(value,root);
                    }
                 }
                 if (check(root) >= 0) {
                     bufferedWriter.write("YES");
                 } else bufferedWriter.write("NO");
            bufferedWriter.flush();
             }
    }

    public static int check(TreeNode tree) {
        if (tree == null) return 0;
        int l = check(tree.left);
        if (l < 0 ) return l;
        int r = check(tree.right);
        if (r < 0) return r;
        if (Math.abs(l - r) > 1) {
            return -Math.max(l,r);
        }
        return Math.max(l,r) + 1;
    }


    public static void addElement(int value,TreeNode root) {
        if (value < root.val) {
            TreeNode left = root.left;
            if (left == null) {
                left = new TreeNode(value);
                root.left = left;
            } else addElement(value,left);
        } else if (value > root.val){
            TreeNode right = root.right;
            if (right == null) {
                right = new TreeNode(value);
                root.right = right;
            } else addElement(value,root.right);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
