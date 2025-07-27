import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {

        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int x = 0;
        int y = 0;
        int diff = Integer.MAX_VALUE;
        while(end < sequence.length) {
            if(sum == k) {
                if(end - start < diff) {
                    x = start;
                    y = end;
                    diff = end - start;
                }
                sum -= sequence[start++];
            } else if(sum > k) {
                sum -= sequence[start++];
            } else {
                if(++end < sequence.length) {
                    sum += sequence[end];
                }
                
            }
        }
        return new int[] {x, y};
    }
}
