package C;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class SecondMax {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int rootValue = Integer.parseInt(stringTokenizer.nextToken());
            Tree root = new Tree(rootValue);
            while (stringTokenizer.hasMoreTokens()) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (value == 0) break;
                addElement(value, root);
            }
            Tree current = root;
            int max = findMax(current);
            int secondMax = findSecondMax(root, max);
            bufferedWriter.write(String.valueOf(secondMax));
            bufferedWriter.flush();
        }
    }

    public static void addElement(int value, Tree root) {
        if (value < root.value) {
            Tree left = root.left;
            if (left != null) {
                addElement(value, left);
            } else {
                left = new Tree(value);
                left.root = root;
                root.left = left;
            }
        } else if (value > root.value) {
            Tree right = root.right;
            if (right != null) {
                addElement(value, right);
            } else {
                right = new Tree(value);
                right.root = root;
                root.right = right;
            }
        }
    }

    public static int findMax(Tree root) {
        while (root.right != null)
            root = root.right;
        return root.value;
    }

    public static int findSecondMax(Tree root, int maxElement) {
        if (root.root != null) {
            if (root.right == null) return root.value;
        }
        if (root.right != null) {
            while (root.right != null) {
                root = root.right;
            }
            if (root.left != null && root.value == maxElement) return findSecondMax(root.left, maxElement);
            else if (root.value == maxElement) return root.root.value;
            else return root.value;
        }
        return findSecondMax(root.left, maxElement);
    }
}

class Tree {
    Tree root;
    Tree left;
    Tree right;
    int value;

    boolean visit = false;

    public Tree(int value) {
        this.value = value;
    }

    public Tree() {
    }
}
