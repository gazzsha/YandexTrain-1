import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TheAlienGenome {
    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line1 = br.readLine();
            String line = br.readLine();
            for (int i = 0; i != line.length() - 1; i++) {
                set.add((line.charAt(i) + "" + line.charAt(i + 1)));
            }
            int sz = 0;
            for (int i = 0; i != line1.length() - 1; i++) {
                if (set.contains((line1.charAt(i) + "" + line1.charAt(i + 1)))) sz++;
            }
            System.out.println(sz);


        }
    }
}
