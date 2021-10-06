import java.util.*;

public class BaekJoon_20291 {
	static Map<String,Integer> map=new TreeMap<>();
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String str=sc.next();
			// 입력된 파일명을 "." 이후로 잘라 확장자만 얻는다. 
			String temp=str.substring(str.indexOf(".")+1);
			
			// 이미 있는 확장자라면 해당 확장자의 값을 1늘려 삽입한다.
			if(map.containsKey(temp)) 
				map.put(temp, map.get(temp)+1);
			
			// 없는 확장자라면 개수를 1로 count 한뒤 삽입한다.
			else
				map.put(temp, 1);
		}
		
		// Map에 저장된 확장자 명(key)과, 확장자 별 파일 개수(value->map.get(key))를 출력한다.
		for(String key:map.keySet())
			System.out.println(key+" "+map.get(key));
	}

}
