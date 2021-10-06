package Programmers;

import java.util.*;

public class level1_34 {
	 public int[] solution(int N, int[] stages) {
	        int[] answer=new int[N];
	        /*
	         * 각 스테이지마다 실패율을 저장하기 위해 Map을 사용한다.
	         * Map은 key 값과 value 값을 동시에 저장할 수 있는 자료구조로
	         * 후에 value 값의 크키에 따라 key 값을 정렬하기 용이하다. 
	         */
	        Map<Integer,Double> map=new HashMap<>();
	        
	        // 각 스테이지 마다 실패율을 구하는 for문 실행
	        for(int i=1;i<=N;i++) {
	        	int stage=i; // 스테이지 변수
	        	int noclearpeople=0; // 스테이지를 클리어하지 못한 수
	        	int clearpeople=0; // 스테이지에 도달한 수
	        
	        	for(int j=0;j<stages.length;j++) {
	        		// 스테이지 값과 같으면 스테이지에 도달했으나 클리어 X
	        		if(stage==stages[j])
	        			noclearpeople++;
	        		// 스테이지 값보다 같거나 크다면 스테이지에 도달한 수
	        		if(stage<=stages[j])
	        			clearpeople++;
	        	}
	        	
	        	// 실패율 구하기 : 스테이지에 도달했으나 아직 클리어 못한 수 / 스테이지에 도달한 수
	        	double failure=0;
	        	if(noclearpeople!=0&&clearpeople!=0)
	        		failure=(double)noclearpeople/(double)clearpeople;
	        	
	        	// 각 스테이지 별로 실패율을 저장한다.
	        	map.put(stage,failure);
	        }
	        
	        // 실패율에 크기에 따라 스테이지 값을 배열에 저장한다.
	        for(int i=0;i<N;i++) {
	        	double max=-1;
	        	int maxkey=0; // key 값(=스테이지)
	        	for(Integer key:map.keySet()) {
	        		// 실패율이 가장 높은 스테이지 찾기
	        		if(max<map.get(key)) {
	        			max=map.get(key);
	        			maxkey=key;
	        		}
	        	}
	        	answer[i]=maxkey;
	        	map.remove(maxkey);
	        }
	        return answer;
	  }
}
