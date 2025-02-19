import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("code", 0);
        hm.put("date", 1);
        hm.put("maximum", 2);
        hm.put("remain", 3);
        
        List<int[]> list = new ArrayList<>();
        int e = hm.get(ext);
        for(int i = 0; i < data.length; i++) {
            if(data[i][e] < val_ext) {
                int[] temp = {data[i][0], data[i][1], data[i][2], data[i][3]};
                list.add(temp);
            }
        }
        System.out.println(list);
        int idx = hm.get(sort_by);
        Collections.sort(list, (o1, o2) -> {
            return o1[idx] - o2[idx];
        });
        int[][] answer = new int[list.size()][4];
        for(int i = 0; i < answer.length; i++) {
            int[] arr = list.get(i);
            for(int j = 0; j < 4; j++) {
                answer[i][j] = arr[j];
            }
        }
        return answer;
    }
}
