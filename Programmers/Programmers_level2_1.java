public class level2_1 {
	public int solution(int[] arr) {
        int answer=arr[0]; // 배열의 첫 번째 값을 저장
        
        for(int i=1;i<arr.length;i++) {
        	int gcdval=gcd(answer,arr[i]); // 배열의 두 값의 최대공약수를 구한다.
        	
        	answer=answer*arr[i]/gcdval; // 두 값의 최대공배수를 구한다.
        }
        return answer;
    }
	
	// 최대 공약수 구하는 함수 : 유클리드 호제법
	public int gcd(int a, int b) {
		while(b!=0) {
			int r=a%b; // 나머지를 구해준다.
				
			// GCD(a,b) = GCD(b,r)이므로 변환
			a=b;
			b=r;
		}
		// 나머지가 0이 되면 a 자리에 있는 값이 최대 공약수
		return a;
	}
}
