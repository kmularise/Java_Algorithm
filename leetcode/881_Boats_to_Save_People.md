# 881. Boats to Save People
* 문제 : https://leetcode.com/problems/boats-to-save-people/description/?envType=daily-question&envId=2024-08-01
* 리트코드 랜덤디펜스(medium)
* 시간복잡도 : n log (n) 
* 그리디, 투포인터
* 정렬은 Arrays 내장된 함수 sort를 이용하였다. 그렇지만 counting 정렬(계수 정렬)을 이용한다면 최댓값이 작기에 시간복잡도(n)으로 정렬을 할 수 있을 것 같다.
* Arrays.sort() 할 때 int가 기본타입이라 Comparator를 사용하지 못했다. 이에 따라 Integer[]로 바꿔주는 작업을 해 comparator를 사용하거나 기본 sort만 이용해야 할 것 같다. 이점을 인지하지 못해서 컴파일이 되지 않아서 주의를해야 할거 같다.
* 아이디어만 떠올리면 구현을 비교적 간단한 거 같다.
```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //limit를 가장 적게
        //그리디하게 가져갈 수 있을까
        //people을 정렬
        //start end
        //가장 큰거부터 
        //각 보트를 보고 남아있는 공간이 없으면 새로 만들기
        Arrays.sort(people);
        int big = people.length - 1;
        int small = 0;
        int count = 0;
        while (true) {
            if (big == small) {
                count++;
                break;
            }
            if (big < small) {
                break;
            }
            if (people[small] + people[big] <= limit) {
                small++;
            }
            big--;
            count++;
        }
        return count;
    }
}
```
