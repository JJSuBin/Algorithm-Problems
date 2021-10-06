public class level1_13 {
	 public int[] solution(long n) {
		 String str=String.valueOf(n);
	     int length=Long.toString(n).length(); // n의 자릿수 개수
		 int[] answer=new int[length];
		 
		 /*
		  * n을 뒤집어 저장해야 하기 때문에 배열의 인덱스 끝부터 저장을 시작한다.
		  * int형 배열인 answer에 저장해야 하기 떄문에 Integer.parseInt() 함수를 사용한다.
		  * 이때, 해당 함수는 String형을 int형으로 바꿔주는 것이기 떄문에
		  * char형인 str.charAt()을 String 형으로 변환한 값을 int형으로 변환해야 한다.
		  */
		 for(int i=0;i<length;i++) 
			 answer[length-1-i]=Integer.parseInt(String.valueOf(str.charAt(i)));
			 
	     return answer;
	  }
}
