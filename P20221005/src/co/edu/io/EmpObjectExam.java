package co.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpObjectExam {
	public static void main(String[] args) throws Exception {

		// 메인메소드가 실행되면 C:/Temp/emp.dat 읽어들임.
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.사원등록 2.목록출력 3.삭제 4.종료");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			scn.nextLine();
			String[] empAry = null;

			if (menu == 1) {
//				System.out.println("사원id>> ");
//				int id = scn.nextInt();
//				System.out.println("사원이름>> ");
//				scn.nextLine();
//				String name = scn.nextLine();
//				System.out.println("사원부서>> ");
//				String dept = scn.nextLine();
//
//				empList.add(new Emp(id, name, dept));
				System.out.println("입력>> ");
				String empVal = scn.nextLine();
//				// split을 이용할 경우.
				empAry = empVal.split(" ");
				Emp emp = new Emp(Integer.parseInt(empAry[0]), empAry[1], empAry[2]);

				empList.add(emp);

			} else if (menu == 2) {
				for (Emp emp : empList) {
					System.out.println(emp.toString());
				}
			} else if (menu == 3) {
				System.out.println("삭제할 사원번호 입력>> ");
				int empId = scn.nextInt();

				for (int i = 0; i < empList.size(); i++) {
					if (empList.get(i) != null && empList.get(i).id == empId) {
						empList.remove(i);
					}

				}
			} else if (menu == 4) {
				// 컬렉션에 있던 내용을 ObjectOutputStream을 활용해서 C:/Temp/emp.dat에 저장하고 종료하기.

				FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(empList);

				System.out.println("시스템종료");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
	}
}
