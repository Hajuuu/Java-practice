## 문제
- 매일 다른 옷을 조합하여 입어야 한다
- 각 종류별로 최대 1가지 의상만 착용 가능
- 한개라도 겹치지 않거나 하나가 더 추가된 경우에는 서로 다른 방법으로 착용한 것으로 계산됨
- clothes로 만들 수 있는 서로 다른 옷의 조합 수를 구해야함
- clothes는 [의상의 이름, 의상의 종류]로 이루어져있음


## 풀이
- HashMap 이용해서 의상 종류별 개수 구하기
- 각 map의 value값 크기를 곱한거에 1 빼기 (한개는 입어야 하므로)
- Map의 key는 String, value는 Set으로 설정


```java
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> cloth = new HashMap<>();
        for(String[] row : clothes) {
            Set<String> c = cloth.getOrDefault(row[1], new HashSet<>());
            c.add(row[0]);
            cloth.put(row[1], c);   
        }
        
        int answer = 1;
        for(String key : cloth.keySet()) {
            Set<String> c = cloth.get(key);
            answer *= c.size() + 1;
        }
        return answer - 1;
    }
}
```

## 다른 풀이
옷의 이름을 알아야 풀 수 있는 문제가 아니고 같은 이름을 가진 의상이 없기 때문에 value를 Integer로 해도됨
