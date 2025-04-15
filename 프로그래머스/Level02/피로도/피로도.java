class Solution {
    static int length = 0;
    static int answer = 0;
    static int[][] dun;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        dun = dungeons;
        length = dungeons.length;
        visited = new boolean[length];
        find(k, 0);
        return answer;
    }
    
    public static void find(int k, int count) {
        answer = Math.max(answer, count);
        for(int i = 0; i < length; i++) {
            if(!visited[i] && k >= dun[i][0]) {
                visited[i] = true;
                find(k - dun[i][1], count + 1);
                visited[i] = false;
            }
        }
        
    }
}
