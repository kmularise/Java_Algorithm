import java.util.*;

class Info {
    Info (int node, int people) {
        this.node = node;
        this.people = people;
    }
    int node;
    int people;
}

public class Main {
    private static List<Integer> people = new ArrayList<>();
    private static int n;
    private static int color[] = new int[11];
    private static boolean visited[] = new boolean[11];
    private static List<List<Integer>> graph = new ArrayList<>(11);
    private static int minVal = Integer.MAX_VALUE;
    

    private static Info dfs(int current, int targetColor) {
        visited[current] = true;
        Info info = new Info(1, people.get(current));
        for (int next : graph.get(current)) {
            if (color[next] != targetColor) continue;
            if (visited[next]) continue;
            Info temp = dfs(next, targetColor);
            info.node += temp.node;
            info.people += temp.people;
        }
        return info;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        people.add(-1);
        graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            people.add(sc.nextInt());
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n ;i++) {
            graph.add(new ArrayList<>());
            int nextCount = sc.nextInt();
            for (int j = 0; j < nextCount ; j++) {
                int next = sc.nextInt();
                graph.get(i).add(next);
            }
        }
        for (int i = 1 ; i < (1 << n) - 1; i++) {
            Arrays.fill(visited, false);
            Arrays.fill(color, 0);
            int one = -1;
            int another = -1;
            for (int j = 0 ; j < n ; j++) {
                int temp = i & (1 << j);
                if ((i & (1 << j)) != 0) {
                    color[j + 1] = 1;
                    one = j + 1;
                }
                else {
                    another = j + 1;
                }
            }
            Info oneInfo = dfs(one, 1);
            Info anotherInfo = dfs(another, 0);
            if (oneInfo.node + anotherInfo.node != n) continue;
            minVal = Math.min(minVal, Math.abs(anotherInfo.people - oneInfo.people));
        }
        System.out.println(minVal == Integer.MAX_VALUE ? -1 : minVal);


    }
}