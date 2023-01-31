import java.util.Scanner;
import java.util.Stack;


public class Algorithm {
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		Stack<Integer> st = new Stack<>();
		StringBuffer bf = new StringBuffer();
		int num = 1;
		boolean result = true;
		for(int i = 0; i < A.length; i++) {
			int su = A[i];
			if(su >= num) {
				while(su >= num) {
					st.push(num++);
					bf.append("+\n");
					
				}
				st.pop();
				bf.append("-\n");
			} 
			else {
				int n = st.pop();
				if(n > su) {
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					bf.append("-\n");
				}
			}
		}
		if(result) System.out.println(bf.toString());
		
	}

}
