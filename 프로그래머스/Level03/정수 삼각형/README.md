## 문제
- 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중 거쳐간 숫자의 합이 가장 큰 경우를 찾는 문제
- 아래 칸으로 이동할 때는 대각선 방향으로만 이동 가능하다.

## 풀이
- dp문제
- dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
- j가 0이면 dp[i][j] = dp[i - 1][j] + triangle[i][j];
- j가 triangle[i].length - 1라면 dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
