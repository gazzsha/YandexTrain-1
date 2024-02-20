import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TheNumberOfWordsInTheText {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            Set<String> set = new HashSet<>();
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                while (stringTokenizer.hasMoreTokens()) {
                    set.add(stringTokenizer.nextToken());
                }
            }
            bufferedWriter.write(String.valueOf(set.size()));
            bufferedWriter.flush();
        }
    }
}
