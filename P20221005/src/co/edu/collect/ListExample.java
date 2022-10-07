package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListExample {
	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<String>();
		// 추가.
		strs.add("홍길동");
		strs.add("김민식");
		strs.add("박유식");

		// 삭제.
		strs.remove(0); // 인덱스 값으로 삭제 가능.
		strs.remove("박유식");

		strs.add(0, "최기분"); // 특정위치에 추가 가능

		System.out.println("collect크기: " + strs.size());

		for (String str : strs) { // strs가 가진 개수만큼 반복해서 String 타입으로 출력하고 이를 변수 str로 저장함(?)
			System.out.println(str);
		}
		for (int i = 0; i < strs.size(); i++) {
			System.out.printf("%d번째의 값은 %s\n", i, strs.get(i));
		}

		// 반복자를 생성.
		Iterator<String> itr = strs.iterator(); // Iterator: 반복자
		while (itr.hasNext()) { // .hasNext(): 가지고 올 값이 있는지 묻고 있으면 true 출력
			String result = itr.next();
			System.out.println(result);
		}

		// 100만건.
		ArrayList<Integer> inAry = new ArrayList<Integer>();
		long start = System.nanoTime(); //
		for (int i = 0; i < 10000; i++) {
			inAry.add(i);
		}
		long end = System.nanoTime(); //
		System.out.println("Ary: " + (end - start));

		LinkedList<Integer> lnAry = new LinkedList<Integer>();
		long start2 = System.nanoTime(); //
		for (int i = 0; i < 10000; i++) {
			lnAry.add(i);
		}
		long end2 = System.nanoTime(); //
		System.out.println("Lry: " + (end2 - start2));
	}
}
