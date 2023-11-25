import java.util.*;
import java.io.*;

//n이 엄청 커서 시간복잡도(n)으로 최적을 찾기는 어려울거 같고 log n으로 해야 될거 같다.
public class Main {
    private static int n;
    private static int m;
    private static List<Integer> colors;

    private static long getWeight(long target) {
        long number = 0;
        for (Integer count : colors) {
            number += count / target;
            if (count % target != 0) number++;
        }
        // System.out.println("number " + number + " " + n);
        if (number <= n) {
            return number;
        }
        return -1L;
    }

    public static void main(String[] args) throws Exception {
        //기본 틀
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmds = br.readLine().split(" ");
        n = Integer.parseInt(cmds[0]);
        m = Integer.parseInt(cmds[1]);
        int maxVal = 0;
        colors = new ArrayList<>();
        for (int i = 0 ; i < m ; i++) {
            int num = Integer.parseInt(br.readLine());
            colors.add(num);
            maxVal = Math.max(maxVal, num);
        }
        long left = 1;
        long right = maxVal;
        long answer = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long num = getWeight(mid);
            // System.out.println(num);
            if (num != -1) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);

    }
}