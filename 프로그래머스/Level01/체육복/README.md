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


# 복습
## 문제
- 학생들의 번호는 체격 순이기 떄문에 바로 앞번호나 뒷번호의 학생에게만 체육복을 빌려줄 수 있음
- 체육수업을 들을 수 있는 학생의 최댓값을 리턴

## 풀이
- 여벌 체육복을 가진 학생중에 도난 당한 학생 제외
- lost - 1이 reserve에 있는지 체크 -> answer 증가시키고 reserve 리스트에서 삭제
- lost + 1이 reserve에 있는지 체크 -> answer 증가시키고 reserve 리스트에서 삭제
- answer는 n - lost 리스트 사이즈로 시작 (안빌려도 되는 사람 + 빌릴 수 있는 사람 하나씩 증가시키기)
- lost - 1, lost + 1 이 순서대로 탐색하기 때문에 lost 리스트를 무조건 오름차순 정렬해야됨
