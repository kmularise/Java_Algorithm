import java.util.*;

// dfs 로 하면 2^30정도가 들텐데 시간 초과날 수 있다고 함. 
// 실제로 시간 초과남..
// 이때는 DP로 풀자.기저 사례, 메모리제이션, 로직, 초기화

public class Failure{
    private static int treeNumbers[] = new int[1000];
    private static int count;
    private static int maxMove;
    private static int maxVal = 0;
    private static List<Integer> fruitsList = new ArrayList<>();
    private static List<Integer> treesList = new ArrayList<>();
    private static int dp[][];
    private static void dfs(int move, int current, int idx, int count) {
        if (idx >= fruitsList.size()) {
            maxVal = Math.max(maxVal, count);
            return;
        }
        if (current == treesList.get(idx)) {
            dfs(move, current, idx + 1, count +fruitsList.get(idx));
        }
        else {
        if (move < maxMove){
            dfs(move + 1, treesList.get(idx), idx + 1, count + fruitsList.get(idx));
        }
            dfs(move, current, idx + 1, count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        maxMove = sc.nextInt();
        for (int i = 0 ; i < count ; i++) {
            treeNumbers[i] = sc.nextInt();
        }
        int fruits = 1;
        int treeNumber = treeNumbers[0];
        for (int i = 1 ; i < count ; i++) {
            if (treeNumbers[i] != treeNumbers[i - 1]){
                fruitsList.add(fruits);
                treesList.add(treeNumber);
                treeNumber = treeNumbers[i];
                fruits = 1;
            } else {
                fruits++;
            }
        }
        fruitsList.add(fruits);
        treesList.add(treeNumber);
        dfs(0, 1, 0, 0);
        System.out.println(maxVal);
        
    }
}