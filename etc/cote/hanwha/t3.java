import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String start_date = "05/04 MON";
//		String end_date = "05/30";
//		String[] login_dates = {"05/26", "05/25", "05/27", "05/10", "05/11", "05/23", "05/22", "05/21", "05/06", "05/09", "05/07", "05/08"};
		String start_date = "05/27 SUN";
		String end_date = "06/16";
		String[] login_dates = {"05/31", "05/30", "06/01", "06/04", "06/07", "06/06", "06/09", "06/08", "06/13", "06/14", "06/10"};
//		
		System.out.println(solution(start_date, end_date, login_dates));
	}

	static List<String> list = new ArrayList<>();
	public static int solution(String start_date, String end_date, String[] login_dates) {
		int answer = -1;
		int len = login_dates.length;
		Arrays.sort(login_dates);
		//주말 계산
		//int[] yoilIdx = new int[8];
		
		list.add("0");
		list.add("MON");
		list.add("TUE");
		list.add("WED");
		list.add("THU");
		list.add("FRI");
		list.add("SAT");
		list.add("SUN");
		
		// 1 MON, 2 TUE, 3 WED, 4 THU, 5 FRI, 6 SAT, 7 SUN

		int cnt = 1;
		int status = 0;
		int nextStatus = 0;
		String friday = "";
		boolean flag = false;
		for(int i = 0 ; i < len-1 ; i++) {
			status = findYoil(start_date, login_dates[i]);
			nextStatus = findYoil(start_date, login_dates[i+1]);
					
			String[] first = new String[2];
			String[] second = new String[2];
			
			if(nextStatus == 6 || nextStatus == 7) {
				flag = true;
				friday = login_dates[i];
				continue;
			}
			else if(flag){
				first = friday.split("/");
				second = login_dates[i+1].split("/");
			}
			else {
				first = login_dates[i].split("/");
				second = login_dates[i+1].split("/");
			}
			
			if(first[0].equals(second[0])) {
				int num1 = Integer.parseInt(first[1]);
				int num2 = Integer.parseInt(second[1]);
				
				if(flag) {
					if(num1 + 3 == num2) {
						cnt++;
					}
				}
				else if(status == 5){
					if(num1 + 3 == num2) {
						cnt++;
					}
				}
				else if(num1 + 1 == num2) {
					if(status != 6 && status != 7) {
						cnt++;
					}
				}
				else {
					if(answer < cnt) {
						answer = cnt;
					}
					cnt = 1;
				}
//				if(status == 5) {
//					if(num1 + 3 == num2) {
//						cnt++;
//					}
//					else {
//						if(answer < cnt) {
//							answer = cnt;
//						}
//						cnt = 1;
//					}
//				}
//				else if(status != 6 && status != 7) {
//					if(num1 + 1 == num2) {
//						cnt++;
//					}
//					else {
//						if(answer < cnt) {
//							answer = cnt;
//						}
//						cnt = 1;
//					}
//				}
				
			}
			else {
				int lastDay = finalDate(Integer.parseInt(first[0]));
				if(lastDay == Integer.parseInt(first[1]) && second[1].equals("01")){ // 말일과 첫날이면
					if(status != 6 && status != 7) {
						cnt++;
					}
					else {
						if(answer < cnt) {
							answer = cnt;
						}
						cnt = 1;
					}
				}
				
			}
		}
		return answer;
	}
	
	public static int findYoil(String start_date, String date) {
		int result = 0;
		int nowYoil = 0;
		int nextYoil = 0;
		
		//현재 날짜와 시작일의 차
		String[] temp = start_date.split(" ");
		String[] startDate = temp[0].split("/");
		String[] nowDate = date.split("/");
		
		if(startDate[0].equals(nowDate[0])) {
			result = Integer.parseInt(nowDate[1]) - Integer.parseInt(startDate[1]);
		}
		else { // startdate 05/27 enddate 08/31 nowdate 07/02
			int startDay = finalDate(Integer.parseInt(startDate[0])) - Integer.parseInt(startDate[1]);
			int finalDay = Integer.parseInt(nowDate[1]);
			
			int middle = 0;
			for(int i = Integer.parseInt(startDate[0]) + 1 ; i < Integer.parseInt(nowDate[0]) ; i++) {
				middle = middle + finalDate(i);
			}
			
			result = startDay + middle + finalDay;
		}
		
		//요일구하기
		// 1 MON, 2 TUE, 3 WED, 4 THU, 5 FRI, 6 SAT, 7 SUN
		nowYoil = list.indexOf(temp[1]); // sun 7
		result = result%7;
		if(nowYoil + result < 7) {
			nextYoil = nowYoil + result;
		}
		else {
			nextYoil = (nowYoil+result)%7;
		}		
		
		return nextYoil;
	}
	public static int finalDate(int month) {
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return 28;
		}
		 
		return 0;
	}
}
