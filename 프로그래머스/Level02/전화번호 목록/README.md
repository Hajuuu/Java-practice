## 문제
- 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false 리턴
- 그렇지 않다면 true 리턴

## 풀이
- 각 배열을 정렬
- for문 이용해서 현재 index의 번호가 다른 번호의 접두어인지 확인 
- startsWith()이용해서 확인
--> 틀림(시간초과)
```java
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
            
        }
        return true;
    }
}
```
### 최종 풀이
- set에 전화번호를 모두 저장해둔다
- for문으로 돌면서 phone_book의 번호를 0번부터 모으면서 저장해둔 전화번호에 일치하는게 있는지 확인
- 이때 현재 번호는 set에서 지워야한다
- 이후 만약 일치하는게 있다면 false를 리턴, 없다면 번호를 다시 set에 넣는다
