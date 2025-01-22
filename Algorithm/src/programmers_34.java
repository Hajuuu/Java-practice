class Solution {
    public int solution(int number, int limit, int power) {
        int result = 0;
        for(int i = 1; i <= number; i++) {
            int num = gcd(i);
            if(num <= limit) {
                result += num;
                continue;
            }
            result += power;
        }
        return result;
    }
    
    public static int gcd(int num) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                count++;
                if(num / i != i) {
                    count++;
                }
            }
        }
        return count;
    }
}
