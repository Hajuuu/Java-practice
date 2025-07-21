import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1, 0, 2, 0, -2};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1, 2, 0, -2, 0};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            boolean check = true;
            for(int j = 0; j < places[i].length; j++) {
                for(int p = 0; p < places[i][j].length(); p++) {
                    if(places[i][j].charAt(p) == 'P') {
                        check = find(j, p, places[i]);
                        if(!check) {
                            break;
                        }
                    }
                }
                if(!check) {
                    break;
                }
            }
            if(check) {
                answer[i] = 1;
                continue;
            }
            answer[i] = 0;
        }
        return answer;
    }
    
    public boolean find(int startX, int startY, String[] place) {
        for(int i = 0; i < 4; i++) {
            int nowX = startX + dx[i];
            int nowY = startY + dy[i];
            if(nowX >= 0 && nowX < place.length && nowY >= 0 && nowY < place[0].length()) {
                if(place[nowX].charAt(nowY) == 'P') {
                    return false;
                }
            }
        }
        for(int i = 4; i < 8; i++) {
            int nowX = startX + dx[i];
            int nowY = startY + dy[i];
            
            if(nowX >= 0 && nowX < place.length && nowY >= 0 && nowY < place[0].length()) {
                if(place[nowX].charAt(nowY) == 'P' && (place[nowX].charAt(startY) == 'O' || place[startX].charAt(nowY) == 'O')) {
                    return false;
                }
            }
        }
        for(int i = 8; i < 12; i++) {
            int nowX = startX + dx[i];
            int nowY = startY + dy[i];
            if(nowX >= 0 && nowX < place.length && nowY >= 0 && nowY < place[0].length()) {
                if(place[nowX].charAt(nowY) == 'P' && place[startX + dx[i] / 2].charAt(startY + dy[i] / 2) != 'X') {
                    return false;
                }
            }
        }
        return true;
    }
}
