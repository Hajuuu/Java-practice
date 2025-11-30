class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] score = new int[n + 1][n + 1];
        for(int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            
            score[a][b] = 1;
            score[b][a] = -1;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(score[i][k] == 1 && score[k][j] == 1) {
                        score[i][j] = 1;
                        score[j][i] = -1;
                    }
                    else if(score[i][k] == -1 && score[k][j] == -1) {
                        score[i][j] = -1;
                        score[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(score[i][j] != 0) {
                    count++;
                }
            }
            if(count >= n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}
