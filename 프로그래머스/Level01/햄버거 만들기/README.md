## 문제
- ingredient에 1, 2, 3, 1 순서대로 쌓이면 햄버거를 포장할 수 있음
- 만들 수 있는 햄버거의 개수 구하기

## 풀이
- 문자열로 합쳐서 '1231'이 있을 경우 count 추가하고 문장에서 지우기
-> 시간 초과

- ingredient를 리스트로 바꾸고 앞에서부터 돌면서 1231 나오면 지우고 다시 처음부터 확인
-> 시간초과

- burger 리스트에 하나씩 추가하면서 1231인지 확인하고 지우기
-> 통과

- 전체를 한번에 추가해서 계속 확인하는게 아니라 하나씩 추가하면서 확인하기
