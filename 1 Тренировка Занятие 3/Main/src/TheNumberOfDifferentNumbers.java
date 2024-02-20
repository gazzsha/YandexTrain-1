import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TheNumberOfDifferentNumbers {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String lines = br.readLine();
            String[] strs = lines.trim().split("\\s+");
            for (String str : strs) {
                set.add(Integer.parseInt(str));
            }
        }
        System.out.println(set.size());

    }
}
