import java.io.*;
import java.util.StringTokenizer;

public class Diplomas {
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            int h = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            long res = binarySearch(n, h, w);
            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.flush();
        }
    }

    public static long binarySearch(int n, int h, int w) {
        long r = (long) n * Math.max(w, h);
        long l = Math.min(h, w);
        while (l != r) {
            long mid = (l + r) / 2;
            if ((mid / w * mid / h) > n) {
                r = mid;
            } else l = mid + 1;
        }
        return l;
    }
}
