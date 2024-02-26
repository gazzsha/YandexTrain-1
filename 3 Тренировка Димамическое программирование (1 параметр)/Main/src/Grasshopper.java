import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Grasshopper {
    public static final Integer N = 30;
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int[] a = new int[N + 1];
            a[0] = 0;
            a[1] = 1;
            for (int i = 2; i <= k; i++) {
                a[i] = sum(a,i);
            }
            for (int i = k + 1; i < n + 1; i++) {
                a[i] = sumK(a, k, i);
            }
            System.out.println(a[n]);
        }
    }

    public static int sumK(int[] a, int k, int index) {
        int sum = 0;
        for (int i = index - k; i != index; i++) {
            sum += a[i];
        }
        return sum;
    }
    public static int sum(int[] a,int k) {
        int sum = 0;
        while (k > 0) {
            sum+= a[k - 1];
            k--;
        }
        return sum;
    }
}
