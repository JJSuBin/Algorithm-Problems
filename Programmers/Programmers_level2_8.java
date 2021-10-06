public class level2_8 {
	int solution(int[][] land) {
        int answer=Integer.MIN_VALUE;
        int[][] dp=new int[land.length][land[0].length];
        
        // dp에 land의 0 번째 행에 있는 값 복사
        for(int i=0;i<land[0].length;i++)
        	dp[0][i]=land[0][i];
        
        // 1 번쨰 행부터 반복
        for(int i=1;i<land.length;i++) {
        	// i번째 행의 j열 탐색
        	for(int j=0;j<land[i].length;j++) {
        		int max=Integer.MIN_VALUE;
        		// 4개의 행 탐색
        		for(int k=0;k<4;k++) {
        			// 현재 열 j와 이전의 열 k가 같다면 해당 땅은 밟을 수 없다.
        			if(j==k)
        				continue;
        			// 나머지 3개의 열에서 최댓값을 찾는다.
        			max=Math.max(max, dp[i-1][k]);
        		}
        		// 위에서 찾은 최댓값과 현재 땅 값을 더해 dp에 저장
        		dp[i][j]=land[i][j]+max;
        	}
        }
        
        // n-1번쨰 행에 저장된 각각의 최댓값들 중 가장 큰 값을 answer에 저장
        for(int i=0;i<4;i++)
        	answer=Math.max(answer, dp[land.length-1][i]);
        
        return answer;
    }
}
