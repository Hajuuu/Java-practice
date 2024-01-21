import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11000 {
	
	static ArrayList<Lecture> lectures;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		lectures = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			lectures.add(new Lecture(s, t));
		}
		Collections.sort(lectures, new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});
		int answer = assignment(lectures.get(0).end);

		System.out.println(answer);
	}
	
	private static int assignment(int end) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(end);
		lectures.remove(0);
		for(Lecture i : lectures) {
			if(i.start >= queue.peek()) {
				queue.poll();
			}
			queue.offer(i.end);
		}
		
		return queue.size();
	}

}

class Lecture {
	
	int start;
	int end;
	
	Lecture(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
}