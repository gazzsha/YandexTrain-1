import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder stringBuilder = new StringBuilder();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int[] numbers = new int[n + 1];
            int[] previx = new int[n + 1];
            int[] count = new int[n + 1];
            previx[1] = -1;
            for (int i = 1; i < n; i++) {
                if (count[i + 1] == 0 || (count[(i) + 1] > count[i] + 1)) {
                    previx[i + 1] = i;
                    count[i + 1] = count[i] + 1;
                }
                if (i * 2 <= n && (count[(i) * 2] == 0 || (count[(i) * 2] > count[i] + 1))) {
                    previx[(i) * 2] = i;
                    count[(i) * 2] = count[i] + 1;
                }
                if (i * 3 <= n && (count[(i * 3)] == 0 || (count[(i) * 3] > count[i] + 1))) {
                    previx[(i) * 3] = i;
                    count[(i) * 3] = count[i] + 1;
                }
            }
            List<Integer> list = new ArrayList<>();
            while (previx[n] != -1) {
                list.add(n);
                n = previx[n];
            }
            list.add(n);
            stringBuilder.append(list.size() - 1).append("\n");
            for (int i = list.size() - 1; i >= 0; i--) {
                stringBuilder.append(list.get(i)).append(" ");
            }
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }
    }
}
