public class level2_10 {
	public String solution(int n, int t, int m, int p) {
        /*
         * n:진법 
         * t:미리 구할 숫자의 개수 
         * m:게임에 참가하는 인원 
         * p:튜브의 순서 
         */
		StringBuilder answer=new StringBuilder();
		StringBuilder sb=new StringBuilder("0"); // n진법으로 바꾼 숫자 저장
		String[] alpabet={"A","B","C","D","E","F"}; // 16진수일 경우에 바꿔줄 알파벳을 저장한 배열
		int num=1; // 시작 숫자
		
		// 미리 구할 숫자의 개수 * 게임에 참가하는 인원의 길이까지 답이 나올만큼 반복
		while(sb.length()-1<t*m) {
			StringBuilder binary=new StringBuilder(); // num을 2진수로 바꾼값을 저장
			int quot=num; // 몫
			int remain; // 나머지
			
			while(quot>0) {
				remain=quot%n;
				quot/=n;
				
				if(remain>=10&&remain<=15) // 알파벳으로 바꿔야 하는 경우
					binary.append(alpabet[remain-10]);
				else binary.append(remain); // 위의 경우가 아니라면 저장
			}
			// binary에 저장된 2진수로 바꾼 값은 뒤집혀있기 때문에 reverse()로 바꿔 저장한다.
			sb.append(binary.reverse());
			num++;
		}
		
		int tube=p; // 튜브 차례
		for(int i=0;i<t;i++) {
			// 문자열의 처음 인덱스는 0부터 시작하기 때문에 1을 뺀 지점의 값을 answer에 저장한다.
			answer.append(sb.charAt(tube-1));
			tube+=m; // 튜브가 다음에 구해야 하는 인덱스 번호
		}
        return answer.toString();
    }
}
