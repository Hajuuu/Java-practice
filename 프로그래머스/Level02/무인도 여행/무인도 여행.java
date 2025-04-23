import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] map;
    static int X;
    static int Y;
    static int sum = 0;
    public int[] solution(String[] maps) {
        X = maps.length;
        Y = maps[0].length();
        map = new int[X][Y];
        visited = new boolean[X][Y];
        for(int i = 0; i < X; i++) {
            String str = maps[i];
            for(int j = 0; j < Y; j++) {
                if(str.charAt(j) == 'X') {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = str.charAt(j) - '0';
            }
        }
        ArrayList<Integer> count = new ArrayList<>();
        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++) {
                if(visited[i][j] || map[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                sum = map[i][j];
                dfs(i, j);
                if(sum > 0) {
                    count.add(sum);
                }
            }
        }
        if(count.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        Collections.sort(count);
        
        int[] answer = new int[count.size()];
        for(int i = 0; i < count.size(); i++) {
            answer[i] = count.get(i);
        }
        
        return answer;
        
    }
    
    public void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(nowX >= 0 && nowX < X && nowY >= 0 && nowY < Y) {
                if(!visited[nowX][nowY] && map[nowX][nowY] > 0) {
                    visited[nowX][nowY] = true;
                    sum += map[nowX][nowY];                   
                    dfs(nowX, nowY);
                }
            }
        }
    }
}
