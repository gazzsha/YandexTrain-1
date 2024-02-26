import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class dfs {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            int visited[] = new int[v+1];
            List<List<Integer>> lists = new ArrayList<>();
            {
                for (int i = 0; i != v + 1; i++)
                    lists.add(new ArrayList<>());
            }
            for (int i = 0; i != e; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int ver1 = Integer.parseInt(stringTokenizer.nextToken());
                int ver2 = Integer.parseInt(stringTokenizer.nextToken());
                lists.get(ver1).add(ver2);
                lists.get(ver2).add(ver1);
            }
            List<Integer> component = new ArrayList<>();
            dfs(lists,visited,1,component);
            bufferedWriter.write(component.size() + "\n");
            component.stream().sorted().forEach(
                    x -> {
                        try {
                            bufferedWriter.write(x + " ");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
            );
            bufferedWriter.flush();
        }
    }
    public static void dfs(List<List<Integer>> lists,int[] visited,int now,List<Integer> component) {
        visited[now] = 1;
        component.add(now);
        for (Integer neig : lists.get(now)) {
            if (visited[neig] == 0) {
                dfs(lists,visited,neig,component);
            }
        }
    }
}
