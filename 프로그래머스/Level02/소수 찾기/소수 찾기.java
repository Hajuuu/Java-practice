import java.util.*;
class Solution {
    static boolean[] visit;
    static Set<Integer> nums;
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean[numbers.length()];
        nums = new HashSet<>();
        for(int i = 1; i <= numbers.length(); i++) {
            find(numbers, "", i);
        }
        
        for(int num : nums) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    } 
    
    public void find(String numbers, String now, int depth) {
        if(depth == now.length()) {
            nums.add(Integer.parseInt(now));
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            find(numbers, now + numbers.charAt(i), depth);
            visit[i] = false;
        }
    }
    public boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
