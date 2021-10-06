public class level1_45 {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer=n-lost.length; // 수업을 들을 수 있는 학생 수
        
        /*
         * 체육복을 도난당하 학생 중 여분의 체육복을 가져온 사람이 있다면 
         * 해당 학생은 체육복을 빌려줄 수 없기 때문에 
         * 수업을 들을 수 있는 학생 수를 1 증가시키고 배열의 값을 -1로 바꿔준다.
         */
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(lost[i]==reserve[j]) {
        			answer++;
        			lost[i]=-1;
        			reserve[j]=-1;
        			break;
        		}
        	}
        }
        
        // 체육복을 도난당한 학생들에게 여분의 체육복을 빌려주는 경우
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		// 체육복을 빌려줄 수 있는 경우
        		if(lost[i]-1==reserve[j]||lost[i]+1==reserve[j]) {
        			answer++; // 수업을 들을 수 있는 학생 수 +1
        			reserve[j]=-1; // 여분의 체육복을 가져온 사람 삭제
        			break;
        		}
        	}
        }
        return answer;
    }
}
