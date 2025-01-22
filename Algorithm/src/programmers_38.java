class Solution {
    static int[] num;
    public int solution(int n) {
        num = new int[n + 1];
        prime(n);
        
        int result = 0;
        for(int i = 2; i <= n; i++) {
            if(num[i] == 0) {
                result++;
            }
        }
        return result;
    }
    
    public static void prime(int n) {
        num[0] = 1;
        num[1] = 1;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(num[i] == 1) {
                continue;
            }
            for(int j = i * i; j < num.length; j += i) {
                num[j] = 1;
            }
        }
    }
}
