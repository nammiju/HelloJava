package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {

	List<Memo> memoStorage = new ArrayList<>(); // 정보담아놓기위한 컬렉션.
	File file = new File("C:/Temp/memobook.dat"); // 파일객체 생성.
	Scanner scn = new Scanner(System.in);

	// 싱글톤방식으로 인스턴스 생성.
	private static MemoManager instance = new MemoManager();

	private MemoManager() {
		readFromFile(); // memoManager가 실행되면 생성자가 호출될때 같이 실행되게하깅.
	}

	public static MemoManager getInstance() {
		return instance;
	}

	// 추가.
	public void inputData() {
		System.out.print("번호 입력>> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("날짜 입력>> ");
		String date = scn.nextLine();
		System.out.print("내용 입력>> ");
		String content = scn.nextLine();

		memoStorage.add(new Memo(no, date, content));
	}

	// 조회(날짜입력 -> 해당날짜 모든 데이터 출력)
	public void searchData() {
		System.out.print("날짜 입력>> ");
		String sData = scn.nextLine();
		boolean exists = false;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (sData.equals(memoStorage.get(i).getDate())) {
				System.out.println(memoStorage.get(i).toString());
				exists = true;
			}
		}
		if (!exists) {
			System.out.println("해당날짜의 메모가 없습니다.");
		}
	}

	// 번호를 입력하면 한건 삭제.
	public void deleteData() {
		System.out.print("번호 입력>> ");
		for (int i = 0; i < memoStorage.size(); i++) {
			int no = Integer.parseInt(scn.nextLine());

			if (memoStorage.get(i) != null && memoStorage.get(i).getNo()==no) {
				memoStorage.remove(i);
				break;
			}
			if (memoStorage.get(i).getNo() != no) {
				System.out.println("찾는 번호가 없습니다.");
			}
		}
	}

	// 프로그램 실행시 memoBook 파일을 읽어서 데이터를 memoStorage에 담는 기능.
	public void readFromFile() {
		// try with resource.
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {

			memoStorage = (List<Memo>) ois.readObject();

		} catch (Exception e) {
//			e.printStackTrace();
			return;
		}
	}

	// 종료하면 파일저장.
	public void storeToFile() {
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(memoStorage); // 파일 저장.

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
