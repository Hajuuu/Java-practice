import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                numbers.add(arr[i]);
            }
        }
        Collections.sort(numbers);
        if(numbers.size() == 0) {
            numbers.add(-1);
            return numbers.stream().mapToInt(Integer::intValue).toArray();
        }
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
