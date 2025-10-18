import java.util.*;
class Solution {
    static Map<String, String> parentMap;
    static Map<String, Integer> profitMap;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parentMap = new HashMap<>();
        profitMap = new HashMap<>();
        
        for(int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }
        
        for(int i = 0; i < seller.length; i++) {
            distributeProfit(seller[i], amount[i] * 100);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }
        return answer;
    }
    
    public void distributeProfit(String seller, int profit) {
        int toParent = profit / 10;
        int selfProfit = profit - toParent;
        
        profitMap.put(seller, profitMap.get(seller) + selfProfit);
        
        String parent = parentMap.get(seller);
        
        if(!parent.equals("-") && toParent > 0) {
            distributeProfit(parent, toParent);
        }
    }
}
