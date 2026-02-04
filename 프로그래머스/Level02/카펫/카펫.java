class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 3;
        while(true) {
            int y = (brown - 2 * x + 4) / 2;
            if(2 * x + 2 * y - 4 == brown) {
                if((x - 2) * (y - 2) == yellow) {
                    break;
                }
            }
            x++;
        }
        
        int a = x;
        int b = (brown - 2 * x + 4) / 2;
        return new int[] {Math.max(a, b), Math.min(a, b)};
    }
}
