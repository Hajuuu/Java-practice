import java.util.*;
class Solution {
    static Set<Integer> set;
    static int[] num;
    public int[] solution(int[] numbers) {
        num = numbers;
        set = new HashSet<>();
        dfs(0, 0, 0);
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
    
    public static void dfs(int depth, int start, int sum) {
        if(depth == 2) {
            set.add(sum);
            return;
        }
        for(int i = start; i < num.length; i++) {
            dfs(depth + 1, i + 1, sum + num[i]);
        }
    }
}
