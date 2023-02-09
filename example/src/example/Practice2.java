package example;

import java.util.*;

public class Practice2 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) {
			System.out.print(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				
				if("".equals(input)) continue;
				
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를" + MAX_SIZE + "개 보여줍니다.");
				} else if(input.equalsIgnoreCase("history")) {
					save(input);
					
					LinkedList list = (LinkedList)q;
					
					final int SIZE = list.size();
					for(int i = 0; i < SIZE; i++) {
						System.out.println((i+1)+"."+list.get(i));
					}
				} else {
					save(input);
					System.out.println(input);
				}
			} catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		}
		
		
	}
	
	public static void save(String input) {
		//queue에 저장한다.
		if(!"".equals(input)) //if(input!=null && !input.equals(""))
			q.offer(input);
		
		//queue의 최대크기를 넘으면 제일 먼저 넣은 것 삭제
		if(q.size() > MAX_SIZE)
			q.remove();
	}
	
}

