import java.io.*;
import java.util.*;


public class Algorithm {
	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(sc.nextLine());
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
				
				
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.println(A[i]);
		}
		
	}

}
