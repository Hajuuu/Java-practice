import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length - 1;
        int answer = 0;
        Arrays.sort(people);
        while(start <= end) {
            int sum = people[start] + people[end];
            if(sum <= limit) {
                start++;
                sum += people[start];
            }
            answer++;
            end--;
        }
        
        return answer;
    }
}
