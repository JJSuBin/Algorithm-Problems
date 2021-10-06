public class level1_31 {
	public String solution(int a, int b) {
        String answer = "";
        
        /*
         * day 배열 : 요일을 저장한 배열
         * month 배열 : 각 월의 일수가 저장된 배열
         */
        String[] day= {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] month= {31, 29, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};
        int total=0;
        
        // 1월 1일 부터 a월 b일 까지의 누적 날짜 구하기
        for(int i=0;i<a-1;i++)
        	total+=month[i];
        total+=b-1;
        
        answer=day[total%7]; // 구한 날짜의 요일 구하기
        return answer;
    }
}
