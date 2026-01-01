## 문제
- N마리 중에 N/2 가져갈 수 있음
- 가질 수 있는 폰켓몬의 종류가 가장 많을때의 폰켓몬 개수를 리턴

## 풀이
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
