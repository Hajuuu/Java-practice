import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        int answer = 0;
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        long N = sum1 + sum2;
        if(N % 2 != 0) {
            return -1;
        }
        N /= 2;
        while(true) {
            if(sum1 == N || answer > queue1.length * 3) {
                break;
            }
            if(sum1 > N) {
                int n = q1.poll();
                q2.offer(n);
                sum2 += n;
                sum1 -= n;
                answer++;
                continue;
            }
            if(sum1 < N) {
                int n = q2.poll();
                q1.offer(n);
                sum1 += n;
                sum2 -= n;
                answer++;
            }
        }
        if(answer > queue1.length * 3) {
            return -1;
        }
        return answer;
    }
  
}
