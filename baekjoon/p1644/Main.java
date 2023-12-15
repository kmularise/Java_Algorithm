import java.util.*;
// 시간 복잡도는 n^2 이하 아마 break 문을 걸어서 유효하지 않은 연산은 하지 않도록 해서
// 톰과하는게 아닌가 싶다.
public class Main {
    //아리토스테네스 체
    private static boolean[] numbers = new boolean[4000001];
    private static List<Long> primes = new ArrayList<>();
    private static List<Long> primeSum = new ArrayList<>();
    public static void checkPrimeNumbers() {
        numbers[0] = true;
        numbers[1] = true;
        for (int i = 2 ; i <= 4000000 ; i++) {
            if (!numbers[i]) {
                for (int j = i * 2 ; j <= 4000000 ; j += i) {
                    numbers[j] = true;
                }
                primes.add((long)i);
            }
        }
    }
    public static void main(String[] args) {
        //기본 틀
        //i : j
        checkPrimeNumbers();
        long sum = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        primeSum.add(0L);
        
        for (long prime : primes) {
            sum += prime;
            primeSum.add(sum);
        }
        long temp = primeSum.get(primeSum.size() - 1);
        for (int i = 0 ; i < primeSum.size() ; i++) {
            for (int j = i + 1 ; j < primeSum.size() ; j++) {
                if (primeSum.get(j) - primeSum.get(i) == n) {
                    count+= 1;
                    break ;
                }
                else if (primeSum.get(j) - primeSum.get(i) > n) {
                    break ;
                }
            }
        }
        System.out.println(count);
    }
}