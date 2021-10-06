import java.util.*;

public class level2_6 {
	 public String solution(String s) {
	    String answer="";
	    String[] arr=s.split(" "); // 공백을 기준으로 숫자를 나눠 저장
	    int[] num=new int[arr.length]; 
	    
	    // String 배열에 저장된 변수를 int형으로 바꿔 저장
	    for(int i=0;i<num.length;i++)
	    	num[i]=Integer.parseInt(arr[i]);
	    	
	    Arrays.sort(num); // 오름차순으로 정렬
	    answer=String.valueOf(num[0])+" "+String.valueOf(num[num.length-1]);
	    
	    return answer;
	  }
}
