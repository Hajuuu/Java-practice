## 문제
- 2022년 3월의
- SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT를 출력
- OFFLINE_SALE의 USED_ID는 NULL로 출력
- 판매일 기준 오름차순, 상품 ID 기준 오름차순, 유저 ID 기준 오름차순

## 풀이
- UNION 이용
```sql
SELECT * FROM (테이블 1)
UNION
SELECT * FROM (테이블 2)
```
UNION ALL - 중복 제거하지 않음
NULL AS USER_ID -> OFFLINE_TABLE에 없는 열 NULL로 출력

- UNION에 WHERE 적용하는 방법 -> 서브쿼리 이용
