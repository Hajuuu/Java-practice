## 문제
- 12세 이하인 여자환자의 PT_NAME, PT_NO, GEND_CD, AGE, TLNO 조회
- 전화번호가 없는 경우 'NONE' 출력
- 나이를 기준으로 내림차순 정렬, 나이가 같다면 환자이름 기준으로 오름차순 정렬

## 풀이
- NULL 처리 : IFNULL(column_name, "대체값")
