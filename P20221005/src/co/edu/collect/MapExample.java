package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		// key: Integer, val: String 이런식으로 키와 밸류에 타입을 각각 설정해야함.
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김기영");
		map.put(300, "박문식");
		map.put(300, "윤문식"); // 똑같은 키값이 들어오면 이전의 데이터 없애고 새로운걸로 대체함

		map.remove(300); // 삭제.

		System.out.println("컬렉션: " + map.size());

		System.out.println("val: " + map.get(300)); // get(key): 키값을 넣어주면 밸류 출력

		// 반복자 생성.
		Set<Integer> keySet = map.keySet(); // 키값만 새로운 set컬렉션에 저장.
		for (Integer key : keySet) {
			System.out.println("키: " + key + ", 값: " + map.get(key));
		}

		Set<Entry<Integer, String>> entSet = map.entrySet(); // entrySet(): 키값과 밸류를 모두 담는 Set컬렉션생성.
		for (Entry<Integer, String> ent : entSet) {
			System.out.println("키: " + ent.getKey() + ", 값: " + ent.getValue());
		}
	}
}
