import java.util.*;
class Solution {
    static List<Set<Integer>> dp;
    public int solution(int N, int number) {
        dp = new ArrayList<>();
        if(N == number) {
            return 1;
        }
        
        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        for(int i = 2; i <= 8; i++) {
            for(int j = 1; j <= i / 2; j++) {
                operation(i, j, i - j);
                operation(i, i - j, j);
            }
            
            String strNum = String.valueOf(N);
            dp.get(i).add(Integer.parseInt(strNum.repeat(i)));
            
            for(int num : dp.get(i)) {
                if(num == number) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static void operation(int now, int a, int b) {
        for(int i : dp.get(a)) {
            for(int j : dp.get(b)) {
                dp.get(now).add(i + j);
                dp.get(now).add(i - j);
                dp.get(now).add(i * j);
                if(j != 0) {
                    dp.get(now).add(i / j);
                }
            }
        }
    }
}
