## 문제
- 모든 달은 28일까지 있다고 가정
- 유효기간이 지났을 경우 result에 추가
- 파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어진다.

## 풀이
- 약관 종류(HashMap)에 따라 일자만큼 더해서 파기날짜 계산
- 파기 날짜는 월 + 유효기간, 일 - 1, 1일인 경우 28일로 변경 및 월 - 1, 월이 12보다 큰 경우 월 - 12, 연도 + 1
- 날짜는 split으로 나누기
---
- 날짜 계산을 모두 일로 바꿔서 하기
-> 성공
## 에러
- `.` 앞에 `\\` 사용해야됨
