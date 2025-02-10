## 문제
- 완주하지 못한 선수의 이름을 return
- 참여한 선수의 수는 1명 이상, 100,000명 이하
- 이름은 1~20개의 알파벳 소문자
- 동명이인이 있을 수 있다.

## 풀이
- Stream API를 이용한 풀이
- List로 변환해서 풀이 -> 시간 초과
- 둘 다 정렬해서 값이 같지 않을 경우 리턴 -> 성공했지만 해시맵으로 풀이하는게 시간복잡도가 낮다
```java
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }
}
```
- 해시맵으로 풀이
