class Solution {
    public int solution(int n, int[] stations, int w) {
        int start = 0;
        int end = 0;
        int count = 0;
        int answer = 0;
        
        for(int i = 0; i < stations.length; i++) {
            if(i == 0) {
                if(stations[i] == 1) {
                    start = w + 2;
                } else {
                    start = 1;
                }
            }
            end = stations[i] - w - 1;
            if(start > end) {
                start = stations[i] + w + 1;
                continue;
            }
            count = end - start + 1;
            if(count % (w * 2 + 1) == 0) {
                answer += count / (w * 2 + 1);
            } else {
                answer += count / (w * 2 + 1) + 1;
            }
            start = stations[i] + w + 1;
        }
        if(start <= n) {
            if((n - start + 1) % (w * 2 + 1) == 0) {
                answer += (n - start + 1) / (w * 2 + 1);
            } else {
                answer += (n - start + 1) / (w * 2 + 1) + 1;
            }
        }
        return answer;
    }
}
