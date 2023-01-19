import java.util.Random;
import java.util.Scanner;


public class Algorithm {

	static int maxOf(int[] a) {
		int max = a[0];
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max)
				max = a[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand =new Random();
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		int num = rand.nextInt(10);
		System.out.println("사람 수: " + num);
		
		
		int[] height = new int[num];
		
		System.out.println("키는 다음과 같습니다.");
		for(int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90);
			System.out.println("height[" + i + "]: " + height[i]);
		}
		
		System.out.println("최대값은 " + maxOf(height) + "입니다.");
			
	}

}
