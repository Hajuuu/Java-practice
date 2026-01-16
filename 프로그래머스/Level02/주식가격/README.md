## 문제
- 초 단위로 기록된 주식 가격이 담긴 배열 prices가 매개변수로 주어질 때 가격이 떨어지지 않은 기간을 구한다.

## 풀이
- 스택에 각 주식 가격의 idx(시간), prices를 배열로 넣고, stack.peek()한 가격이 현재 가격보다 낮다면 꺼낸다.
- for문 내부의 while문을 통해 모든 스택의 값을 확인한다.

## 복습
- 주식의 가격이 떨어지지 않은 기간을 구하는 문제
- stack에 {인덱스(들어간 시간), 가격}으로 넣는다.
- 현재 넣으려는 가격이 스택 맨 위 값보다 작다면 스택에서 빼고 answer에 현재 시간 - 들어간 시간, 즉 유지시간 값을 넣는다.
- while문으로 쌓여있던 가격중 현재 가격보다 작은 스택은 다 제거한다.
- 이후 스택에 넣는다.
- 이런식으로 해서 스택이 비어있지 않다면 하나씩 꺼내면서 answer를 채운다.

```java
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty()) {
                int[] prev = stack.peek();
                if(prev[1] > prices[i]) {
                    stack.pop();
                    answer[prev[0]] = i - prev[0];
                    continue;
                }
                break;
            }
            stack.push(new int[] {i, prices[i]});
        }
        
        int totalTime = prices.length - 1;
        while(!stack.isEmpty()) {
            int[] now = stack.pop();
            answer[now[0]] = totalTime - now[0];
        }
        
        return answer;
    }
}
```

근데 가격에 대한 정보는 이미 prices 배열에 있어서 스택에는 시간만 저장해도 됨
