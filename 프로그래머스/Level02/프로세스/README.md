## 문제
- 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 큐에 넣는다.
- 해당 프로세스가 몇 번째로 실행되는지 확인

## 풀이
- 우선순위를 얻기 위해 우선순위큐에 정렬시킴
- priorities와 비교하여 현재 값과 우선순위 큐의 맨 앞 값이 같다면 큐에서 삭제하고 answer더하기
