class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = attacks[0][0];
        int nowHp = health;
        for(int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int demage = attacks[i][1];
            if(i > 0) {
                time = attackTime - attacks[i - 1][0];
            }
            if(time - 1 == bandage[0]) {
                nowHp = Math.min(health, nowHp + bandage[2]);
            }
            if(time - 1 > bandage[0]) {
                int plusHealth = bandage[2] * ((time - 1) / bandage[0]);
                nowHp = Math.min(health, nowHp + plusHealth);    
            }
            nowHp = Math.min(health, nowHp + (time - 1) * bandage[1]);
            nowHp -= demage;
            if(nowHp <= 0) {
                return -1;
            }
        }
        
        return nowHp;
    }

}
