import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class OpenCalculator {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String lines = br.readLine();
            String[] strs = lines.trim().split("\\s+");
            for (String s : strs) {
                set.add(Integer.parseInt(s));
            }
            lines = br.readLine();
            char[] chars = lines.toCharArray();
            int sz = 0;
            for (Character c : chars) {
                if (!set.contains(c - '0')) {
                    sz++;
                    set.add(c - '0');
                }
            }
            System.out.println(sz);


        }
    }
}
