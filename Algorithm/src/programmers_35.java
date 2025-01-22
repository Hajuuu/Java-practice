class Solution {
    public String solution(int a, int b) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int count = 0;
        for(int i = 1; i < a; i++) {
            count += month[i];
        }
        count += b;
        return day[count % 7];
    }
}
