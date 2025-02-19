import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] == 0) {
                    continue;
                }
                if(!stack.isEmpty() && stack.peek() == board[j][moves[i] - 1]) {
                    count += 2;
                    stack.pop();
                    board[j][moves[i] - 1] = 0;
                    break;
                }
                if(board[j][moves[i] - 1] != 0) {
                    stack.push(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }
        return count;
    }
}
