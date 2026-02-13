## 문제
- TOTAL_ORDER가 3000보다 높으면서 INGREDIENT_TYPE이 fruit_based인 아이스크림의 FLAVOR를 총주문량이 큰 순서대로 조회

## 풀이
**조인**
```sql
SELECT <열 목록>
FROM <첫 번째 테이블>
  INNER JOIN <두 번째 테이블>
  ON <조인 조건>
WHERE 검색 조건
```

