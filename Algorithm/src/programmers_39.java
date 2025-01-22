import java.util.*;
class Solution {
    static boolean[] prime;
    static int[] num;
    static int answer;
    public int solution(int[] nums) {
        num = nums;
        Arrays.sort(nums);
        prime = new boolean[nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + 1];
        answer = 0;
        makePrime(nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3]);

        add(0, 0, 0);
        return answer;
    }
    
    public static void add(int sum, int a, int count) {
        if(count == 3) {
            if(!prime[sum]) {
                answer++;
            }
            return;
        }
        for(int i = a; i < num.length; i++) {
            add(sum + num[i], i + 1, count + 1);
        }
    }
    public static void makePrime(int n) {
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]) {
                continue;
            }
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
    
    
}
