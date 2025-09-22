import java.util.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        int[] extended = new int[len * 2];
        
        for (int i = 0; i < len * 2; i++) {
            if (i < len) extended[i] = weak[i];
            else extended[i] = weak[i - len] + n;
        }

        int answer = dist.length + 1; 

        List<int[]> permutations = new ArrayList<>();
        permute(dist, 0, permutations);

        for (int start = 0; start < len; start++) {
            for (int[] order : permutations) {
                int cnt = 1; // how many friends used
                int pos = extended[start] + order[cnt - 1]; // first friend’s coverage

                for (int idx = start; idx < start + len; idx++) {
                    if (extended[idx] > pos) { // cannot cover this weak point
                        cnt++;
                        if (cnt > order.length) break;
                        pos = extended[idx] + order[cnt - 1];
                    }
                }
                answer = Math.min(answer, cnt);
            }
        }

        return answer > dist.length ? -1 : answer;
    }

    void permute(int[] arr, int depth, List<int[]> result) {
        if (depth == arr.length) {
            result.add(arr.clone());
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, i, depth);
            permute(arr, depth + 1, result);
            swap(arr, i, depth);
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
