class Solution {
    public long solution(int price, int money, int count) {
        long[] sum = new long[count + 1];
        sum[1] = price;
        for(int i = 2; i <= count; i++) {
            sum[i] = sum[i - 1] + price * i;
        }
        if(money - sum[count] >= 0) {
            return 0;
        }
        return sum[count] - money;
    }
}
