## 문제
- 서울에 위치한 식당들의
- REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, 평균(REVIEW_SCORE)
- REVIEW 평균점수는 소수점 세 번째 자리에서 반올림
- 평균점수를 기준으로 내림차순, 즐겨찾기수를 기준으로 내림차순

## 풀이
- WHERE로 서울 식당만 출력
- GROUP BY REST_ID로 같은 식당끼리 그룹으로 묶고 평균 점수 계산
