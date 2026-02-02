import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int length = citations.length;
        int start = -1;
        int end = length;
        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(citations[mid] >= length - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return length - end;
    }
}
