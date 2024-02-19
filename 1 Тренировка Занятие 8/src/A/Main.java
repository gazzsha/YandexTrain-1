package A;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            int rootValue = Integer.parseInt(stringTokenizer.nextToken());
            Tree root = new Tree();
            root.value = rootValue;
            while (stringTokenizer.hasMoreTokens()) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                if (num == 0) break;
                add(num, root);
            }
            int size = 0;
            int maxSize = 0;
            maxSize = treeTraversal(root, size, maxSize);
            bufferedWriter.write(String.valueOf(maxSize == 0 ? 0 : maxSize + 1));
            bufferedWriter.flush();
        }
    }

    public static void add(int value, Tree root) {
        if (value < root.value) {
            Tree left = root.left;
            if (left == null) {
                left = new Tree(value);
                left.root = root;
                root.left = left;
            } else add(value, left);
        } else if (value > root.value) {
            Tree right = root.right;
            if (right == null) {
                right = new Tree(value);
                right.root = root;
                root.right = right;
            } else add(value, right);
        }
    }

    public static int treeTraversal(Tree root, int size, int maxSize) {
        if (root.left != null && !root.left.visit) {
            root = root.left;
            root.visit = true;
            size++;
            maxSize = Math.max(maxSize, treeTraversal(root, size, maxSize));
        } else if (root.right != null && !root.right.visit) {
            root = root.right;
            root.visit = true;
            size++;
            maxSize = Math.max(maxSize, treeTraversal(root, size, maxSize));
        } else if (root.root != null) {
            root = root.root;
            maxSize = Math.max(size, maxSize);
            size--;
            maxSize = Math.max(maxSize, treeTraversal(root, size, maxSize));
        }
        return maxSize;
    }


    static class Tree {
        public Tree left;
        public Tree right;
        public Tree root;

        public boolean visit = false;

        int value;

        public Tree() {
        }

        public Tree(int value) {
            this.value = value;
        }
    }
}