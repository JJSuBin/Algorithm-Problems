public class level1_42 {
	 public int solution(int[] a, int[] b) {
	        int answer=0;
	        // 두 배열의 길이는 같기 때문에 둘 중 하나의 배열 길이를 저장
	        int length=a.length;
	        
	        // 두 배열을 곱한 값을 누적 = 내적
	        for(int i=0;i<length;i++)
	        	answer+=a[i]*b[i];
	        
	        return answer;
	  }
}
