import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];
        int count = 0;
        int nowX = 5;
        int nowY = 5;
        int d = 0;
        for(int i = 0; i < dirs.length(); i++) {
            if(dirs.charAt(i) == 'U') {
                d = 0;
            }
            if(dirs.charAt(i) == 'R') {
                d = 1;
            }
            if(dirs.charAt(i) == 'D') {
                d = 2;
            }            
            if(dirs.charAt(i) == 'L') {
                d = 3;
            }  
    
            int nextX = nowX + dx[d];
            int nextY = nowY + dy[d];
            if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10) {
                continue;
            }
            if(!visited[nextX][nextY][d]) {
                visited[nextX][nextY][d] = true;
                visited[nowX][nowY][(d + 2) % 4] = true;
                count++;
            }
            nowX = nextX;
            nowY = nextY;
        }
        return count;
    }
    
}
