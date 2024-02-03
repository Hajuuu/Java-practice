import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_20055 {

	static List<Conveyor> belt;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		belt = new ArrayList<>();
		for(int i = 0; i < 2 * N; i++) {
			belt.add(new Conveyor(Integer.parseInt(st.nextToken()), false));
		}
		
		int count = 1;
		while(true) {
			belt.add(0, belt.get(2 * N - 1));
			belt.remove(2 * N);
			if(belt.get(N - 1).robot) {
				belt.set(N - 1, new Conveyor(belt.get(N - 1).durability, false));
			}
			for(int i = N - 2; i >= 0; i--) {
				checkMove(i, i + 1);
			}
			Conveyor start = belt.get(0);
			if(start.durability > 0) {
				belt.set(0, new Conveyor(start.durability - 1, true));
			}
			int check = checkDurability();
			if(check >= K) {
				break;
			}
			count++;
			
		}
		System.out.println(count);
		
	}
	
	public static void checkMove(int start, int end) {
		Conveyor now = belt.get(start);
		Conveyor next = belt.get(end);
		
		if(now.robot) {
			if(end == N - 1 && next.durability > 0) {
				belt.set(start, new Conveyor(now.durability, false));
				belt.set(end, new Conveyor(next.durability - 1, false));
				return;
			}
			if(!next.robot && next.durability > 0) {
				belt.set(start, new Conveyor(now.durability, false));
				belt.set(end, new Conveyor(next.durability - 1, true));
			}
		}
	}
	
	
	public static int checkDurability() {
		int count = 0;
		for(Conveyor c : belt) {
			if(c.durability == 0) {
				count++;
			}
		}
		return count;
	}

}

class Conveyor {
	int durability;
	boolean robot;
	
	Conveyor (int durability, boolean robot) {
		this.durability = durability;
		this.robot = robot;
	}

}
