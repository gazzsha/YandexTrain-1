import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneInRow {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] dp = new int[36];
            dp[0] = 2;
            dp[1] = 4;
            dp[2] = 7;

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i-3];
            }
            System.out.println(dp[n - 1]);
        }
    }
}