import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static List<List<Integer>> points;

    public static int distance(List<Integer> target, List<Integer> compared) {
        int ret = 0;
        ret += Math.pow(target.get(0) - compared.get(0), 2);
        ret += Math.pow(target.get(1) - compared.get(1), 2);
        return ret;
    }

    public static int divideAndConquer(int start, int end) {
        int length = end - start + 1;
        // System.out.println(start + " " + end + " " + length);
        if (length == 2) {
            return distance(points.get(start), points.get(end));
        }
        if (length == 3) {
            int ret = distance(points.get(start), points.get(start + 1));
            ret = Math.min(ret, distance(points.get(start), points.get(start + 2)));
            ret = Math.min(ret, distance(points.get(start + 1), points.get(start + 2)));
            return ret;
        }
        int mid = (start + end) / 2;
        int answer = Math.min(divideAndConquer(start, mid), divideAndConquer(mid + 1, end));
        

        List<List<Integer>> candidates = new ArrayList<>();
        int targetLine = (points.get(mid).get(0) + points.get(mid + 1).get(0)) / 2;
        for (int i = start ; i <= end ; i++) {
            if (Math.pow(targetLine - points.get(i).get(0), 2) < answer) {
                candidates.add(points.get(i));
            }
        }
        candidates.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));
        int size = candidates.size();
        for (int i = 0 ; i < size ; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Math.pow(candidates.get(i).get(1) - candidates.get(j).get(1), 2) >= answer) break ;
                else
                    answer = Math.min(answer, distance(candidates.get(i), candidates.get(j)));
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        //기본 틀
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        points = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            String[] point = br.readLine().split(" ");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            points.add(List.of(x, y));
        }
        // x 좌표를 기준으로 정렬시킨다.
        points.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        
        System.out.println(divideAndConquer(0, n - 1));
    
    }
}