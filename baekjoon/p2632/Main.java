import java.util.*;
import java.io.*;

public class Main {
    static int[] mSums;
    static int[] nSums;
    static Map<Integer, Integer> nCounts;
    static Map<Integer, Integer> mCounts;
    private static void check(int mValue, int size, Map<Integer, Integer> mCounts) {
        if (mValue <= size && mValue > 0) {
            if (mCounts.get(mValue) == null) {
                mCounts.put(mValue, 1);
            } else {
                int temp = mCounts.get(mValue);
                mCounts.put(mValue, temp + 1);
            }
        }
    }
    private static void execute(int size, int m, List<Integer> mPizzas, Map<Integer, Integer> mCounts) {
        mCounts.put(0, 1);
        mCounts.put(mPizzas.stream().reduce(0, Integer::sum), 1);
        for (int peek = 1 ; peek < m ; peek++) {
            int target = 0;
            for (int i = 0 ; i < peek ; i++) {
                target += mPizzas.get(i);
            }
            check(target, size, mCounts);
            // System.out.println(target + " " + 0 + " " + peek);
            for (int i = 1 ; i < m ; i++) {
                target += mPizzas.get((peek + i) % m);
                target -= mPizzas.get((i - 1) % m);
                check(target, size, mCounts);
                // System.out.println(target + " " + i + " " + peek);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] cmds = br.readLine().split(" ");
        int m = Integer.parseInt(cmds[0]);
        int n = Integer.parseInt(cmds[1]);
        List<Integer> mPizzas = new ArrayList<>();
        List<Integer> nPizzas = new ArrayList<>();
        nCounts = new HashMap<>();
        mCounts = new HashMap<>();
        for (int i = 0 ; i < m ; i++) {
            mPizzas.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0 ; i < n ; i++) {
            nPizzas.add(Integer.parseInt(br.readLine()));
        }
        execute(size, m, mPizzas, mCounts);
        execute(size, n, nPizzas, nCounts);
        int count = 0;
        for ( int key : mCounts.keySet()) {
            if (nCounts.get(size - key) != null) {
                count += mCounts.get(key) * nCounts.get(size - key);
            }
        }
        System.out.println(count);
    }
}