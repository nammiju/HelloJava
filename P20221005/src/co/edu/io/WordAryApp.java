package co.edu.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordAryApp {
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		// 임의 문장을 10개씩 출력하고 타이핑해서 맞으면 사라지게..
		ArrayList<String> words = randomWords(10);
		for (String word : words) {
			System.out.println(word);
		}
		boolean done = true;
		while (true) {
			System.out.println("문장입력 >>> ");
			String rw = scn.nextLine();

			for (int i = 0; i < words.size(); i++) {
				if (words.get(i) != null && words.get(i).equals(rw)) {
					words.remove(i);
				}
			}
			done = true;
			for (String str : words) {
				if (str != null) {
					System.out.println(str);
					done = false;
				}
			}
			if (done) {
				break;
			}
		}
//		String inputVal = scn.nextLine();
//		if(words.get(i).equals(inputVal)){
//		   words.remove(i);
//		}
//		if(words.idEmpty()){
//			break;
//		}
	}

	public static ArrayList<String> randomWords(int times) throws Exception {
		// ArrayList<String>에 전체 문장을 담고..
		ArrayList<String> words = new ArrayList<String>();
		String path = "src/co/edu/io/wordAry.txt"; // 파일 경로
		File file = new File(path); // 파일 객체를 만들고
		Scanner scn = new Scanner(file); // 파일 객체를 스캐너로 읽어냄

		while (scn.hasNext()) {
			String readStr = scn.nextLine();
			readStr = readStr.replaceAll("\"", "").trim(); // 따옴표 없앰
//			System.out.println(readStr);
			words.add(readStr.substring(0, readStr.indexOf(",")));
		}
		// 임의의 개수 times 갯수만큼을 반환하도록.
		ArrayList<String> randomWords = new ArrayList<String>(); // 랜덤하게 뽑은 문장만 담을 배열 생성. 
		for (int i = 0; i < times; i++) { // times번 만큼 반복하는 반복문
			int random = (int) (Math.random() * 494); // 0~494까지의 숫자중 랜덤한 정수를 뽑아냄.
			randomWords.add(words.get(random)); // 뽑아낸 숫자를 words의 인덱스 번호에 넣어 그 인덱스번호에 해당하는 값을 randomWords에 넣어줌. 이걸 times횟수 반복!
		}
//		Set<Integer> idxSet = new HashSet<>();
//		while(idxSet.size() < times){
//			idxSet.add((int)(Math.random()*words.size()));
//		}
//		for (int idx : idxSet){
//			random
		
		scn.close();
		return randomWords;
	}
}
