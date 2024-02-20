import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class IntersectionOfSets {
    public static void main(String[] args) throws IOException, IOException {
        Set<Integer> set = new TreeSet<>();
        Set<Integer> set1 = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String lines = br.readLine();
            String[] strs = lines.trim().split("\\s+");
            for (String str : strs) {
                set.add(Integer.parseInt(str));
            }
            lines = br.readLine();
            strs = lines.trim().split("\\s+");
            for (String str : strs) {
                set1.add(Integer.parseInt(str));
            }
        }
        for (Integer x : set) {
            if (set1.contains(x)) {
                System.out.print(x + " ");
            }
        }
    }
}
