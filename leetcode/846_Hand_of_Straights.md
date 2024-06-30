# 846. Hand of Straights
* 그리디
* 우선순위큐로도 풀 수 있는 방법이 있는데, 그 부분을 알아봐야겠다.
```java
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        int kind = hand.length / groupSize;
        int[] checked = new int [kind];
        int[] idx = new int[kind];
        Arrays.fill(idx, -1);
        idx[0] = 0;
        checked[0] = hand[0];
        int first = 0;
        for (int i = 1; i < hand.length ; i++) {
            boolean isExists = false;
            for (int j = 0 ; j <= first ; j++) {
                if (idx[j] < groupSize - 1 && (hand[i] == checked[j] + 1)) {
                    idx[j]++;
                    checked[j] = hand[i];
                    isExists = true;
                    break;
                }
            }
            if (!isExists) {
                if (first == kind - 1) {
                        return false;
                    }
                    first++;
                    checked[first] = hand[i];
                    idx[first] = 0;                    
                } 
        }
        return true;
    }
}
```
