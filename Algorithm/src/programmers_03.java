class Solution {
    public int solution(int[] numbers) {
        boolean[] check = new boolean[10];
        for(int i = 0; i < numbers.length; i++) {
            check[numbers[i]] = true;
        }
        
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            if(!check[i]) {
                sum += i;
            }
        }
        return sum;
    }
}
