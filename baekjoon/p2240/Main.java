import java.util.*;

// dfs 로 하면 2^30정도가 들텐데 시간 초과날 수 있다고 함. 
// 실제로 시간 초과남..
// 이때는 DP로 풀자.기저 사례, 메모리제이션, 로직, 초기화

public class Main{
    private static int treeNumbers[] = new int[1000];
    private static final int MIN_VALUE = -1000000000;
    private static int n;
    private static int maxMove;
    private static int maxVal = 0;
    private static List<Integer> fruitsList = new ArrayList<>();
    private static List<Integer> treesList = new ArrayList<>();
    private static int dp[][][] = new int[1001][2][31];

    private static int getFruit(int idx, int tree, int count){
        if (count < 0) return MIN_VALUE;
        if (idx == n) return count == 0 ? 0 : MIN_VALUE;
        int ret = dp[idx][tree][count];
        if (ret != -1) return ret;
        int segment = (tree == treeNumbers[idx] - 1) ? 1 : 0;
        dp[idx][tree][count] = Math.max(getFruit(idx + 1, (tree + 1) % 2, count - 1), getFruit(idx + 1, tree, count)) + segment;
        return dp[idx][tree][count];
    }

    public static void main(String[] args) {
        for (int y = 0 ; y < 1001; y++) {
            for (int x= 0; x < 2; x++) {
                Arrays.fill(dp[y][x], -1);
            }
        }
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maxMove = sc.nextInt();
        for (int i = 0 ; i < n ; i++) {
            treeNumbers[i] = sc.nextInt();
        }
        System.out.println(Math.max(getFruit(0, 0, maxMove), getFruit(0, 1, maxMove - 1)));
    }
}