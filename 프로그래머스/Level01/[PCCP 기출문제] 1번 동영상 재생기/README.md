## 문제
- prev : 10초 전으로 이동, 현재 위치가 10초 미만이면 0분 0초로 이동
- next : 10초 후로 이동, 남은 시간이 10초 미만인 경우 마지막 위치로 이동
- op_start <= 현재 재생 위치 <= op_end인 경우 자동으로 오프닝이 끝나는 위치로 이동
- 동영상의 위치 "mm:ss" 형식으로 리턴

## 풀이
- pos가 오프닝에 해당하는지 확인
- commands 길이만큼 for문으로 확인 
- if문으로 commands 처리
- pos가 오프닝 구간에 위치하는지 확인하고 오프닝 구간에 해당하면 건너뛰기

## 에러
- 시간 계산은 정확히...
- 시간 계산하는 부분 함수 하나로 빼기
