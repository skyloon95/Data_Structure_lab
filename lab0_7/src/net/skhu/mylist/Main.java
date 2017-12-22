/*
 *파일명 : MyList.java
 *작성일 : 2017.9.12
 *작성자 : 201432014 모설아
 *내용 : 드라이버 클래스
 */

package net.skhu.mylist;

import java.util.InputMismatchException;
/**
 * @author snow
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_7 : 모설아\n");
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		MyList mList = new MyList(); // MyList 객체 생성
		
		mList.print(); // 최초 리스트 출력
		
		while(true) {
			System.out.print("저장하실 정수를 입력해주십시오 : ");
			try {
				mList.add(scan.nextInt());
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열이 가득 찼습니다.");
				break;
			} catch(InputMismatchException e) {
				System.out.println("정수 형태로만 저장 가능합니다.\n");
				scan.nextLine(); // 추가적인 오류 방지를 위한 버퍼삭제
			} finally {
				mList.print();
			}
		}
	}

}
