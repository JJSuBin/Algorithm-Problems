public class level2_9 {
	public static int solution(int n) {
        int answer=0;
        // n을 2진수로 바꾸기
        String str=Integer.toBinaryString(n);
        int count=0;
        
        // n을 2진수로 바꾼 값에서 1의 개수를 count한다.
        for(int i=0;i<str.length();i++)
        	if(str.charAt(i)=='1')
        		count++;
        
        // 완전 탐색
        for(int i=n+1;i<1000000;i++) {
        	// n보다 큰 수를 2진수로 변환
        	String num=Integer.toBinaryString(i);
        	int one_count=0;
        	
        	// 1의 개수 count
        	for(int j=0;j<num.length();j++)
        		if(num.charAt(j)=='1')
        			one_count++;
        	
        	/*
        	 * n과 1의 개수가 같다면 해당 값을 저장 후 
			 * 조건을 만족하는 가장 작은 값을 찾는 것이기 때문에 break
        	 */
        	if(one_count==count) {
        		answer=i;
        		break;
        	}
        }
        return answer;
	}
}
