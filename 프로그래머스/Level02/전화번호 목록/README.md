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
