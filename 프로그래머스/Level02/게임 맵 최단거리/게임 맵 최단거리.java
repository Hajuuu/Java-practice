import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] distance;
    public int solution(int[][] maps) {
        distance = new int[maps.length][maps[0].length];
        
        bfs(maps, 0, 0);
        if(distance[maps.length - 1][maps[0].length - 1] == 0) {
            return -1;
        }
        return distance[maps.length - 1][maps[0].length - 1];
    }
    
    public void bfs(int[][] maps, int startX, int startY) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startX, startY});
        distance[startX][startY] = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nowX = cur[0] + dx[i];
                int nowY = cur[1] + dy[i];
                if(nowX < 0 || nowX >= maps.length || nowY < 0 || nowY >= maps[0].length) {
                    continue;
                }
                if(maps[nowX][nowY] == 1 && distance[nowX][nowY] == 0) {
                    distance[nowX][nowY] = distance[cur[0]][cur[1]] + 1;
                    queue.offer(new int[] {nowX, nowY});
                }
            }
        }
    }
}
