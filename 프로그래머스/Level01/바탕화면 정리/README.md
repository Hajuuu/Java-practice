## 문제
- 빈칸은 `.`, 파일은 `#`으로 표시
- 점 S(lux, luy), 점 E(rdx, rdy) return

## 풀이
- wallpaper 배열 하나씩 확인하면서 파일 있는지 확인, 없으면 넘어가기
- 가장 위, 가장 아래, 가장 왼쪽, 가장 오른쪽에 있는 파일 위치 찾기
- indexOf(), lastIndexOf()
