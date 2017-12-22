/*
 *파일명 : MyListTest.java
 *작성일 : 2017.9.21
 *작성자 : 201432014 모설아
 *내용 : 리스트 작성 및 수정 테스트 드라이버 클래스
 */
package net.skhu.mylist;

import net.skhu.mylist.MyList.ArrayIndexOutOfDataSizeException;

/**
 * @author snow
 *
 */
public class MyListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_1 : 모설아\n");

		//MyList 객체 생성
		MyList list = new MyList();

		//list에 저장
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(-999);
		list.add(50);
		list.add(90);
		list.add(10);

		//list 내용 전체 출력
		System.out.println(list);

		//list의 크기
		System.out.println("리스트 크기 = "+list.size()+"\n");

		//Scanner 객체 생성
		java.util.Scanner scan = new java.util.Scanner(System.in);

		//list 조회
		while(true) {
			try {
				System.out.print("조회할 인덱스 입력 : ");
				int ipt = scan.nextInt();
				System.out.println("인덱스 "+ipt+"의 원소 = "+list.get(ipt)+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//갱신
		while(true) {
			try {
				System.out.print("777로 갱신할 인덱스 입력 : ");
				int ipt = scan.nextInt();
				list.set(ipt, 777);
				System.out.println(list+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//삽입
		while(true) {
			try {
				System.out.print("999를 삽입할 인덱스 입력 : ");
				int ipt = scan.nextInt();
				list.add(ipt, 999);
				System.out.println(list+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//삭제
		while(true) {
			try {
				System.out.print("삭제할 인덱스 입력 : ");
				int ipt = scan.nextInt();
				int x = list.remove(ipt);
				System.out.println("인덱스 "+ipt+"의 원소 = "+x);
				System.out.println(list+"\n");
				break;
			} catch(ArrayIndexOutOfDataSizeException e) {
				System.out.println(e.getMessage());
			}
		}

		/**
		 * 옵션 1
		 */
		
		//list 추가
		for(int i = 1 ; i<=25 ; i++) {
			list.add(i);
		}
		
		//list 전체 출력
		System.out.println(list);
		
	}

}
