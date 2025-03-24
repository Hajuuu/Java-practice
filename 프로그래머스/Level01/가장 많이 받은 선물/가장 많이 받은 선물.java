import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            hm.put(friends[i], i);
        }
        
        int[][] giftList = new int[friends.length][friends.length];
        int[][] giftScore = new int[friends.length][3];
        int[] nextGift = new int[friends.length];
        boolean[][] visit = new boolean[friends.length][friends.length];
        for(int i = 0; i < gifts.length; i++) {
            String[] names = gifts[i].split(" ");
            int a = hm.get(names[0]);
            int b = hm.get(names[1]);
            giftList[a][b]++;
            giftScore[a][0]++;
            giftScore[b][1]++;
            giftScore[a][2] = giftScore[a][0] - giftScore[a][1];
            giftScore[b][2] = giftScore[b][0] - giftScore[b][1];
        }
        
        
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                if(i == j || visit[i][j]) {
                    continue;
                }
                
                visit[i][j] = true;
                visit[j][i] = true;
                if(giftList[i][j] < 1 && giftList[j][i] < 1) {
                    if(giftScore[i][2] > giftScore[j][2]) {
                        nextGift[i]++;
                    } else if(giftScore[i][2] < giftScore[j][2]) {
                        nextGift[j]++;
                    }
                    continue;
                }
                if(giftList[i][j] > giftList[j][i]) {
                    nextGift[i]++;
                } else if(giftList[i][j] < giftList[j][i]) {
                    nextGift[j]++;
                } else {
                    if(giftScore[i][2] > giftScore[j][2]) {
                        nextGift[i]++;
                    } else if(giftScore[i][2] < giftScore[j][2]) {
                        nextGift[j]++;
                    }
                }
                
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for(int i : nextGift) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
}
