import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VeryEasyTask {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            long time = Math.min(x, y);

            long l = 0;
            long r = (long) Math.max(x, y) * n;
            while (l != r) {
                long mid = (l + (r - l) / 2);
                if (mid / x + mid / y >= (long) (n - 1)) {
                    r = mid;
                } else l = mid + 1;
            }
            System.out.println(l + time);
        }
    }
}
