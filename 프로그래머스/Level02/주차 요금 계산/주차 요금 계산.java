import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> cars = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        StringTokenizer st;
        for(int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String number = st.nextToken();
            String record = st.nextToken();
            int hour = Integer.parseInt(time.substring(0, 2));
            int min = Integer.parseInt(time.substring(3, 5));
            int totalMin = hour * 60 + min;
            if(record.equals("IN")) {
                cars.put(number, totalMin);
                continue;
            }
            if(record.equals("OUT")) {
                int in = cars.get(number);
                cars.remove(number);
                totalMin -= in;
                totalTime.put(number, totalTime.getOrDefault(number, 0) + totalMin);   
            }
        }
        int maxTime = 23 * 60 + 59;
        for(String key : cars.keySet()) {
            int in = cars.get(key);
            int totalMin = maxTime - in;
            totalTime.put(key, totalTime.getOrDefault(key, 0) + totalMin);
            
        }
        ArrayList<String> keySet = new ArrayList<>(totalTime.keySet());
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
  
        for(int i = 0; i < answer.length; i++) {
            int totalMin = totalTime.get(keySet.get(i));
            if(totalMin <= fees[0]) {
                answer[i] = fees[1];
                continue;
            }
            answer[i] += fees[1];
            totalMin -= fees[0];
            if(totalMin % fees[2] != 0) {
                answer[i] += fees[3];
            }
            answer[i] += (totalMin / fees[2]) * fees[3];
        }
        return answer;
    }
}
