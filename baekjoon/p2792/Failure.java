import java.util.*;
import java.io.*;

//시간 복잡도 nlogn
//내 알고리즘이 반드시 최적을 보장하지 않는다는게 가장 큰 실패요인이다..
//최적화 결정 문제로 시간복잡도를 줄일 때 이분탐색을 사용하면 좋을 거 같다. log n 정도가 나올거 같다.
//의문은 그냥 O(n)으로 작성하면 시간 초과 나나? 그 부분도 궁금하다.
public class Failure {
    private static int n;
    private static int m;
    private static List<Integer> colors;

    public static void main(String[] args) throws Exception {
        //기본 틀
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmds = br.readLine().split(" ");
        int n = Integer.parseInt(cmds[0]);
        int m = Integer.parseInt(cmds[1]);

        int rest = n % m;
        int lower = n / m;
        int higher = lower + 1;
        colors = new ArrayList<>();
        for (int i = 0 ; i < m ; i++) {
            colors.add(Integer.parseInt(br.readLine()));
        }
        colors.sort((a, b) -> (Integer.compare(-a, -b)));
        int answer = 0;
        for (int i = 0 ; i < m ; i++) {
            if (i < rest) {
                int temp;
                if (colors.get(i) % higher == 0) {
                    temp = colors.get(i) / higher;
                } else {
                    temp = colors.get(i) / higher + 1;
                }
                answer = Math.max(temp, answer);
            }
            else {
                int temp;
                if (colors.get(i) % lower == 0) {
                    temp = colors.get(i) / lower;
                } else {
                    temp = colors.get(i) / lower + 1;
                }
                answer = Math.max(temp, answer);
            }
        }
        System.out.println(answer);
    }
}