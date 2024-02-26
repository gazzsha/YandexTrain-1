import java.io.*;
import java.util.StringTokenizer;

public class ApproximateBinarySearch {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ;
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int[] a = new int[n];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != n; i++) {
                a[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i != k; i++) {
                int value = Integer.parseInt(stringTokenizer.nextToken());
                int l = lBinarySearch(a, value);
                int r = rBinarySearch(a, value);
                if (l != -1 && r != -1) {
                    if (Math.abs(value - l) < Math.abs(value - r))
                        stringBuilder.append(l).append("\n");
                    else stringBuilder.append(r).append("\n");
                } else if (l == -1) {
                    stringBuilder.append(r).append("\n");
                } else stringBuilder.append(l).append("\n");
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }
    }

    public static int lBinarySearch(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        while (l != r) {
            int mid = (l + r) / 2;
            if (a[mid] >= target) {
                r = mid;
            } else l = mid + 1;
        }
        if (a[l] >= target) return a[l];
        return -1;
    }

    public static int rBinarySearch(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        while (l != r) {
            int mid = (l + r + 1) / 2;
            if (a[mid] <= target) {
                l = mid;
            } else r = mid - 1;
        }
        if (a[l] <= target) return a[l];
        return -1;
    }
}
