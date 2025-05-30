## 문제
- 집은 (1,1), 학교는 (m, n)일 때 오른쪽과 아래쪽으로만 움직여 학교까지 갈 수 있는 최단경로
- 최단경로의 개수를 1,000,000,007로 나눈 나머지를 리턴

## 풀이
- 최단경로를 1,000,000,007로 나눈 나머지 ? -> 최단경로의 개수가 매우 많다는 의미 -> dp 활용
- 물 웅덩이의 dp[x][y]는 -1로 지정
- dp로 카운트해도 되는 이유 - 오른쪽과 아래쪽으로만 갈 수 있음 -> cycle이 없다.
- `dp[i][j] += dp[i][j - 1] + dp[i - 1][j]`
- dp[i][j - 1]이나 dp[i - 1][j]가 웅덩이인 경우는 제외하기 위해 if문으로 비교 후 더한다.

### dp로 풀 수 있는 이유 추가(gpt)
아주 좋은 질문입니다!
결론부터 말하면:
**오른쪽, 아래뿐 아니라 위와 왼쪽도 이동할 수 있다면 일반적인 DP로는 풀 수 없습니다.**
혹은 **그대로 풀면 올바르지 않거나 무한 루프에 빠질 수 있습니다.**

---

## ✅ 왜 일반 DP로 풀 수 없는가?

**DP의 전제는 "하위 문제를 이용해 상위 문제를 한 방향으로 쌓아간다"는 것**입니다.
그런데 **위, 왼쪽 이동까지 허용**하면 상황이 크게 달라집니다:

### ❌ 1. **순환 경로 (Cycle)가 생길 수 있음**

* 예를 들어 어떤 칸 `(i, j)`에서 `(i, j-1)`로 가고, 다시 `(i, j)`로 돌아올 수 있습니다.
* 이런 식으로 **경로가 순환하면서 무한히 반복**될 수 있습니다.
* 일반적인 DP는 이런 **사이클**을 감지하거나 방지할 수 없습니다.

> DP는 DAG (Directed Acyclic Graph, 방향 비순환 그래프) 구조여야 합니다.
> 위, 왼쪽 이동을 허용하면 **그래프에 사이클이 생겨서 DP의 전제가 깨집니다.**

---

## ✅ 어떻게 해결할 수 있을까?

### 1. **모든 경로를 탐색하는 방식으로 전환해야 함**

* **DFS + 메모이제이션**이나
* **BFS (큐 이용) + 방문 처리** 방식이 적합합니다.
* 경로에 **사이클이 생기지 않도록 방문 처리나 제한을 두는 게 필수**입니다.

### 2. **그래프 탐색 + DP 결합 (Topological Sorting)**

* 만약 맵이 **사이클이 없도록 만들어져 있다면**, 위/왼쪽 이동이 있어도 가능은 합니다.
* 이 경우 위상 정렬(Topological Sort)을 통해 순서를 정하고 DP를 할 수 있지만,
  이건 일반적인 DP보다는 **그래프 알고리즘의 영역**입니다.

---

## ✅ 요약

| 이동 방향               | 일반 DP 가능 여부        | 이유                    |
| ------------------- | ------------------ | --------------------- |
| 오른쪽 + 아래만           | ✅ 가능               | 하위 문제 → 상위 문제로 순방향 진행 |
| + 위, 왼쪽까지           | ❌ 불가능 (기본 DP)      | 사이클 생김 → 무한 루프 가능성 있음 |
| + 위, 왼쪽 (단, 사이클 없음) | ⚠️ 가능 (위상 정렬 등 필요) | DAG 구조면 DP 가능, 복잡도 증가 |

---

필요하다면 **위/왼쪽 이동이 가능한 경우의 해결 예시 코드**도 도와드릴 수 있어요!
