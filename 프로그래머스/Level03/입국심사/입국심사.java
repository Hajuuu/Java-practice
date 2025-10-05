import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long answer = 0;
        long right = times[times.length - 1] * (long) n;
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = countPeople(times, mid);
            if(count < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
    
    public long countPeople(int[] times, long time) {
        long count = 0;
        for(int i = 0; i < times.length; i++) {
            count += time / times[i];
        }
        return count;
    }
}
