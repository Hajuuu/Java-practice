import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> term = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] t = terms[i].split(" ");
            term.put(t[0], Integer.parseInt(t[1]));
        }
        String[] nDay = today.split("\\.");
        long now = Integer.parseInt(nDay[0]) * 336 + Integer.parseInt(nDay[1]) * 28 + Integer.parseInt(nDay[2]);
        for(int i = 0; i < privacies.length; i++) {
            String[] date = privacies[i].split("[\\. ]");
            long day = Integer.parseInt(date[0]) * 336 + Integer.parseInt(date[1]) * 28 + Integer.parseInt(date[2]) + term.get(date[3]) * 28;
            if(day <= now) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
