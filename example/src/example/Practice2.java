package example;

import java.util.*;

public class Practice2 {
	
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2012, 0, 27);
		System.out.println("date1은" + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고");
		System.out.println("오늘(date2)은" + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"요일입니다.");
		
		long diffrence = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println(diffrence+"초가 지났습니다.");
		System.out.println(diffrence/(24*60*60)+"일이 지났습니다.");
		
	}

	private static String toString(Calendar date) {
		// TODO Auto-generated method stub
		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH)+1) + "월" + date.get(Calendar.DATE) + "일";
	}
	
}

