import java.util.*;

public class level1_49 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer=new int[commands.length];
        
        for(int i=0;i<commands.length;i++) {
        	ArrayList<Integer> arr=new ArrayList<Integer>();
        	
        	// 주어진 인덱스 i부터 j까지의 array 값을 리스트에 저장 
        	for(int j=commands[i][0]-1;j<commands[i][1];j++) 
        			arr.add(array[j]);
        	
        	Collections.sort(arr); // 정렬 수행
        	answer[i]+=arr.get(commands[i][2]-1); // 정렬된 값들 중 k번째 값 answer에 저장
        }
        return answer;
    }
}
