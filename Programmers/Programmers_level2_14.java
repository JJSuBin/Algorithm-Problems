package Programmers_Level2;

public class level2_14 {
	 public int solution(String skill, String[] skill_trees) {
	     int answer=skill_trees.length;
	     int before=0; 
	     int current=0;
	     
	     for(int i=0;i<skill_trees.length;i++) {
	    	 /*
	    	  *  before에는 skill의 첫 번째 알파벳이 skill_trees[i]의 
	    	  *  몇 번째 인덱스에 있는지 저장되어 있다.
	    	  *  
	    	  *  예를들어 skill이 CBD이고, skill_tree[i]가 BACDE라면 
	    	  *  before에는 BACDE에 C가 몇 번쨰 인덱스에 있는지가 저장되어 있는 것이다.(=2)
	    	  */
	    	 before=skill_trees[i].indexOf(skill.charAt(0));
	    	 
	    	 // skill의 첫 번쨰 인덱스는 이미 before에 저장되어 있으므로 다음 문자부터 검사
	    	 for(int j=1;j<skill.length();j++) {
	    		 // 현재 비교하고자 하는 skill의 알파벳이 몇 번쨰에 있는지 검사
	    		 current=skill_trees[i].indexOf(skill.charAt(j));
	    		 
	    		 /*
	    		  * 현재 구하고자 하는 스킬이 스킬트리에 있고, 
	    		  * 이전 스킬의 인덱스가 현재 스킬의 인덱스보다 크다면 불가능
	    		  * -> 예를들어 skill이 CBD이고, skill_tree[i]가 BACDE라면 
	    		  * C의 인덱스는 2, B의 인덱스는 0인 경우
	    		  * 
	    		  * 또한 이전 스킬이 스킬트리에 없는데 현재 스킬이 스킬트리에 있다면 불가능
	    		  * -> 예를들어 skill이 CBD이고, skill_tree[i]가 AEBFG라면
	    		  * C의 인덱스는 -1(스킬트리에 포함X), B의 인덱스는 2이인 경우
	    		  */
	    		 if((before>current&&current!=-1)||(before==-1&&current!=-1)) {
	    			 answer--;
	    			 break;
	    		 }
	    		 before=current; // 값 갱신
	    	 }
	     }
	     
	     return answer;
	 }
}
