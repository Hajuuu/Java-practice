## 문제
- 크기별로 분류했을 때 서로 다른 종류의 수를 최소화
- k : 귤의 개수
- tangerine : 귤의 크기를 담은 배열
- result: 서로 다른 종류의 수의 최솟값

## 풀이
- Map에 귤의 크기와 개수 담기
- 귤의 개수로 정렬하여 k개 만큼 map에서 제거
- key값 바꿀때마다 count증가
- 굳이 0인거 확인 안하고 map.get() 개수만큼 삭제하고 0보다 작으면 break

### 새로 알게된 내용
**Map - value 값을 기준으로 정렬**
List<Integer> keySet = new ArrayList<>(map.keySet());
// 내림차순
keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));
