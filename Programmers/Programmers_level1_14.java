public class level1_14 {
	 public int solution(int n) {
	    int answer=0;
	    int num=n;
	    
	    /*
	     * %10을 하여 끝의 자리수의 값을 더하고
	     * /10을 하여 더한 끝 자리수를 잘라낸다.
	     */
	    while(num>0) {
	    	answer+=num%10;
	    	num/=10;
	    }
	    return answer;
	}
}
