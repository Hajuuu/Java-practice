class Solution {
    public int[] solution(String[] wallpaper) {
        int[] s = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] e = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] answer = new int[4];
        for(int i = 0; i < wallpaper.length; i++) {
            if(!wallpaper[i].contains("#")) {
                continue;
            }
            if(i < s[0]) {
                s[0] = i;
            }
            if(i > e[0]) {
                e[0] = i;
            }
            if(wallpaper[i].indexOf("#") < s[1]) {
                s[1] = wallpaper[i].indexOf("#");
            }
            if(wallpaper[i].lastIndexOf("#") > e[1]) {
                e[1] = wallpaper[i].lastIndexOf("#");
            }
        }
        answer[0] = s[0];
        answer[1] = s[1];
        answer[2] = e[0] + 1;
        answer[3] = e[1] + 1;
        
        return answer;
    }
}
