package E;

import java.io.*;
import java.util.StringTokenizer;

public class LeafWithdrawal {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int rootValue = Integer.parseInt(stringTokenizer.nextToken());
            StringBuilder stringBuilder = new StringBuilder();
            Tree root = new Tree(rootValue);
            while (stringTokenizer.hasMoreTokens()) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (value != 0) {
                    addElement(root, value);
                }
            }
            bypass(root, stringBuilder);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }

    }


    static public void addElement(Tree root, int value) {
        if (value < root.value) {
            Tree left = root.left;
            if (left == null) {
                left = new Tree(value);
                left.root = root;
                root.left = left;
            } else addElement(left, value);
        } else if (value > root.value) {
            Tree right = root.right;
            if (right == null) {
                right = new Tree(value);
                right.root = root;
                root.right = right;
            } else addElement(right, value);
        }
    }

    public static void bypass(Tree root, StringBuilder stringBuilder) {
        while (root.left != null && !root.left.visit) {
            root = root.left;
        }
        if (!root.visit && root.left == null && root.right == null) stringBuilder.append(root.value).append("\n");
        root.visit = true;
        if (root.right != null && !root.right.visit) {
            bypass(root.right, stringBuilder);
        } else if (root.root != null) bypass(root.root, stringBuilder);
    }
}

class Tree {
    Tree left;
    Tree right;
    Tree root;
    int value;

    boolean visit = false;

    public Tree(int value) {
        this.value = value;
    }

    public Tree() {
    }
}

