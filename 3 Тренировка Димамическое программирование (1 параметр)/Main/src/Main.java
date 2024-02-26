import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// min in Array
// 1 2 3 4
// 5
//answer 4 5 -> 4 - 5 = abs(-1) = 1;
//public class Main {
//    public static void main(String[] args) throws IOException {
//        StringBuilder stringBuilder = new StringBuilder();
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            int n = Integer.parseInt(bufferedReader.readLine());
//            int[] a = new int[n];
//            String line = bufferedReader.readLine();
//            String[] numbers = line.split("\\s+");
//            for (int i = 0; i != n; i++) {
//                a[i] = Integer.parseInt(numbers[i]);
//            }
//            int m = Integer.parseInt(bufferedReader.readLine());
//            int[] b = new int[m];
//            line = bufferedReader.readLine();
//            numbers = line.split("\\s+");
//            for (int i = 0; i != m; i++) {
//                b[i] = Integer.parseInt(numbers[i]);
//            }
//            search(a,b,n,m,stringBuilder);
//            System.out.println(stringBuilder);
//        }
//    }
//
//    public static void search(int[] a,int[] b ,int n,int m,StringBuilder stringBuilder) {
//        int first = 0;
//        int last = 0;
//        int min = Math.abs(a[first] - b[last]);
//        int min1 = a[first];
//        int min2 = b[last];
//        for (;first != n; first++) {
//            while(last != m && (a[first] - b[last] >= 0 || Math.abs(a[first] - b[last]) < min)) {
//                if (Math.abs(a[first] - b[last]) < min) {
//                    min = Math.abs(a[first] - b[last]);
//                    min1 = a[first];
//                    min2 = b[last];
//                } else {
//                    last++;
//                }
//            }
//        }
//        stringBuilder.append(min1).append(" ").append(min2);
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = bufferedReader.readLine();
            String[] numbers = line.split("\\s+");
            int n = Integer.parseInt(numbers[0]);
            int num = Integer.parseInt(numbers[1]);
            int[] a = new int[n];
            line = bufferedReader.readLine();
            numbers = line.split("\\s+");
            for (int i = 0; i != n; i++) {
                a[i] = Integer.parseInt(numbers[i]);
            }
            search(a, n, num);
        }
    }

    public static void search(int[] a, int n, int k) {
        int first = 0;
        int last = 1;
        long count = 0;
        int size = 0;
        Arrays.sort(a);
        Set<Integer> similar = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (; first != n - 2; ) {
            map.put(a[first], 1);
            while (last != n && size != 1) {
                if (map.containsKey(a[last])) {
                    map.put(a[last], map.get(a[last]) + 1);
                } else {
                    map.put(a[last], 1);
                }
                last++;
                size++;
            }
            if (last != n && ((long) a[first] * k) >= a[last]) {
                if (map.containsKey(a[last])) {
                    map.put(a[last], map.get(a[last]) + 1);
                } else {
                    map.put(a[last], 1);
                }
                long l1 = factorialUsingForLoop(last - first + 1);
                long l2 = 1;
                for (Map.Entry<Integer, Integer> val : map.entrySet()) {
                    l2*= (factorialUsingForLoop(val.getValue()));
                }
                if (map.get(a[last]).equals(map.get(a[first])) && !similar.contains(a[last])) {
                    similar.add(a[last]);
                    count+= l1 / l2;
                } else if (!map.get(a[last]).equals(map.get(a[first]))) count+= l1 / l2;
            }
            map.clear();
            size = 0;
            last++;
            if (last >= n)  {
                first++;
                last = first;
                last++;
            }
        }
        System.out.println(count);
    }

    public static long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
//    public static int[] previxsum(int[] a,int n) {
//        int[] b = new int[n + 1];
//        for (int i = 1; i != n + 1; i++) {
//            b[i] = b[i-1] + a[i-1];
//        }
//        return b;
//    }