## 문제
- schedules: n명의 출근 희망 시각
- timelogs: 직원들이 일주일 동안 출근한 시각
- startday: 이벤트를 시작한 요일
- 토, 일 제외

## 풀이
- for문으로 출근시간 비교
- start: startday, end: 6

## 에러
- 출근시간 + 10분까지 지각 아님
- 50~59분인 경우 계산 안함
- 753 -> 803
- 일주일이 시작 날짜부터 출근시간, 이 중에서 주말을 빼고 계산해야한다.
