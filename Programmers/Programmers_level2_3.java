public class level2_3 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
        /*
         * 행렬의 곱셉(A행렬 X B행렬)은
         * A 행렬의 열과 B행렬의 행의 크기가 같아야 가능하다.
         */
		
		int[][] answer=new int[arr1.length][arr2[0].length];
        
		// 행렬 계산
        for(int i=0;i<arr1.length;i++) {
        	for(int j=0;j<arr2[0].length;j++) {
        		for(int k=0;k<arr1[0].length;k++) {
        			answer[i][j]+=arr1[i][k]*arr2[k][j];
        		}
        	}
        }
        return answer;
    }
}
