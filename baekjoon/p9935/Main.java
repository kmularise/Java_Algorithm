import java.util.*;
import java.io.*;
//1000000 개여서 배열로 만들면 메모리 초과가 나나..
//Stack 자료구조의 아이디어를 이용하는 것
//비교 문자열이 최대 36자라서 크기가 그렇게 크지않으므로 시간 복잡도는 n일 거 같다.
public class Main {
    public static void main(String[] args) throws Exception {
        //기본 틀
        //1~36
        // ((()))
        // 앞쪽 (문자열) 뒤쪽
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String compared = br.readLine();
        int csize = compared.length();
        int tsize = target.length();
        //character??
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < tsize ; i++) {
            sb.append(target.charAt(i));
            boolean isDeleted = true;
            if (sb.length() >= csize && sb.charAt(sb.length() - 1) == compared.charAt(csize - 1)) {
                for (int j = 0 ; j < csize ; j++) {
                    char sbChar = sb.charAt(sb.length() - csize + j);
                    char comparedChar = compared.charAt(j);
                    if (sbChar != comparedChar) {
                        isDeleted = false;
                    }
                }
                if (isDeleted) {
                    sb.delete(sb.length() - csize, sb.length());
                }
            }
        }
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}