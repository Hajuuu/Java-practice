## 문제
- [i, j, k] 배열이 담긴 commands가 주어짐
- i번째부터 j번째 숫자까지 자르고 정렬했을 때 k번째에 있는 수를 배열에 담아 리턴

## 풀이
- i부터 j까지 Arrays.copyOfRange 이용해서 자르고 정렬
- i - 1 ~ j까지 자르기
- k - 1번째 copy 배열 가져와서 answer에 저장
