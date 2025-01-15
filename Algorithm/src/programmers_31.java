import java.util.*;
class Solution {
    static int num;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        num = n;
        int[][] a1 = new int[n][n];
        int[][] a2 = new int[n][n];
        Stack<Integer> stack;
        for(int i = 0; i < n; i++) {
            stack = binary(arr1[i]);
            for(int j = 0; j < n; j++) {
                if(stack.size() > 0) {
                    a1[i][j] = stack.pop();
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            stack = binary(arr2[i]);
            for(int j = 0; j < n; j++) {
                if(stack.size() > 0) {
                    a2[i][j] = stack.pop();
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            String str = "";
            for(int j = 0; j < n; j++) {
                if(a1[i][j] == 0 && a2[i][j] == 0) {
                    str += " ";
                } else {
                    str += "#";
                }
            }
            answer[i] = str;
        }
        return answer;
    }
    
    public static Stack<Integer> binary(int a) {
        Stack<Integer> stack = new Stack<>();
        while(a > 0) {
            stack.push(a % 2);
            a /= 2;
        }
        while(stack.size() < num) {
            stack.push(0);
        }
        return stack;
    }
}
