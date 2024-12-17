import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int a = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = a;
            }
        }
        Arrays.sort(sizes, (o1,o2) -> {
            return o2[0] - o1[0];
        });
        int w = sizes[0][0];
        Arrays.sort(sizes, (o1,o2) -> {
            return o2[1] - o1[1];
        });
        int h = sizes[0][1];
        return w * h;
    }
}
