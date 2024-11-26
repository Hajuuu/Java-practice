import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1) {
            arr[0] = -1;
            return arr;
        }
        int[] answer = new int[arr.length - 1];
        int[] sortArr = arr.clone();
        Arrays.sort(sortArr);
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sortArr[0] == arr[i]) {
                continue;
            }
            answer[index] = arr[i];
            index++;
        }
        return answer;
    } 
}
