import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImprovingAcademicPerformance {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            long a = Long.parseLong(bufferedReader.readLine());
            long b = Long.parseLong(bufferedReader.readLine());
            long c = Long.parseLong(bufferedReader.readLine());
            System.out.println(binarySearch(a, b, c));
        }
    }

    public static long binarySearch(long a, long b, long c) {
        long l = 0;
        long r = (long) 10e15;
        while (l != r) {
            long mid = (l + (r - l) / 2);
            if ((2 * (a * 2 + b * 3 + c * 4 + mid * 5)) >= 7 * (a + b + c + mid)) {
                r = mid;
            } else l = mid + 1;
        }
        return l;
    }
}
