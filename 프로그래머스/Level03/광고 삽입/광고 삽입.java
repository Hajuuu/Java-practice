class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = stringToTime(play_time);
        int advTime = stringToTime(adv_time);
        long[] totalTime = new long[playTime + 1];
        for(String log : logs) {
            String[] l = log.split("-");
            int start = stringToTime(l[0]);
            int end = stringToTime(l[1]);
            totalTime[start] += 1;
            totalTime[end] -= 1;
        }
        
        for(int i = 1; i <= playTime; i++) {
            totalTime[i] += totalTime[i - 1];
        }
        
        for(int i = 1; i <= playTime; i++) {
            totalTime[i] += totalTime[i - 1];
        }
        
        long maxView = totalTime[advTime - 1];
        int maxStart = 0;
        for(int i = advTime; i <= playTime; i++) {
            long currentView = totalTime[i] - totalTime[i - advTime];
            if(currentView > maxView) {
                maxView = currentView;
                maxStart = i - advTime + 1;
            }
        }
        
        return timeToString(maxStart);
    }
    
    public int stringToTime(String input) {
        int time = 0;
        String[] t = input.split(":");
        time += Integer.parseInt(t[0]) * 60 * 60
            + Integer.parseInt(t[1]) * 60 
            + Integer.parseInt(t[2]);
        return time;
    }
    
    public String timeToString(int input) {
        int h = input / 3600;
        input %= 3600;
        int m = input / 60;
        int s = input % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
