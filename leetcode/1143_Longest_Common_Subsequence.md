# 1143. Longest Common Subsequence
* 문제 : https://leetcode.com/problems/longest-common-subsequence/
* 시간 복잡도 : text1 길이 * text 2 길이
* 풀이를 DP로 선택한 이유 :
    * 완전 탐색으로 선택을 하게 된다면 text1에서 substring을 고르고, text2에서 substring을 고르고 거기서 LCS를 구해야 하는 방식을 생각할 수 있다.
    * 이렇게 되면 substring을 구하는 조합의 가짓수가 (2 ^ text1 길이) * (2 ^ text2 길이)가 될 것이다. 따라서 시간 복잡도가 무지막지하게 커진다. text1, text2 길이가 1000자인 상황에서 이러한 선택은 적합하지 않다.
    * 그리고 substring을 구할 때 이전의 정보를 저장하게 되면 그러니까 text1 string에서 인덱스 i, text2 string에서 인덱스 j를 가리키고 있을 때, (i -1, j) 까지의 정보들과, (i, j - 1)까지의 정보들을 이용할 수 있다. 따라서 이러한 정보들을 이용하는 점화식을 구하고 이전에 정보들을 저장해둔다면 시간복잡도를 줄일 수 있을 것이다.
```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //완전 탐색 
        //dp - text1 포인터, text2 포인터
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0 ; i < text1.length() ; i++) {
            for (int j = 0 ; j <. text2.length() ; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        int answer = dp[text1.length()][text2.length()];
        return answer;
    }
}
```
