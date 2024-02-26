import java.io.*;

public class Square {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            long n = Long.parseLong(bufferedReader.readLine());
            long m = Long.parseLong(bufferedReader.readLine());
            long t = Long.parseLong(bufferedReader.readLine());
            bufferedWriter.write(String.valueOf(binarySearch(n, m, t)));
            bufferedWriter.flush();
        }
    }

    public static long binarySearch(long n, long m, long t) {
        long l = 0;
        long r = (n + m - 2) / 4 + 1;
        while (l != r) {
            long mid = (l + (r - l) / 2);
            if (check(mid, n, m, t)) {
                r = mid;
            } else l = mid + 1;
        }
        return l - 1;
    }

    public static boolean check(long k, long n, long m, long t) {
        long sum = 0;
        long sz = k;
        long a1 = 2 * n + 2 * m - 4;
        sum = sz * (2 * a1 + (-8) * (sz - 1)) / 2;
//        for (int i = 0; i != k; i++) {
//            sum += 2 * (n + m - 4L * i) - 4;
//        }
        return sum > t;
    }
}


