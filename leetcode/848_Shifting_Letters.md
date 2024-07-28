# 848. Shifting Letters
* 리트코드 랜덤 디펜스
* 누적합
* 처음에 누적합으로 안풀고 그냥 다 더해서 틀렸고, 두번째로 int로 해서 오버플로우 문제가 발생했다.
* 최대 누적된 shift가 10^14이어서 2^31-1을 넘어설 수도 있기 때문이다.
```java
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        //누적합 아이디어와 비슷할 듯
        char[] charArray = new char[s.length()];
        long shift = 0;
        for (int i = shifts.length - 1 ; i >=0 ;i--) {
            shift = shift + shifts[i];
            charArray[i] = s.charAt(i);
            long origin = charArray[i] - 'a';
            char target = (char)('a' + (char)((origin + shift) % 26));
            charArray[i] = target;
        }
        return new String(charArray);
    }
}
```
