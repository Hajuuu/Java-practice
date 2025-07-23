import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            if(left % speeds[i] != 0) {
                day[i] = left / speeds[i] + 1;
                continue;
            
                }
            day[i] = left / speeds[i];

        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = day[0];
        int count = 1;
        for(int i = 1; i < day.length; i++) {        
            if(day[i] > max) {
                max = day[i];
                list.add(count);
                count = 1;
                continue;
            }
            count++;
            
        }

        list.add(count);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
