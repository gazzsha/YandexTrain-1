import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ConnectivityСomponents {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
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
            int[] visited = new int[v + 1];
            int[] components = new int[v + 1];
            int comp = 1;
            for (int i = 1; i != v + 1; i++) {
                if (visited[i] == 0) {
                    dfs(lists, i, visited, components, comp);
                }
                comp++;
            }
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int i = 1; i != v +1; i++) {
                if (!map.containsKey(components[i])) {
                    map.put(components[i],new ArrayList<>());
                    map.get(components[i]).add(i);
                } else map.get(components[i]).add(i);
            }
            bufferedWriter.write(map.size() + "\n");
            for (Map.Entry<Integer,List<Integer>> pair : map.entrySet()) {
                bufferedWriter.write(pair.getValue().size() + "\n");
                for (Integer value : pair.getValue())
                    bufferedWriter.write(value + " ");
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
         }
    }

    public static void dfs(List<List<Integer>> lists,int now, int[] visited,int[] components,int comp) {
        visited[now] = 1;
        for (Integer neig : lists.get(now)) {
            if (visited[neig] == 0) {
                dfs(lists, neig, visited, components, comp);
            }
        }
        components[now] = comp;
    }
}
