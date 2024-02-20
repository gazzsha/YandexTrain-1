import java.io.*;
import java.util.*;
import java.util.stream.Collector;

public class Cubes {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder stringBuilder = new StringBuilder();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            Set<Integer> anyaCubes = new TreeSet<>();
            Set<Integer> boryaCubes = new TreeSet<>();
            for (int i = 0; i != n; i++) {
                anyaCubes.add(Integer.valueOf(bufferedReader.readLine()));
            }
            for (int i = 0; i != m; i++) {
                boryaCubes.add(Integer.valueOf(bufferedReader.readLine()));
            }
            Set<Integer> both = new TreeSet<>(anyaCubes);
            both.retainAll(boryaCubes);
            anyaCubes.removeAll(both);
            boryaCubes.removeAll(both);
            printSet(both, stringBuilder);
            printSet(anyaCubes, stringBuilder);
            printSet(boryaCubes, stringBuilder);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }
    }

    public static void printSet(Set<Integer> set, StringBuilder stringBuilder) {
        stringBuilder.append(set.size()).append("\n");
//        set.stream().sorted(Comparator.comparingInt(Integer::valueOf)).forEach(
//                value -> stringBuilder.append(value).append(" ")
//        );
        set.forEach(
                value -> stringBuilder.append(value).append(" ")
        );
        stringBuilder.append("\n");
    }
}