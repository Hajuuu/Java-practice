## 문제
- 이중 우선순위 큐
- I 숫자 : 큐에 주어진 숫자를 삽입
- D 1 : 큐에서 최댓값을 삭제
- D -1 : 큐에서 최솟값을 삭제
- 모든 연산을 처리한 후 큐가 비어있으면 [0,0], 비어있지 않으면 [최댓값,최솟값] 리턴
- 최댓값, 최솟값이 두 개 이상이라면 하나만 삭제
- 데이터 삭제 연산 시 큐가 비었다면 무시

## 풀이
- PriorityQueue 두개 사용해서 큐에 하나씩 숫자 넣기
- 최댓값 큐에서 최댓값을 빼면 최솟값 queue에서 뺀 숫자를 지워주고 반대는 반대로 지워준다.
- 최댓값 큐와 최솟값 큐가 비어있지 않다면 answer에 최댓값 및 최솟값 저장
