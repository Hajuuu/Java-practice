class Solution {
    public int solution(int[][] sizes) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int[] size : sizes) {
            maxX = Math.max(maxX, Math.max(size[0], size[1]));
            maxY = Math.max(maxY, Math.min(size[0], size[1]));
        }
        
        return maxX * maxY;
    }
}
