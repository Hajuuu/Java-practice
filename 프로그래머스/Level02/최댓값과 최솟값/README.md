## 문제
- s의 최댓값과 최솟값을 찾는 문제

## 풀이
- for문을 통해 List에 넣고 정렬

## 에러
- 정렬했을 때 전체가 -인 경우 반대로 정렬됨
- Math.max와 Math.min으로 해결

```java
import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<Integer> nums = new ArrayList<>();
        while(st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        String answer = "";
        answer += Math.min(nums.get(0), nums.get(nums.size() - 1));
        answer += " ";
        answer += Math.max(nums.get(0), nums.get(nums.size() - 1));
        return answer;
    }
}
```

-> 첫번째 풀이

```java
import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return min + " " + max;
    }
}
```
-> List를 쓰지 않고 풀이
