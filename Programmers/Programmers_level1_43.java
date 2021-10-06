public class level1_43 {
	 public int solution(int[] absolutes, boolean[] signs) {
	        int answer=0;
	        
	        for(int i=0;i<absolutes.length;i++) {
	        	// signs 값이 true라면 양의 정수
	        	if(signs[i]==true) 
	        		answer+=absolutes[i];
	        	// signs 값이 true라면 음의 정수
	        	else 
	        		answer-=absolutes[i];
	        }
	        return answer;
	 }
}
