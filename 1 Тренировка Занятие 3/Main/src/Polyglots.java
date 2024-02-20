import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Polyglots {
    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line1 = br.readLine();
            String line2 = br.readLine();
            for (int j = 0; j != Integer.parseInt(line2); j++) {
                String line = br.readLine();
                set.add(line);
            }
            Set<String> set1 = new HashSet<>(set);
            for (int i = 0; i != Integer.parseInt(line1) - 1; i++) {
                line2 = br.readLine();
                Set<String> set2 = new HashSet<>();
                for (int j = 0; j != Integer.parseInt(line2); j++) {
                    String line = br.readLine();
                    set.add(line);
                    set2.add(line);
                }
                set1.retainAll(set2);
            }
            System.out.println(set1.size());
            for (String val : set1) {
                System.out.println(val);
            }
            System.out.println(set.size());
            for (String val : set) {
                System.out.println(val);
            }
        }

    }
}
