package B;

import java.io.*;
import java.util.StringTokenizer;

public class TheDepthOfTheAddedElements {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            int valueRoot = Integer.parseInt(stringTokenizer.nextToken());
            Tree tree = new Tree(valueRoot);
            int size = 1;
            stringBuilder.append(size).append(" ");
            while (stringTokenizer.hasMoreTokens()) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (value == 0) break;
                addElement(value, tree, stringBuilder, size);
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }

    }

    public static void addElement(int value, Tree root, StringBuilder stringBuilder, int size) {
        if (value < root.value) {
            Tree left = root.left;
            if (left != null) {
                size++;
                addElement(value, left, stringBuilder, size);
            } else {
                size++;
                stringBuilder.append(size).append(" ");
                left = new Tree(value);
                left.root = root;
                root.left = left;
            }
        } else if (value > root.value) {
            Tree right = root.right;
            if (right != null) {
                size++;
                addElement(value, right, stringBuilder, size);
            } else {
                size++;
                stringBuilder.append(size).append(" ");
                right = new Tree(value);
                right.root = root;
                root.right = right;
            }
        }
    }
}

class Tree {
    Tree root;
    Tree left;
    Tree right;
    int value;

    public Tree(int value) {
        this.value = value;
    }

    public Tree() {
    }
}
