class Solution {
    static int answer;
    static boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;
        visit = new boolean[dungeons.length];
        count(dungeons, 0, k);
        return answer;
    }
    
    public void count(int[][] dungeons, int count, int k) {
        answer = Math.max(answer, count);
        for(int i = 0; i < dungeons.length; i++) {
            if(visit[i] || dungeons[i][0] > k) {
                continue;
            }
            visit[i] = true;
            count(dungeons, count + 1, k - dungeons[i][1]);
            visit[i] = false;
        }
    }
}
