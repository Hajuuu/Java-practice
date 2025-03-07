class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean check = true;
        for(int i = 0; i < schedules.length; i++) {
            check = true;
            schedules[i] += 10;
            if(schedules[i] % 100 > 59) {
                int min = (schedules[i] % 100) % 60;
                schedules[i] = (schedules[i] / 100 + 1) * 100 + min;
            }
            for(int j = 0; j < 7; j++) {
                if((startday + j) % 7 == 0 || (startday + j) % 7 == 6) {
                    continue;
                }
                if(schedules[i] < timelogs[i][j]) {
                    check = false;
                    break;
                }
            }
            if(check) {
                answer++;
            }
        }
        return answer;
    }
}
