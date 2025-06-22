import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) {
            return sticker[0];
        }
        int[] select1 = new int[sticker.length];
        int[] select2 = new int[sticker.length];
        select1[0] = sticker[0];
        select1[1] = sticker[0];
        select2[1] = sticker[1];
        for(int i = 2; i < sticker.length - 1; i++) {
            select1[i] = Math.max(select1[i - 1], select1[i - 2] + sticker[i]);
        }
        
        for(int i = 2; i < sticker.length; i++) {
            select2[i] = Math.max(select2[i - 1], select2[i - 2] + sticker[i]);
        }
        
        return Math.max(select1[sticker.length - 2], select2[sticker.length - 1]);
    }

}
