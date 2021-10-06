public class level1_11 {
	public long solution(long n) {
        // n의 값에 루트를 씌운 값을 구한다.
		Double sqrt=Math.sqrt(n);
        
		/*
		 * n이 양의 정수의 제곱근이면 
		 * n에 루트를 씌운 값이 양의 정수여야 한다.
		 * 따라서, sqrt 값과 sqrt 값을 정수형으로 바꾼 값이 같다면
		 * n은 양의 정수의 제곱근이 된다.
		 */
        if(sqrt==sqrt.intValue())
        	return (long)Math.pow(sqrt+1, 2);
        else return -1;
    }
}
