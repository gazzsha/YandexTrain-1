import java.io.*;
import java.util.StringTokenizer;

public class BinarySearch {
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int[] a = new int[n];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                a[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            StringBuilder s = new StringBuilder();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != k; i++) {
                int target = Integer.parseInt(stringTokenizer.nextToken());
                binarySearch(a, target, s);
            }
            bufferedWriter.write(s.toString());
            bufferedWriter.flush();
        }
    }

    public static void binarySearch(int[] a, int target, StringBuilder stringBuilder) {
        int l = 0;
        int r = a.length - 1;
        while (l != r) {
            int mid = (l + r) / 2;
            if (a[mid] >= target) {
                r = mid;
            } else l = mid + 1;
        }
        if (a[l] == target) {
            stringBuilder.append("YES\n");
        } else stringBuilder.append("NO\n");
    }
}