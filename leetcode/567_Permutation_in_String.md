# 567. Permutation in String
* 시간복잡도 : O(n), n = s2 길이
* 공간복잡도 : O(n)
* 고정 길이의 슬라이딩 윈도우 방법 이용
    * 완전 탐색을 할 경우, 시작 인덱스를 정하고 s2의 길이까지 인덱스를 탐색하면서 permutation의 구성 문자 종류와 수를 만족시키면 true를 반환하고 그게 아니면 false를 반환한다. 그리고 시작 인덱스를 0부터 s2 길이 - s1 길이까지 반복하게 한다. 완전 탐색을 하게 된다면, 최악의 시간 복잡도는 s1 * s2가 된다. 이 경우 중복해서 각 인덱스의 문자를 확인하는 과정이 포함되게 되고 이를 줄이는 과정이 필요하다고 생각했다.
    * DP를 사용하면 적절하지 않은 이유 : DP를 사용하게 되면 0번째 인덱스의 정보가 계속 누적해서 반영되게 된다. 하지만 여기서는 단 s1 길이의 문자들에 대해서만 판별하면 된다. 따라서 적합하지 않다고 생각했다.
    * 또한 확인해야할 문자들의 수가 s1으로 고정되어 있으므로, 가변 길이의 슬라이딩 윈도우보다는 고정 길이의 슬라이딩 윈도우가 적합하다.
* 실수한 부분 : permutation은 문자의 중복이 일어날 수 있다. 단지 순서만 없는 것이다. 처음에는 중복을 없애고 구하는 식으로 해서 neetcode.io에서는 통과했지만, leetcode 플랫폼에서는 통과하지 못했다.

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> source = new HashMap<>();
        for (int i = 0 ; i < k ; i++) {
            int num = source.getOrDefault(s1.charAt(i), 0);
            count.put(s1.charAt(i) , 0);
            source.put(s1.charAt(i), num + 1);
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        //처음 k개에 대해서 확인
        int c = 0;
        for (int i = 0 ; i < k ; i++) {
            if (count.containsKey(s2.charAt(i))) {
                int target = count.get(s2.charAt(i));
                if (target < source.get(s2.charAt(i))) {
                    c++;
                }
                count.put(s2.charAt(i), target + 1);
            }
        }
        if (c == k) {
            return true;
        }
        //k로 window 크기 고정
        for (int r = k ; r < s2.length() ; r++) {
            int l = r - k;
            if (count.containsKey(s2.charAt(r))) {
                int target = count.get(s2.charAt(r));
                if (target < source.get(s2.charAt(r))) {
                    c++;
                }
                count.put(s2.charAt(r), target + 1);
            }
            if (count.containsKey(s2.charAt(l))) {
                int target = count.get(s2.charAt(l));
                if (target <= source.get(s2.charAt(l))) {
                    c--;
                }
                count.put(s2.charAt(l), target - 1);
            }
            if (c == k) { 
                return true;
            }
        }
        return false;
    }
}
```
