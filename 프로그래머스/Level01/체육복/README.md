## 문제
- 전체 학생의 수 n
- 체육복을 도난당한 학생들의 번호 lost
- 여벌의 체육복을 가져온 학생들 reserve
- 여벌 체육복을 가져온 학생이 도난을 당할 수 있음

## 풀이
- answer = n - lost로 초기화
- lost랑 reserve로 더해서 여분 있는 학생 배열 만들기
- lost 값의 앞과 뒤 학생이 students에 존재하는지 확인하고 존재하면 answer에 플러스
-> 실패

- students 배열 전체를 돌면서 0보다 크거나 같은 경우는 answer에 더하고 아닐 경우 앞뒤 확인하는 식으로 구함
-> 런타임 에러

- lost와 reserve를 list로 바꿔서 lost배열과 겹친다면 각각 list에서 지우기

## 에러
- losts와 reserves를 정렬해야됨
- lost 배열을 돌면서 losts와 reserves에 중복인 요소를 지워야 하는데 losts를 돌면서 지우려고 해서 `ConcurrentModificationException` 발생
- remove시 인덱스값으로 찾는데 값으로 찾으려고 해서 에러 발생, `new Integer()`로 해결
