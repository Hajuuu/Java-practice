## 문제
- 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상
- 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index

## 풀이
- 오름차순으로 정렬
- h이상이 h개 있으려면 length - i >= citations[i]여야됨
- 이분탐색으로 찾기

## 헷갈렸던점
- H-index는 무조건 배열에 있는 숫자일 필요가 없음

+ O(N) 풀이(정렬X)
```java
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int c : citations) {
            if (c >= n) count[n]++;
            else count[c]++;
        }

        int papers = 0;
        for (int h = n; h >= 0; h--) {
            papers += count[h];
            if (papers >= h) {
                return h;
            }
        }
        return 0;
    }
}

```
