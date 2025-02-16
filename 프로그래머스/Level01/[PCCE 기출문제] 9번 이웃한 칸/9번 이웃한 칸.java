class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            if(h + dx[i] < 0 || h + dx[i] >= board.length || w + dy[i] < 0 || w + dy[i] >= board.length) {
                continue;
            }
            if(board[h + dx[i]][w + dy[i]].equals(board[h][w])) {
                answer++;
            }
        }
        return answer;
    }
}
