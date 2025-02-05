import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> game = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(dartResult, "[SDT#*]", true);
        while(st.hasMoreTokens()) {
            String now = st.nextToken();
            if(now.equals("S")) {
                continue;
            }
            if(now.equals("D")) {
                game.set(game.size() - 1, game.get(game.size() - 1) * game.get(game.size() - 1));
                continue;
            }
            if(now.equals("T")) {
                game.set(game.size() - 1, game.get(game.size() - 1) * game.get(game.size() - 1) * game.get(game.size() - 1));
                continue;
            }
            if(now.equals("*")) {
                game.set(game.size() - 1, game.get(game.size() - 1) * 2);
                if(game.size() > 1) {
                    game.set(game.size() - 2, game.get(game.size() - 2) * 2);
                }
                continue;
            }
            if(now.equals("#")) {
                game.set(game.size() - 1, game.get(game.size() - 1) * -1);
                continue;
            }
            game.add(Integer.parseInt(now));
        }
        for(int i = 0; i < game.size(); i++) {
            answer += game.get(i);
        }
        return answer;
    }
}
