class Solution {
    public String solution(int[] food) {
        String str = "";
        for(int i = 1; i < food.length; i++) {
            str += String.valueOf(i).repeat(food[i] / 2);
        }
        StringBuffer sb = new StringBuffer(str);
        str += '0';
        str += sb.reverse().toString();
        return str;
    }
}
