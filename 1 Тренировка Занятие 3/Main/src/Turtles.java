import java.io.*;
import java.util.*;

public class Turtles {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int count = Integer.parseInt(bufferedReader.readLine());
            Set<Map.Entry<Integer,Integer>> set = new HashSet<>();
            for (int i = 0; i != count; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                if (a < 0) {
                    a = b - a;
                }
                if (b < 0) {
                    b = a - b;
                }
                if (a >= 0 && b >= 0 ) {
                    if ((a + b) == count - 1) {
                        set.add(new AbstractMap.SimpleEntry<>(a, b));
                    }
                }
            }
            bufferedWriter.write(String.valueOf(set.size()));
            bufferedWriter.flush();
        }
    }
}
