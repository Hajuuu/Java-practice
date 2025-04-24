class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int N, M;
    static int[][] map;
    public int numIslands(char[][] grid) {
        N = grid.length;
        M = grid[0].length;
        map = new int[N][M];
        visited = new boolean[N][M];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j]= grid[i][j] - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] || map[i][j] == 0) {
                    continue;
                }
                dfs(i, j);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(nowX >= 0 && nowX < N && nowY >= 0 && nowY < M) {
                if(visited[nowX][nowY] || map[nowX][nowY] == 0) {
                    continue;
                }
                dfs(nowX, nowY);
            }
        }
    }
}
