# 763. Partition Labels
* https://leetcode.com/problems/partition-labels/
* 그리디
* first index이 순서는 보장되니까 last index만 고려하면 되는데 first Idx를 추가를 했다. 
```java
class Solution {
    Map<Character, Integer> firstMap = new HashMap<>();
    Map<Character, Integer> lastMap = new HashMap<>();
    public List<Integer> partitionLabels(String s) {
        //각각의 count
        //모든 단어에 대해서 
        //알파벳에 대해서 first index last index 구하기
        //first index 순서대로 정렬
        // max last index 구하기
        // max last index를 first index가 넘어서면 다음걸로 갱신 그게 아니면 계속 max last index를 업데이트해 나간다.
        for (int i = 0 ; i < s.length() ; i++) {
            char target = s.charAt(i);
            Integer first = firstMap.get(target);
            if (first == null) {
                firstMap.put(target, i);
                lastMap.put(target, i);
            } else {
                lastMap.put(target, i);
            }
        }
        List<Integer> answers = new ArrayList<>();
        int firstIdx = Integer.MAX_VALUE;
        int lastIdx = -1;
        for (int i = 0 ; i < s.length() ; i++) {
            char target = s.charAt(i);
            firstIdx = Math.min(firstMap.get(target), firstIdx);
            lastIdx = Math.max(lastMap.get(target), lastIdx);
            if (lastIdx == i) {
                answers.add(lastIdx - firstIdx + 1);
                firstIdx = i + 1;
            }
        }
        return answers;
    }
}
```
* 필요한 부분만 추려내고 좀 더 속도를 개선한 코드는 다음과 같다.
```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIdx =new int[26];
        for (int i = 0 ; i < s.length() ; i++) {
            int target = s.charAt(i) - 'a';
            lastIdx[target] = i;
        }
        List<Integer> answer = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0 ; i < s.length(); i++) {
            int last = lastIdx[s.charAt(i) - 'a'];
            end = Math.max(end, last);
            if (i == end) {
                answer.add(end - start + 1);
                start = i + 1;
            }
        }
        return answer;
    }
}
```
