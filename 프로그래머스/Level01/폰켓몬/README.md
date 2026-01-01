## 문제
- N마리 중에 N/2 가져갈 수 있음
- 가질 수 있는 폰켓몬의 종류가 가장 많을때의 폰켓몬 개수를 리턴

## 틀린 풀이
- set에 dfs로 경우의수 ex 1, 2, 3, 3
- set 사이즈랑 최대값 비교해서 최대값 구한 후 리턴

```java
import java.util.*;
class Solution {
    static int N;
    static int max;
    static Set<Integer> numbers;
    public int solution(int[] nums) {
        N = nums.length / 2;
        max = Integer.MIN_VALUE;
        numbers = new HashSet<>();
        dfs(0, 0, nums);
        return max;
    }
    
    public void dfs(int count, int depth, int[] nums) {
        if(count == N) {
            max = Math.max(max, numbers.size());
            return;
        }
        
        for(int i = depth; i < nums.length; i++) {
            numbers.add(nums[i]);
            dfs(count + 1, i + 1, nums);
            numbers.remove(nums[i]);
        }
    }
}
```
-> 시간 초과

## 새로운 풀이
- N / 2 만큼의 폰켓몬을 고를 수 있으므로 우선 nums를 hashSet에 넣어서 종류의 개수 확인
- N / 2보다 작다면 그 수만큼, N / 2보다 크다면 N / 2개 만큼 고를 수 있음
