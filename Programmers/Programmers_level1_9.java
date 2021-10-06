public class level1_9 {
	 public String solution(int num) {
	     String answer="";
	     // 짝수일 경우
	     if(num%2==0)
	    	 answer+="Even";
	     
	     // 홀수일 경우
	     else
	    	 answer+="Odd";
	     
	     return answer;
	 }
}
