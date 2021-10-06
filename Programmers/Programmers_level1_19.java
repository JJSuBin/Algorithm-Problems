public class level1_19 {
	 public String solution(int n) {
	   String answer = "";
	   
	   // n/2번 문자열 "수박"을 적어준다. n이 짝수인 경우는 여기서 종료
	   for(int i=1;i<=n/2;i++)
			answer+="수박";
		
	    // n이 홀수인 경우에는 뒤에 "수"를 한번 더 써줘야 한다.
		if(n%2!=0) 
			answer+="수";
		
	   return answer;
	 }
}
